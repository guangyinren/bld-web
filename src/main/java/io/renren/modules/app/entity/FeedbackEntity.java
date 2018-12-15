package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 意见反馈
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 10:17:55
 */
@TableName("feedback")
public class FeedbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String feedbackid;
	/**
	 * 状态(0:未处理,1:处理中,2:处理完成)
	 */
	private String status;
	/**
	 * 类型(内容意见,产品意见,bug问题,其他)
	 */
	private String type;
	/**
	 * 渠道(0:app内容投诉,1:用户反馈)
	 */
	private String channel;
	/**
	 * 举报人id
	 */
	private String userid;
	/**
	 * 联系方式
	 */
	private String informinfo;
	/**
	 * 来源类型
	 */
	private String sourcetype;
	/**
	 * 来源id
	 */
	private String sourceid;
	/**
	 * 图片信息
	 */
	private String resources;
	/**
	 * 举报关键词
	 */
	private String keywords;
	/**
	 * 内容
	 */
	private String context;
	/**
	 * 反馈信息
	 */
	private String dealinfo;
	/**
	 * 处理结果
	 */
	private String dealresult;
	/**
	 * 处理人
	 */
	private String dealuser;
	/**
	 * 处理时间
	 */
	private Date dealtime;
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
	private Date createtime;
	/**
	 * 最后修改日期
	 */
	private Date modifytime;
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
	public void setFeedbackid(String feedbackid) {
		this.feedbackid = feedbackid;
	}
	/**
	 * 获取：
	 */
	public String getFeedbackid() {
		return feedbackid;
	}
	/**
	 * 设置：状态(0:未处理,1:处理中,2:处理完成)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:未处理,1:处理中,2:处理完成)
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型(内容意见,产品意见,bug问题,其他)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(内容意见,产品意见,bug问题,其他)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：渠道(0:app内容投诉,1:用户反馈)
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * 获取：渠道(0:app内容投诉,1:用户反馈)
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * 设置：举报人id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：举报人id
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：联系方式
	 */
	public void setInforminfo(String informinfo) {
		this.informinfo = informinfo;
	}
	/**
	 * 获取：联系方式
	 */
	public String getInforminfo() {
		return informinfo;
	}
	/**
	 * 设置：来源类型
	 */
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	/**
	 * 获取：来源类型
	 */
	public String getSourcetype() {
		return sourcetype;
	}
	/**
	 * 设置：来源id
	 */
	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}
	/**
	 * 获取：来源id
	 */
	public String getSourceid() {
		return sourceid;
	}
	/**
	 * 设置：图片信息
	 */
	public void setResources(String resources) {
		this.resources = resources;
	}
	/**
	 * 获取：图片信息
	 */
	public String getResources() {
		return resources;
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
	 * 设置：内容
	 */
	public void setContext(String context) {
		this.context = context;
	}
	/**
	 * 获取：内容
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 设置：反馈信息
	 */
	public void setDealinfo(String dealinfo) {
		this.dealinfo = dealinfo;
	}
	/**
	 * 获取：反馈信息
	 */
	public String getDealinfo() {
		return dealinfo;
	}
	/**
	 * 设置：处理结果
	 */
	public void setDealresult(String dealresult) {
		this.dealresult = dealresult;
	}
	/**
	 * 获取：处理结果
	 */
	public String getDealresult() {
		return dealresult;
	}
	/**
	 * 设置：处理人
	 */
	public void setDealuser(String dealuser) {
		this.dealuser = dealuser;
	}
	/**
	 * 获取：处理人
	 */
	public String getDealuser() {
		return dealuser;
	}
	/**
	 * 设置：处理时间
	 */
	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getDealtime() {
		return dealtime;
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
	 * 设置：最后修改日期
	 */
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	/**
	 * 获取：最后修改日期
	 */
	public Date getModifytime() {
		return modifytime;
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
