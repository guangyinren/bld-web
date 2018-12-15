package io.renren.modules.app.dao;

import io.renren.modules.app.entity.ForumUserEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 论坛用户
 * 
 * @author lhc
 * @email 
 * @date 2018-12-09 18:57:25
 */
 @Mapper
public interface ForumUserDao extends BaseMapper<ForumUserEntity> {
	
}
