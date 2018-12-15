package io.renren.modules.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * 
 * @author lhc
 * @email 
 * @date 2018-12-11 16:07:23
 */
@TableName("shop_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableField(exist = false)
	private List<OrderItemEntity> orderItems;
	
	public List<OrderItemEntity> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemEntity> orderItems) {
		this.orderItems = orderItems;
	}
	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 类型(0:商城,1:便利店,2:二手商品)
	 */
	private String type;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 
	 */
	private Date expire;
	/**
	 * 用户id
	 */
	private Long memberid;
	/**
	 * 省市地址
	 */
	private String areaname;
	/**
	 * 
	 */
	private Date completedate;
	/**
	 * 收件人姓名
	 */
	private String consignee;
	/**
	 * 
	 */
	private String memo;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 
	 */
	private String sn;
	/**
	 * 
	 */
	private String zipcode;
	/**
	 * 
	 */
	private Long areaid;
	/**
	 * 状态(addAddress:待添加地址,pendingPayment:待付款)
	 */
	private String status;
	/**
	 * 配送方式(self:自取,deliver:物流)
	 */
	private String shippingmethod;
	/**
	 * 运费
	 */
	private BigDecimal shipfee;
	/**
	 * 运单号
	 */
	private String shipno;
	/**
	 * 运送公司
	 */
	private String shipcom;
	/**
	 * 目前地址
	 */
	private String shipnow;
	/**
	 * 总计金额
	 */
	private BigDecimal amount;
	/**
	 * 应付金额
	 */
	private BigDecimal totalprice;
	/**
	 * 明细条数
	 */
	private Integer quantity;
	/**
	 * 
	 */
	private Date createdate;
	/**
	 * 
	 */
	private Date modifydate;
	/**
	 * 
	 */
	private String prop1;
	/**
	 * 
	 */
	private String prop2;
	/**
	 * 
	 */
	private String prop3;
	/**
	 * 
	 */
	private String prop4;
	/**
	 * 
	 */
	private String prop5;
	/**
	 * 
	 */
	private String prop6;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：类型(0:商城,1:便利店,2:二手商品)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:商城,1:便利店,2:二手商品)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	/**
	 * 获取：
	 */
	public Date getExpire() {
		return expire;
	}
	/**
	 * 设置：用户id
	 */
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getMemberid() {
		return memberid;
	}
	/**
	 * 设置：省市地址
	 */
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	/**
	 * 获取：省市地址
	 */
	public String getAreaname() {
		return areaname;
	}
	/**
	 * 设置：
	 */
	public void setCompletedate(Date completedate) {
		this.completedate = completedate;
	}
	/**
	 * 获取：
	 */
	public Date getCompletedate() {
		return completedate;
	}
	/**
	 * 设置：收件人姓名
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	/**
	 * 获取：收件人姓名
	 */
	public String getConsignee() {
		return consignee;
	}
	/**
	 * 设置：
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}
	/**
	 * 获取：
	 */
	public String getSn() {
		return sn;
	}
	/**
	 * 设置：
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * 获取：
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * 设置：
	 */
	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}
	/**
	 * 获取：
	 */
	public Long getAreaid() {
		return areaid;
	}
	/**
	 * 设置：状态(addAddress:待添加地址,pendingPayment:待付款)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态(addAddress:待添加地址,pendingPayment:待付款)
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：配送方式(self:自取,deliver:物流)
	 */
	public void setShippingmethod(String shippingmethod) {
		this.shippingmethod = shippingmethod;
	}
	/**
	 * 获取：配送方式(self:自取,deliver:物流)
	 */
	public String getShippingmethod() {
		return shippingmethod;
	}
	/**
	 * 设置：运费
	 */
	public void setShipfee(BigDecimal shipfee) {
		this.shipfee = shipfee;
	}
	/**
	 * 获取：运费
	 */
	public BigDecimal getShipfee() {
		return shipfee;
	}
	/**
	 * 设置：运单号
	 */
	public void setShipno(String shipno) {
		this.shipno = shipno;
	}
	/**
	 * 获取：运单号
	 */
	public String getShipno() {
		return shipno;
	}
	/**
	 * 设置：运送公司
	 */
	public void setShipcom(String shipcom) {
		this.shipcom = shipcom;
	}
	/**
	 * 获取：运送公司
	 */
	public String getShipcom() {
		return shipcom;
	}
	/**
	 * 设置：目前地址
	 */
	public void setShipnow(String shipnow) {
		this.shipnow = shipnow;
	}
	/**
	 * 获取：目前地址
	 */
	public String getShipnow() {
		return shipnow;
	}
	/**
	 * 设置：总计金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：总计金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：应付金额
	 */
	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}
	/**
	 * 获取：应付金额
	 */
	public BigDecimal getTotalprice() {
		return totalprice;
	}
	/**
	 * 设置：明细条数
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取：明细条数
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * 设置：
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：
	 */
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	/**
	 * 获取：
	 */
	public Date getModifydate() {
		return modifydate;
	}
	/**
	 * 设置：
	 */
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
	/**
	 * 获取：
	 */
	public String getProp1() {
		return prop1;
	}
	/**
	 * 设置：
	 */
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}
	/**
	 * 获取：
	 */
	public String getProp2() {
		return prop2;
	}
	/**
	 * 设置：
	 */
	public void setProp3(String prop3) {
		this.prop3 = prop3;
	}
	/**
	 * 获取：
	 */
	public String getProp3() {
		return prop3;
	}
	/**
	 * 设置：
	 */
	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}
	/**
	 * 获取：
	 */
	public String getProp4() {
		return prop4;
	}
	/**
	 * 设置：
	 */
	public void setProp5(String prop5) {
		this.prop5 = prop5;
	}
	/**
	 * 获取：
	 */
	public String getProp5() {
		return prop5;
	}
	/**
	 * 设置：
	 */
	public void setProp6(String prop6) {
		this.prop6 = prop6;
	}
	/**
	 * 获取：
	 */
	public String getProp6() {
		return prop6;
	}
}
