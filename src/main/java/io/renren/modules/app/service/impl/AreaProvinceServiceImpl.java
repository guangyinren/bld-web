package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.AreaProvinceDao;
import io.renren.modules.app.entity.AreaProvinceEntity;
import io.renren.modules.app.service.AreaProvinceService;


@Service("areaProvinceService")
public class AreaProvinceServiceImpl extends ServiceImpl<AreaProvinceDao, AreaProvinceEntity> implements AreaProvinceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AreaProvinceEntity> page = this.selectPage(
                new Query<AreaProvinceEntity>(params).getPage(),
                new EntityWrapper<AreaProvinceEntity>()
        );

        return new PageUtils(page);
    }

}
