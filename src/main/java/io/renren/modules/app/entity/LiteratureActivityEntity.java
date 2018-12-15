package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文学活动表
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@TableName("literature_activity")
public class LiteratureActivityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String literatureActivityId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 题目
	 */
	private String title;
	/**
	 * 简介
	 */
	private String intro;
	/**
	 * 规则说明
	 */
	private String ruleInfo;
	/**
	 * 须知/注意事项
	 */
	private String attentionInfo;
	/**
	 * 管理员
	 */
	private String managers;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 主办方
	 */
	private String sponsorName;
	/**
	 * 主办方公众号
	 */
	private String sponsorAccount;
	/**
	 * 投稿数
	 */
	private Integer articleNum;
	/**
	 * 浏览数
	 */
	private Integer browseNum;
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
	public void setLiteratureActivityId(String literatureActivityId) {
		this.literatureActivityId = literatureActivityId;
	}
	/**
	 * 获取：
	 */
	public String getLiteratureActivityId() {
		return literatureActivityId;
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
	 * 设置：题目
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：题目
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：简介
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：简介
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：规则说明
	 */
	public void setRuleInfo(String ruleInfo) {
		this.ruleInfo = ruleInfo;
	}
	/**
	 * 获取：规则说明
	 */
	public String getRuleInfo() {
		return ruleInfo;
	}
	/**
	 * 设置：须知/注意事项
	 */
	public void setAttentionInfo(String attentionInfo) {
		this.attentionInfo = attentionInfo;
	}
	/**
	 * 获取：须知/注意事项
	 */
	public String getAttentionInfo() {
		return attentionInfo;
	}
	/**
	 * 设置：管理员
	 */
	public void setManagers(String managers) {
		this.managers = managers;
	}
	/**
	 * 获取：管理员
	 */
	public String getManagers() {
		return managers;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：主办方
	 */
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	/**
	 * 获取：主办方
	 */
	public String getSponsorName() {
		return sponsorName;
	}
	/**
	 * 设置：主办方公众号
	 */
	public void setSponsorAccount(String sponsorAccount) {
		this.sponsorAccount = sponsorAccount;
	}
	/**
	 * 获取：主办方公众号
	 */
	public String getSponsorAccount() {
		return sponsorAccount;
	}
	/**
	 * 设置：投稿数
	 */
	public void setArticleNum(Integer articleNum) {
		this.articleNum = articleNum;
	}
	/**
	 * 获取：投稿数
	 */
	public Integer getArticleNum() {
		return articleNum;
	}
	/**
	 * 设置：浏览数
	 */
	public void setBrowseNum(Integer browseNum) {
		this.browseNum = browseNum;
	}
	/**
	 * 获取：浏览数
	 */
	public Integer getBrowseNum() {
		return browseNum;
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
