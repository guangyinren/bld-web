package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 账户
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 12:40:20
 */
@TableName("account")
public class AccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String accountid;
	/**
	 * 状态(0:正常,1:冻结,2:销户)
	 */
	private String status;
	/**
	 * 类型(0:用户,1:在线商户 2:代理商 3:个人 4:内部账户 5:POS商户)
	 */
	private String type;
	/**
	 * 用户/商户id
	 */
	private String userid;
	/**
	 * 真实姓名/签约姓名
	 */
	private String realname;
	/**
	 * 账户余额(可用余额)
	 */
	private BigDecimal balance;
	/**
	 * 不可用余额
	 */
	private BigDecimal unbalance;
	/**
	 * 来源类型
	 */
	private String sourcetype;
	/**
	 * 来源id
	 */
	private String sourceid;
	/**
	 * 图片信息
	 */
	private String resources;
	/**
	 * 会计科目
	 */
	private String accountsubject;
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
	 * 设置：
	 */
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	/**
	 * 获取：
	 */
	public String getAccountid() {
		return accountid;
	}
	/**
	 * 设置：状态(0:正常,1:冻结,2:销户)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:正常,1:冻结,2:销户)
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型(0:用户,1:在线商户 2:代理商 3:个人 4:内部账户 5:POS商户)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:用户,1:在线商户 2:代理商 3:个人 4:内部账户 5:POS商户)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：用户/商户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户/商户id
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：真实姓名/签约姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：真实姓名/签约姓名
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：账户余额(可用余额)
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	/**
	 * 获取：账户余额(可用余额)
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * 设置：不可用余额
	 */
	public void setUnbalance(BigDecimal unbalance) {
		this.unbalance = unbalance;
	}
	/**
	 * 获取：不可用余额
	 */
	public BigDecimal getUnbalance() {
		return unbalance;
	}
	/**
	 * 设置：来源类型
	 */
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	/**
	 * 获取：来源类型
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
	 * 设置：图片信息
	 */
	public void setResources(String resources) {
		this.resources = resources;
	}
	/**
	 * 获取：图片信息
	 */
	public String getResources() {
		return resources;
	}
	/**
	 * 设置：会计科目
	 */
	public void setAccountsubject(String accountsubject) {
		this.accountsubject = accountsubject;
	}
	/**
	 * 获取：会计科目
	 */
	public String getAccountsubject() {
		return accountsubject;
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
}
