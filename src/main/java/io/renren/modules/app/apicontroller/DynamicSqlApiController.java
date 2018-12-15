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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.renren.modules.app.entity.DynamicSqlEntity;
import io.renren.modules.app.entity.InformEntity;
import io.renren.modules.app.service.DynamicSqlService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-11-11 13:01:55
 */
@RestController
@RequestMapping("api/dynamicsql")
public class DynamicSqlApiController {
    @Autowired
    private DynamicSqlService dynamicSqlService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:dynamicsql:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dynamicSqlService.queryPage(params);

        return R.ok().put("page", page);
    }
    
    @RequestMapping("/list1")
    public R list1(){
    	List<Map<String, Object>> list = dynamicSqlService.selectSql("SELECT inform_id,user_id as userId,type,source_user from inform");
        return R.ok().put("list",list);
    }
    
    @RequestMapping("/list2")
    public R list2(){
    	Wrapper<DynamicSqlEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("inform_id,type,source_id,source_user");
    	List<Map<String, Object>> list = dynamicSqlService.selectMaps(wrapper);
        return R.ok().put("list",list);
    }
    
    /**
     * 会返回所有实体字段,包括null
     * @return
     */
    @RequestMapping("/list3")
    public R list3(){
    	Wrapper<DynamicSqlEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("inform_id,type,source_id,source_user");
    	List<DynamicSqlEntity> list = dynamicSqlService.selectList(wrapper);
        return R.ok().put("list",list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dynamicSqlId}")
    @RequiresPermissions("app:dynamicsql:info")
    public R info(@PathVariable("dynamicSqlId") String dynamicSqlId){
			DynamicSqlEntity dynamicSql = dynamicSqlService.selectById(dynamicSqlId);

        return R.ok().put("dynamicSql", dynamicSql);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DynamicSqlEntity dynamicSql){
    	dynamicSqlService.insert(dynamicSql);
    	System.out.println(dynamicSql.getDynamicSqlId());
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:dynamicsql:update")
    public R update(@RequestBody DynamicSqlEntity dynamicSql){
			dynamicSqlService.updateById(dynamicSql);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:dynamicsql:delete")
    public R delete(@RequestBody String[] dynamicSqlIds){
			dynamicSqlService.deleteBatchIds(Arrays.asList(dynamicSqlIds));

        return R.ok();
    }

}
