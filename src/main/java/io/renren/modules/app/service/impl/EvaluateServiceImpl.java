package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.EvaluateDao;
import io.renren.modules.app.entity.EvaluateEntity;
import io.renren.modules.app.service.EvaluateService;


@Service("evaluateService")
public class EvaluateServiceImpl extends ServiceImpl<EvaluateDao, EvaluateEntity> implements EvaluateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EvaluateEntity> page = this.selectPage(
                new Query<EvaluateEntity>(params).getPage(),
                new EntityWrapper<EvaluateEntity>()
        );

        return new PageUtils(page);
    }

}
