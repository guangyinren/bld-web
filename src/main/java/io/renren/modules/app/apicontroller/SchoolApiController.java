package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.SchoolEntity;
import io.renren.modules.app.service.SchoolService;



/**
 * 学校
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/school")
public class SchoolApiController {
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
    public R save(SchoolEntity school){
		schoolService.insert(school);
		System.out.println(school.getSchoolId());
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:school:update")
    public R update(SchoolEntity school){
			schoolService.updateById(school);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:school:delete")
    public R delete(String[] schoolIds){
			schoolService.deleteBatchIds(Arrays.asList(schoolIds));

        return R.ok();
    }

}
