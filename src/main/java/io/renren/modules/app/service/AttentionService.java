package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.AttentionEntity;

import java.util.List;
import java.util.Map;

/**
 * 关注表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
public interface AttentionService extends IService<AttentionEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 关注的用户
     * @param userId
     * @return
     */
	List<Map<String, Object>> queryAttentionUser(String userId);
	
	/**
	 * 关注的公众号
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> queryAttentionPublicAccount(String userId);

	/**
	 * 关注的动态
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> queryAttentionDynamic(String userId);
	
	/**
	 * 关注的话题
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> queryAttentionTopic(String userId);
}

