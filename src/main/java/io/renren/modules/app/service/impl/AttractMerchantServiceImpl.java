package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.AttractMerchantDao;
import io.renren.modules.app.entity.AttractMerchantEntity;
import io.renren.modules.app.service.AttractMerchantService;


@Service("attractMerchantService")
public class AttractMerchantServiceImpl extends ServiceImpl<AttractMerchantDao, AttractMerchantEntity> implements AttractMerchantService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AttractMerchantEntity> page = this.selectPage(
                new Query<AttractMerchantEntity>(params).getPage(),
                new EntityWrapper<AttractMerchantEntity>()
        );

        return new PageUtils(page);
    }

}
