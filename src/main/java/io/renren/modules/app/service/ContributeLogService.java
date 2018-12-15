package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ContributeLogEntity;

import java.util.Map;

/**
 * 投稿记录
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
public interface ContributeLogService extends IService<ContributeLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

