package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 地区管理--省份表
 * 
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@TableName("area_province")
public class AreaProvinceEntity implements Serializable {
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
	 * 省名称
	 */
	private String provinceName;
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
	 * 设置：省名称
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	/**
	 * 获取：省名称
	 */
	public String getProvinceName() {
		return provinceName;
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
