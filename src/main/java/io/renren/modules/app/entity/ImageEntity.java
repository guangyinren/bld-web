package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片
 * 
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
@TableName("image")
public class ImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String imageId;
	/**
	 * 图片名
	 */
	private String name;
	/**
	 * 原名
	 */
	private String oldName;
	/**
	 * 后缀
	 */
	private String suffix;
	/**
	 * 宽
	 */
	private Integer width;
	/**
	 * 高
	 */
	private Integer height;
	/**
	 * 大小
	 */
	private Integer size;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 排序
	 */
	private Integer sortno;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 说明
	 */
	private String remark;
	/**
	 * 是否外链
	 */
	private Integer isLink;
	/**
	 * 源地址
	 */
	private String sourceUrl;
	/**
	 * 配置属性
	 */
	private String config;
	/**
	 * 创建人
	 */
	private Long creator;
	/**
	 * 修改人
	 */
	private Long modifier;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 修改日期
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

	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	/**
	 * 设置：图片名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：图片名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：原名
	 */
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	/**
	 * 获取：原名
	 */
	public String getOldName() {
		return oldName;
	}
	/**
	 * 设置：后缀
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	/**
	 * 获取：后缀
	 */
	public String getSuffix() {
		return suffix;
	}
	/**
	 * 设置：宽
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}
	/**
	 * 获取：宽
	 */
	public Integer getWidth() {
		return width;
	}
	/**
	 * 设置：高
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}
	/**
	 * 获取：高
	 */
	public Integer getHeight() {
		return height;
	}
	/**
	 * 设置：大小
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	/**
	 * 获取：大小
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * 设置：路径
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取：路径
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置：排序
	 */
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSortno() {
		return sortno;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：说明
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：是否外链
	 */
	public void setIsLink(Integer isLink) {
		this.isLink = isLink;
	}
	/**
	 * 获取：是否外链
	 */
	public Integer getIsLink() {
		return isLink;
	}
	/**
	 * 设置：源地址
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	/**
	 * 获取：源地址
	 */
	public String getSourceUrl() {
		return sourceUrl;
	}
	/**
	 * 设置：配置属性
	 */
	public void setConfig(String config) {
		this.config = config;
	}
	/**
	 * 获取：配置属性
	 */
	public String getConfig() {
		return config;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public Long getCreator() {
		return creator;
	}
	/**
	 * 设置：修改人
	 */
	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}
	/**
	 * 获取：修改人
	 */
	public Long getModifier() {
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
	 * 设置：修改日期
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改日期
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
