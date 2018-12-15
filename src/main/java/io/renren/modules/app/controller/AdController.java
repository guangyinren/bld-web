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

import io.renren.modules.app.entity.AdEntity;
import io.renren.modules.app.service.AdService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:51
 */
@RestController
@RequestMapping("app/ad")
public class AdController {
    @Autowired
    private AdService adService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:ad:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = adService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:ad:info")
    public R info(@PathVariable("id") String id){
			AdEntity ad = adService.selectById(id);

        return R.ok().put("ad", ad);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:ad:save")
    public R save(@RequestBody AdEntity ad){
			adService.insert(ad);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:ad:update")
    public R update(@RequestBody AdEntity ad){
			adService.updateById(ad);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:ad:delete")
    public R delete(@RequestBody String[] ids){
			adService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
