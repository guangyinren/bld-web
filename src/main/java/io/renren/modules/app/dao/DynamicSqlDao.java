package io.renren.modules.app.dao;

import io.renren.modules.app.entity.DynamicSqlEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 
 * 
 * @author lhc
 * @email 
 * @date 2018-11-11 13:01:55
 */
 @Mapper
public interface DynamicSqlDao extends BaseMapper<DynamicSqlEntity> {
	 List<Map<String, Object>> selectSql(String sql);
}
