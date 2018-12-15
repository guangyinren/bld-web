package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.LiteratureActivityEntity;

import java.util.Map;

/**
 * 文学活动表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
public interface LiteratureActivityService extends IService<LiteratureActivityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

