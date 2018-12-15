package io.renren.modules.app.apicontroller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.ProductEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.DynamicSqlService;
import io.renren.modules.app.service.ProductService;



/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:50
 */
@RestController
@RequestMapping("api/product")
public class ProductApiController extends AbstractController{
    @Autowired
    private ProductService productService;
    @Autowired
    private DynamicSqlService dynamicSqlService;

    /**
     * 指定类目下的商品列表
     * @param categoryId
     * @return
     */
    @RequestMapping("/cproductlist")
    public R cproductlist(String categoryId){
    	if(StringUtils.isEmpty(categoryId)) {
    		return R.error("categoryId不能为空");
    	}
    	
    	Wrapper<ProductEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("id,name,image,price,cost,unit,caption,introduction,memo,productImage,labels,parameterValue");
    	wrapper.eq("isMarketable", 1);
    	wrapper.eq("productCategoryId", categoryId);
    	List<Map<String, Object>> list = productService.selectMaps(wrapper);
        return R.ok().put("list",list);
    }
    
    /**
     * 限时购
     * @return
     */
    @RequestMapping("/limittime")
    public R limittime(){
    	Wrapper<ProductEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("id,name,image,price,cost,unit,caption,introduction,memo,productImage,labels,parameterValue");
    	wrapper.eq("isMarketable", 1);
    	wrapper.eq("config", 1);
    	List<Map<String, Object>> list = productService.selectMaps(wrapper);
        return R.ok().put("list",list);
    }
    /**
     * 猜你喜欢(实际上是热销)
     * @return
     */
    @RequestMapping("/hot")
    public R hot(String userId){
    	Wrapper<ProductEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("id,name,image,price,cost,unit,caption,introduction,memo,productImage,labels,parameterValue");
    	wrapper.eq("isMarketable", 1);
    	wrapper.eq("isHot", 1);
    	List<Map<String, Object>> list = productService.selectMaps(wrapper);
    	return R.ok().put("list",list);
    }


   /**
    *   详情
    * @param orderId
    * @return
    */
    @RequestMapping("/info")
    public R info(String productId){
    	if(StringUtils.isEmpty(productId)) {
    		return R.error("productId不能为空");
    	}
		ProductEntity product = productService.selectById(productId);
		if(product==null) {
			return R.error(1, "无此产品信息");
		}
        return R.ok().put("data", product);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:product:save")
    public R save(@RequestBody ProductEntity product){
			productService.insert(product);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:product:update")
    public R update(@RequestBody ProductEntity product){
			productService.updateById(product);

        return R.ok();
    }

    @RequestMapping("/delete")
	public R delete(String id) {
		UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		if (StringUtils.isEmpty(id)) {
			return R.error(1, "id不能为空");
		}
		ProductEntity entity = productService.selectById(id);
		if(entity==null) {
			return R.error(1, "此商品不存在");
		}
		if(!user.getUserId().equals(entity.getObjectid())) {
			return R.error(1, "无权删除此产品");
		}
		productService.deleteById(id);
		return R.ok();
	}

}
