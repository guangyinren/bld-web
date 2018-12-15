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

import io.renren.modules.app.entity.AdPositionEntity;
import io.renren.modules.app.service.AdPositionService;
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
@RequestMapping("app/adposition")
public class AdPositionController {
    @Autowired
    private AdPositionService adPositionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:adposition:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = adPositionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:adposition:info")
    public R info(@PathVariable("id") String id){
			AdPositionEntity adPosition = adPositionService.selectById(id);

        return R.ok().put("adPosition", adPosition);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:adposition:save")
    public R save(@RequestBody AdPositionEntity adPosition){
			adPositionService.insert(adPosition);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:adposition:update")
    public R update(@RequestBody AdPositionEntity adPosition){
			adPositionService.updateById(adPosition);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:adposition:delete")
    public R delete(@RequestBody String[] ids){
			adPositionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
