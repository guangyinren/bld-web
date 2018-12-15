package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.AdPositionEntity;

import java.util.Map;

/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:51
 */
public interface AdPositionService extends IService<AdPositionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

