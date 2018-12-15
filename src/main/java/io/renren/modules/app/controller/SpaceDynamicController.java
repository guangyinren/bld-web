package io.renren.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import io.renren.modules.app.entity.ArticleEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.SpaceDynamicEntity;
import io.renren.modules.app.service.SpaceDynamicService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 空间动态
 *
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
@RestController
@RequestMapping("app/spacedynamic")
public class SpaceDynamicController {
    @Autowired
    private SpaceDynamicService spaceDynamicService;
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:spacedynamic:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spaceDynamicService.queryPage(params);
         for(int i=0;i<page.getList().size();i++){
             SpaceDynamicEntity entity=(SpaceDynamicEntity)page.getList().get(i);
            if(StringUtils.isNotEmpty(entity.getPraise())){
                JSONObject praiseObject = JSONObject.parseObject(entity.getPraise());
                ((SpaceDynamicEntity) page.getList().get(i)).setPraise(praiseObject.getString("total"));
            }
        }
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{spaceDynamicId}")
    @RequiresPermissions("app:spacedynamic:info")
    public R info(@PathVariable("spaceDynamicId") String spaceDynamicId){
			SpaceDynamicEntity spaceDynamic = spaceDynamicService.selectById(spaceDynamicId);

        return R.ok().put("spaceDynamic", spaceDynamic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:spacedynamic:save")
    public R save(@RequestBody SpaceDynamicEntity spaceDynamic){
			spaceDynamicService.insert(spaceDynamic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:spacedynamic:update")
    public R update(@RequestBody SpaceDynamicEntity spaceDynamic){
			spaceDynamicService.updateById(spaceDynamic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:spacedynamic:delete")
    public R delete(@RequestBody Long[] spaceDynamicIds){
			spaceDynamicService.deleteBatchIds(Arrays.asList(spaceDynamicIds));

        return R.ok();
    }
    
}
