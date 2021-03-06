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

import io.renren.modules.app.entity.OrderEntity;
import io.renren.modules.app.service.OrderService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-11 16:07:23
 */
@RestController
@RequestMapping("app/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:order:info")
    public R info(@PathVariable("id") String id){
			OrderEntity order = orderService.selectById(id);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:order:save")
    public R save(@RequestBody OrderEntity order){
			orderService.insert(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:order:update")
    public R update(@RequestBody OrderEntity order){
			orderService.updateById(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:order:delete")
    public R delete(@RequestBody String[] ids){
			orderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
