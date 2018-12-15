package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 推广记录
 * 
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@TableName("spread_log")
public class SpreadLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 推广记录id
	 */
	@TableId
	private String spreadLogId;
	/**
	 * 状态(0:待审核,1:待支付,2:待推广,3.推广中,4:推广结束,5:退款,6:审核不通过)
	 */
	private Integer status;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 来源类型(0:动态)
	 */
	private Integer sourceType;
	/**
	 * 来源id
	 */
	private String sourceId;
	/**
	 * 推广地域(0:年级,1:学校,2:市,3:省,4:国)
	 */
	private Integer place;
	/**
	 * 单价
	 */
	private BigDecimal price;
	/**
	 * 天数
	 */
	private Integer num;
	/**
	 * 折扣
	 */
	private BigDecimal rate;
	/**
	 * 总价
	 */
	private BigDecimal totalprice;
	/**
	 * 实付金额
	 */
	private BigDecimal endprice;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 审核意见
	 */
	private String reason;
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
	 * 设置：推广记录id
	 */
	public void setSpreadLogId(String spreadLogId) {
		this.spreadLogId = spreadLogId;
	}
	/**
	 * 获取：推广记录id
	 */
	public String getSpreadLogId() {
		return spreadLogId;
	}
	/**
	 * 设置：状态(0:待审核,1:待支付,2:待推广,3.推广中,4:推广结束,5:退款,6:审核不通过)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:待审核,1:待支付,2:待推广,3.推广中,4:推广结束,5:退款,6:审核不通过)
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：来源类型(0:动态)
	 */
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
	/**
	 * 获取：来源类型(0:动态)
	 */
	public Integer getSourceType() {
		return sourceType;
	}
	/**
	 * 设置：来源id
	 */
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	/**
	 * 获取：来源id
	 */
	public String getSourceId() {
		return sourceId;
	}
	/**
	 * 设置：推广地域(0:年级,1:学校,2:市,3:省,4:国)
	 */
	public void setPlace(Integer place) {
		this.place = place;
	}
	/**
	 * 获取：推广地域(0:年级,1:学校,2:市,3:省,4:国)
	 */
	public Integer getPlace() {
		return place;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：天数
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：天数
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * 设置：折扣
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	/**
	 * 获取：折扣
	 */
	public BigDecimal getRate() {
		return rate;
	}
	/**
	 * 设置：总价
	 */
	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}
	/**
	 * 获取：总价
	 */
	public BigDecimal getTotalprice() {
		return totalprice;
	}
	/**
	 * 设置：实付金额
	 */
	public void setEndprice(BigDecimal endprice) {
		this.endprice = endprice;
	}
	/**
	 * 获取：实付金额
	 */
	public BigDecimal getEndprice() {
		return endprice;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：审核意见
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：审核意见
	 */
	public String getReason() {
		return reason;
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
