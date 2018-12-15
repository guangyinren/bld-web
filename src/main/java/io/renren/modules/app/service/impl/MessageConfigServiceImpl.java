package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MessageConfigDao;
import io.renren.modules.app.entity.MessageConfigEntity;
import io.renren.modules.app.service.MessageConfigService;


@Service("messageConfigService")
public class MessageConfigServiceImpl extends ServiceImpl<MessageConfigDao, MessageConfigEntity> implements MessageConfigService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MessageConfigEntity> page = this.selectPage(
                new Query<MessageConfigEntity>(params).getPage(),
                new EntityWrapper<MessageConfigEntity>()
        );

        return new PageUtils(page);
    }

}
