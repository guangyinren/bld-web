package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.AccountLogDao;
import io.renren.modules.app.entity.AccountLogEntity;
import io.renren.modules.app.service.AccountLogService;


@Service("accountLogService")
public class AccountLogServiceImpl extends ServiceImpl<AccountLogDao, AccountLogEntity> implements AccountLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AccountLogEntity> page = this.selectPage(
                new Query<AccountLogEntity>(params).getPage(),
                new EntityWrapper<AccountLogEntity>()
        );

        return new PageUtils(page);
    }

}
