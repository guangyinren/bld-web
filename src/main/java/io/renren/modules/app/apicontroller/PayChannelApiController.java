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

import io.renren.modules.app.entity.PayChannelEntity;
import io.renren.modules.app.service.PayChannelService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 支付渠道表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/paychannel")
public class PayChannelApiController {
    @Autowired
    private PayChannelService payChannelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:paychannel:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = payChannelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{payChannelId}")
    @RequiresPermissions("app:paychannel:info")
    public R info(@PathVariable("payChannelId") String payChannelId){
			PayChannelEntity payChannel = payChannelService.selectById(payChannelId);

        return R.ok().put("payChannel", payChannel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:paychannel:save")
    public R save(PayChannelEntity payChannel){
			payChannelService.insert(payChannel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:paychannel:update")
    public R update(PayChannelEntity payChannel){
			payChannelService.updateById(payChannel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:paychannel:delete")
    public R delete(String[] payChannelIds){
			payChannelService.deleteBatchIds(Arrays.asList(payChannelIds));

        return R.ok();
    }

}
