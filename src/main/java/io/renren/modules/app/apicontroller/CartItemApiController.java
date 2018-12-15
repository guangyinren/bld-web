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

import io.renren.modules.app.entity.CartItemEntity;
import io.renren.modules.app.service.CartItemService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:51
 */
@RestController
@RequestMapping("api/cartitem")
public class CartItemApiController {
    @Autowired
    private CartItemService cartItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:cartitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cartItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:cartitem:info")
    public R info(@PathVariable("id") String id){
			CartItemEntity cartItem = cartItemService.selectById(id);

        return R.ok().put("cartItem", cartItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:cartitem:save")
    public R save(@RequestBody CartItemEntity cartItem){
			cartItemService.insert(cartItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:cartitem:update")
    public R update(@RequestBody CartItemEntity cartItem){
			cartItemService.updateById(cartItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:cartitem:delete")
    public R delete(@RequestBody String[] ids){
			cartItemService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
