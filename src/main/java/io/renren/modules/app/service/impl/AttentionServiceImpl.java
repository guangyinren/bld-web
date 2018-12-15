package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.AttentionDao;
import io.renren.modules.app.entity.AttentionEntity;
import io.renren.modules.app.service.AttentionService;


@Service("attentionService")
public class AttentionServiceImpl extends ServiceImpl<AttentionDao, AttentionEntity> implements AttentionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AttentionEntity> page = this.selectPage(
                new Query<AttentionEntity>(params).getPage(),
                new EntityWrapper<AttentionEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<Map<String, Object>> queryAttentionUser(String userId) {
		return baseMapper.queryAttentionUser(userId);
	}

	@Override
	public List<Map<String, Object>> queryAttentionPublicAccount(String userId) {
		return baseMapper.queryAttentionPublicAccount(userId);
	}

	@Override
	public List<Map<String, Object>> queryAttentionDynamic(String userId) {
		return baseMapper.queryAttentionDynamic(userId);
	}

	@Override
	public List<Map<String, Object>> queryAttentionTopic(String userId) {
		return baseMapper.queryAttentionTopic(userId);
	}

}
