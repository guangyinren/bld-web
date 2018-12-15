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

import io.renren.modules.app.entity.AccountEntity;
import io.renren.modules.app.service.AccountService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 账户
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 12:40:20
 */
@RestController
@RequestMapping("app/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:account:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{accountid}")
    @RequiresPermissions("app:account:info")
    public R info(@PathVariable("accountid") String accountid){
			AccountEntity account = accountService.selectById(accountid);

        return R.ok().put("account", account);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:account:save")
    public R save(@RequestBody AccountEntity account){
			accountService.insert(account);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:account:update")
    public R update(@RequestBody AccountEntity account){
			accountService.updateById(account);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:account:delete")
    public R delete(@RequestBody String[] accountids){
			accountService.deleteBatchIds(Arrays.asList(accountids));

        return R.ok();
    }

}
