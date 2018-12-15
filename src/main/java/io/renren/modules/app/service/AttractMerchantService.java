package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.AttractMerchantEntity;

import java.util.Map;

/**
 * 招商合作
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 10:57:15
 */
public interface AttractMerchantService extends IService<AttractMerchantEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

