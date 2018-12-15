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

import io.renren.modules.app.entity.MessageConfigEntity;
import io.renren.modules.app.service.MessageConfigService;
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
@RequestMapping("app/messageconfig")
public class MessageConfigController {
    @Autowired
    private MessageConfigService messageConfigService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:messageconfig:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = messageConfigService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:messageconfig:info")
    public R info(@PathVariable("id") String id){
			MessageConfigEntity messageConfig = messageConfigService.selectById(id);

        return R.ok().put("messageConfig", messageConfig);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:messageconfig:save")
    public R save(@RequestBody MessageConfigEntity messageConfig){
			messageConfigService.insert(messageConfig);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:messageconfig:update")
    public R update(@RequestBody MessageConfigEntity messageConfig){
			messageConfigService.updateById(messageConfig);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:messageconfig:delete")
    public R delete(@RequestBody String[] ids){
			messageConfigService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
