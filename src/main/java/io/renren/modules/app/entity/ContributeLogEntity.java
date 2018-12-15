package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 投稿记录
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@TableName("contribute_log")
public class ContributeLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 投稿记录id
	 */
	@TableId
	private String contributeLogId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 作者
	 */
	private String userId;
	/**
	 * 活动id
	 */
	private String literatureActivityId;
	/**
	 * 投稿时间
	 */
	private Date contributeTime;
	/**
	 * 是否获奖
	 */
	private Integer isPrize;
	/**
	 * 奖品信息
	 */
	private String prizeInfo;
	/**
	 * 获奖时间
	 */
	private Date prizeTime;
	/**
	 * 设置
	 */
	private String config;
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
	 * 设置：投稿记录id
	 */
	public void setContributeLogId(String contributeLogId) {
		this.contributeLogId = contributeLogId;
	}
	/**
	 * 获取：投稿记录id
	 */
	public String getContributeLogId() {
		return contributeLogId;
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
	 * 设置：作者
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：作者
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：活动id
	 */
	public void setLiteratureActivityId(String literatureActivityId) {
		this.literatureActivityId = literatureActivityId;
	}
	/**
	 * 获取：活动id
	 */
	public String getLiteratureActivityId() {
		return literatureActivityId;
	}
	/**
	 * 设置：投稿时间
	 */
	public void setContributeTime(Date contributeTime) {
		this.contributeTime = contributeTime;
	}
	/**
	 * 获取：投稿时间
	 */
	public Date getContributeTime() {
		return contributeTime;
	}
	/**
	 * 设置：是否获奖
	 */
	public void setIsPrize(Integer isPrize) {
		this.isPrize = isPrize;
	}
	/**
	 * 获取：是否获奖
	 */
	public Integer getIsPrize() {
		return isPrize;
	}
	/**
	 * 设置：奖品信息
	 */
	public void setPrizeInfo(String prizeInfo) {
		this.prizeInfo = prizeInfo;
	}
	/**
	 * 获取：奖品信息
	 */
	public String getPrizeInfo() {
		return prizeInfo;
	}
	/**
	 * 设置：获奖时间
	 */
	public void setPrizeTime(Date prizeTime) {
		this.prizeTime = prizeTime;
	}
	/**
	 * 获取：获奖时间
	 */
	public Date getPrizeTime() {
		return prizeTime;
	}
	/**
	 * 设置：设置
	 */
	public void setConfig(String config) {
		this.config = config;
	}
	/**
	 * 获取：设置
	 */
	public String getConfig() {
		return config;
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
}
