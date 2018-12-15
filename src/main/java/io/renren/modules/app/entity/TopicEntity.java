package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 话题
 * 
 * @author lhc
 * @email 
 * @date 2018-06-26 23:52:37
 */
@TableName("topic")
public class TopicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 话题id
	 */
	@TableId
	private String topicId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 论坛id
	 */
	private String forumId;
	/**
	 * 题目
	 */
	private String title;
	/**
	 * 简介
	 */
	private String intro;
	/**
	 * 题主id
	 */
	private String userId;
	/**
	 * 姓名
	 */
	private String userName;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 视频/图片
	 */
	private String resources;
	/**
	 * 位置
	 */
	private String location;
	/**
	 * 点赞数量
	 */
	private String praise;
	/**
	 * 关注数
	 */
	private Integer attentionNum;
	/**
	 * 评论数
	 */
	private Integer comment;
	/**
	 * 分享
	 */
	private String share;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 置顶
	 */
	private Integer top;
	/**
	 * 热门
	 */
	private Integer hot;
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
	 * 设置：话题id
	 */
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	/**
	 * 获取：话题id
	 */
	public String getTopicId() {
		return topicId;
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
	 * 设置：论坛id
	 */
	public void setForumId(String forumId) {
		this.forumId = forumId;
	}
	/**
	 * 获取：论坛id
	 */
	public String getForumId() {
		return forumId;
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
	 * 设置：题主id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：题主id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：姓名
	 */
	public String getUserName() {
		return userName;
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
	 * 设置：位置
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 获取：位置
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置：点赞数量
	 */
	public void setPraise(String praise) {
		this.praise = praise;
	}
	/**
	 * 获取：点赞数量
	 */
	public String getPraise() {
		return praise;
	}
	/**
	 * 设置：关注数
	 */
	public void setAttentionNum(Integer attentionNum) {
		this.attentionNum = attentionNum;
	}
	/**
	 * 获取：关注数
	 */
	public Integer getAttentionNum() {
		return attentionNum;
	}
	/**
	 * 设置：评论数
	 */
	public void setComment(Integer comment) {
		this.comment = comment;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getComment() {
		return comment;
	}
	/**
	 * 设置：分享
	 */
	public void setShare(String share) {
		this.share = share;
	}
	/**
	 * 获取：分享
	 */
	public String getShare() {
		return share;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPublishTime() {
		return publishTime;
	}
	/**
	 * 设置：置顶
	 */
	public void setTop(Integer top) {
		this.top = top;
	}
	/**
	 * 获取：置顶
	 */
	public Integer getTop() {
		return top;
	}
	/**
	 * 设置：热门
	 */
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	/**
	 * 获取：热门
	 */
	public Integer getHot() {
		return hot;
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
