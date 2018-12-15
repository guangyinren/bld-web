package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.CommentEntity;

import java.util.Map;

/**
 * 评论
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
public interface CommentService extends IService<CommentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取动态评论的信息和评论用户
     * @param sourceUser
     * @param sourceId
     * @return
     */
	Map<String, Object> queryInformCommonDetail(String sourceUser, String sourceId);
}

