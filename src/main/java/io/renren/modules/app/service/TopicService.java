package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.TopicEntity;

import java.util.List;
import java.util.Map;

/**
 * 话题
 *
 * @author lhc
 * @email 
 * @date 2018-06-26 23:52:37
 */
public interface TopicService extends IService<TopicEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 获取学校的话题列表
     * @param schoolId
     * @return
     */
	List<Map<String, Object>> queryTopicBySchool(String schoolId);
}

