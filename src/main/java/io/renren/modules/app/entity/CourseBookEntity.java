package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程表
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 09:22:05
 */
@TableName("course_book")
public class CourseBookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String courseBookId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 班级(对应user表)
	 */
	private String uclass;
	/**
	 * 班级信息
	 */
	private String classInfo;
	/**
	 * 学年信息
	 */
	private String yearInfo;
	/**
	 * 管理员
	 */
	private String managers;
	/**
	 * 早读
	 */
	private Integer isMorning;
	/**
	 * 早读
	 */
	private String kc0;
	/**
	 * 第一节
	 */
	private String kc1;
	/**
	 * 
	 */
	private String kc2;
	/**
	 * 
	 */
	private String kc3;
	/**
	 * 
	 */
	private String kc4;
	/**
	 * 
	 */
	private String kc5;
	/**
	 * 
	 */
	private String kc6;
	/**
	 * 
	 */
	private String kc7;
	/**
	 * 
	 */
	private String kc8;
	/**
	 * 
	 */
	private String kc9;
	/**
	 * 
	 */
	private String kc10;
	/**
	 * 
	 */
	private String kc11;
	/**
	 * 
	 */
	private String kc12;
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
	public void setCourseBookId(String courseBookId) {
		this.courseBookId = courseBookId;
	}
	/**
	 * 获取：
	 */
	public String getCourseBookId() {
		return courseBookId;
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
	 * 设置：班级(对应user表)
	 */
	public void setUclass(String uclass) {
		this.uclass = uclass;
	}
	/**
	 * 获取：班级(对应user表)
	 */
	public String getUclass() {
		return uclass;
	}
	/**
	 * 设置：班级信息
	 */
	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}
	/**
	 * 获取：班级信息
	 */
	public String getClassInfo() {
		return classInfo;
	}
	/**
	 * 设置：学年信息
	 */
	public void setYearInfo(String yearInfo) {
		this.yearInfo = yearInfo;
	}
	/**
	 * 获取：学年信息
	 */
	public String getYearInfo() {
		return yearInfo;
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
	 * 设置：早读
	 */
	public void setIsMorning(Integer isMorning) {
		this.isMorning = isMorning;
	}
	/**
	 * 获取：早读
	 */
	public Integer getIsMorning() {
		return isMorning;
	}
	/**
	 * 设置：早读
	 */
	public void setKc0(String kc0) {
		this.kc0 = kc0;
	}
	/**
	 * 获取：早读
	 */
	public String getKc0() {
		return kc0;
	}
	/**
	 * 设置：第一节
	 */
	public void setKc1(String kc1) {
		this.kc1 = kc1;
	}
	/**
	 * 获取：第一节
	 */
	public String getKc1() {
		return kc1;
	}
	/**
	 * 设置：
	 */
	public void setKc2(String kc2) {
		this.kc2 = kc2;
	}
	/**
	 * 获取：
	 */
	public String getKc2() {
		return kc2;
	}
	/**
	 * 设置：
	 */
	public void setKc3(String kc3) {
		this.kc3 = kc3;
	}
	/**
	 * 获取：
	 */
	public String getKc3() {
		return kc3;
	}
	/**
	 * 设置：
	 */
	public void setKc4(String kc4) {
		this.kc4 = kc4;
	}
	/**
	 * 获取：
	 */
	public String getKc4() {
		return kc4;
	}
	/**
	 * 设置：
	 */
	public void setKc5(String kc5) {
		this.kc5 = kc5;
	}
	/**
	 * 获取：
	 */
	public String getKc5() {
		return kc5;
	}
	/**
	 * 设置：
	 */
	public void setKc6(String kc6) {
		this.kc6 = kc6;
	}
	/**
	 * 获取：
	 */
	public String getKc6() {
		return kc6;
	}
	/**
	 * 设置：
	 */
	public void setKc7(String kc7) {
		this.kc7 = kc7;
	}
	/**
	 * 获取：
	 */
	public String getKc7() {
		return kc7;
	}
	/**
	 * 设置：
	 */
	public void setKc8(String kc8) {
		this.kc8 = kc8;
	}
	/**
	 * 获取：
	 */
	public String getKc8() {
		return kc8;
	}
	/**
	 * 设置：
	 */
	public void setKc9(String kc9) {
		this.kc9 = kc9;
	}
	/**
	 * 获取：
	 */
	public String getKc9() {
		return kc9;
	}
	/**
	 * 设置：
	 */
	public void setKc10(String kc10) {
		this.kc10 = kc10;
	}
	/**
	 * 获取：
	 */
	public String getKc10() {
		return kc10;
	}
	/**
	 * 设置：
	 */
	public void setKc11(String kc11) {
		this.kc11 = kc11;
	}
	/**
	 * 获取：
	 */
	public String getKc11() {
		return kc11;
	}
	/**
	 * 设置：
	 */
	public void setKc12(String kc12) {
		this.kc12 = kc12;
	}
	/**
	 * 获取：
	 */
	public String getKc12() {
		return kc12;
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
