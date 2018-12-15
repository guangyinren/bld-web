package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.AdPositionDao;
import io.renren.modules.app.entity.AdPositionEntity;
import io.renren.modules.app.service.AdPositionService;


@Service("adPositionService")
public class AdPositionServiceImpl extends ServiceImpl<AdPositionDao, AdPositionEntity> implements AdPositionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AdPositionEntity> page = this.selectPage(
                new Query<AdPositionEntity>(params).getPage(),
                new EntityWrapper<AdPositionEntity>()
        );

        return new PageUtils(page);
    }

}
