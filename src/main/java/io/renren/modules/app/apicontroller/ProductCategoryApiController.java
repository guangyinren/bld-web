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

import io.renren.modules.app.entity.ProductCategoryEntity;
import io.renren.modules.app.entity.StoreEntity;
import io.renren.modules.app.service.ProductCategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:50
 */
@RestController
@RequestMapping("api/productcategory")
public class ProductCategoryApiController {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 根据类型获取类目列表
     * @param type
     * @return
     */
    @RequestMapping("/list")
    public R list(String type){
    	if(StringUtils.isEmpty(type)) {
    		return R.error("type不能为空");
    	}
    	if ("0".equals(type)) {//便利店
			
		}else if("1".equals(type)){//二手商品
			
		}else if("2".equals(type)){//正品
			
		}else {
			return R.error("type类型错误");
		}
    	Wrapper<ProductCategoryEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("id,name,treePath");
    	wrapper.eq("type", type);
    	List<Map<String, Object>> list = productCategoryService.selectMaps(wrapper);
        return R.ok().put("list",list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:productcategory:info")
    public R info(@PathVariable("id") String id){
			ProductCategoryEntity productCategory = productCategoryService.selectById(id);

        return R.ok().put("productCategory", productCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:productcategory:save")
    public R save(@RequestBody ProductCategoryEntity productCategory){
			productCategoryService.insert(productCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:productcategory:update")
    public R update(@RequestBody ProductCategoryEntity productCategory){
			productCategoryService.updateById(productCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:productcategory:delete")
    public R delete(@RequestBody String[] ids){
			productCategoryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
