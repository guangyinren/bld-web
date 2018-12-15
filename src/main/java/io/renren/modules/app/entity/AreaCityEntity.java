package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 地区管理--地市表
 * 
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@TableName("area_city")
public class AreaCityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 省编号
	 */
	private String provinceNo;
	/**
	 * 地市编号
	 */
	private String cityNo;
	/**
	 * 地市名称
	 */
	private String cityName;
	/**
	 * 排序号
	 */
	private Integer sortno;
	/**
	 * 单价/每天
	 */
	private BigDecimal price;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：省编号
	 */
	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}
	/**
	 * 获取：省编号
	 */
	public String getProvinceNo() {
		return provinceNo;
	}
	/**
	 * 设置：地市编号
	 */
	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}
	/**
	 * 获取：地市编号
	 */
	public String getCityNo() {
		return cityNo;
	}
	/**
	 * 设置：地市名称
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * 获取：地市名称
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * 设置：排序号
	 */
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getSortno() {
		return sortno;
	}
	/**
	 * 设置：单价/每天
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：单价/每天
	 */
	public BigDecimal getPrice() {
		return price;
	}
}
