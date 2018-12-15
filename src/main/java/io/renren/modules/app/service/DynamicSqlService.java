package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.DynamicSqlEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-11-11 13:01:55
 */
public interface DynamicSqlService extends IService<DynamicSqlEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    List<Map<String, Object>> selectSql(String sql);
}

