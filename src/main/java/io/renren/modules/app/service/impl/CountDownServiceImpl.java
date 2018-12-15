package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.CountDownDao;
import io.renren.modules.app.entity.CountDownEntity;
import io.renren.modules.app.service.CountDownService;


@Service("countDownService")
public class CountDownServiceImpl extends ServiceImpl<CountDownDao, CountDownEntity> implements CountDownService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CountDownEntity> page = this.selectPage(
                new Query<CountDownEntity>(params).getPage(),
                new EntityWrapper<CountDownEntity>()
        );

        return new PageUtils(page);
    }

}
