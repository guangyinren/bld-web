package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.PaymentDao;
import io.renren.modules.app.entity.PaymentEntity;
import io.renren.modules.app.service.PaymentService;


@Service("paymentService")
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, PaymentEntity> implements PaymentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PaymentEntity> page = this.selectPage(
                new Query<PaymentEntity>(params).getPage(),
                new EntityWrapper<PaymentEntity>()
        );

        return new PageUtils(page);
    }

}
