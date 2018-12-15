package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.LiteratureActivityDao;
import io.renren.modules.app.entity.LiteratureActivityEntity;
import io.renren.modules.app.service.LiteratureActivityService;


@Service("literatureActivityService")
public class LiteratureActivityServiceImpl extends ServiceImpl<LiteratureActivityDao, LiteratureActivityEntity> implements LiteratureActivityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiteratureActivityEntity> page = this.selectPage(
                new Query<LiteratureActivityEntity>(params).getPage(),
                new EntityWrapper<LiteratureActivityEntity>()
        );

        return new PageUtils(page);
    }

}
