package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.PayChannelEntity;

import java.util.Map;

/**
 * 支付渠道表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
public interface PayChannelService extends IService<PayChannelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

