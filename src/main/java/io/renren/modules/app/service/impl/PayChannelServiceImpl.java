package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.PayChannelDao;
import io.renren.modules.app.entity.PayChannelEntity;
import io.renren.modules.app.service.PayChannelService;


@Service("payChannelService")
public class PayChannelServiceImpl extends ServiceImpl<PayChannelDao, PayChannelEntity> implements PayChannelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PayChannelEntity> page = this.selectPage(
                new Query<PayChannelEntity>(params).getPage(),
                new EntityWrapper<PayChannelEntity>()
        );

        return new PageUtils(page);
    }

}
