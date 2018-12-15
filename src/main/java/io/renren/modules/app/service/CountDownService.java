package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.CountDownEntity;

import java.util.Map;

/**
 * 倒计时表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
public interface CountDownService extends IService<CountDownEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

