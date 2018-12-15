package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.ContributeLogEntity;
import io.renren.modules.app.service.ContributeLogService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 投稿记录
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/contributelog")
public class ContributeLogApiController {
    @Autowired
    private ContributeLogService contributeLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:contributelog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = contributeLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{contributeLogId}")
    @RequiresPermissions("app:contributelog:info")
    public R info(@PathVariable("contributeLogId") String contributeLogId){
			ContributeLogEntity contributeLog = contributeLogService.selectById(contributeLogId);

        return R.ok().put("contributeLog", contributeLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:contributelog:save")
    public R save(ContributeLogEntity contributeLog){
			contributeLogService.insert(contributeLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:contributelog:update")
    public R update(ContributeLogEntity contributeLog){
			contributeLogService.updateById(contributeLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:contributelog:delete")
    public R delete(String[] contributeLogIds){
			contributeLogService.deleteBatchIds(Arrays.asList(contributeLogIds));

        return R.ok();
    }

}
