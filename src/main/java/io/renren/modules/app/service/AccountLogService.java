package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.AccountLogEntity;

import java.util.Map;

/**
 * 账户流水
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 12:40:20
 */
public interface AccountLogService extends IService<AccountLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

