package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 地区管理--镇区表
 * 
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@TableName("area_town")
public class AreaTownEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String cityNo;
	/**
	 * 区域编号
	 */
	private String townNo;
	/**
	 * 区域名称
	 */
	private String townName;
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
	 * 设置：
	 */
	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}
	/**
	 * 获取：
	 */
	public String getCityNo() {
		return cityNo;
	}
	/**
	 * 设置：区域编号
	 */
	public void setTownNo(String townNo) {
		this.townNo = townNo;
	}
	/**
	 * 获取：区域编号
	 */
	public String getTownNo() {
		return townNo;
	}
	/**
	 * 设置：区域名称
	 */
	public void setTownName(String townName) {
		this.townName = townName;
	}
	/**
	 * 获取：区域名称
	 */
	public String getTownName() {
		return townName;
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
