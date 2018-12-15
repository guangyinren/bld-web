package io.renren.modules.app.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 联系人表单
 * @author LHC
 * 2018年7月1日
 */
public class RelationUserForm {
	/**
	 * 联系人id
	 */
	@NotBlank(message="联系人id不能为空")
    private String relationUser;

    /**
     * 分组
     */
    private String group;
    
    /**
     * 名称
     */
    private String relationName;

    /**
     * 备注
     */
    private String relationRemark;
    
    /**
     * 用户id
     */
    @NotBlank(message="当前用户id不能为空")
    private String userId;

	public String getRelationUser() {
		return relationUser;
	}

	public void setRelationUser(String relationUser) {
		this.relationUser = relationUser;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRelationRemark() {
		return relationRemark;
	}

	public void setRelationRemark(String relationRemark) {
		this.relationRemark = relationRemark;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
}
