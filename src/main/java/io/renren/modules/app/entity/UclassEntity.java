package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级
 * 
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@TableName("uclass")
public class UclassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 班级id
	 */
	@TableId
	private String uclassId;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 学校id
	 */
	private String schoolId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 介绍
	 */
	private String intro;
	/**
	 * 创建年份
	 */
	private Integer year;
	/**
	 * 班级号码
	 */
	private Integer classNum;
	/**
	 * 人数
	 */
	private Integer studentNum;
	/**
	 * 管理员
	 */
	private String managers;
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
	 * 设置：班级id
	 */
	public void setUclassId(String uclassId) {
		this.uclassId = uclassId;
	}
	/**
	 * 获取：班级id
	 */
	public String getUclassId() {
		return uclassId;
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
	 * 设置：学校id
	 */
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * 获取：学校id
	 */
	public String getSchoolId() {
		return schoolId;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：介绍
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：介绍
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：创建年份
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：创建年份
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：班级号码
	 */
	public void setClassNum(Integer classNum) {
		this.classNum = classNum;
	}
	/**
	 * 获取：班级号码
	 */
	public Integer getClassNum() {
		return classNum;
	}
	/**
	 * 设置：人数
	 */
	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}
	/**
	 * 获取：人数
	 */
	public Integer getStudentNum() {
		return studentNum;
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
