package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ForumUserEntity;

import java.util.Map;

/**
 * 论坛用户
 *
 * @author lhc
 * @email 
 * @date 2018-12-09 18:57:25
 */
public interface ForumUserService extends IService<ForumUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

