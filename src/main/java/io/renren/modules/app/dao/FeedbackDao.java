package io.renren.modules.app.dao;

import io.renren.modules.app.entity.FeedbackEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 意见反馈
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 10:17:55
 */
 @Mapper
public interface FeedbackDao extends BaseMapper<FeedbackEntity> {
	
}
