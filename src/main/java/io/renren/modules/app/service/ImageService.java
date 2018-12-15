package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ImageEntity;

import java.util.Map;

/**
 * 图片
 *
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
public interface ImageService extends IService<ImageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

