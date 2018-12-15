package io.renren.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.ImageEntity;
import io.renren.modules.app.service.ImageService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 图片
 *
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
@RestController
@RequestMapping("app/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:image:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = imageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{imageId}")
    @RequiresPermissions("app:image:info")
    public R info(@PathVariable("imageId") Long imageId){
			ImageEntity image = imageService.selectById(imageId);

        return R.ok().put("image", image);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:image:save")
    public R save(@RequestBody ImageEntity image){
			imageService.insert(image);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:image:update")
    public R update(@RequestBody ImageEntity image){
			imageService.updateById(image);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:image:delete")
    public R delete(@RequestBody Long[] imageIds){
			imageService.deleteBatchIds(Arrays.asList(imageIds));

        return R.ok();
    }

}
