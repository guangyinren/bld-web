package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lhc
 * @email 
 * @date 2018-12-05 22:34:43
 */
@TableName("shop_product_category")
public class ProductCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String objid;
	/**
	 * 
	 */
	private Date createdate;
	/**
	 * 
	 */
	private Date modifydate;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String parentid;
	/**
	 * 
	 */
	private String treepath;
	/**
	 * 
	 */
	private Integer grade;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 
	 */
	private String seodescription;
	/**
	 * 
	 */
	private String seokeywords;
	/**
	 * 
	 */
	private String seotitle;
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
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setObjid(String objid) {
		this.objid = objid;
	}
	/**
	 * 获取：
	 */
	public String getObjid() {
		return objid;
	}
	/**
	 * 设置：
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：
	 */
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	/**
	 * 获取：
	 */
	public Date getModifydate() {
		return modifydate;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	/**
	 * 获取：
	 */
	public String getParentid() {
		return parentid;
	}
	/**
	 * 设置：
	 */
	public void setTreepath(String treepath) {
		this.treepath = treepath;
	}
	/**
	 * 获取：
	 */
	public String getTreepath() {
		return treepath;
	}
	/**
	 * 设置：
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	/**
	 * 获取：
	 */
	public Integer getGrade() {
		return grade;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：
	 */
	public void setSeodescription(String seodescription) {
		this.seodescription = seodescription;
	}
	/**
	 * 获取：
	 */
	public String getSeodescription() {
		return seodescription;
	}
	/**
	 * 设置：
	 */
	public void setSeokeywords(String seokeywords) {
		this.seokeywords = seokeywords;
	}
	/**
	 * 获取：
	 */
	public String getSeokeywords() {
		return seokeywords;
	}
	/**
	 * 设置：
	 */
	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}
	/**
	 * 获取：
	 */
	public String getSeotitle() {
		return seotitle;
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
