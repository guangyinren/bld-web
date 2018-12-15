package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.StoreMemberEntity;

import java.util.Map;

/**
 * 店铺会员
 *
 * @author lhc
 * @email 
 * @date 2018-12-07 11:10:29
 */
public interface StoreMemberService extends IService<StoreMemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

