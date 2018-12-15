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

import io.renren.modules.app.entity.MsgListUserEntity;
import io.renren.modules.app.service.MsgListUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户会话列表
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 22:57:39
 */
@RestController
@RequestMapping("app/msglistuser")
public class MsgListUserController {
    @Autowired
    private MsgListUserService msgListUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:msglistuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = msgListUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{listuserid}")
    @RequiresPermissions("app:msglistuser:info")
    public R info(@PathVariable("listuserid") String listuserid){
			MsgListUserEntity msgListUser = msgListUserService.selectById(listuserid);

        return R.ok().put("msgListUser", msgListUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:msglistuser:save")
    public R save(@RequestBody MsgListUserEntity msgListUser){
			msgListUserService.insert(msgListUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:msglistuser:update")
    public R update(@RequestBody MsgListUserEntity msgListUser){
			msgListUserService.updateById(msgListUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:msglistuser:delete")
    public R delete(@RequestBody String[] listuserids){
			msgListUserService.deleteBatchIds(Arrays.asList(listuserids));

        return R.ok();
    }

}
