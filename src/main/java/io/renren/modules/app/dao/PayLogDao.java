package io.renren.modules.app.dao;

import io.renren.modules.app.entity.PayLogEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 支付记录
 * 
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
 @Mapper
public interface PayLogDao extends BaseMapper<PayLogEntity> {
	
}
