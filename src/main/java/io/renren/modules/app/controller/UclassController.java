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

import io.renren.modules.app.entity.UclassEntity;
import io.renren.modules.app.service.UclassService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 班级
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/uclass")
public class UclassController {
    @Autowired
    private UclassService uclassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:uclass:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = uclassService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uclassId}")
    @RequiresPermissions("app:uclass:info")
    public R info(@PathVariable("uclassId") String uclassId){
			UclassEntity uclass = uclassService.selectById(uclassId);

        return R.ok().put("uclass", uclass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:uclass:save")
    public R save(@RequestBody UclassEntity uclass){
			uclassService.insert(uclass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:uclass:update")
    public R update(@RequestBody UclassEntity uclass){
			uclassService.updateById(uclass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:uclass:delete")
    public R delete(@RequestBody String[] uclassIds){
			uclassService.deleteBatchIds(Arrays.asList(uclassIds));

        return R.ok();
    }

}
