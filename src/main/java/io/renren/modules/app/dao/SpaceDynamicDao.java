package io.renren.modules.app.dao;

import io.renren.modules.app.entity.SpaceDynamicEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 空间动态
 * 
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
@Mapper
public interface SpaceDynamicDao extends BaseMapper<SpaceDynamicEntity> {
	public Set<Map<String, Object>> queryFriendDynamic(String userId);

	public Set<Map<String, Object>> queryAttentionAccountDynamic(String userId);

	public Map<String, Object> queryInformPraiseDetail(String sourceUser, String sourceId);
}
