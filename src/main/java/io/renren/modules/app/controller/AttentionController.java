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

import io.renren.modules.app.entity.AttentionEntity;
import io.renren.modules.app.service.AttentionService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 关注表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/attention")
public class AttentionController {
    @Autowired
    private AttentionService attentionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:attention:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attentionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attentionId}")
    @RequiresPermissions("app:attention:info")
    public R info(@PathVariable("attentionId") String attentionId){
			AttentionEntity attention = attentionService.selectById(attentionId);

        return R.ok().put("attention", attention);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:attention:save")
    public R save(@RequestBody AttentionEntity attention){
			attentionService.insert(attention);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:attention:update")
    public R update(@RequestBody AttentionEntity attention){
			attentionService.updateById(attention);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:attention:delete")
    public R delete(@RequestBody String[] attentionIds){
			attentionService.deleteBatchIds(Arrays.asList(attentionIds));

        return R.ok();
    }

}
