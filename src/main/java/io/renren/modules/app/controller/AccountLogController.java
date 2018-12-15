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

import io.renren.modules.app.entity.AccountLogEntity;
import io.renren.modules.app.service.AccountLogService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 账户流水
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 12:40:20
 */
@RestController
@RequestMapping("app/accountlog")
public class AccountLogController {
    @Autowired
    private AccountLogService accountLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:accountlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{accountlogid}")
    @RequiresPermissions("app:accountlog:info")
    public R info(@PathVariable("accountlogid") String accountlogid){
			AccountLogEntity accountLog = accountLogService.selectById(accountlogid);

        return R.ok().put("accountLog", accountLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:accountlog:save")
    public R save(@RequestBody AccountLogEntity accountLog){
			accountLogService.insert(accountLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:accountlog:update")
    public R update(@RequestBody AccountLogEntity accountLog){
			accountLogService.updateById(accountLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:accountlog:delete")
    public R delete(@RequestBody String[] accountlogids){
			accountLogService.deleteBatchIds(Arrays.asList(accountlogids));

        return R.ok();
    }

}
