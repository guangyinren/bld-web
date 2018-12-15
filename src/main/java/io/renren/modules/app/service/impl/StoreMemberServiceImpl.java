package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.StoreMemberDao;
import io.renren.modules.app.entity.StoreMemberEntity;
import io.renren.modules.app.service.StoreMemberService;


@Service("storeMemberService")
public class StoreMemberServiceImpl extends ServiceImpl<StoreMemberDao, StoreMemberEntity> implements StoreMemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StoreMemberEntity> page = this.selectPage(
                new Query<StoreMemberEntity>(params).getPage(),
                new EntityWrapper<StoreMemberEntity>()
        );

        return new PageUtils(page);
    }

}
