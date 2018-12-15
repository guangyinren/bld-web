package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 公众号
 * 
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
@TableName("public_account")
public class PublicAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long publicAccountId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 账号名称
	 */
	private String name;
	/**
	 * 全称
	 */
	private String fullname;
	/**
	 * 级别
	 */
	private String level;
	/**
	 * 头像
	 */
	private String headpicPath;
	/**
	 * 是否置顶
	 */
	private Integer isTop;
	/**
	 * 是否热门
	 */
	private Integer isHot;
	/**
	 * 背景
	 */
	private String bgPath;
	/**
	 * 简介
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
	 * 关注人数
	 */
	private Integer attentionNum;
	/**
	 * 所属用户
	 */
	private String userId;
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
	public void setPublicAccountId(Long publicAccountId) {
		this.publicAccountId = publicAccountId;
	}
	/**
	 * 获取：
	 */
	public Long getPublicAccountId() {
		return publicAccountId;
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
	 * 设置：账号名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：账号名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：全称
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * 获取：全称
	 */
	public String getFullname() {
		return fullname;
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
	 * 设置：是否置顶
	 */
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	/**
	 * 获取：是否置顶
	 */
	public Integer getIsTop() {
		return isTop;
	}
	/**
	 * 设置：是否热门
	 */
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	/**
	 * 获取：是否热门
	 */
	public Integer getIsHot() {
		return isHot;
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
	 * 设置：简介
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：简介
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
	 * 设置：关注人数
	 */
	public void setAttentionNum(Integer attentionNum) {
		this.attentionNum = attentionNum;
	}
	/**
	 * 获取：关注人数
	 */
	public Integer getAttentionNum() {
		return attentionNum;
	}
	/**
	 * 设置：所属用户
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：所属用户
	 */
	public String getUserId() {
		return userId;
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
