package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 即时消息内容
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:05
 */
@TableName("msg_content")
public class MsgContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String msgcontentid;
	/**
	 * 会话列表id
	 */
	private String listid;
	/**
	 * 状态(0:未发送,1:已发送,2:已接收,3:删除)
	 */
	private String status;
	/**
	 * 类型(0:文字,1:图片)
	 */
	private String type;
	/**
	 * 资源
	 */
	private String resource;
	/**
	 * 用户id
	 */
	private String userid;
	/**
	 * 用户名称
	 */
	private String username;
	/**
	 * 头像
	 */
	private String headpic;
	/**
	 * 接收用户id
	 */
	private String touserid;
	/**
	 * 接收用户名称
	 */
	private String tousername;
	/**
	 * 头像
	 */
	private String toheadpic;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 发送时间
	 */
	private Date sendtime;
	/**
	 * 接收时间
	 */
	private Date receivetime;
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
	public void setMsgcontentid(String msgcontentid) {
		this.msgcontentid = msgcontentid;
	}
	/**
	 * 获取：
	 */
	public String getMsgcontentid() {
		return msgcontentid;
	}
	/**
	 * 设置：会话列表id
	 */
	public void setListid(String listid) {
		this.listid = listid;
	}
	/**
	 * 获取：会话列表id
	 */
	public String getListid() {
		return listid;
	}
	/**
	 * 设置：状态(0:未发送,1:已发送,2:已接收,3:删除)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:未发送,1:已发送,2:已接收,3:删除)
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型(0:文字,1:图片)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:文字,1:图片)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：资源
	 */
	public void setResource(String resource) {
		this.resource = resource;
	}
	/**
	 * 获取：资源
	 */
	public String getResource() {
		return resource;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：用户名称
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名称
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadpic() {
		return headpic;
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
	 * 设置：接收用户名称
	 */
	public void setTousername(String tousername) {
		this.tousername = tousername;
	}
	/**
	 * 获取：接收用户名称
	 */
	public String getTousername() {
		return tousername;
	}
	/**
	 * 设置：头像
	 */
	public void setToheadpic(String toheadpic) {
		this.toheadpic = toheadpic;
	}
	/**
	 * 获取：头像
	 */
	public String getToheadpic() {
		return toheadpic;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：发送时间
	 */
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	/**
	 * 获取：发送时间
	 */
	public Date getSendtime() {
		return sendtime;
	}
	/**
	 * 设置：接收时间
	 */
	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}
	/**
	 * 获取：接收时间
	 */
	public Date getReceivetime() {
		return receivetime;
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
