package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.AdEntity;
import io.renren.modules.app.service.AdService;
import io.renren.modules.app.service.DynamicSqlService;



/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:51
 */
@RestController
@RequestMapping("api/ad")
public class AdApiController {
    @Autowired
    private AdService adService;
    @Autowired
    private DynamicSqlService dynamicSqlService;

    /*
     * 获取不同页面轮播图(3:首页,2:便利店首页,1:共享商城首页)
     */
    @RequestMapping("/list")
    public R list(String type){
    	if(StringUtils.isEmpty(type)) {
    		return R.error("type不能为空");
    	}
    	Wrapper<AdEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("title,image,url");
    	wrapper.eq("adPositionId", type).eq("isEnabled", 1);
    	List<Map<String, Object>> list = adService.selectMaps(wrapper);
        return R.ok().put("list",list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:ad:info")
    public R info(@PathVariable("id") String id){
			AdEntity ad = adService.selectById(id);

        return R.ok().put("ad", ad);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:ad:save")
    public R save(@RequestBody AdEntity ad){
			adService.insert(ad);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:ad:update")
    public R update(@RequestBody AdEntity ad){
			adService.updateById(ad);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:ad:delete")
    public R delete(@RequestBody String[] ids){
			adService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
