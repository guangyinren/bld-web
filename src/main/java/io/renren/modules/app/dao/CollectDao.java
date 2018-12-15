package io.renren.modules.app.dao;

import io.renren.modules.app.entity.CollectEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 收藏表
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
 @Mapper
public interface CollectDao extends BaseMapper<CollectEntity> {
	
}
