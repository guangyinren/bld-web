package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * 
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String userId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 类型(0:学生，1:老师)
	 */
	private Integer type;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 性别(0:未知,1：男,2：女)
	 */
	private Integer sex;
	/**
	 * 生日方式(0:阳历,1：阴历)
	 */
	private Integer birthdayType;
	/**
	 * 出生日期
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date birthday;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 级别
	 */
	private Integer level;
	/**
	 * vip级别
	 */
	private Integer viplevel;
	/**
	 * 安全级别
	 */
	private Integer safelevel;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 证件类型证件类型（0:身份证,1:护照,2:军官证,3:户口本）
	 */
	private String idType;
	/**
	 * 证件号码
	 */
	private String idNum;
	/**
	 * 学校ID
	 */
	private String schoolId;
	/**
	 * 班级ID
	 */
	private String uclassId;
	/**
	 * 学校
	 */
	private String school;
	/**
	 * 年级
	 */
	private String grade;
	/**
	 * 班级
	 */
	private String uclass;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 手机sn码
	 */
	private String snCodes;
	/**
	 * 第三方账号
	 */
	private String thirdNumbers;
	/**
	 * 头像
	 */
	private String headpicPath;
	/**
	 * 背景
	 */
	private String bgPath;
	/**
	 * 个人简介
	 */
	private String intro;
	/**
	 * 标签
	 */
	private String label;
	/**
	 * 二维码
	 */
	private String qrCode;
	/**
	 * 设置
	 */
	private String settings;
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
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
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
	 * 设置：类型(0:学生，1:老师)
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:学生，1:老师)
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：性别(0:未知,1：男,2：女)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别(0:未知,1：男,2：女)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：生日方式(0:阳历,1：阴历)
	 */
	public void setBirthdayType(Integer birthdayType) {
		this.birthdayType = birthdayType;
	}
	/**
	 * 获取：生日方式(0:阳历,1：阴历)
	 */
	public Integer getBirthdayType() {
		return birthdayType;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：出生日期
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：级别
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：级别
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：vip级别
	 */
	public void setViplevel(Integer viplevel) {
		this.viplevel = viplevel;
	}
	/**
	 * 获取：vip级别
	 */
	public Integer getViplevel() {
		return viplevel;
	}
	/**
	 * 设置：安全级别
	 */
	public void setSafelevel(Integer safelevel) {
		this.safelevel = safelevel;
	}
	/**
	 * 获取：安全级别
	 */
	public Integer getSafelevel() {
		return safelevel;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：证件类型证件类型（0:身份证,1:护照,2:军官证,3:户口本）
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * 获取：证件类型证件类型（0:身份证,1:护照,2:军官证,3:户口本）
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 设置：证件号码
	 */
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	/**
	 * 获取：证件号码
	 */
	public String getIdNum() {
		return idNum;
	}
	/**
	 * 设置：学校ID
	 */
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * 获取：学校ID
	 */
	public String getSchoolId() {
		return schoolId;
	}
	/**
	 * 设置：班级ID
	 */
	public void setUclassId(String uclassId) {
		this.uclassId = uclassId;
	}
	/**
	 * 获取：班级ID
	 */
	public String getUclassId() {
		return uclassId;
	}
	/**
	 * 设置：学校
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * 获取：学校
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * 设置：年级
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * 获取：年级
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * 设置：班级
	 */
	public void setUclass(String uclass) {
		this.uclass = uclass;
	}
	/**
	 * 获取：班级
	 */
	public String getUclass() {
		return uclass;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：手机sn码
	 */
	public void setSnCodes(String snCodes) {
		this.snCodes = snCodes;
	}
	/**
	 * 获取：手机sn码
	 */
	public String getSnCodes() {
		return snCodes;
	}
	/**
	 * 设置：第三方账号
	 */
	public void setThirdNumbers(String thirdNumbers) {
		this.thirdNumbers = thirdNumbers;
	}
	/**
	 * 获取：第三方账号
	 */
	public String getThirdNumbers() {
		return thirdNumbers;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadpicPath(String headpicPath) {
		this.headpicPath = headpicPath;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadpicPath() {
		return headpicPath;
	}
	/**
	 * 设置：背景
	 */
	public void setBgPath(String bgPath) {
		this.bgPath = bgPath;
	}
	/**
	 * 获取：背景
	 */
	public String getBgPath() {
		return bgPath;
	}
	/**
	 * 设置：个人简介
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：个人简介
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：标签
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * 获取：标签
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * 设置：二维码
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	/**
	 * 获取：二维码
	 */
	public String getQrCode() {
		return qrCode;
	}
	/**
	 * 设置：设置
	 */
	public void setSettings(String settings) {
		this.settings = settings;
	}
	/**
	 * 获取：设置
	 */
	public String getSettings() {
		return settings;
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
