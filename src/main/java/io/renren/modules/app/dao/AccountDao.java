package io.renren.modules.app.dao;

import io.renren.modules.app.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 账户
 * 
 * @author lhc
 * @email 
 * @date 2018-12-13 12:40:20
 */
 @Mapper
public interface AccountDao extends BaseMapper<AccountEntity> {
	
}
