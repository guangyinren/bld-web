package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import io.renren.common.utils.LogUtil;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.ShieldEntity;
import io.renren.modules.app.entity.SpaceDynamicEntity;
import io.renren.modules.app.service.ShieldService;
import io.renren.modules.app.service.SpaceDynamicService;
import io.renren.modules.app.service.UserService;



/**
 * 屏蔽表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/shield")
public class ShieldApiController {
    @Autowired
    private ShieldService shieldService;
    @Autowired
    private UserService userService;
    @Autowired
    private SpaceDynamicService spaceDynamicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:shield:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shieldService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{shieldId}")
    @RequiresPermissions("app:shield:info")
    public R info(@PathVariable("shieldId") String shieldId){
			ShieldEntity shield = shieldService.selectById(shieldId);

        return R.ok().put("shield", shield);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(ShieldEntity shield){
    	LogUtil.logAfter("添加屏蔽信息", "请求参数:{}", JSON.toJSONString(shield));
    	if(StringUtils.isEmpty(shield.getUserId())) {
    		return R.error(1, "用户id不能为空");
    	}
    	if(StringUtils.isEmpty(shield.getType())) {
    		return R.error(1, "屏蔽类型不能为空");
    	}
    	if(StringUtils.isEmpty(shield.getSourceId())) {
    		return R.error(1, "屏蔽id不能为空");
    	}
    	
    	if(shield.getType().equals("0")) {//动态
    		SpaceDynamicEntity spaceDynamicEntity=spaceDynamicService.selectById(shield.getSourceId());
    		if(spaceDynamicEntity==null) {
    			return R.error(1, "动态不存在");
    		}else if(shield.getUserId().equals(String.valueOf(spaceDynamicEntity.getUserId()))){
    			return R.error(1, "不能屏蔽自己的动态");
    		}
    	}else if(shield.getType().equals("1")&&shield.getUserId().equals(shield.getSourceId())) {//用户
    		return R.error(1, "不能屏蔽自己");
    	}
		shieldService.insert(shield);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:shield:update")
    public R update(ShieldEntity shield){
			shieldService.updateById(shield);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:shield:delete")
    public R delete(String[] shieldIds){
			shieldService.deleteBatchIds(Arrays.asList(shieldIds));

        return R.ok();
    }

}
