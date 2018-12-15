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

import io.renren.modules.app.entity.SpreadLogEntity;
import io.renren.modules.app.service.SpreadLogService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 推广记录
 *
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@RestController
@RequestMapping("app/spreadlog")
public class SpreadLogController {
    @Autowired
    private SpreadLogService spreadLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:spreadlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spreadLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{spreadLogId}")
    @RequiresPermissions("app:spreadlog:info")
    public R info(@PathVariable("spreadLogId") String spreadLogId){
			SpreadLogEntity spreadLog = spreadLogService.selectById(spreadLogId);

        return R.ok().put("spreadLog", spreadLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:spreadlog:save")
    public R save(@RequestBody SpreadLogEntity spreadLog){
			spreadLogService.insert(spreadLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:spreadlog:update")
    public R update(@RequestBody SpreadLogEntity spreadLog){
			spreadLogService.updateById(spreadLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:spreadlog:delete")
    public R delete(@RequestBody String[] spreadLogIds){
			spreadLogService.deleteBatchIds(Arrays.asList(spreadLogIds));

        return R.ok();
    }

}
