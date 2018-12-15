package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.UclassDao;
import io.renren.modules.app.entity.UclassEntity;
import io.renren.modules.app.service.UclassService;


@Service("uclassService")
public class UclassServiceImpl extends ServiceImpl<UclassDao, UclassEntity> implements UclassService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UclassEntity> page = this.selectPage(
                new Query<UclassEntity>(params).getPage(),
                new EntityWrapper<UclassEntity>()
        );

        return new PageUtils(page);
    }

}
