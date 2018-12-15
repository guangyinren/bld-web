package io.renren.modules.app.dao;

import io.renren.modules.app.entity.ImageEntity;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 图片
 * 
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
@Mapper
public interface ImageDao extends BaseMapper<ImageEntity> {
	
}
