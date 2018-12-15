package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.PublicAccountEntity;

import java.util.Map;

/**
 * 公众号
 *
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
public interface PublicAccountService extends IService<PublicAccountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

