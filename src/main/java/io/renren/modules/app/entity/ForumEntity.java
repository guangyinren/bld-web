package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 论坛/封地
 * 
 * @author lhc
 * @email 
 * @date 2018-12-09 17:04:37
 */
@TableName("pal_forum")
public class ForumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 论坛id
	 */
	@TableId
	private String forumid;
	/**
	 * 状态(0:待认证,1:待审核,2:已通过)
	 */
	private String status;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 业务类型
	 */
	private String businesstype;
	/**
	 * 来源类型(0:封地)
	 */
	private String sourcetype;
	/**
	 * 来源id
	 */
	private String sourceid;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 介绍
	 */
	private String intro;
	/**
	 * 声明
	 */
	private String declare;
	/**
	 * 标签
	 */
	private String labels;
	/**
	 * 展示图片
	 */
	private String showpic;
	/**
	 * 城市名称
	 */
	private String cityname;
	/**
	 * 地区id
	 */
	private String areaid;
	/**
	 * 省市地址
	 */
	private String areaname;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 坐标
	 */
	private String locationxy;
	/**
	 * 机构id
	 */
	private String organizationid;
	/**
	 * 机构名称
	 */
	private String organizationname;
	/**
	 * 话题数
	 */
	private Integer topicnum;
	/**
	 * 关注数
	 */
	private Integer attentionnum;
	/**
	 * 会员数
	 */
	private Integer memnernum;
	/**
	 * 最少人数
	 */
	private Integer minnum;
	/**
	 * 最多人数
	 */
	private Integer maxnum;
	/**
	 * 坛主
	 */
	private String userid;
	/**
	 * 坛主名称
	 */
	private String username;
	/**
	 * 管理员
	 */
	private String managers;
	/**
	 * 检验时间
	 */
	private Date expirationtime;
	/**
	 * 设置
	 */
	private String config;
	/**
	 * 备注
	 */
	private String remark;
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
	 * 最后修改日期
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
	 * 设置：论坛id
	 */
	public void setForumid(String forumid) {
		this.forumid = forumid;
	}
	/**
	 * 获取：论坛id
	 */
	public String getForumid() {
		return forumid;
	}
	/**
	 * 设置：状态(0:待认证,1:待审核,2:已通过)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:待认证,1:待审核,2:已通过)
	 */
	public String getStatus() {
		return status;
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
	 * 设置：业务类型(0:生活)
	 */
	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}
	/**
	 * 获取：业务类型(0:生活)
	 */
	public String getBusinesstype() {
		return businesstype;
	}
	/**
	 * 设置：来源类型(0:封地)
	 */
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	/**
	 * 获取：来源类型(0:封地)
	 */
	public String getSourcetype() {
		return sourcetype;
	}
	/**
	 * 设置：来源id
	 */
	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}
	/**
	 * 获取：来源id
	 */
	public String getSourceid() {
		return sourceid;
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
	 * 设置：声明
	 */
	public void setDeclare(String declare) {
		this.declare = declare;
	}
	/**
	 * 获取：声明
	 */
	public String getDeclare() {
		return declare;
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
	 * 设置：展示图片
	 */
	public void setShowpic(String showpic) {
		this.showpic = showpic;
	}
	/**
	 * 获取：展示图片
	 */
	public String getShowpic() {
		return showpic;
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
	 * 设置：地区id
	 */
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	/**
	 * 获取：地区id
	 */
	public String getAreaid() {
		return areaid;
	}
	/**
	 * 设置：省市地址
	 */
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	/**
	 * 获取：省市地址
	 */
	public String getAreaname() {
		return areaname;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：坐标
	 */
	public void setLocationxy(String locationxy) {
		this.locationxy = locationxy;
	}
	/**
	 * 获取：坐标
	 */
	public String getLocationxy() {
		return locationxy;
	}
	/**
	 * 设置：机构id
	 */
	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}
	/**
	 * 获取：机构id
	 */
	public String getOrganizationid() {
		return organizationid;
	}
	/**
	 * 设置：机构名称
	 */
	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}
	/**
	 * 获取：机构名称
	 */
	public String getOrganizationname() {
		return organizationname;
	}
	/**
	 * 设置：话题数
	 */
	public void setTopicnum(Integer topicnum) {
		this.topicnum = topicnum;
	}
	/**
	 * 获取：话题数
	 */
	public Integer getTopicnum() {
		return topicnum;
	}
	/**
	 * 设置：关注数
	 */
	public void setAttentionnum(Integer attentionnum) {
		this.attentionnum = attentionnum;
	}
	/**
	 * 获取：关注数
	 */
	public Integer getAttentionnum() {
		return attentionnum;
	}
	/**
	 * 设置：会员数
	 */
	public void setMemnernum(Integer memnernum) {
		this.memnernum = memnernum;
	}
	/**
	 * 获取：会员数
	 */
	public Integer getMemnernum() {
		return memnernum;
	}
	/**
	 * 设置：最少人数
	 */
	public void setMinnum(Integer minnum) {
		this.minnum = minnum;
	}
	/**
	 * 获取：最少人数
	 */
	public Integer getMinnum() {
		return minnum;
	}
	/**
	 * 设置：最多人数
	 */
	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}
	/**
	 * 获取：最多人数
	 */
	public Integer getMaxnum() {
		return maxnum;
	}
	/**
	 * 设置：坛主
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：坛主
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：坛主名称
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：坛主名称
	 */
	public String getUsername() {
		return username;
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
	 * 设置：检验时间
	 */
	public void setExpirationtime(Date expirationtime) {
		this.expirationtime = expirationtime;
	}
	/**
	 * 获取：检验时间
	 */
	public Date getExpirationtime() {
		return expirationtime;
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
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	 * 设置：最后修改日期
	 */
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	/**
	 * 获取：最后修改日期
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
