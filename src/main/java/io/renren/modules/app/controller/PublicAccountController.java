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

import io.renren.modules.app.entity.PublicAccountEntity;
import io.renren.modules.app.service.PublicAccountService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 公众号
 *
 * @author lhc
 * @email 
 * @date 2018-06-06 23:21:07
 */
@RestController
@RequestMapping("app/publicaccount")
public class PublicAccountController {
    @Autowired
    private PublicAccountService publicAccountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:publicaccount:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = publicAccountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{publicAccountId}")
    @RequiresPermissions("app:publicaccount:info")
    public R info(@PathVariable("publicAccountId") Long publicAccountId){
			PublicAccountEntity publicAccount = publicAccountService.selectById(publicAccountId);

        return R.ok().put("publicAccount", publicAccount);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:publicaccount:save")
    public R save(@RequestBody PublicAccountEntity publicAccount){
			publicAccountService.insert(publicAccount);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:publicaccount:update")
    public R update(@RequestBody PublicAccountEntity publicAccount){
			publicAccountService.updateById(publicAccount);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:publicaccount:delete")
    public R delete(@RequestBody Long[] publicAccountIds){
			publicAccountService.deleteBatchIds(Arrays.asList(publicAccountIds));

        return R.ok();
    }
}
