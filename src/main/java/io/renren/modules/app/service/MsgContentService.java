package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MsgContentEntity;

import java.util.Map;

/**
 * 即时消息内容
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:05
 */
public interface MsgContentService extends IService<MsgContentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

