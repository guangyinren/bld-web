package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.DynamicSqlDao;
import io.renren.modules.app.entity.DynamicSqlEntity;
import io.renren.modules.app.service.DynamicSqlService;


@Service("dynamicSqlService")
public class DynamicSqlServiceImpl extends ServiceImpl<DynamicSqlDao, DynamicSqlEntity> implements DynamicSqlService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DynamicSqlEntity> page = this.selectPage(
                new Query<DynamicSqlEntity>(params).getPage(),
                new EntityWrapper<DynamicSqlEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<Map<String, Object>> selectSql(String sql) {
		return baseMapper.selectSql(sql);
	}

}
