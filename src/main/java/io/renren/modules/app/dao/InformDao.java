package io.renren.modules.app.dao;

import io.renren.modules.app.entity.InformEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 通知
 * 
 * @author lhc
 * @email 
 * @date 2018-07-08 18:51:20
 */
 @Mapper
public interface InformDao extends BaseMapper<InformEntity> {

	List<Map<String, Object>> queryMyInform(String userId);
	
}
