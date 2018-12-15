package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.SpaceDynamicDao;
import io.renren.modules.app.entity.SpaceDynamicEntity;
import io.renren.modules.app.service.SpaceDynamicService;


@Service("spaceDynamicService")
public class SpaceDynamicServiceImpl extends ServiceImpl<SpaceDynamicDao, SpaceDynamicEntity> implements SpaceDynamicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SpaceDynamicEntity> page = this.selectPage(
                new Query<SpaceDynamicEntity>(params).getPage(),
                new EntityWrapper<SpaceDynamicEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public Set<Map<String, Object>> queryFriendDynamic(String userId) {
		return baseMapper.queryFriendDynamic(userId);
	}

	@Override
	public Set<Map<String, Object>> queryAttentionAccountDynamic(String userId) {
		return baseMapper.queryAttentionAccountDynamic(userId);
	}

	@Override
	public Map<String, Object> queryInformPraiseDetail(String sourceUser, String sourceId) {
		return baseMapper.queryInformPraiseDetail(sourceUser,sourceId);
	}
}
