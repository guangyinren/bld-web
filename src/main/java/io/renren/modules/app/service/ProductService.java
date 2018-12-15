package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ProductEntity;

import java.util.Map;

/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-06 21:20:35
 */
public interface ProductService extends IService<ProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

