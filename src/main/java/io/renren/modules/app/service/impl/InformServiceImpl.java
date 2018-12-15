package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.InformDao;
import io.renren.modules.app.entity.InformEntity;
import io.renren.modules.app.service.InformService;


@Service("informService")
public class InformServiceImpl extends ServiceImpl<InformDao, InformEntity> implements InformService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InformEntity> page = this.selectPage(
                new Query<InformEntity>(params).getPage(),
                new EntityWrapper<InformEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<Map<String, Object>> queryMyInform(String userId) {
		return baseMapper.queryMyInform(userId);
	}

}
