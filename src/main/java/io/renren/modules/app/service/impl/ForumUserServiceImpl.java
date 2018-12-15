package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ForumUserDao;
import io.renren.modules.app.entity.ForumUserEntity;
import io.renren.modules.app.service.ForumUserService;


@Service("forumUserService")
public class ForumUserServiceImpl extends ServiceImpl<ForumUserDao, ForumUserEntity> implements ForumUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ForumUserEntity> page = this.selectPage(
                new Query<ForumUserEntity>(params).getPage(),
                new EntityWrapper<ForumUserEntity>()
        );

        return new PageUtils(page);
    }

}
