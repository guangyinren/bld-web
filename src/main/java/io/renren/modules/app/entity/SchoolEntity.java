package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 学校
 * 
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@TableName("school")
public class SchoolEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学校id
	 */
	@TableId
	private String schoolId;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 学校代号
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 英文名称
	 */
	private String enName;
	/**
	 * 简称
	 */
	private String shortName;
	/**
	 * 介绍
	 */
	private String intro;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 县
	 */
	private String town;
	/**
	 * 详细地址
	 */
	private String adress;
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
	 * 一年级单价/每天
	 */
	private BigDecimal onePrice;
	/**
	 * 二年级单价/每天
	 */
	private BigDecimal twoPrice;
	/**
	 * 三年级单价/每天
	 */
	private BigDecimal threePrice;
	/**
	 * 四年级单价/每天
	 */
	private BigDecimal fourPrice;
	/**
	 * 学校单价/每天
	 */
	private BigDecimal schoolPrice;

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
	 * 设置：学校代号
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：学校代号
	 */
	public String getCode() {
		return code;
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
	 * 设置：英文名称
	 */
	public void setEnName(String enName) {
		this.enName = enName;
	}
	/**
	 * 获取：英文名称
	 */
	public String getEnName() {
		return enName;
	}
	/**
	 * 设置：简称
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * 获取：简称
	 */
	public String getShortName() {
		return shortName;
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
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：县
	 */
	public void setTown(String town) {
		this.town = town;
	}
	/**
	 * 获取：县
	 */
	public String getTown() {
		return town;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAdress() {
		return adress;
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
	 * 设置：一年级单价/每天
	 */
	public void setOnePrice(BigDecimal onePrice) {
		this.onePrice = onePrice;
	}
	/**
	 * 获取：一年级单价/每天
	 */
	public BigDecimal getOnePrice() {
		return onePrice;
	}
	/**
	 * 设置：二年级单价/每天
	 */
	public void setTwoPrice(BigDecimal twoPrice) {
		this.twoPrice = twoPrice;
	}
	/**
	 * 获取：二年级单价/每天
	 */
	public BigDecimal getTwoPrice() {
		return twoPrice;
	}
	/**
	 * 设置：三年级单价/每天
	 */
	public void setThreePrice(BigDecimal threePrice) {
		this.threePrice = threePrice;
	}
	/**
	 * 获取：三年级单价/每天
	 */
	public BigDecimal getThreePrice() {
		return threePrice;
	}
	/**
	 * 设置：四年级单价/每天
	 */
	public void setFourPrice(BigDecimal fourPrice) {
		this.fourPrice = fourPrice;
	}
	/**
	 * 获取：四年级单价/每天
	 */
	public BigDecimal getFourPrice() {
		return fourPrice;
	}
	/**
	 * 设置：学校单价/每天
	 */
	public void setSchoolPrice(BigDecimal schoolPrice) {
		this.schoolPrice = schoolPrice;
	}
	/**
	 * 获取：学校单价/每天
	 */
	public BigDecimal getSchoolPrice() {
		return schoolPrice;
	}
}
