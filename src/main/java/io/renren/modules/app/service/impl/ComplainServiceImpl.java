package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ComplainDao;
import io.renren.modules.app.entity.ComplainEntity;
import io.renren.modules.app.service.ComplainService;


@Service("complainService")
public class ComplainServiceImpl extends ServiceImpl<ComplainDao, ComplainEntity> implements ComplainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ComplainEntity> page = this.selectPage(
                new Query<ComplainEntity>(params).getPage(),
                new EntityWrapper<ComplainEntity>()
        );

        return new PageUtils(page);
    }

}
