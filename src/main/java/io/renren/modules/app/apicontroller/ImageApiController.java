package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.modules.app.entity.ImageEntity;
import io.renren.modules.app.service.ImageService;
import io.renren.common.base.AbstractController;
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
@RequestMapping("api/image")
public class ImageApiController extends AbstractController{
    @Autowired
    private ImageService imageService;
    
    @RequestMapping("/queryMyImg")
    public R queryMyImg(String userId){
    	userId=(userId==null?getUser().getUserId():userId);
    	ImageEntity entity=new ImageEntity();
    	entity.setUserId(Long.valueOf(userId));
    	List<ImageEntity> list = imageService.selectList(new EntityWrapper<ImageEntity>(entity));
        return R.ok().put("list", list);
    }
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
    public R save(ImageEntity image){
			imageService.insert(image);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:image:update")
    public R update(ImageEntity image){
			imageService.updateById(image);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:image:delete")
    public R delete(Long[] imageIds){
			imageService.deleteBatchIds(Arrays.asList(imageIds));

        return R.ok();
    }

}
