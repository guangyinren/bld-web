package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ReceiverDao;
import io.renren.modules.app.entity.ReceiverEntity;
import io.renren.modules.app.service.ReceiverService;


@Service("receiverService")
public class ReceiverServiceImpl extends ServiceImpl<ReceiverDao, ReceiverEntity> implements ReceiverService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ReceiverEntity> page = this.selectPage(
                new Query<ReceiverEntity>(params).getPage(),
                new EntityWrapper<ReceiverEntity>()
        );

        return new PageUtils(page);
    }

}
