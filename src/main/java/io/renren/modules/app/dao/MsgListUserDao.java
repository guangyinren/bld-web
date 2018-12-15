package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MsgListUserEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 用户会话列表
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 22:57:39
 */
 @Mapper
public interface MsgListUserDao extends BaseMapper<MsgListUserEntity> {
	
}
