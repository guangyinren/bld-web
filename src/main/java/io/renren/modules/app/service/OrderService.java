package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.OrderEntity;

import java.util.Map;

/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-11 16:07:23
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

