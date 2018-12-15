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

import io.renren.modules.app.entity.MsgContentEntity;
import io.renren.modules.app.service.MsgContentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 即时消息内容
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:05
 */
@RestController
@RequestMapping("app/msgcontent")
public class MsgContentController {
    @Autowired
    private MsgContentService msgContentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:msgcontent:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = msgContentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{msgcontentid}")
    @RequiresPermissions("app:msgcontent:info")
    public R info(@PathVariable("msgcontentid") String msgcontentid){
			MsgContentEntity msgContent = msgContentService.selectById(msgcontentid);

        return R.ok().put("msgContent", msgContent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:msgcontent:save")
    public R save(@RequestBody MsgContentEntity msgContent){
			msgContentService.insert(msgContent);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:msgcontent:update")
    public R update(@RequestBody MsgContentEntity msgContent){
			msgContentService.updateById(msgContent);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:msgcontent:delete")
    public R delete(@RequestBody String[] msgcontentids){
			msgContentService.deleteBatchIds(Arrays.asList(msgcontentids));

        return R.ok();
    }

}
