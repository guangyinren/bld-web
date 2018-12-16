package io.renren.modules.app.apicontroller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.DateUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.constant.CommonAttribute;
import io.renren.modules.app.entity.OrderEntity;
import io.renren.modules.app.entity.OrderItemEntity;
import io.renren.modules.app.entity.ProductEntity;
import io.renren.modules.app.entity.ReceiverEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.OrderItemService;
import io.renren.modules.app.service.OrderService;
import io.renren.modules.app.service.ProductService;
import io.renren.modules.app.service.ReceiverService;
import io.renren.modules.app.service.UserService;

/**
 * 
 *
 * @author lhc
 * @email
 * @date 2018-12-05 22:01:50
 */
@RestController
@RequestMapping("api/order")
public class OrderApiController extends AbstractController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ReceiverService receiverService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;

	/*
	 * 设置收货地址
	 */
	@RequestMapping("/setReceiver")
	public R setReceiver(String receiverId, String orderId) {
		UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		if (ValidateUtils.isContainEmpty(receiverId, orderId)) {
			return R.error(1, "必传参数为空");
		}
		OrderEntity order = orderService.selectById(orderId);
		if (order == null) {
			return R.error(1, "无此订单号");
		}
		ReceiverEntity defaultReceiver = receiverService.selectById(orderId);
		if (defaultReceiver == null) {
			return R.error(1, "无此收货地址");
		}
		order.setConsignee(defaultReceiver.getConsignee());
		order.setPhone(defaultReceiver.getPhone());
		order.setAreaname(defaultReceiver.getAreaname());
		order.setAddress(defaultReceiver.getAddress());
		order.setStatus(CommonAttribute.ORDER_STATUS_PENDING_PAYMENT);
		orderService.updateById(order);
		return R.ok();
	}

	/**
	 * 我的订单
	 * @param status
	 * @return
	 */
	@RequestMapping("/myList")
	public R myList(String status) {
		UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		Wrapper<OrderEntity> wrapper = new EntityWrapper<>();
		wrapper.setSqlSelect("id,status,memberId,consignee,areaName,address,phone,shippingMethod,amount,totalPrice,quantity,createDate,completeDate");
		wrapper.eq("memberId", user.getUserId()).orderBy("createDate", false);
		if (!StringUtils.isEmpty(status)) {
			wrapper.eq("status", status);
		}
		List<Map<String, Object>> list = orderService.selectMaps(wrapper);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> order=list.get(i);
			String sql = "select p.image,p.name,p.price,i.quantity FROM shop_order_item i,shop_product p WHERE i.productId=p.id and i.orderId="+order.get("id");
			List<Map<String, Object>> items = userService.selectSql(sql);
			order.put("items", items);
			list.set(i, order);
		}
		return R.ok().put("list", list);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") String id) {
		OrderEntity order = orderService.selectById(id);

		return R.ok().put("order", order);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody OrderEntity order) {
		UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}

		if (ValidateUtils.isContainEmpty(order.getType())) {
			return R.error(1, "必传参数为空");
		}
		// 校验明细项
		if (order.getOrderItems() == null || order.getOrderItems().size() <= 0) {
			return R.error(1, "该订单无商品");
		}
		BigDecimal totalprice = new BigDecimal(0);
		for (int i = 0; i < order.getOrderItems().size(); i++) {
			OrderItemEntity item = order.getOrderItems().get(i);
			ProductEntity product = productService.selectById(order.getOrderItems().get(i).getProductid());
			item.setName(product.getName());
			item.setImage(product.getImage());
			item.setPrice(product.getPrice());
			item.setCreatedate(new Date());
			item.setModifydate(new Date());
			totalprice = totalprice.add(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
		}
		// 是否有默认地址
		ReceiverEntity defaultReceiver = receiverService
				.selectOne(new EntityWrapper<ReceiverEntity>().eq("memberId", user.getUserId()).eq("isDefault", 1));
		if (defaultReceiver == null) {
			order.setStatus(CommonAttribute.ORDER_STATUS_ADD_ADDRESS);
		} else {
			order.setConsignee(defaultReceiver.getConsignee());
			order.setPhone(defaultReceiver.getPhone());
			order.setAreaname(defaultReceiver.getAreaname());
			order.setAddress(defaultReceiver.getAddress());
			order.setStatus(CommonAttribute.ORDER_STATUS_PENDING_PAYMENT);
		}
		if (StringUtils.isEmpty(order.getShippingmethod())) {// 默认为物流配送
			order.setShippingmethod(CommonAttribute.SHIPPING_METHOD_DELIVER);
		}
		// 设置一天过期
		order.setExpire(DateUtils.addDateDays(new Date(), 1));
		order.setQuantity(order.getOrderItems().size());
		order.setMemberid(Long.valueOf(user.getUserId()));
		order.setCreatedate(new Date());
		order.setAmount(totalprice);
		order.setTotalprice(totalprice);
		order.setModifydate(new Date());
		orderService.insert(order);
		for (int i = 0; i < order.getOrderItems().size(); i++) {
			order.getOrderItems().get(i).setOrderid(Long.valueOf(order.getId()));
		}
		orderItemService.insertBatch(order.getOrderItems());
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("orderId", order.getId());
		dataMap.put("totalprice", order.getTotalprice());
		return R.ok().put("data", dataMap);
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody OrderEntity order) {
		orderService.updateById(order);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("app:order:delete")
	public R delete(@RequestBody String[] ids) {
		orderService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
