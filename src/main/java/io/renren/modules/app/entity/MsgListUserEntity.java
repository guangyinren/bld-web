package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户会话列表
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 22:57:39
 */
@TableName("msg_list_user")
public class MsgListUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String listuserid;
	/**
	 * 用户id
	 */
	private String userid;
	/**
	 * 用户id
	 */
	private String touserid;
	/**
	 * 会话id
	 */
	private String listid;
	/**
	 * 状态(0:正常,1:删除)
	 */
	private String status;
	/**
	 * 对方头像
	 */
	private String toheadpic;
	/**
	 * 对方名称
	 */
	private String title;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 未读消息数
	 */
	private Integer newnum;
	/**
	 * 最后一条消息内容
	 */
	private String lastmsg;
	/**
	 * 最后通话时间
	 */
	private Date lasttime;
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
	public void setListuserid(String listuserid) {
		this.listuserid = listuserid;
	}
	/**
	 * 获取：
	 */
	public String getListuserid() {
		return listuserid;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getTouserid() {
		return touserid;
	}
	public void setTouserid(String touserid) {
		this.touserid = touserid;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：会话id
	 */
	public void setListid(String listid) {
		this.listid = listid;
	}
	/**
	 * 获取：会话id
	 */
	public String getListid() {
		return listid;
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
	 * 设置：对方头像
	 */
	public void setToheadpic(String toheadpic) {
		this.toheadpic = toheadpic;
	}
	/**
	 * 获取：对方头像
	 */
	public String getToheadpic() {
		return toheadpic;
	}
	/**
	 * 设置：对方名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：对方名称
	 */
	public String getTitle() {
		return title;
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
	 * 设置：未读消息数
	 */
	public void setNewnum(Integer newnum) {
		this.newnum = newnum;
	}
	/**
	 * 获取：未读消息数
	 */
	public Integer getNewnum() {
		return newnum;
	}
	/**
	 * 设置：最后一条消息内容
	 */
	public void setLastmsg(String lastmsg) {
		this.lastmsg = lastmsg;
	}
	/**
	 * 获取：最后一条消息内容
	 */
	public String getLastmsg() {
		return lastmsg;
	}
	/**
	 * 设置：最后通话时间
	 */
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	/**
	 * 获取：最后通话时间
	 */
	public Date getLasttime() {
		return lasttime;
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
