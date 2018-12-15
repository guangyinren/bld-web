package io.renren.modules.app.dao;

import io.renren.modules.app.entity.RelationUserEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 联系人
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
 @Mapper
public interface RelationUserDao extends BaseMapper<RelationUserEntity> {

	List<Map<String, Object>> queryAttentionByKey(String userId, String key);
	
}
