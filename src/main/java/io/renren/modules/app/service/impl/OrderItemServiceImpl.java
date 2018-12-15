package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.OrderItemDao;
import io.renren.modules.app.entity.OrderItemEntity;
import io.renren.modules.app.service.OrderItemService;


@Service("orderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderItemEntity> page = this.selectPage(
                new Query<OrderItemEntity>(params).getPage(),
                new EntityWrapper<OrderItemEntity>()
        );

        return new PageUtils(page);
    }

}
