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

import io.renren.modules.app.entity.CourseBookEntity;
import io.renren.modules.app.service.CourseBookService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 课程表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/coursebook")
public class CourseBookController {
    @Autowired
    private CourseBookService courseBookService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:coursebook:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseBookService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{courseBookId}")
    @RequiresPermissions("app:coursebook:info")
    public R info(@PathVariable("courseBookId") String courseBookId){
			CourseBookEntity courseBook = courseBookService.selectById(courseBookId);

        return R.ok().put("courseBook", courseBook);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:coursebook:save")
    public R save(@RequestBody CourseBookEntity courseBook){
			courseBookService.insert(courseBook);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:coursebook:update")
    public R update(@RequestBody CourseBookEntity courseBook){
			courseBookService.updateById(courseBook);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:coursebook:delete")
    public R delete(@RequestBody String[] courseBookIds){
			courseBookService.deleteBatchIds(Arrays.asList(courseBookIds));

        return R.ok();
    }

}
