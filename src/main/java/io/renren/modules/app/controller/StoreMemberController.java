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

import io.renren.modules.app.entity.StoreMemberEntity;
import io.renren.modules.app.service.StoreMemberService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 店铺会员
 *
 * @author lhc
 * @email 
 * @date 2018-12-07 11:10:29
 */
@RestController
@RequestMapping("app/storemember")
public class StoreMemberController {
    @Autowired
    private StoreMemberService storeMemberService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:storemember:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storeMemberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:storemember:info")
    public R info(@PathVariable("id") String id){
			StoreMemberEntity storeMember = storeMemberService.selectById(id);

        return R.ok().put("storeMember", storeMember);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:storemember:save")
    public R save(@RequestBody StoreMemberEntity storeMember){
			storeMemberService.insert(storeMember);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:storemember:update")
    public R update(@RequestBody StoreMemberEntity storeMember){
			storeMemberService.updateById(storeMember);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:storemember:delete")
    public R delete(@RequestBody String[] ids){
			storeMemberService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
