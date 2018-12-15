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

import io.renren.modules.app.entity.SchoolEntity;
import io.renren.modules.app.service.SchoolService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 学校
 *
 * @author lhc
 * @email 
 * @date 2018-07-29 23:13:35
 */
@RestController
@RequestMapping("app/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:school:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = schoolService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schoolId}")
    @RequiresPermissions("app:school:info")
    public R info(@PathVariable("schoolId") String schoolId){
			SchoolEntity school = schoolService.selectById(schoolId);

        return R.ok().put("school", school);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:school:save")
    public R save(@RequestBody SchoolEntity school){
			schoolService.insert(school);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:school:update")
    public R update(@RequestBody SchoolEntity school){
			schoolService.updateById(school);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:school:delete")
    public R delete(@RequestBody String[] schoolIds){
			schoolService.deleteBatchIds(Arrays.asList(schoolIds));

        return R.ok();
    }

}
