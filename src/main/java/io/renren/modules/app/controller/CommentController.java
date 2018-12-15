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

import io.renren.modules.app.entity.CommentEntity;
import io.renren.modules.app.service.CommentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 评论
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:comment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{commentId}")
    @RequiresPermissions("app:comment:info")
    public R info(@PathVariable("commentId") String commentId){
			CommentEntity comment = commentService.selectById(commentId);

        return R.ok().put("comment", comment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:comment:save")
    public R save(@RequestBody CommentEntity comment){
			commentService.insert(comment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:comment:update")
    public R update(@RequestBody CommentEntity comment){
			commentService.updateById(comment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:comment:delete")
    public R delete(@RequestBody String[] commentIds){
			commentService.deleteBatchIds(Arrays.asList(commentIds));

        return R.ok();
    }

}
