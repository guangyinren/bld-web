package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.CartItemDao;
import io.renren.modules.app.entity.CartItemEntity;
import io.renren.modules.app.service.CartItemService;


@Service("cartItemService")
public class CartItemServiceImpl extends ServiceImpl<CartItemDao, CartItemEntity> implements CartItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CartItemEntity> page = this.selectPage(
                new Query<CartItemEntity>(params).getPage(),
                new EntityWrapper<CartItemEntity>()
        );

        return new PageUtils(page);
    }

}
