package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知
 * 
 * @author lhc
 * @email 
 * @date 2018-07-08 19:24:58
 */
@TableName("inform")
public class InformEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String informId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 类型(0:点赞,1:评论)
	 */
	private String type;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 用户类型
	 */
	private String userType;
	/**
	 * 来源类型
	 */
	private String sourceType;
	/**
	 * 来源id
	 */
	private String sourceId;
	/**
	 * 源用户
	 */
	private String sourceUser;
	/**
	 * 源用户类型
	 */
	private String sourceUtype;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 视频/图片
	 */
	private String resources;
	/**
	 * 是否已读
	 */
	private Integer isReade;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 设置：
	 */
	public void setInformId(String informId) {
		this.informId = informId;
	}
	/**
	 * 获取：
	 */
	public String getInformId() {
		return informId;
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
	 * 设置：类型(0:点赞,1:评论)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:点赞,1:评论)
	 */
	public String getType() {
		return type;
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
	 * 设置：用户类型
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * 获取：用户类型
	 */
	public String getUserType() {
		return userType;
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
	 * 设置：源用户
	 */
	public void setSourceUser(String sourceUser) {
		this.sourceUser = sourceUser;
	}
	/**
	 * 获取：源用户
	 */
	public String getSourceUser() {
		return sourceUser;
	}
	/**
	 * 设置：源用户类型
	 */
	public void setSourceUtype(String sourceUtype) {
		this.sourceUtype = sourceUtype;
	}
	/**
	 * 获取：源用户类型
	 */
	public String getSourceUtype() {
		return sourceUtype;
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
	 * 设置：是否已读
	 */
	public void setIsReade(Integer isReade) {
		this.isReade = isReade;
	}
	/**
	 * 获取：是否已读
	 */
	public Integer getIsReade() {
		return isReade;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
