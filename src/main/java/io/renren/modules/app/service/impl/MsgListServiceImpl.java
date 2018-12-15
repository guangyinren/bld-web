package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MsgListDao;
import io.renren.modules.app.entity.MsgListEntity;
import io.renren.modules.app.service.MsgListService;


@Service("msgListService")
public class MsgListServiceImpl extends ServiceImpl<MsgListDao, MsgListEntity> implements MsgListService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MsgListEntity> page = this.selectPage(
                new Query<MsgListEntity>(params).getPage(),
                new EntityWrapper<MsgListEntity>()
        );

        return new PageUtils(page);
    }

}
