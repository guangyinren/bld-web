package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.AreaCityEntity;

import java.util.Map;

/**
 * 地区管理--地市表
 *
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
public interface AreaCityService extends IService<AreaCityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

