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

import io.renren.modules.app.entity.ForumEntity;
import io.renren.modules.app.service.ForumService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论坛/封地
 *
 * @author lhc
 * @email 
 * @date 2018-12-09 17:04:37
 */
@RestController
@RequestMapping("app/forum")
public class ForumController {
    @Autowired
    private ForumService forumService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:forum:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forumService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{forumid}")
    @RequiresPermissions("app:forum:info")
    public R info(@PathVariable("forumid") String forumid){
			ForumEntity forum = forumService.selectById(forumid);

        return R.ok().put("forum", forum);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:forum:save")
    public R save(@RequestBody ForumEntity forum){
			forumService.insert(forum);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:forum:update")
    public R update(@RequestBody ForumEntity forum){
			forumService.updateById(forum);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:forum:delete")
    public R delete(@RequestBody String[] forumids){
			forumService.deleteBatchIds(Arrays.asList(forumids));

        return R.ok();
    }

}
