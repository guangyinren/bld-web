package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知
 * 
 * @author lhc
 * @email 
 * @date 2018-12-10 13:22:43
 */
@TableName("notice")
public class NoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String noticeid;
	/**
	 * 状态(0:正常,1:删除)
	 */
	private String status;
	/**
	 * 类型(0:文本,1:图片)
	 */
	private String type;
	/**
	 * 发送人
	 */
	private String userid;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 资源信息
	 */
	private String resources;
	/**
	 * 图片
	 */
	private String showpic;
	/**
	 * 描述
	 */
	private String intro;
	/**
	 * 对象类型(0:系统,1:封地)
	 */
	private String objecttype;
	/**
	 * 对象信息
	 */
	private String objectid;
	/**
	 * 链接
	 */
	private String url;
	/**
	 * 接收类型(0:userIds,1:userType)
	 */
	private String receivetype;
	/**
	 * 
	 */
	private String receiveinfo;
	/**
	 * 发送时间
	 */
	private Date sendtime;
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
	public void setNoticeid(String noticeid) {
		this.noticeid = noticeid;
	}
	/**
	 * 获取：
	 */
	public String getNoticeid() {
		return noticeid;
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
	 * 设置：类型(0:文本,1:图片)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:文本,1:图片)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：发送人
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：发送人
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
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
	 * 设置：资源信息
	 */
	public void setResources(String resources) {
		this.resources = resources;
	}
	/**
	 * 获取：资源信息
	 */
	public String getResources() {
		return resources;
	}
	/**
	 * 设置：图片
	 */
	public void setShowpic(String showpic) {
		this.showpic = showpic;
	}
	/**
	 * 获取：图片
	 */
	public String getShowpic() {
		return showpic;
	}
	/**
	 * 设置：描述
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：描述
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：对象类型(0:系统,1:封地)
	 */
	public void setObjecttype(String objecttype) {
		this.objecttype = objecttype;
	}
	/**
	 * 获取：对象类型(0:系统,1:封地)
	 */
	public String getObjecttype() {
		return objecttype;
	}
	/**
	 * 设置：对象信息
	 */
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	/**
	 * 获取：对象信息
	 */
	public String getObjectid() {
		return objectid;
	}
	/**
	 * 设置：链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：链接
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：接收类型(0:userIds,1:userType)
	 */
	public void setReceivetype(String receivetype) {
		this.receivetype = receivetype;
	}
	/**
	 * 获取：接收类型(0:userIds,1:userType)
	 */
	public String getReceivetype() {
		return receivetype;
	}
	/**
	 * 设置：
	 */
	public void setReceiveinfo(String receiveinfo) {
		this.receiveinfo = receiveinfo;
	}
	/**
	 * 获取：
	 */
	public String getReceiveinfo() {
		return receiveinfo;
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
