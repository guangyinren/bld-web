package io.renren.modules.app.dao;

import io.renren.modules.app.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 
 * 
 * @author lhc
 * @email 
 * @date 2018-12-11 16:07:23
 */
 @Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
