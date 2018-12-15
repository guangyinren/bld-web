package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.CourseBookDao;
import io.renren.modules.app.entity.CourseBookEntity;
import io.renren.modules.app.service.CourseBookService;


@Service("courseBookService")
public class CourseBookServiceImpl extends ServiceImpl<CourseBookDao, CourseBookEntity> implements CourseBookService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CourseBookEntity> page = this.selectPage(
                new Query<CourseBookEntity>(params).getPage(),
                new EntityWrapper<CourseBookEntity>()
        );

        return new PageUtils(page);
    }

}
