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

import io.renren.modules.app.entity.EvaluateEntity;
import io.renren.modules.app.service.EvaluateService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 商品评价
 *
 * @author lhc
 * @email 
 * @date 2018-12-11 17:19:28
 */
@RestController
@RequestMapping("app/evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:evaluate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = evaluateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{evaluateid}")
    @RequiresPermissions("app:evaluate:info")
    public R info(@PathVariable("evaluateid") String evaluateid){
			EvaluateEntity evaluate = evaluateService.selectById(evaluateid);

        return R.ok().put("evaluate", evaluate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:evaluate:save")
    public R save(@RequestBody EvaluateEntity evaluate){
			evaluateService.insert(evaluate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:evaluate:update")
    public R update(@RequestBody EvaluateEntity evaluate){
			evaluateService.updateById(evaluate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:evaluate:delete")
    public R delete(@RequestBody String[] evaluateids){
			evaluateService.deleteBatchIds(Arrays.asList(evaluateids));

        return R.ok();
    }

}
