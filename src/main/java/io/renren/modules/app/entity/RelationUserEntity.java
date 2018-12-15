package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 联系人
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@TableName("relation_user")
public class RelationUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String relationUserId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 分组
	 */
	private String group;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 联系人id
	 */
	private String relationUser;
	/**
	 * 联系人名称
	 */
	private String relationName;
	/**
	 * 备注
	 */
	private String relationRemark;
	/**
	 * 头像
	 */
	private String headPic;
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
	public void setRelationUserId(String relationUserId) {
		this.relationUserId = relationUserId;
	}
	/**
	 * 获取：
	 */
	public String getRelationUserId() {
		return relationUserId;
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
	 * 设置：分组
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	/**
	 * 获取：分组
	 */
	public String getGroup() {
		return group;
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
	 * 设置：联系人id
	 */
	public void setRelationUser(String relationUser) {
		this.relationUser = relationUser;
	}
	/**
	 * 获取：联系人id
	 */
	public String getRelationUser() {
		return relationUser;
	}
	/**
	 * 设置：联系人名称
	 */
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	/**
	 * 获取：联系人名称
	 */
	public String getRelationName() {
		return relationName;
	}
	/**
	 * 设置：备注
	 */
	public void setRelationRemark(String relationRemark) {
		this.relationRemark = relationRemark;
	}
	/**
	 * 获取：备注
	 */
	public String getRelationRemark() {
		return relationRemark;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadPic() {
		return headPic;
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
