package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 支付记录
 * 
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@TableName("pay_log")
public class PayLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 支付记录id
	 */
	@TableId
	private String payLogId;
	/**
	 * 类型(0:空间推广,1:开通会员)
	 */
	private Integer type;
	/**
	 * 状态(0:待完善支付信息,1:待支付,2:成功,3.失败,退款)
	 */
	private Integer status;
	/**
	 * 业务id
	 */
	private String businessId;
	/**
	 * 渠道id
	 */
	private String payChannelId;
	/**
	 * 渠道名称
	 */
	private String payChannelName;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 金额
	 */
	private BigDecimal amount;
	/**
	 * 手续费
	 */
	private BigDecimal fee;
	/**
	 * 付款类型
	 */
	private String payType;
	/**
	 * 付款号码
	 */
	private String payNum;
	/**
	 * 收款类型
	 */
	private String receiveType;
	/**
	 * 收款号码
	 */
	private String receiveNum;
	/**
	 * 信息
	 */
	private String info;
	/**
	 * 支付时间
	 */
	private Date payTime;
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
	private Date createTime;
	/**
	 * 最后修改日期
	 */
	private Date modifyTime;

	/**
	 * 设置：支付记录id
	 */
	public void setPayLogId(String payLogId) {
		this.payLogId = payLogId;
	}
	/**
	 * 获取：支付记录id
	 */
	public String getPayLogId() {
		return payLogId;
	}
	/**
	 * 设置：类型(0:空间推广,1:开通会员)
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:空间推广,1:开通会员)
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：状态(0:待完善支付信息,1:待支付,2:成功,3.失败,退款)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:待完善支付信息,1:待支付,2:成功,3.失败,退款)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：业务id
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	/**
	 * 获取：业务id
	 */
	public String getBusinessId() {
		return businessId;
	}
	/**
	 * 设置：渠道id
	 */
	public void setPayChannelId(String payChannelId) {
		this.payChannelId = payChannelId;
	}
	/**
	 * 获取：渠道id
	 */
	public String getPayChannelId() {
		return payChannelId;
	}
	/**
	 * 设置：渠道名称
	 */
	public void setPayChannelName(String payChannelName) {
		this.payChannelName = payChannelName;
	}
	/**
	 * 获取：渠道名称
	 */
	public String getPayChannelName() {
		return payChannelName;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：手续费
	 */
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	/**
	 * 获取：手续费
	 */
	public BigDecimal getFee() {
		return fee;
	}
	/**
	 * 设置：付款类型
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 获取：付款类型
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 设置：付款号码
	 */
	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	/**
	 * 获取：付款号码
	 */
	public String getPayNum() {
		return payNum;
	}
	/**
	 * 设置：收款类型
	 */
	public void setReceiveType(String receiveType) {
		this.receiveType = receiveType;
	}
	/**
	 * 获取：收款类型
	 */
	public String getReceiveType() {
		return receiveType;
	}
	/**
	 * 设置：收款号码
	 */
	public void setReceiveNum(String receiveNum) {
		this.receiveNum = receiveNum;
	}
	/**
	 * 获取：收款号码
	 */
	public String getReceiveNum() {
		return receiveNum;
	}
	/**
	 * 设置：信息
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 获取：信息
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * 设置：支付时间
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**
	 * 获取：支付时间
	 */
	public Date getPayTime() {
		return payTime;
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
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：最后修改日期
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：最后修改日期
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
}
