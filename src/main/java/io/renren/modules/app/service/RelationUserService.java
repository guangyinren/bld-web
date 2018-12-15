package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;

import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.RelationUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 联系人
 *
 * @author lhc
 * @email
 * @date 2018-06-30 00:00:27
 */
public interface RelationUserService extends IService<RelationUserEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 根据设定的参数获取联系人
	 * 
	 * @param params
	 * @return
	 */
	public List<RelationUserEntity> queryList(Map<String, Object> params);

	/**
	 * 搜索关注的用户
	 * @param userId
	 * @param key
	 * @return
	 */
	public List<Map<String, Object>> queryAttentionByKey(String userId, String key);
}
