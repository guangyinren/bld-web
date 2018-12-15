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
 * @date 2018-12-05 22:01:51
 */
@TableName("shop_member")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 
	 */
	private Date createdate;
	/**
	 * 
	 */
	private Date modifydate;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private Date logindate;
	/**
	 * 
	 */
	private String loginip;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private Date birth;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 
	 */
	private String registerip;
	/**
	 * 
	 */
	private BigDecimal balance;
	/**
	 * 
	 */
	private BigDecimal amount;
	/**
	 * 
	 */
	private String weixinopenid;
	/**
	 * 
	 */
	private String prop1;
	/**
	 * 
	 */
	private String prop2;

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
	/**
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	/**
	 * 获取：
	 */
	public Date getLogindate() {
		return logindate;
	}
	/**
	 * 设置：
	 */
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	/**
	 * 获取：
	 */
	public String getLoginip() {
		return loginip;
	}
	/**
	 * 设置：
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	/**
	 * 获取：
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：
	 */
	public void setRegisterip(String registerip) {
		this.registerip = registerip;
	}
	/**
	 * 获取：
	 */
	public String getRegisterip() {
		return registerip;
	}
	/**
	 * 设置：
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * 设置：
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：
	 */
	public void setWeixinopenid(String weixinopenid) {
		this.weixinopenid = weixinopenid;
	}
	/**
	 * 获取：
	 */
	public String getWeixinopenid() {
		return weixinopenid;
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
}
