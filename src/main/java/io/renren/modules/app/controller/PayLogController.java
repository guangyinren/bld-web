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

import io.renren.modules.app.entity.PayLogEntity;
import io.renren.modules.app.service.PayLogService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 支付记录
 *
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@RestController
@RequestMapping("app/paylog")
public class PayLogController {
    @Autowired
    private PayLogService payLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:paylog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = payLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{payLogId}")
    @RequiresPermissions("app:paylog:info")
    public R info(@PathVariable("payLogId") String payLogId){
			PayLogEntity payLog = payLogService.selectById(payLogId);

        return R.ok().put("payLog", payLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:paylog:save")
    public R save(@RequestBody PayLogEntity payLog){
			payLogService.insert(payLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:paylog:update")
    public R update(@RequestBody PayLogEntity payLog){
			payLogService.updateById(payLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:paylog:delete")
    public R delete(@RequestBody String[] payLogIds){
			payLogService.deleteBatchIds(Arrays.asList(payLogIds));

        return R.ok();
    }

}
