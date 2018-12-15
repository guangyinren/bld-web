package io.renren.modules.app.service;


import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.LoginForm;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobileOrEmail(String context);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	UserEntity login(LoginForm form);
	
	PageUtils queryPage(Map<String, Object> params);
	
	/**
	 * 我的粉丝
	 * @param userId
	 * @return
	 */
	List<UserEntity> queryMyFans(String userId);
	
	/**
	 * 自定义sql查询
	 * @param sql
	 * @return
	 */
	List<Map<String, Object>> selectSql(String sql);
}
