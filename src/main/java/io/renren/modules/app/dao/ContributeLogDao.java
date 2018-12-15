package io.renren.modules.app.dao;

import io.renren.modules.app.entity.ContributeLogEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 投稿记录
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
 @Mapper
public interface ContributeLogDao extends BaseMapper<ContributeLogEntity> {
	
}
