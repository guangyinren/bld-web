package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.StoreEntity;
import io.renren.modules.app.entity.StoreMemberEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.DynamicSqlService;
import io.renren.modules.app.service.StoreMemberService;
import io.renren.modules.app.service.StoreService;



/**
 * 店铺
 *
 * @author lhc
 * @email 
 * @date 2018-12-06 22:36:31
 */
@RestController
@RequestMapping("api/store")
public class StoreApiController extends AbstractController{
    @Autowired
    private StoreService storeService;
    @Autowired
    private DynamicSqlService dynamicSqlService;
    @Autowired
    private StoreMemberService storeMemberService;
    
    /**
     * 我加入的便利店
     * @param userId
     * @return
     */
    @RequestMapping("/mylist")
    public R mylist(){
    	UserEntity user = getUser();
    	if(user==null) {
    		return R.error(10,"用户未登录");
    	}
    	//获取我加入的店铺id
    	Wrapper<StoreMemberEntity> memberwrapper = new EntityWrapper<>();
    	memberwrapper.setSqlSelect("storeId");
    	memberwrapper.eq("userId", user.getUserId());
    	List<Object> storeIds = storeMemberService.selectObjs(memberwrapper);
    	
    	Wrapper<StoreEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("storeId,name,showPic");
    	wrapper.eq("status", 1);
    	wrapper.in("storeId", storeIds);
    	List<Map<String, Object>> list = storeService.selectMaps(wrapper);
        return R.ok().put("list",list);
    }
    
    /**
     * 附近便利店
     * @param cityName
     * @return
     */
    @RequestMapping("/nearlist")
    public R list(String cityName){
    	if(StringUtils.isEmpty(cityName)) {
    		return R.error("cityName不能为空");
    	}
    	Wrapper<StoreEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("storeId,name,showPic");
    	wrapper.eq("status", 1).eq("cityName", cityName);
    	List<Map<String, Object>> list = storeService.selectMaps(wrapper);
        return R.ok().put("list",list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storeService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 便利店详情
     * @param storeid
     * @return
     */
    @RequestMapping("/info")
    public R info(String storeid){
		StoreEntity store = storeService.selectById(storeid);
        return R.ok().put("storeId", store.getStoreid()).put("name", store.getName()).put("showPic", store.getShowpic());
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StoreEntity store){
			storeService.insert(store);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StoreEntity store){
			storeService.updateById(store);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:store:delete")
    public R delete(@RequestBody String[] storeids){
			storeService.deleteBatchIds(Arrays.asList(storeids));

        return R.ok();
    }

}
