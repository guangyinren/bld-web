package io.renren.modules.app.dao;

import io.renren.modules.app.entity.StoreMemberEntity;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 店铺会员
 * 
 * @author lhc
 * @email 
 * @date 2018-12-07 11:10:29
 */
 @Mapper
public interface StoreMemberDao extends BaseMapper<StoreMemberEntity> {
	
}
