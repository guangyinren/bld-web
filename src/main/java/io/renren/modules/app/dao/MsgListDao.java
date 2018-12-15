package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MsgListEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 会话列表
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:04
 */
 @Mapper
public interface MsgListDao extends BaseMapper<MsgListEntity> {
	
}
