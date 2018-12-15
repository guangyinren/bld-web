package io.renren.modules.app.apicontroller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.constant.CommonAttribute;
import io.renren.modules.app.entity.OrderEntity;
import io.renren.modules.app.entity.ReceiverEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.OrderService;
import io.renren.modules.app.service.ReceiverService;



/**
 * 
 * 收货地址
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:50
 */
@RestController
@RequestMapping("api/receiver")
public class ReceiverApiController extends AbstractController{
    @Autowired
    private ReceiverService receiverService;
    @Autowired
    private OrderService orderService;

   /**
    * 获取当前用户的所有地址
    * @return
    */
    @RequestMapping("/list")
    public R list(){
    	UserEntity user = getUser();
    	if(user==null) {
    		return R.error(10,"用户未登录");
    	}
    	Wrapper<ReceiverEntity> wrapper = new EntityWrapper<>();
    	wrapper.eq("memberId", user.getUserId());
    	wrapper.setSqlSelect("id,areaName,address,consignee,phone,areaId,isDefault");
		List<Map<String, Object>> list = receiverService.selectMaps(wrapper);
        return R.ok().put("list", list);
    }


   /**
    * 获取默认地址
    * @return
    */
    @RequestMapping("/defaultinfo")
    public R defaultinfo(){
    	UserEntity user = getUser();
    	if(user==null) {
    		return R.error(10,"用户未登录");
    	}
    	Wrapper<ReceiverEntity> wrapper = new EntityWrapper<>();
    	wrapper.eq("memberId", user.getUserId());
    	wrapper.eq("isDefault", 1);
		ReceiverEntity receiver = receiverService.selectOne(wrapper);
		if(receiver==null) {
			return R.ok().put("data", null);
		}
		HashMap<String, Object> resultMap=new HashMap<>();
		resultMap.put("id", receiver.getId());
		resultMap.put("name", receiver.getConsignee());
		resultMap.put("phone", receiver.getPhone());
		resultMap.put("areaName", receiver.getAreaname());
		resultMap.put("address", receiver.getAddress());
		
        return R.ok().put("data", resultMap);
    }

    /**
     * 添加地址,如果之前没有地址则设置为默认地址
     * @param receiver
     * @return
     */
    @RequestMapping("/save")
    public R save(@RequestBody ReceiverEntity entity,String orderId){
    	UserEntity user = getUser();
    	if(user==null) {
    		return R.error(10,"用户未登录");
    	}
    	if (ValidateUtils.isContainEmpty(entity.getConsignee(), entity.getAreaname(),entity.getAddress(),entity.getPhone())) {
			return R.error(1, "必传参数为空");
		}
    	//判断用户之前是否有默认的地址
    	ReceiverEntity defaultReceiver = receiverService.selectOne(new EntityWrapper<ReceiverEntity>().eq("memberId", user.getUserId()).eq("isDefault", 1));
    	if(defaultReceiver==null) {
    		entity.setIsdefault(true);
    	}else if(entity.getIsdefault()) {
    		defaultReceiver.setIsdefault(false);
    		receiverService.updateById(defaultReceiver);
    		entity.setIsdefault(true);
    	}else {
    		entity.setIsdefault(false);
    	}
    	
    	entity.setMemberid(user.getUserId());
    	entity.setCreatedate(new Date());
		receiverService.insert(entity);
		
		//如果订单地址不为空则设置订单地址
		if (StringUtils.isEmpty(orderId)) {
			OrderEntity order = orderService.selectById(orderId);
			if(order!=null) {
				order.setConsignee(entity.getConsignee());
	    		order.setPhone(entity.getPhone());
	    		order.setAreaname(entity.getAreaname());
	    		order.setAddress(entity.getAddress());
	    		order.setStatus(CommonAttribute.ORDER_STATUS_PENDING_PAYMENT);
	    		orderService.updateById(order);
	    	}
		}
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ReceiverEntity receiver,String orderId){
    	UserEntity user = getUser();
    	if(user==null) {
    		return R.error(10,"用户未登录");
    	}
    	if (StringUtils.isEmpty(receiver.getId())) {
			return R.error(1, "id不能为空");
		}
    	ReceiverEntity entity = receiverService.selectById(receiver.getId());
    	if(entity==null) {
    		return R.error(1,"不存在此id的地址");
    	}
    	if (!StringUtils.isEmpty(receiver.getConsignee())) {
    		entity.setConsignee(receiver.getConsignee());
		}
    	if (!StringUtils.isEmpty(receiver.getAreaname())) {
    		entity.setAreaname(receiver.getAreaname());
		}
    	if (!StringUtils.isEmpty(receiver.getAddress())) {
    		entity.setAddress(receiver.getAddress());
		}
    	if (!StringUtils.isEmpty(receiver.getPhone())) {
    		entity.setPhone(receiver.getPhone());
		}
    	if (!StringUtils.isEmpty(receiver.getIsdefault())) {
    		if(receiver.getIsdefault()) {
    			//判断是否已经有默认地址且与当前不一样
    			ReceiverEntity defaultReceiver = receiverService.selectOne(new EntityWrapper<ReceiverEntity>().eq("memberId", user.getUserId()).eq("isDefault", 1));
            	if(defaultReceiver==null) {
            		entity.setIsdefault(true);
            	}else {
            		defaultReceiver.setIsdefault(false);
            		receiverService.updateById(defaultReceiver);
            		entity.setIsdefault(true);
            	}
    		}
		}
    	receiverService.updateById(entity);
    	//如果订单地址不为空则设置订单地址
    			if (StringUtils.isEmpty(orderId)) {
    				OrderEntity order = orderService.selectById(orderId);
    				if(order!=null) {
    					order.setConsignee(entity.getConsignee());
    		    		order.setPhone(entity.getPhone());
    		    		order.setAreaname(entity.getAreaname());
    		    		order.setAddress(entity.getAddress());
    		    		order.setStatus(CommonAttribute.ORDER_STATUS_PENDING_PAYMENT);
    		    		orderService.updateById(order);
    		    	}
    			}
    	return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(String id){
    	UserEntity user = getUser();
    	if(user==null) {
    		return R.error(10,"用户未登录");
    	}
    	if (StringUtils.isEmpty(id)) {
			return R.error(1, "id不能为空");
		}
		receiverService.deleteById(id);
        return R.ok();
    }

}
