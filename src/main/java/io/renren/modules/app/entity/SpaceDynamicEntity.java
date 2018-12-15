package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 空间动态
 * 
 * @author lhc
 * @email 
 * @date 2018-12-11 17:07:01
 */
@TableName("space_dynamic")
public class SpaceDynamicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String spaceDynamicId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 类型(0:用户,1:公众号,2:话题))
	 */
	private String type;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 来源类型(一般是表名)
	 */
	private String sourcetype;
	/**
	 * 来源id
	 */
	private String sourceid;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 
	 */
	private Integer sortno;
	/**
	 * 视频/图片
	 */
	private String resources;
	/**
	 * 位置
	 */
	private String location;
	/**
	 * 点赞
	 */
	private String praise;
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
	 * 是否置顶
	 */
	private Integer isTop;
	/**
	 * 是否热门
	 */
	private Integer isHot;
	/**
	 * 是否外链(分享)
	 */
	private Integer isLink;
	/**
	 * 引用动态id
	 */
	private String linkid;
	/**
	 * 配置属性
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
	 * 修改日期
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
	public void setSpaceDynamicId(String spaceDynamicId) {
		this.spaceDynamicId = spaceDynamicId;
	}
	/**
	 * 获取：
	 */
	public String getSpaceDynamicId() {
		return spaceDynamicId;
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
	 * 设置：类型(0:用户,1:公众号,2:话题))
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:用户,1:公众号,2:话题))
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
	 * 设置：来源类型(一般是表名)
	 */
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	/**
	 * 获取：来源类型(一般是表名)
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
	 * 设置：
	 */
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	/**
	 * 获取：
	 */
	public Integer getSortno() {
		return sortno;
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
	 * 设置：点赞
	 */
	public void setPraise(String praise) {
		this.praise = praise;
	}
	/**
	 * 获取：点赞
	 */
	public String getPraise() {
		return praise;
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
	 * 设置：是否置顶
	 */
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	/**
	 * 获取：是否置顶
	 */
	public Integer getIsTop() {
		return isTop;
	}
	/**
	 * 设置：是否热门
	 */
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	/**
	 * 获取：是否热门
	 */
	public Integer getIsHot() {
		return isHot;
	}
	/**
	 * 设置：是否外链(分享)
	 */
	public void setIsLink(Integer isLink) {
		this.isLink = isLink;
	}
	/**
	 * 获取：是否外链(分享)
	 */
	public Integer getIsLink() {
		return isLink;
	}
	/**
	 * 设置：引用动态id
	 */
	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}
	/**
	 * 获取：引用动态id
	 */
	public String getLinkid() {
		return linkid;
	}
	/**
	 * 设置：配置属性
	 */
	public void setConfig(String config) {
		this.config = config;
	}
	/**
	 * 获取：配置属性
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
	 * 设置：修改日期
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改日期
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
