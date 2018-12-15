package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.SpreadLogEntity;

import java.util.Map;

/**
 * 推广记录
 *
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
public interface SpreadLogService extends IService<SpreadLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

