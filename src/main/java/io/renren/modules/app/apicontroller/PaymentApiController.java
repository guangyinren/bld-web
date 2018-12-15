package io.renren.modules.app.apicontroller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.AlipayUtils;
import io.renren.common.utils.HttpClientUtil;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.common.utils.WeixinUtils;
import io.renren.modules.app.constant.CommonAttribute;
import io.renren.modules.app.entity.OrderEntity;
import io.renren.modules.app.entity.OrderItemEntity;
import io.renren.modules.app.entity.PaymentEntity;
import io.renren.modules.app.entity.ProductEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.OrderItemService;
import io.renren.modules.app.service.OrderService;
import io.renren.modules.app.service.PaymentService;
import io.renren.modules.app.service.ProductService;



/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:50
 */
@Controller
@RequestMapping("api/payment")
public class PaymentApiController extends AbstractController{
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ProductService productService;

    
    @RequestMapping("/pay")
    public R pay(String orderId,String ip,String type){
    	UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
    	if (ValidateUtils.isContainEmpty(orderId,ip,type)) {
			return R.error(1, "必传参数为空");
		}
    	OrderEntity order = orderService.selectById(orderId);
    	if(order==null) {
    		return R.error(1, "订单不存在");
    	}
    	//查看是否已经完善地址
    	if(CommonAttribute.ORDER_STATUS_ADD_ADDRESS.equals(order.getStatus())) {
    		return R.error(1, "订单地址未填写");
    	}
    	if("0".equals(type)) {//微信
    		Map<String,Object> result =WeixinUtils.h5Pay(String.valueOf(order.getId()),order.getAmount(), "订单支付", ip, getResponse());
        	result.put("mweb_url", result.get("mweb_url")+orderId);
        	System.out.println("返回页面的结果:"+result);
        	return R.ok(result);
    		
    	}else if("1".equals(type)) {//支付宝
    		AlipayUtils.webPay(orderId, order.getAmount()/*.multiply(new BigDecimal(100))*/, "订单支付", getRequest(), getResponse());
    	}else {
    		return R.error(1, "type有误");
    	}
		return R.ok();
        
    }


    /**
     * 支付宝同步
     * @param orderId
     * @return
     */
    @RequestMapping("/alipayReturn/{orderId}")
    public R alipayReturn(@PathVariable("orderId") String orderId){
        //跳转到订单详情页
    	return R.ok("跳转到订单详情页");
    }
    
