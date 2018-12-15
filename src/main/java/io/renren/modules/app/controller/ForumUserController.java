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

import io.renren.modules.app.entity.ForumUserEntity;
import io.renren.modules.app.service.ForumUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 论坛用户
 *
 * @author lhc
 * @email 
 * @date 2018-12-09 18:57:25
 */
@RestController
@RequestMapping("app/forumuser")
public class ForumUserController {
    @Autowired
    private ForumUserService forumUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:forumuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forumUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{forumuserid}")
    @RequiresPermissions("app:forumuser:info")
    public R info(@PathVariable("forumuserid") String forumuserid){
			ForumUserEntity forumUser = forumUserService.selectById(forumuserid);

        return R.ok().put("forumUser", forumUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:forumuser:save")
    public R save(@RequestBody ForumUserEntity forumUser){
			forumUserService.insert(forumUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:forumuser:update")
    public R update(@RequestBody ForumUserEntity forumUser){
			forumUserService.updateById(forumUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:forumuser:delete")
    public R delete(@RequestBody String[] forumuserids){
			forumUserService.deleteBatchIds(Arrays.asList(forumuserids));

        return R.ok();
    }

}
