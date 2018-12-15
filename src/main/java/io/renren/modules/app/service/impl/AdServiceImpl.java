package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.AdDao;
import io.renren.modules.app.entity.AdEntity;
import io.renren.modules.app.service.AdService;


@Service("adService")
public class AdServiceImpl extends ServiceImpl<AdDao, AdEntity> implements AdService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AdEntity> page = this.selectPage(
                new Query<AdEntity>(params).getPage(),
                new EntityWrapper<AdEntity>()
        );

        return new PageUtils(page);
    }

}
