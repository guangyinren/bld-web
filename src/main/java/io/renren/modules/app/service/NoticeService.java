package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.NoticeEntity;

import java.util.Map;

/**
 * 通知
 *
 * @author lhc
 * @email 
 * @date 2018-12-10 13:22:43
 */
public interface NoticeService extends IService<NoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

