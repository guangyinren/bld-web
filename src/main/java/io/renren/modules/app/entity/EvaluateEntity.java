package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品评价
 * 
 * @author lhc
 * @email 
 * @date 2018-12-11 17:19:28
 */
@TableName("shop_evaluate")
public class EvaluateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String evaluateid;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 用户id
	 */
	private String userid;
	/**
	 * 回复评论id
	 */
	private String replyid;
	/**
	 * 商家id
	 */
	private String shopuserid;
	/**
	 * 产品id
	 */
	private String productid;
	/**
	 * 产品信息
	 */
	private String productinfo;
	/**
	 * 订单id
	 */
	private String orderid;
	/**
	 * 订单item id
	 */
	private String orderitemid;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 视频/图片
	 */
	private String resources;
	/**
	 * 发布时间
	 */
	private Date publishtime;
	/**
	 * 是否置顶
	 */
	private Integer istop;
	/**
	 * 是否热门
	 */
	private Integer ishot;
	/**
	 * 配置
	 */
	private String config;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 修改人
	 */
	private String modifier;
	/**
	 * 创建日期
	 */
	private Date createtime;
	/**
	 * 修改日期
	 */
	private Date modifytime;
	/**
	 * 回复的评论的用户id
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
	public void setEvaluateid(String evaluateid) {
		this.evaluateid = evaluateid;
	}
	/**
	 * 获取：
	 */
	public String getEvaluateid() {
		return evaluateid;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：回复评论id
	 */
	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}
	/**
	 * 获取：回复评论id
	 */
	public String getReplyid() {
		return replyid;
	}
	/**
	 * 设置：商家id
	 */
	public void setShopuserid(String shopuserid) {
		this.shopuserid = shopuserid;
	}
	/**
	 * 获取：商家id
	 */
	public String getShopuserid() {
		return shopuserid;
	}
	/**
	 * 设置：产品id
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}
	/**
	 * 获取：产品id
	 */
	public String getProductid() {
		return productid;
	}
	/**
	 * 设置：产品信息
	 */
	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}
	/**
	 * 获取：产品信息
	 */
	public String getProductinfo() {
		return productinfo;
	}
	/**
	 * 设置：订单id
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * 获取：订单id
	 */
	public String getOrderid() {
		return orderid;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：视频/图片
	 */
	public void setResources(String resources) {
		this.resources = resources;
	}
	/**
	 * 获取：视频/图片
	 */
	public String getResources() {
		return resources;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPublishtime() {
		return publishtime;
	}
	/**
	 * 设置：是否置顶
	 */
	public void setIstop(Integer istop) {
		this.istop = istop;
	}
	/**
	 * 获取：是否置顶
	 */
	public Integer getIstop() {
		return istop;
	}
	/**
	 * 设置：是否热门
	 */
	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}
	/**
	 * 获取：是否热门
	 */
	public Integer getIshot() {
		return ishot;
	}
	/**
	 * 设置：配置
	 */
	public void setConfig(String config) {
		this.config = config;
	}
	/**
	 * 获取：配置
	 */
	public String getConfig() {
		return config;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：修改人
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	/**
	 * 获取：修改人
	 */
	public String getModifier() {
		return modifier;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：修改日期
	 */
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	/**
	 * 获取：修改日期
	 */
	public Date getModifytime() {
		return modifytime;
	}
	/**
	 * 设置：回复的评论的用户id
	 */
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
	/**
	 * 获取：回复的评论的用户id
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
	public String getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(String orderitemid) {
		this.orderitemid = orderitemid;
	}
	
}
