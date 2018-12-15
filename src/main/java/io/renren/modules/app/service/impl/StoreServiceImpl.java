package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.StoreDao;
import io.renren.modules.app.entity.StoreEntity;
import io.renren.modules.app.service.StoreService;


@Service("storeService")
public class StoreServiceImpl extends ServiceImpl<StoreDao, StoreEntity> implements StoreService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StoreEntity> page = this.selectPage(
                new Query<StoreEntity>(params).getPage(),
                new EntityWrapper<StoreEntity>()
        );

        return new PageUtils(page);
    }

}
