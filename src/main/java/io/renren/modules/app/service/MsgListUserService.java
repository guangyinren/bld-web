package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MsgListUserEntity;

import java.util.Map;

/**
 * 用户会话列表
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 22:57:39
 */
public interface MsgListUserService extends IService<MsgListUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

