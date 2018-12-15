package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.AreaProvinceEntity;

import java.util.Map;

/**
 * 地区管理--省份表
 *
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
public interface AreaProvinceService extends IService<AreaProvinceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

