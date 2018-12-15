package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ForumEntity;

import java.util.Map;

/**
 * 论坛/封地
 *
 * @author lhc
 * @email 
 * @date 2018-12-09 17:04:37
 */
public interface ForumService extends IService<ForumEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

