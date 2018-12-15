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

import io.renren.modules.app.entity.CountDownEntity;
import io.renren.modules.app.service.CountDownService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 倒计时表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/countdown")
public class CountDownController {
    @Autowired
    private CountDownService countDownService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:countdown:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = countDownService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{countDownId}")
    @RequiresPermissions("app:countdown:info")
    public R info(@PathVariable("countDownId") String countDownId){
			CountDownEntity countDown = countDownService.selectById(countDownId);

        return R.ok().put("countDown", countDown);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:countdown:save")
    public R save(@RequestBody CountDownEntity countDown){
			countDownService.insert(countDown);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:countdown:update")
    public R update(@RequestBody CountDownEntity countDown){
			countDownService.updateById(countDown);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:countdown:delete")
    public R delete(@RequestBody String[] countDownIds){
			countDownService.deleteBatchIds(Arrays.asList(countDownIds));

        return R.ok();
    }

}
