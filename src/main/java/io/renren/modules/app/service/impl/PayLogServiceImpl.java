package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.PayLogDao;
import io.renren.modules.app.entity.PayLogEntity;
import io.renren.modules.app.service.PayLogService;


@Service("payLogService")
public class PayLogServiceImpl extends ServiceImpl<PayLogDao, PayLogEntity> implements PayLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PayLogEntity> page = this.selectPage(
                new Query<PayLogEntity>(params).getPage(),
                new EntityWrapper<PayLogEntity>()
        );

        return new PageUtils(page);
    }

}
