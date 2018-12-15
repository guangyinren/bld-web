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

import io.renren.modules.app.entity.RelationUserEntity;
import io.renren.modules.app.service.RelationUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 联系人
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/relationuser")
public class RelationUserController {
    @Autowired
    private RelationUserService relationUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:relationuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = relationUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{relationUserId}")
    @RequiresPermissions("app:relationuser:info")
    public R info(@PathVariable("relationUserId") String relationUserId){
			RelationUserEntity relationUser = relationUserService.selectById(relationUserId);

        return R.ok().put("relationUser", relationUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:relationuser:save")
    public R save(@RequestBody RelationUserEntity relationUser){
			relationUserService.insert(relationUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:relationuser:update")
    public R update(@RequestBody RelationUserEntity relationUser){
			relationUserService.updateById(relationUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:relationuser:delete")
    public R delete(@RequestBody String[] relationUserIds){
			relationUserService.deleteBatchIds(Arrays.asList(relationUserIds));

        return R.ok();
    }

}
