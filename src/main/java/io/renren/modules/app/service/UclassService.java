package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.UclassEntity;

import java.util.Map;

/**
 * 班级
 *
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
public interface UclassService extends IService<UclassEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

