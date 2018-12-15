package io.renren.modules.app.dao;

import io.renren.modules.app.entity.AccountLogEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 账户流水
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 12:40:20
 */
 @Mapper
public interface AccountLogDao extends BaseMapper<AccountLogEntity> {
	
}
