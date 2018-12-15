package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MsgListEntity;

import java.util.Map;

/**
 * 会话列表
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:04
 */
public interface MsgListService extends IService<MsgListEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

