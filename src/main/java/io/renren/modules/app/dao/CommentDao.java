package io.renren.modules.app.dao;

import io.renren.modules.app.entity.CommentEntity;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 评论
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
 @Mapper
public interface CommentDao extends BaseMapper<CommentEntity> {

	Map<String, Object> queryInformCommonDetail(String sourceUser, String sourceId);
	
}
