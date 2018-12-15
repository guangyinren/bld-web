package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MsgListUserDao;
import io.renren.modules.app.entity.MsgListUserEntity;
import io.renren.modules.app.service.MsgListUserService;


@Service("msgListUserService")
public class MsgListUserServiceImpl extends ServiceImpl<MsgListUserDao, MsgListUserEntity> implements MsgListUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MsgListUserEntity> page = this.selectPage(
                new Query<MsgListUserEntity>(params).getPage(),
                new EntityWrapper<MsgListUserEntity>()
        );

        return new PageUtils(page);
    }

}
