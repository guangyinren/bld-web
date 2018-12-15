package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.SpreadLogDao;
import io.renren.modules.app.entity.SpreadLogEntity;
import io.renren.modules.app.service.SpreadLogService;


@Service("spreadLogService")
public class SpreadLogServiceImpl extends ServiceImpl<SpreadLogDao, SpreadLogEntity> implements SpreadLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SpreadLogEntity> page = this.selectPage(
                new Query<SpreadLogEntity>(params).getPage(),
                new EntityWrapper<SpreadLogEntity>()
        );

        return new PageUtils(page);
    }

}
