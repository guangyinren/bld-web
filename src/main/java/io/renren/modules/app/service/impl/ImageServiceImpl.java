package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ImageDao;
import io.renren.modules.app.entity.ImageEntity;
import io.renren.modules.app.service.ImageService;


@Service("imageService")
public class ImageServiceImpl extends ServiceImpl<ImageDao, ImageEntity> implements ImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ImageEntity> page = this.selectPage(
                new Query<ImageEntity>(params).getPage(),
                new EntityWrapper<ImageEntity>()
        );

        return new PageUtils(page);
    }

}
