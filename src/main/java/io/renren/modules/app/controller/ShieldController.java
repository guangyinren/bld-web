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

import io.renren.modules.app.entity.ShieldEntity;
import io.renren.modules.app.service.ShieldService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 屏蔽表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/shield")
public class ShieldController {
    @Autowired
    private ShieldService shieldService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:shield:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shieldService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{shieldId}")
    @RequiresPermissions("app:shield:info")
    public R info(@PathVariable("shieldId") String shieldId){
			ShieldEntity shield = shieldService.selectById(shieldId);

        return R.ok().put("shield", shield);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:shield:save")
    public R save(@RequestBody ShieldEntity shield){
			shieldService.insert(shield);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:shield:update")
    public R update(@RequestBody ShieldEntity shield){
			shieldService.updateById(shield);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:shield:delete")
    public R delete(@RequestBody String[] shieldIds){
			shieldService.deleteBatchIds(Arrays.asList(shieldIds));

        return R.ok();
    }

}