    @ResponseBody
    @RequestMapping("/alipayNotify")
    public R alipayNotify(){
        String alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0Av62gpFScGmXDZLo7b/sZynYQiD2ZVud5UzqotlxcTwu8CFe85bYND/qpwYjFVP4N4Sz9+V/kA2VxZzgxIcpm2BMXjEVbPCl8VMfR55XJV41+J0A6D2E8KZuLrMCwRjVD94N7ZiOH5viFCVF1QQmf/JMKFC/dU3Hq6gEODy2gIoXXmRoC8/Jkm9pG6fsUqcrbIpc0DgewditFMMBdHIbFpBK2PiSxNocE0pq3RJpf6Er08E/2vNYNYid/IVllu8u7nVWNAncJ5DkV8sSpWiQHUs8dHyTAHRQgFjoIL8GZSsyr4aS+xLZNK3A15wDh/7ZJoFpXI72qeIJ6fQNyNatwIDAQAB";
    	//获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = getRequest().getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        System.out.println("==alipayNotify==="+params);
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        try {
            boolean flag = AlipaySignature.rsaCheckV1(params, alipayPublicKey, AlipayConstants.CHARSET_UTF8,AlipayConstants.SIGN_TYPE_RSA2);
            if(flag){
                //插入流水
                String trade_status = params.get("trade_status");
                String out_trade_no = params.get("out_trade_no");
                String passback_params = params.get("passback_params");
                String orderId = "";
                try {
                    orderId = URLDecoder.decode(passback_params,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if("TRADE_SUCCESS".equals(trade_status) || "TRADE_FINISHED".equals(trade_status)){
                    //支付流水添加
                    BigDecimal total_amount = new BigDecimal(params.get("total_amount"));
                    OrderEntity order=orderService.selectById(orderId);
                    PaymentEntity payment = new PaymentEntity();
                    payment.setCreatedate(new Date());
                    payment.setModifydate(new Date());
                    payment.setMemberid(order.getMemberid());
                    payment.setOrderid(orderId);
                    payment.setAmount(total_amount);
                    payment.setSn(out_trade_no);
                    payment.setMethod(CommonAttribute.PAYMENT_METHOD_ALIPAY);
                    paymentService.insert(payment);
                    
                    if("2".equals(order.getType())) {
                    	//二手产品状态修改
                    	List<OrderItemEntity> items = orderItemService.selectList(new EntityWrapper<OrderItemEntity>().eq("orderId", orderId));
                    	for(int i=0;i<items.size();i++) {
                    		OrderItemEntity item = items.get(i);
                    		ProductEntity p=productService.selectById(item.getProductid());
                    		if("2".equals(p.getType())) {
                    			p.setIsmarketable(false);
                    			productService.updateById(p);
                    		}
                    	}
                    }
                    //订单状态修改
                    order.setSn(out_trade_no);//支付交易号
                    order.setStatus(CommonAttribute.ORDER_STATUS_PENDING_SHIPMENT);
                    order.setModifydate(new Date());
                    orderService.updateById(order);
                }
            }
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	return R.ok();
    }

    @RequestMapping("/weixinNotify")
    public String weixinNotify(){
    	String weixinpayKey = "c3687265875760282l36872653687265";
    	String data = HttpClientUtil.readData(getRequest());
    	Map<String,String> weixinResult = new HashMap<String,String>();
        try {
            System.out.println("==weixinpayNotify=data="+data);
            Map<String,String> result = WeixinUtils.xmlToMap(data);
            System.out.println("==weixinpayNotify=result="+result);
            
            //判断验签
            if(WeixinUtils.isSignatureValid(data, weixinpayKey)){
                String orderId = result.get("out_trade_no");
                String result_code = result.get("result_code");
//                String orderId = result.get("attach");
                System.out.println();
                if("SUCCESS".equals(result_code)){
                    //支付流水添加
                    Integer total_fee = Integer.valueOf(result.get("total_fee"));
                    OrderEntity order=orderService.selectById(orderId);
                    PaymentEntity payment = new PaymentEntity();
                    payment.setCreatedate(new Date());
                    payment.setModifydate(new Date());
                    payment.setMemberid(order.getMemberid());
                    payment.setOrderid(orderId);
                    payment.setAmount(new BigDecimal(total_fee).divide(new BigDecimal(100)));
//                    payment.setSn(out_trade_no);
                    payment.setMethod(CommonAttribute.PAYMENT_METHOD_WEIXIN);
                    paymentService.insert(payment);
                    
                    if("2".equals(order.getType())) {
                    	//二手产品状态修改
                    	List<OrderItemEntity> items = orderItemService.selectList(new EntityWrapper<OrderItemEntity>().eq("orderId", orderId));
                    	for(int i=0;i<items.size();i++) {
                    		OrderItemEntity item = items.get(i);
                    		ProductEntity p=productService.selectById(item.getProductid());
                    		if("2".equals(p.getType())) {
                    			p.setIsmarketable(false);
                    			productService.updateById(p);
                    		}
                    	}
                    }
                    //订单状态修改
//                    order.setSn(out_trade_no);//支付交易号
                    order.setStatus(CommonAttribute.ORDER_STATUS_PENDING_SHIPMENT);
                    order.setModifydate(new Date());
                    orderService.updateById(order);
                    //返回
                    weixinResult.put("return_code", "SUCCESS");
                    weixinResult.put("return_msg", "OK");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            return WeixinUtils.mapToXml(weixinResult);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return "error";
    }

}
