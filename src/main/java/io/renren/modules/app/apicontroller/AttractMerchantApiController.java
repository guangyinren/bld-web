package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.entity.AttractMerchantEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.AttractMerchantService;



/**
 * 招商合作
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 10:57:15
 */
@RestController
@RequestMapping("api/attractmerchant")
public class AttractMerchantApiController extends AbstractController{
    @Autowired
    private AttractMerchantService attractMerchantService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attractMerchantService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attractmerchantid}")
    public R info(@PathVariable("attractmerchantid") String attractmerchantid){
			AttractMerchantEntity attractMerchant = attractMerchantService.selectById(attractmerchantid);

        return R.ok().put("attractMerchant", attractMerchant);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(String phone){
    	if (ValidateUtils.isContainEmpty(phone)) {
			return R.error(1, "必传参数为空");
		}
    	AttractMerchantEntity attractMerchant=new AttractMerchantEntity();
    	UserEntity user = getUser();
    	if(user!=null) {
    		attractMerchant.setUserid(user.getUserId());
    	}
    	attractMerchant.setStatus("0");
    	attractMerchant.setInforminfo(phone);
    	attractMerchant.setCreatetime(new Date());
		attractMerchantService.insert(attractMerchant);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttractMerchantEntity attractMerchant){
			attractMerchantService.updateById(attractMerchant);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:attractmerchant:delete")
    public R delete(@RequestBody String[] attractmerchantids){
			attractMerchantService.deleteBatchIds(Arrays.asList(attractmerchantids));

        return R.ok();
    }

}
