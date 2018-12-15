package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ProductDao;
import io.renren.modules.app.entity.ProductEntity;
import io.renren.modules.app.service.ProductService;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProductEntity> page = this.selectPage(
                new Query<ProductEntity>(params).getPage(),
                new EntityWrapper<ProductEntity>()
        );

        return new PageUtils(page);
    }

}
