package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.LogUtil;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.ComplainEntity;
import io.renren.modules.app.service.ComplainService;



/**
 * 举报投诉表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/complain")
public class ComplainApiController extends AbstractController{
    @Autowired
    private ComplainService complainService;

    /**
     * 添加一条举报信息
     */
    @RequestMapping("/save")
    public R save(ComplainEntity complain){
    	complain.setCreateTime(new Date());
    	LogUtil.logBefore("举报", "请求数据:{}", JSON.toJSONString(complain));
		complainService.insert(complain);
        return R.ok();
    }
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:complain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = complainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{complainId}")
    @RequiresPermissions("app:complain:info")
    public R info(@PathVariable("complainId") String complainId){
			ComplainEntity complain = complainService.selectById(complainId);

        return R.ok().put("complain", complain);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:complain:update")
    public R update(ComplainEntity complain){
			complainService.updateById(complain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:complain:delete")
    public R delete(String[] complainIds){
			complainService.deleteBatchIds(Arrays.asList(complainIds));

        return R.ok();
    }

}
