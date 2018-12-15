package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.EvaluateEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author lhc
 * @email 
 * @date 2018-12-11 17:19:28
 */
public interface EvaluateService extends IService<EvaluateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

