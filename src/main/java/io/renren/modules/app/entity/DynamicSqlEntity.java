package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lhc
 * @email 
 * @date 2018-11-11 13:01:55
 */
@TableName("dynamic_sql")
public class DynamicSqlEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String dynamicSqlId;

	/**
	 * 设置：
	 */
	public void setDynamicSqlId(String dynamicSqlId) {
		this.dynamicSqlId = dynamicSqlId;
	}
	/**
	 * 获取：
	 */
	public String getDynamicSqlId() {
		return dynamicSqlId;
	}
}
