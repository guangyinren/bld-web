package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.PayLogEntity;

import java.util.Map;

/**
 * 支付记录
 *
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
public interface PayLogService extends IService<PayLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

