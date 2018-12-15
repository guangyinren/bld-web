package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.StoreEntity;

import java.util.Map;

/**
 * 店铺
 *
 * @author lhc
 * @email 
 * @date 2018-12-06 22:36:31
 */
public interface StoreService extends IService<StoreEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

