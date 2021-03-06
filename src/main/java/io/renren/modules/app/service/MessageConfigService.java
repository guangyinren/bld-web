package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MessageConfigEntity;

import java.util.Map;

/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:50
 */
public interface MessageConfigService extends IService<MessageConfigEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

