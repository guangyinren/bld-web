package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ShieldDao;
import io.renren.modules.app.entity.ShieldEntity;
import io.renren.modules.app.service.ShieldService;


@Service("shieldService")
public class ShieldServiceImpl extends ServiceImpl<ShieldDao, ShieldEntity> implements ShieldService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShieldEntity> page = this.selectPage(
                new Query<ShieldEntity>(params).getPage(),
                new EntityWrapper<ShieldEntity>()
        );

        return new PageUtils(page);
    }

}
