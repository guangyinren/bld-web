package io.renren.modules.app.dao;

import io.renren.modules.app.entity.AttentionEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 关注表
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
 @Mapper
public interface AttentionDao extends BaseMapper<AttentionEntity> {

	List<Map<String, Object>> queryAttentionUser(String userId);

	List<Map<String, Object>> queryAttentionPublicAccount(String userId);

	List<Map<String, Object>> queryAttentionDynamic(String userId);

	List<Map<String, Object>> queryAttentionTopic(String userId);
	 
}
