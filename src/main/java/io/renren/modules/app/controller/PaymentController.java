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

import io.renren.modules.app.entity.PaymentEntity;
import io.renren.modules.app.service.PaymentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:50
 */
@RestController
@RequestMapping("app/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:payment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = paymentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:payment:info")
    public R info(@PathVariable("id") String id){
			PaymentEntity payment = paymentService.selectById(id);

        return R.ok().put("payment", payment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:payment:save")
    public R save(@RequestBody PaymentEntity payment){
			paymentService.insert(payment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:payment:update")
    public R update(@RequestBody PaymentEntity payment){
			paymentService.updateById(payment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:payment:delete")
    public R delete(@RequestBody String[] ids){
			paymentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
