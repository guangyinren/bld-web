package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MsgContentDao;
import io.renren.modules.app.entity.MsgContentEntity;
import io.renren.modules.app.service.MsgContentService;


@Service("msgContentService")
public class MsgContentServiceImpl extends ServiceImpl<MsgContentDao, MsgContentEntity> implements MsgContentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MsgContentEntity> page = this.selectPage(
                new Query<MsgContentEntity>(params).getPage(),
                new EntityWrapper<MsgContentEntity>()
        );

        return new PageUtils(page);
    }

}
