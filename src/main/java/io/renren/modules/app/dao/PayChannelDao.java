package io.renren.modules.app.dao;

import io.renren.modules.app.entity.PayChannelEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 支付渠道表
 * 
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
 @Mapper
public interface PayChannelDao extends BaseMapper<PayChannelEntity> {
	
}
