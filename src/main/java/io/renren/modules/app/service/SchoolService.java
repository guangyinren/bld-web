package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.SchoolEntity;

import java.util.Map;

/**
 * 学校
 *
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
public interface SchoolService extends IService<SchoolEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

