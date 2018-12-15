package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ArticleEntity;

import java.util.Map;

/**
 * 文章
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
public interface ArticleService extends IService<ArticleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

