package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 举报投诉表
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@TableName("complain")
public class ComplainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String complainId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 渠道
	 */
	private String channel;
	/**
	 * 举报人id
	 */
	private String userId;
	/**
	 * 联系方式
	 */
	private String informInfo;
	/**
	 * 来源类型
	 */
	private String sourceType;
	/**
	 * 来源id
	 */
	private String sourceId;
	/**
	 * 举报关键词
	 */
	private String keywords;
	/**
	 * 描述
	 */
	private String intro;
	/**
	 * 处理信息
	 */
	private String dealInfo;
	/**
	 * 处理人
	 */
	private String dealUser;
	/**
	 * 处理时间
	 */
	private Date dealTime;
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
	 * 设置：
	 */
	public void setComplainId(String complainId) {
		this.complainId = complainId;
	}
	/**
	 * 获取：
	 */
	public String getComplainId() {
		return complainId;
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
	 * 设置：渠道
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * 获取：渠道
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * 设置：举报人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：举报人id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：联系方式
	 */
	public void setInformInfo(String informInfo) {
		this.informInfo = informInfo;
	}
	/**
	 * 获取：联系方式
	 */
	public String getInformInfo() {
		return informInfo;
	}
	/**
	 * 设置：来源类型
	 */
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	/**
	 * 获取：来源类型
	 */
	public String getSourceType() {
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
	 * 设置：举报关键词
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	/**
	 * 获取：举报关键词
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * 设置：描述
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：描述
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：处理信息
	 */
	public void setDealInfo(String dealInfo) {
		this.dealInfo = dealInfo;
	}
	/**
	 * 获取：处理信息
	 */
	public String getDealInfo() {
		return dealInfo;
	}
	/**
	 * 设置：处理人
	 */
	public void setDealUser(String dealUser) {
		this.dealUser = dealUser;
	}
	/**
	 * 获取：处理人
	 */
	public String getDealUser() {
		return dealUser;
	}
	/**
	 * 设置：处理时间
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getDealTime() {
		return dealTime;
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
