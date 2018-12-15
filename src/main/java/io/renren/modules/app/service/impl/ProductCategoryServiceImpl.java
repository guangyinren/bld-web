package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ProductCategoryDao;
import io.renren.modules.app.entity.ProductCategoryEntity;
import io.renren.modules.app.service.ProductCategoryService;


@Service("productCategoryService")
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategoryEntity> implements ProductCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProductCategoryEntity> page = this.selectPage(
                new Query<ProductCategoryEntity>(params).getPage(),
                new EntityWrapper<ProductCategoryEntity>()
        );

        return new PageUtils(page);
    }

}
