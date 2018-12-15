package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.PublicAccountDao;
import io.renren.modules.app.entity.PublicAccountEntity;
import io.renren.modules.app.service.PublicAccountService;


@Service("publicAccountService")
public class PublicAccountServiceImpl extends ServiceImpl<PublicAccountDao, PublicAccountEntity> implements PublicAccountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PublicAccountEntity> page = this.selectPage(
                new Query<PublicAccountEntity>(params).getPage(),
                new EntityWrapper<PublicAccountEntity>()
        );

        return new PageUtils(page);
    }

}
