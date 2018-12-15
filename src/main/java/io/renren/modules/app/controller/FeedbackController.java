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

import io.renren.modules.app.entity.FeedbackEntity;
import io.renren.modules.app.service.FeedbackService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 意见反馈
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 10:17:55
 */
@RestController
@RequestMapping("app/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:feedback:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feedbackService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{feedbackid}")
    @RequiresPermissions("app:feedback:info")
    public R info(@PathVariable("feedbackid") String feedbackid){
			FeedbackEntity feedback = feedbackService.selectById(feedbackid);

        return R.ok().put("feedback", feedback);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:feedback:save")
    public R save(@RequestBody FeedbackEntity feedback){
			feedbackService.insert(feedback);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:feedback:update")
    public R update(@RequestBody FeedbackEntity feedback){
			feedbackService.updateById(feedback);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:feedback:delete")
    public R delete(@RequestBody String[] feedbackids){
			feedbackService.deleteBatchIds(Arrays.asList(feedbackids));

        return R.ok();
    }

}
