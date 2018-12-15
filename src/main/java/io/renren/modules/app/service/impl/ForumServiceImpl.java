package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ForumDao;
import io.renren.modules.app.entity.ForumEntity;
import io.renren.modules.app.service.ForumService;


@Service("forumService")
public class ForumServiceImpl extends ServiceImpl<ForumDao, ForumEntity> implements ForumService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ForumEntity> page = this.selectPage(
                new Query<ForumEntity>(params).getPage(),
                new EntityWrapper<ForumEntity>()
        );

        return new PageUtils(page);
    }

}
