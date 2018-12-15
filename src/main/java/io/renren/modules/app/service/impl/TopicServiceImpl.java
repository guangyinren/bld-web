package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.TopicDao;
import io.renren.modules.app.entity.TopicEntity;
import io.renren.modules.app.service.TopicService;


@Service("topicService")
public class TopicServiceImpl extends ServiceImpl<TopicDao, TopicEntity> implements TopicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TopicEntity> page = this.selectPage(
                new Query<TopicEntity>(params).getPage(),
                new EntityWrapper<TopicEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<Map<String, Object>> queryTopicBySchool(String schoolId) {
		return baseMapper.queryTopicBySchool(schoolId);
	}

}
