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

import io.renren.modules.app.entity.CollectEntity;
import io.renren.modules.app.service.CollectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 收藏表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:collect:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = collectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{collectId}")
    @RequiresPermissions("app:collect:info")
    public R info(@PathVariable("collectId") String collectId){
			CollectEntity collect = collectService.selectById(collectId);

        return R.ok().put("collect", collect);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:collect:save")
    public R save(@RequestBody CollectEntity collect){
			collectService.insert(collect);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:collect:update")
    public R update(@RequestBody CollectEntity collect){
			collectService.updateById(collect);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:collect:delete")
    public R delete(@RequestBody String[] collectIds){
			collectService.deleteBatchIds(Arrays.asList(collectIds));

        return R.ok();
    }

}
