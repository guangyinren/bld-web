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

import io.renren.modules.app.entity.MsgListEntity;
import io.renren.modules.app.service.MsgListService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 会话列表
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:04
 */
@RestController
@RequestMapping("app/msglist")
public class MsgListController {
    @Autowired
    private MsgListService msgListService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:msglist:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = msgListService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{msglistid}")
    @RequiresPermissions("app:msglist:info")
    public R info(@PathVariable("msglistid") String msglistid){
			MsgListEntity msgList = msgListService.selectById(msglistid);

        return R.ok().put("msgList", msgList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:msglist:save")
    public R save(@RequestBody MsgListEntity msgList){
			msgListService.insert(msgList);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:msglist:update")
    public R update(@RequestBody MsgListEntity msgList){
			msgListService.updateById(msgList);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:msglist:delete")
    public R delete(@RequestBody String[] msglistids){
			msgListService.deleteBatchIds(Arrays.asList(msglistids));

        return R.ok();
    }

}
