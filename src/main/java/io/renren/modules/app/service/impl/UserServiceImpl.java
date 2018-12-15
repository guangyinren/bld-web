package io.renren.modules.app.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import io.renren.common.exception.RRException;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.validator.Assert;
import io.renren.modules.app.dao.UserDao;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.service.UserService;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public UserEntity queryByMobileOrEmail(String context) {
		UserEntity userEntity = new UserEntity();
		if (context.contains("@")) {
			userEntity.setEmail(context);
		} else {
			userEntity.setMobile(context);
		}
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public UserEntity login(LoginForm form) {
		UserEntity user=null;
		if(!StringUtils.isEmpty(form.getMobile())) {
			user=queryByMobileOrEmail(form.getMobile());
		}
		if(!StringUtils.isEmpty(form.getEmail())) {
			user=queryByMobileOrEmail(form.getEmail());
		}
		Assert.isNull(user, "账号错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("密码错误");
		}

		return user;
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<UserEntity> page = this.selectPage(new Query<UserEntity>(params).getPage(),
				new EntityWrapper<UserEntity>());

		return new PageUtils(page);
	}

	@Override
	public List<UserEntity> queryMyFans(String userId) {
		return baseMapper.queryMyFans(userId);
	}
	
	@Override
	public List<Map<String, Object>> selectSql(String sql) {
		return baseMapper.selectSql(sql);
	}
}
