package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 会话列表
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:04
 */
@TableName("msg_list")
public class MsgListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String msglistid;
	/**
	 * 创建者id
	 */
	private String userid;
	/**
	 * 状态(0:正常,1:删除)
	 */
	private String status;
	/**
	 * 名称
	 */
	private String title;
	/**
	 * 接收用户id
	 */
	private String touserid;
	/**
	 * 消息总数
	 */
	private Integer msgnum;
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
	 * 设置：
	 */
	public void setMsglistid(String msglistid) {
		this.msglistid = msglistid;
	}
	/**
	 * 获取：
	 */
	public String getMsglistid() {
		return msglistid;
	}
	/**
	 * 设置：创建者id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：创建者id
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：状态(0:正常,1:删除)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:正常,1:删除)
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：接收用户id
	 */
	public void setTouserid(String touserid) {
		this.touserid = touserid;
	}
	/**
	 * 获取：接收用户id
	 */
	public String getTouserid() {
		return touserid;
	}
	/**
	 * 设置：消息总数
	 */
	public void setMsgnum(Integer msgnum) {
		this.msgnum = msgnum;
	}
	/**
	 * 获取：消息总数
	 */
	public Integer getMsgnum() {
		return msgnum;
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
}
