package io.renren.modules.app.service.impl;

import io.renren.modules.app.dao.UserDao;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ArticleDao;
import io.renren.modules.app.entity.ArticleEntity;
import io.renren.modules.app.service.ArticleService;


@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ArticleEntity> page = this.selectPage(
                new Query<ArticleEntity>(params).getPage(),
                new EntityWrapper<ArticleEntity>()
        );
        return new PageUtils(page);
    }

}
