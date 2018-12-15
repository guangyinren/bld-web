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

import io.renren.modules.app.entity.CartEntity;
import io.renren.modules.app.service.CartService;
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
@RequestMapping("api/cart")
public class CartApiController {
    @Autowired
    private CartService cartService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:cart:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cartService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:cart:info")
    public R info(@PathVariable("id") String id){
			CartEntity cart = cartService.selectById(id);

        return R.ok().put("cart", cart);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:cart:save")
    public R save(@RequestBody CartEntity cart){
			cartService.insert(cart);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:cart:update")
    public R update(@RequestBody CartEntity cart){
			cartService.updateById(cart);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:cart:delete")
    public R delete(@RequestBody String[] ids){
			cartService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
