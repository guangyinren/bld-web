package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 账户流水
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 12:40:20
 */
@TableName("account_log")
public class AccountLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String accountlogid;
	/**
	 * 账户id
	 */
	private String accountid;
	/**
	 * 状态(0:进行中,1:成功,2:失败)
	 */
	private String status;
	/**
	 * 类型(0:充值,1:提现,3:奖励,4:消费)
	 */
	private String type;
	/**
	 * 是否增加(0:加,1:减)
	 */
	private Integer isadd;
	/**
	 * 用户/商户id
	 */
	private String userid;
	/**
	 * 交易金额
	 */
	private BigDecimal amount;
	/**
	 * 交易后账户余额
	 */
	private BigDecimal balance;
	/**
	 * 来源类型(0:微信,1:支付宝,2:银行卡)
	 */
	private String sourcetype;
	/**
	 * 来源id
	 */
	private String sourceid;
	/**
	 * 来源名称
	 */
	private String sourcename;
	/**
	 * 来源账户号码
	 */
	private String sourceaccountno;
	/**
	 * 平台账户类型(0:微信,1:支付宝,2:银行卡)
	 */
	private String psourcetype;
	/**
	 * 平台账户id
	 */
	private String psourceid;
	/**
	 * 平台账户名称
	 */
	private String psourcename;
	/**
	 * 平台账户号码
	 */
	private String psourceaccountno;
	/**
	 * 图片信息
	 */
	private String resources;
	/**
	 * 完成日期
	 */
	private Date endtime;
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
	public void setAccountlogid(String accountlogid) {
		this.accountlogid = accountlogid;
	}
	/**
	 * 获取：
	 */
	public String getAccountlogid() {
		return accountlogid;
	}
	/**
	 * 设置：账户id
	 */
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	/**
	 * 获取：账户id
	 */
	public String getAccountid() {
		return accountid;
	}
	/**
	 * 设置：状态(0:进行中,1:成功,2:失败)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:进行中,1:成功,2:失败)
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型(0:充值,1:提现,3:奖励,4:消费)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(0:充值,1:提现,3:奖励,4:消费)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：是否增加(0:加,1:减)
	 */
	public void setIsadd(Integer isadd) {
		this.isadd = isadd;
	}
	/**
	 * 获取：是否增加(0:加,1:减)
	 */
	public Integer getIsadd() {
		return isadd;
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
	 * 设置：交易金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：交易金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：交易后账户余额
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	/**
	 * 获取：交易后账户余额
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * 设置：来源类型(0:微信,1:支付宝,2:银行卡)
	 */
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	/**
	 * 获取：来源类型(0:微信,1:支付宝,2:银行卡)
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
	 * 设置：来源名称
	 */
	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}
	/**
	 * 获取：来源名称
	 */
	public String getSourcename() {
		return sourcename;
	}
	/**
	 * 设置：来源账户号码
	 */
	public void setSourceaccountno(String sourceaccountno) {
		this.sourceaccountno = sourceaccountno;
	}
	/**
	 * 获取：来源账户号码
	 */
	public String getSourceaccountno() {
		return sourceaccountno;
	}
	/**
	 * 设置：平台账户类型(0:微信,1:支付宝,2:银行卡)
	 */
	public void setPsourcetype(String psourcetype) {
		this.psourcetype = psourcetype;
	}
	/**
	 * 获取：平台账户类型(0:微信,1:支付宝,2:银行卡)
	 */
	public String getPsourcetype() {
		return psourcetype;
	}
	/**
	 * 设置：平台账户id
	 */
	public void setPsourceid(String psourceid) {
		this.psourceid = psourceid;
	}
	/**
	 * 获取：平台账户id
	 */
	public String getPsourceid() {
		return psourceid;
	}
	/**
	 * 设置：平台账户名称
	 */
	public void setPsourcename(String psourcename) {
		this.psourcename = psourcename;
	}
	/**
	 * 获取：平台账户名称
	 */
	public String getPsourcename() {
		return psourcename;
	}
	/**
	 * 设置：平台账户号码
	 */
	public void setPsourceaccountno(String psourceaccountno) {
		this.psourceaccountno = psourceaccountno;
	}
	/**
	 * 获取：平台账户号码
	 */
	public String getPsourceaccountno() {
		return psourceaccountno;
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
	 * 设置：完成日期
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	/**
	 * 获取：完成日期
	 */
	public Date getEndtime() {
		return endtime;
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
