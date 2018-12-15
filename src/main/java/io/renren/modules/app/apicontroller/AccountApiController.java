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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
import io.renren.modules.app.entity.AccountEntity;
import io.renren.modules.app.entity.AccountLogEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.AccountLogService;
import io.renren.modules.app.service.AccountService;



/**
 * 账户
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 12:40:20
 */
@RestController
@RequestMapping("api/account")
public class AccountApiController extends AbstractController{
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountLogService accountLogService;

    /**
     *    获取用户余额
     * @param userId
     * @return
     */
    @RequestMapping("/balance")
    public R balance(String userId){
    	if (StringUtils.isEmpty(userId)) {
			return R.error(1, "必传参数为空");
		}
    	AccountEntity account = accountService.selectOne(new EntityWrapper<AccountEntity>().eq("userId", userId));
    	HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userId", userId);
		dataMap.put("balance", account.getBalance());
		return R.ok().put("data", dataMap);
    }
    
    @RequestMapping("/log")
    public R log(String userId){
    	if (StringUtils.isEmpty(userId)) {
    		return R.error(1, "必传参数为空");
    	}
    	List<Map<String, Object>> listmap = accountLogService
				.selectMaps(new EntityWrapper<AccountLogEntity>().setSqlSelect("id,isAdd,userId,amount,sourceName,createTime").eq("status", 1).eq("userId", userId).orderBy("createTime", false));
		// 查询单个字段
    	return R.ok().put("list", listmap);
    }
    
    @RequestMapping("/recharge")
    public R pay(String ip,String type,BigDecimal amount){
    	UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
    	if (ValidateUtils.isContainEmpty(amount,ip,type)) {
			return R.error(1, "必传参数为空");
		}
    	AccountEntity account = accountService.selectOne(new EntityWrapper<AccountEntity>().eq("userId", user.getUserId()));
    	if(account==null) {
    		account=new AccountEntity();
            account.setUserid(user.getUserId());
            account.setCreatetime(new Date());
            accountService.insert(account);
    	}
    	AccountLogEntity accountLog=new AccountLogEntity();
    	accountLog.setUserid(user.getUserId());
    	accountLog.setType("0");//充值
    	accountLog.setStatus("0");//进行中
    	accountLog.setIsadd(1);
    	accountLog.setAmount(amount);
    	accountLog.setBalance(account.getBalance().add(amount));//充值后可用余额
    	accountLog.setCreatetime(new Date());
    	if("0".equals(type)) {//微信
    		accountLog.setSourcetype("0");
    		accountLog.setSourcename("微信");
    		accountLog.setPsourcetype("0");
    		accountLog.setPsourcename("微信");
    		accountLogService.insert(accountLog);
    		Map<String,Object> result =WeixinUtils.h5PayRecharge(accountLog.getAccountlogid(),amount, "充值", ip, getResponse());
        	result.put("mweb_url", result.get("mweb_url")+accountLog.getAccountlogid());
        	System.out.println("返回页面的结果:"+result);
        	return R.ok(result);
    		
    	}else if("1".equals(type)) {//支付宝
    		accountLog.setSourcetype("1");
    		accountLog.setSourcename("支付宝");
    		accountLog.setPsourcetype("1");
    		accountLog.setPsourcename("支付宝");
    		accountLogService.insert(accountLog);
    		AlipayUtils.webPayRecharge(accountLog.getAccountlogid(), amount/*.multiply(new BigDecimal(100))*/, "充值", getRequest(), getResponse());
    	}else {
    		return R.error(1, "type有误");
    	}
		return R.ok();
        
    }
    
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
                BigDecimal total_amount = new BigDecimal(params.get("total_amount"));
                AccountLogEntity log=accountLogService.selectById(orderId);
                if("TRADE_SUCCESS".equals(trade_status) || "TRADE_FINISHED".equals(trade_status)){
                    //账户流水状态修改
                    if(log.getAmount().compareTo(total_amount)!=0) {
                    	log.setStatus("3");//异常单子
                    }else {
                    	log.setStatus("1");//成功
                    	log.setEndtime(new Date());
                    	//修改账户金额
                    	AccountEntity account = accountService.selectById(log.getAccountid());
                    	account.setBalance(account.getBalance().add(total_amount));
                    	account.setModifytime(new Date());
                    	accountService.updateById(account);
                    }
                }else {
                	log.setStatus("2");//失败
                }
                log.setModifytime(new Date());
                accountLogService.updateById(log);
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
                
                AccountLogEntity log=accountLogService.selectById(orderId);
                
                if("SUCCESS".equals(result_code)){
                    //支付流水添加
                    Integer total_fee = Integer.valueOf(result.get("total_fee"));
                    BigDecimal total_amount = new BigDecimal(total_fee).divide(new BigDecimal(100));
                    //账户流水状态修改
                    if(log.getAmount().compareTo(total_amount)!=0) {
                    	log.setStatus("3");//异常单子
                    }else {
                    	log.setStatus("1");//成功
                    	log.setEndtime(new Date());
                    	//修改账户金额
                    	AccountEntity account = accountService.selectById(log.getAccountid());
                    	account.setBalance(account.getBalance().add(total_amount));
                    	account.setModifytime(new Date());
                    	accountService.updateById(account);
                    }
                    //返回
                    weixinResult.put("return_code", "SUCCESS");
                    weixinResult.put("return_msg", "OK");
                }else {
                	log.setStatus("2");//失败
                }
                log.setModifytime(new Date());
                accountLogService.updateById(log);
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
