package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.AreaCityDao;
import io.renren.modules.app.entity.AreaCityEntity;
import io.renren.modules.app.service.AreaCityService;


@Service("areaCityService")
public class AreaCityServiceImpl extends ServiceImpl<AreaCityDao, AreaCityEntity> implements AreaCityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AreaCityEntity> page = this.selectPage(
                new Query<AreaCityEntity>(params).getPage(),
                new EntityWrapper<AreaCityEntity>()
        );

        return new PageUtils(page);
    }

}
