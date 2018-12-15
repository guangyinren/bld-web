package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.FeedbackDao;
import io.renren.modules.app.entity.FeedbackEntity;
import io.renren.modules.app.service.FeedbackService;


@Service("feedbackService")
public class FeedbackServiceImpl extends ServiceImpl<FeedbackDao, FeedbackEntity> implements FeedbackService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FeedbackEntity> page = this.selectPage(
                new Query<FeedbackEntity>(params).getPage(),
                new EntityWrapper<FeedbackEntity>()
        );

        return new PageUtils(page);
    }

}
