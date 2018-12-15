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

import io.renren.modules.app.entity.NoticeEntity;
import io.renren.modules.app.service.NoticeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 通知
 *
 * @author lhc
 * @email 
 * @date 2018-12-10 13:22:43
 */
@RestController
@RequestMapping("app/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:notice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = noticeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{noticeid}")
    @RequiresPermissions("app:notice:info")
    public R info(@PathVariable("noticeid") String noticeid){
			NoticeEntity notice = noticeService.selectById(noticeid);

        return R.ok().put("notice", notice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:notice:save")
    public R save(@RequestBody NoticeEntity notice){
			noticeService.insert(notice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:notice:update")
    public R update(@RequestBody NoticeEntity notice){
			noticeService.updateById(notice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:notice:delete")
    public R delete(@RequestBody String[] noticeids){
			noticeService.deleteBatchIds(Arrays.asList(noticeids));

        return R.ok();
    }

}
