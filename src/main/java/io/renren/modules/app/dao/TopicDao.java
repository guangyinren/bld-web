package io.renren.modules.app.dao;

import io.renren.modules.app.entity.TopicEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 话题
 * 
 * @author lhc
 * @email 
 * @date 2018-06-26 23:52:37
 */
 @Mapper
public interface TopicDao extends BaseMapper<TopicEntity> {

	List<Map<String, Object>> queryTopicBySchool(String schoolId);
	
}
