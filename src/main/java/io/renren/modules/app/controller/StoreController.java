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

import io.renren.modules.app.entity.StoreEntity;
import io.renren.modules.app.service.StoreService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 店铺
 *
 * @author lhc
 * @email 
 * @date 2018-12-06 22:36:31
 */
@RestController
@RequestMapping("app/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:store:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{storeid}")
    @RequiresPermissions("app:store:info")
    public R info(@PathVariable("storeid") String storeid){
			StoreEntity store = storeService.selectById(storeid);

        return R.ok().put("store", store);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:store:save")
    public R save(@RequestBody StoreEntity store){
			storeService.insert(store);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:store:update")
    public R update(@RequestBody StoreEntity store){
			storeService.updateById(store);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:store:delete")
    public R delete(@RequestBody String[] storeids){
			storeService.deleteBatchIds(Arrays.asList(storeids));

        return R.ok();
    }

}
