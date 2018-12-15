package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.CollectDao;
import io.renren.modules.app.entity.CollectEntity;
import io.renren.modules.app.service.CollectService;


@Service("collectService")
public class CollectServiceImpl extends ServiceImpl<CollectDao, CollectEntity> implements CollectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CollectEntity> page = this.selectPage(
                new Query<CollectEntity>(params).getPage(),
                new EntityWrapper<CollectEntity>()
        );

        return new PageUtils(page);
    }

}
