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

import io.renren.modules.app.entity.AccountLogEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.AccountLogService;
import io.renren.common.base.AbstractController;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;



/**
 * 账户流水
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 12:40:20
 */
@RestController
@RequestMapping("api/accountlog")
public class AccountLogApiController extends AbstractController{
    @Autowired
    private AccountLogService accountLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:accountlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{accountlogid}")
    @RequiresPermissions("app:accountlog:info")
    public R info(@PathVariable("accountlogid") String accountlogid){
			AccountLogEntity accountLog = accountLogService.selectById(accountlogid);

        return R.ok().put("accountLog", accountLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AccountLogEntity accountLog){
    	UserEntity user = getUser();
    	if(user==null) {
    		return R.error(10,"用户未登录");
    	}
		if (ValidateUtils.isContainEmpty(accountLog.getType(), accountLog.getSourcetype(),accountLog.getAmount())) {
			return R.error(1, "必传参数为空");
		}
		if("0".equals(accountLog.getType())||"2".equals(accountLog.getType())) {
			accountLog.setIsadd(1);
		}else if("1".equals(accountLog.getType())){
			accountLog.setIsadd(0);
		}
		accountLogService.insert(accountLog);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:accountlog:update")
    public R update(@RequestBody AccountLogEntity accountLog){
			accountLogService.updateById(accountLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:accountlog:delete")
    public R delete(@RequestBody String[] accountlogids){
			accountLogService.deleteBatchIds(Arrays.asList(accountlogids));

        return R.ok();
    }

}
