package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ContributeLogDao;
import io.renren.modules.app.entity.ContributeLogEntity;
import io.renren.modules.app.service.ContributeLogService;


@Service("contributeLogService")
public class ContributeLogServiceImpl extends ServiceImpl<ContributeLogDao, ContributeLogEntity> implements ContributeLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ContributeLogEntity> page = this.selectPage(
                new Query<ContributeLogEntity>(params).getPage(),
                new EntityWrapper<ContributeLogEntity>()
        );

        return new PageUtils(page);
    }

}
