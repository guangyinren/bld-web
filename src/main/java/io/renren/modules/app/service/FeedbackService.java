package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.FeedbackEntity;

import java.util.Map;

/**
 * 意见反馈
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 10:17:55
 */
public interface FeedbackService extends IService<FeedbackEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

