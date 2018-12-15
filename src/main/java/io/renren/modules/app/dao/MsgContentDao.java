package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MsgContentEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 即时消息内容
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:05
 */
 @Mapper
public interface MsgContentDao extends BaseMapper<MsgContentEntity> {
	
}
