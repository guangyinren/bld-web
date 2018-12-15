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

import io.renren.modules.app.entity.ReceiverEntity;
import io.renren.modules.app.service.ReceiverService;
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
@RequestMapping("app/receiver")
public class ReceiverController {
    @Autowired
    private ReceiverService receiverService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:receiver:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = receiverService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:receiver:info")
    public R info(@PathVariable("id") String id){
			ReceiverEntity receiver = receiverService.selectById(id);

        return R.ok().put("receiver", receiver);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:receiver:save")
    public R save(@RequestBody ReceiverEntity receiver){
			receiverService.insert(receiver);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:receiver:update")
    public R update(@RequestBody ReceiverEntity receiver){
			receiverService.updateById(receiver);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:receiver:delete")
    public R delete(@RequestBody String[] ids){
			receiverService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
