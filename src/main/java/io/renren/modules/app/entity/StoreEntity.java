package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺
 * 
 * @author lhc
 * @email 
 * @date 2018-12-06 22:36:31
 */
@TableName("shop_store")
public class StoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String storeid;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 类型(0:)
	 */
	private String type;
	/**
	 * 店主id
	 */
	private String userid;
	/**
	 * 店名
	 */
	private String name;
	/**
	 * 展示照片
	 */
	private String showpic;
	/**
	 * 级别
	 */
	private String level;
	/**
	 * 认证级别
	 */
	private String authlevel;
	/**
	 * 标签
	 */
	private String labels;
	/**
	 * 
	 */
	private Integer sortno;
	/**
	 * 视频/图片
	 */
	private String resources;
	/**
	 * 位置x
	 */
	private String locationx;
	/**
	 * 位置y
	 */
	private String locationy;
	/**
	 * 地址
	 */
	private String locationname;
	/**
	 * 城市名称
	 */
	private String cityname;
	/**
	 * 是否热门
	 */
	private Integer ishot;
	/**
	 * 是否置顶
	 */
	private Integer istop;
	/**
	 * 是否推荐
	 */
	private Integer isrecommend;
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
	 * 销量
	 */
	private Long salenum;
	/**
	 * 会员数
	 */
	private Integer membernum;
	/**
	 * 配置属性
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
	private Date createtime;
	/**
	 * 修改日期
	 */
	private Date modifytime;
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
	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	/**
	 * 获取：
	 */
	public String getStoreid() {
		return storeid;
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
	 * 设置：类型(0:)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：店主id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：店主id
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：店名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：店名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：展示照片
	 */
	public void setShowpic(String showpic) {
		this.showpic = showpic;
	}
	/**
	 * 获取：展示照片
	 */
	public String getShowpic() {
		return showpic;
	}
	/**
	 * 设置：级别
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 获取：级别
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * 设置：认证级别
	 */
	public void setAuthlevel(String authlevel) {
		this.authlevel = authlevel;
	}
	/**
	 * 获取：认证级别
	 */
	public String getAuthlevel() {
		return authlevel;
	}
	/**
	 * 设置：标签
	 */
	public void setLabels(String labels) {
		this.labels = labels;
	}
	/**
	 * 获取：标签
	 */
	public String getLabels() {
		return labels;
	}
	/**
	 * 设置：
	 */
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	/**
	 * 获取：
	 */
	public Integer getSortno() {
		return sortno;
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
	 * 设置：位置x
	 */
	public void setLocationx(String locationx) {
		this.locationx = locationx;
	}
	/**
	 * 获取：位置x
	 */
	public String getLocationx() {
		return locationx;
	}
	/**
	 * 设置：位置y
	 */
	public void setLocationy(String locationy) {
		this.locationy = locationy;
	}
	/**
	 * 获取：位置y
	 */
	public String getLocationy() {
		return locationy;
	}
	/**
	 * 设置：地址
	 */
	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}
	/**
	 * 获取：地址
	 */
	public String getLocationname() {
		return locationname;
	}
	/**
	 * 设置：城市名称
	 */
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	/**
	 * 获取：城市名称
	 */
	public String getCityname() {
		return cityname;
	}
	/**
	 * 设置：是否热门
	 */
	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}
	/**
	 * 获取：是否热门
	 */
	public Integer getIshot() {
		return ishot;
	}
	/**
	 * 设置：是否置顶
	 */
	public void setIstop(Integer istop) {
		this.istop = istop;
	}
	/**
	 * 获取：是否置顶
	 */
	public Integer getIstop() {
		return istop;
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
	 * 设置：销量
	 */
	public void setSalenum(Long salenum) {
		this.salenum = salenum;
	}
	/**
	 * 获取：销量
	 */
	public Long getSalenum() {
		return salenum;
	}
	/**
	 * 设置：会员数
	 */
	public void setMembernum(Integer membernum) {
		this.membernum = membernum;
	}
	/**
	 * 获取：会员数
	 */
	public Integer getMembernum() {
		return membernum;
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
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：修改日期
	 */
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	/**
	 * 获取：修改日期
	 */
	public Date getModifytime() {
		return modifytime;
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
