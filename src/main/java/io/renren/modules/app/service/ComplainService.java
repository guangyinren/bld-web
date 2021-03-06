package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ComplainEntity;

import java.util.Map;

/**
 * 举报投诉表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
public interface ComplainService extends IService<ComplainEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

