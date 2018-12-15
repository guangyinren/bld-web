package io.renren.modules.app.service;

import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.service.IService;

import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.SpaceDynamicEntity;

/**
 * 空间动态
 *
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
public interface SpaceDynamicService extends IService<SpaceDynamicEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取空间动态(包括自己)
     * @param userId
     * @return
     */
    Set<Map<String, Object>> queryFriendDynamic(String userId);

    /**
     * 关注的公众号的动态
     * @param userId
     * @return
     */
	Set<Map<String, Object>> queryAttentionAccountDynamic(String userId);
	
	/**
	 * 获取点赞通知的详情信息(用户信息和动态信息)
	 * @param object
	 * @param object2
	 * @return
	 */
	Map<String, Object> queryInformPraiseDetail(String sourceUser, String sourceId);
}

