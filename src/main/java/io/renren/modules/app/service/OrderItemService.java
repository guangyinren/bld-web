package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.OrderItemEntity;

import java.util.Map;

/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:50
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

