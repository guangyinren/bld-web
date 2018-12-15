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

import io.renren.modules.app.entity.ComplainEntity;
import io.renren.modules.app.service.ComplainService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 举报投诉表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/complain")
public class ComplainController {
    @Autowired
    private ComplainService complainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:complain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = complainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{complainId}")
    @RequiresPermissions("app:complain:info")
    public R info(@PathVariable("complainId") String complainId){
			ComplainEntity complain = complainService.selectById(complainId);

        return R.ok().put("complain", complain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:complain:save")
    public R save(@RequestBody ComplainEntity complain){
			complainService.insert(complain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:complain:update")
    public R update(@RequestBody ComplainEntity complain){
			complainService.updateById(complain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:complain:delete")
    public R delete(@RequestBody String[] complainIds){
			complainService.deleteBatchIds(Arrays.asList(complainIds));

        return R.ok();
    }

}
