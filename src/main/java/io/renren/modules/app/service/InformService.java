package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.InformEntity;

import java.util.List;
import java.util.Map;

/**
 * 通知
 *
 * @author lhc
 * @email 
 * @date 2018-07-08 18:51:20
 */
public interface InformService extends IService<InformEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 获取我的通知
     * @param userId
     * @return
     */
	List<Map<String, Object>> queryMyInform(String userId);
}

