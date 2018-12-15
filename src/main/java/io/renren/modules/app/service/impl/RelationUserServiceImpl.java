package io.renren.modules.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.app.dao.RelationUserDao;
import io.renren.modules.app.entity.RelationUserEntity;
import io.renren.modules.app.service.RelationUserService;


@Service("relationUserService")
public class RelationUserServiceImpl extends ServiceImpl<RelationUserDao, RelationUserEntity> implements RelationUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RelationUserEntity> page = this.selectPage(
                new Query<RelationUserEntity>(params).getPage(),
                new EntityWrapper<RelationUserEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
    public List<RelationUserEntity> queryList(Map<String, Object> params) {
        return (List<RelationUserEntity>) this.selectByMap(params);
    }

	@Override
	public List<Map<String, Object>> queryAttentionByKey(String userId, String key) {
		return (List<Map<String, Object>>) baseMapper.queryAttentionByKey(userId,key);
	}
}
