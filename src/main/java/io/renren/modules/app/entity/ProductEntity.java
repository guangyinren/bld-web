package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lhc
 * @email 
 * @date 2018-12-06 21:20:35
 */
@TableName("shop_product")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String status;
	/**
	 * 类型(0:正品商城,1:便利店,2:二手)
	 */
	private String type;
	/**
	 * 竞价方式(0:原价,1:上下0.1,2:上下0.2,3:上0.2)
	 */
	private String pricetype;
	/**
	 * 视频/图片
	 */
	private String resources;
	/**
	 * 最低价
	 */
	private BigDecimal lowprice;
	/**
	 * 
	 */
	private BigDecimal highprice;
	/**
	 * 标题
	 */
	private String caption;
	/**
	 * 展示图片
	 */
	private String image;
	/**
	 * 介绍
	 */
	private String introduction;
	/**
	 * 点击数
	 */
	private Long hits;
	/**
	 * 分类id
	 */
	private String productcategoryid;
	/**
	 * 分类名称
	 */
	private String categoryname;
	/**
	 * 标签json
	 */
	private String labels;
	/**
	 * 
	 */
	private String parametervalue;
	/**
	 * 
	 */
	private String specifications;
	/**
	 * 
	 */
	private String memo;
	/**
	 * 
	 */
	private String locationx;
	/**
	 * 
	 */
	private String locationy;
	/**
	 * 是否支持邮寄
	 */
	private Integer ismail;
	/**
	 * 是否支持自提
	 */
	private Integer isself;
	/**
	 * 是否正品
	 */
	private Integer isreal;
	/**
	 * 是否热销
	 */
	private Integer ishot;
	/**
	 * 是否推荐
	 */
	private Integer isrecommend;
	/**
	 * 是否打折
	 */
	private Integer isdiscount;
	/**
	 * 评论数
	 */
	private Integer commentnum;
	/**
	 * 分享数
	 */
	private Integer sharenum;
	/**
	 * 收藏数
	 */
	private Integer collectnum;
	/**
	 * 点赞数
	 */
	private Integer praisenum;
	/**
	 * 
	 */
	private String sn;
	/**
	 * 
	 */
	private String weight;
	/**
	 * 
	 */
	private String production;
	/**
	 * 
	 */
	private Long sales;
	/**
	 * 
	 */
	private Boolean ismarketable;
	/**
	 * 
	 */
	private String citycode;
	/**
	 * 
	 */
	private String cityname;
	/**
	 * 
	 */
	private String unit;
	/**
	 * 
	 */
	private BigDecimal price;
	/**
	 * 
	 */
	private BigDecimal cost;
	/**
	 * 
	 */
	private BigDecimal marketprice;
	/**
	 * 
	 */
	private String productimage;
	/**
	 * 
	 */
	private String config;
	/**
	 * 会员ID(有所属会员则说明是二手商品)
	 */
	private String objectid;
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
	 * 
	 */
	private Date createdate;
	/**
	 * 
	 */
	private Date modifydate;

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
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型(0:正品商城,1:便利店,2:二手)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:正品商城,1:便利店,2:二手)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：竞价方式(0:原价,1:上下0.1,2:上下0.2,3:上0.2)
	 */
	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}
	/**
	 * 获取：竞价方式(0:原价,1:上下0.1,2:上下0.2,3:上0.2)
	 */
	public String getPricetype() {
		return pricetype;
	}
	/**
	 * 设置：视频/图片
	 */
	public void setResources(String resources) {
		this.resources = resources;
	}
	/**
	 * 获取：视频/图片
	 */
	public String getResources() {
		return resources;
	}
	/**
	 * 设置：最低价
	 */
	public void setLowprice(BigDecimal lowprice) {
		this.lowprice = lowprice;
	}
	/**
	 * 获取：最低价
	 */
	public BigDecimal getLowprice() {
		return lowprice;
	}
	/**
	 * 设置：
	 */
	public void setHighprice(BigDecimal highprice) {
		this.highprice = highprice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getHighprice() {
		return highprice;
	}
	/**
	 * 设置：标题
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * 获取：标题
	 */
	public String getCaption() {
		return caption;
	}
	/**
	 * 设置：展示图片
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：展示图片
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：介绍
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * 获取：介绍
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * 设置：点击数
	 */
	public void setHits(Long hits) {
		this.hits = hits;
	}
	/**
	 * 获取：点击数
	 */
	public Long getHits() {
		return hits;
	}
	/**
	 * 设置：分类id
	 */
	public void setProductcategoryid(String productcategoryid) {
		this.productcategoryid = productcategoryid;
	}
	/**
	 * 获取：分类id
	 */
	public String getProductcategoryid() {
		return productcategoryid;
	}
	/**
	 * 设置：分类名称
	 */
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	/**
	 * 获取：分类名称
	 */
	public String getCategoryname() {
		return categoryname;
	}
	/**
	 * 设置：标签json
	 */
	public void setLabels(String labels) {
		this.labels = labels;
	}
	/**
	 * 获取：标签json
	 */
	public String getLabels() {
		return labels;
	}
	/**
	 * 设置：
	 */
	public void setParametervalue(String parametervalue) {
		this.parametervalue = parametervalue;
	}
	/**
	 * 获取：
	 */
	public String getParametervalue() {
		return parametervalue;
	}
	/**
	 * 设置：
	 */
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	/**
	 * 获取：
	 */
	public String getSpecifications() {
		return specifications;
	}
	/**
	 * 设置：
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * 设置：
	 */
	public void setLocationx(String locationx) {
		this.locationx = locationx;
	}
	/**
	 * 获取：
	 */
	public String getLocationx() {
		return locationx;
	}
	/**
	 * 设置：
	 */
	public void setLocationy(String locationy) {
		this.locationy = locationy;
	}
	/**
	 * 获取：
	 */
	public String getLocationy() {
		return locationy;
	}
	/**
	 * 设置：是否支持邮寄
	 */
	public void setIsmail(Integer ismail) {
		this.ismail = ismail;
	}
	/**
	 * 获取：是否支持邮寄
	 */
	public Integer getIsmail() {
		return ismail;
	}
	/**
	 * 设置：是否支持自提
	 */
	public void setIsself(Integer isself) {
		this.isself = isself;
	}
	/**
	 * 获取：是否支持自提
	 */
	public Integer getIsself() {
		return isself;
	}
	/**
	 * 设置：是否正品
	 */
	public void setIsreal(Integer isreal) {
		this.isreal = isreal;
	}
	/**
	 * 获取：是否正品
	 */
	public Integer getIsreal() {
		return isreal;
	}
	/**
	 * 设置：是否热销
	 */
	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}
	/**
	 * 获取：是否热销
	 */
	public Integer getIshot() {
		return ishot;
	}
	/**
	 * 设置：是否推荐
	 */
	public void setIsrecommend(Integer isrecommend) {
		this.isrecommend = isrecommend;
	}
	/**
	 * 获取：是否推荐
	 */
	public Integer getIsrecommend() {
		return isrecommend;
	}
	/**
	 * 设置：是否打折
	 */
	public void setIsdiscount(Integer isdiscount) {
		this.isdiscount = isdiscount;
	}
	/**
	 * 获取：是否打折
	 */
	public Integer getIsdiscount() {
		return isdiscount;
	}
	/**
	 * 设置：评论数
	 */
	public void setCommentnum(Integer commentnum) {
		this.commentnum = commentnum;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getCommentnum() {
		return commentnum;
	}
	/**
	 * 设置：分享数
	 */
	public void setSharenum(Integer sharenum) {
		this.sharenum = sharenum;
	}
	/**
	 * 获取：分享数
	 */
	public Integer getSharenum() {
		return sharenum;
	}
	/**
	 * 设置：收藏数
	 */
	public void setCollectnum(Integer collectnum) {
		this.collectnum = collectnum;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getCollectnum() {
		return collectnum;
	}
	/**
	 * 设置：点赞数
	 */
	public void setPraisenum(Integer praisenum) {
		this.praisenum = praisenum;
	}
	/**
	 * 获取：点赞数
	 */
	public Integer getPraisenum() {
		return praisenum;
	}
	/**
	 * 设置：
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}
	/**
	 * 获取：
	 */
	public String getSn() {
		return sn;
	}
	/**
	 * 设置：
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * 获取：
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * 设置：
	 */
	public void setProduction(String production) {
		this.production = production;
	}
	/**
	 * 获取：
	 */
	public String getProduction() {
		return production;
	}
	/**
	 * 设置：
	 */
	public void setSales(Long sales) {
		this.sales = sales;
	}
	/**
	 * 获取：
	 */
	public Long getSales() {
		return sales;
	}
	/**
	 * 设置：
	 */
	public void setIsmarketable(Boolean ismarketable) {
		this.ismarketable = ismarketable;
	}
	/**
	 * 获取：
	 */
	public Boolean getIsmarketable() {
		return ismarketable;
	}
	/**
	 * 设置：
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	/**
	 * 获取：
	 */
	public String getCitycode() {
		return citycode;
	}
	/**
	 * 设置：
	 */
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	/**
	 * 获取：
	 */
	public String getCityname() {
		return cityname;
	}
	/**
	 * 设置：
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getCost() {
		return cost;
	}
	/**
	 * 设置：
	 */
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	/**
	 * 设置：
	 */
	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}
	/**
	 * 获取：
	 */
	public String getProductimage() {
		return productimage;
	}
	/**
	 * 设置：
	 */
	public void setConfig(String config) {
		this.config = config;
	}
	/**
	 * 获取：
	 */
	public String getConfig() {
		return config;
	}
	/**
	 * 设置：会员ID(有所属会员则说明是二手商品)
	 */
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	/**
	 * 获取：会员ID(有所属会员则说明是二手商品)
	 */
	public String getObjectid() {
		return objectid;
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
}
