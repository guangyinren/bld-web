package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import io.renren.modules.app.entity.EvaluateEntity;
import io.renren.modules.app.entity.OrderItemEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.EvaluateService;
import io.renren.modules.app.service.OrderItemService;
import io.renren.common.base.AbstractController;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;



/**
 * 商品评价
 *
 * @author lhc
 * @email 
 * @date 2018-12-11 17:19:28
 */
@RestController
@RequestMapping("api/evaluate")
public class EvaluateApiController extends AbstractController{
    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private OrderItemService orderItemService;
    @Value("${uploadImgPath}")
	private String uploadImgPath;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:evaluate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = evaluateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{evaluateid}")
    @RequiresPermissions("app:evaluate:info")
    public R info(@PathVariable("evaluateid") String evaluateid){
			EvaluateEntity evaluate = evaluateService.selectById(evaluateid);

        return R.ok().put("evaluate", evaluate);
    }

    
    @RequestMapping("/save")
    public R save(EvaluateEntity evaluate,@RequestParam("files") MultipartFile[] files){
    	UserEntity user = getUser();
    	if(user==null) {
    		return R.error(10,"用户未登录");
    	}
    	if (ValidateUtils.isContainEmpty(evaluate.getOrderitemid(), evaluate.getContent())) {
			return R.error(1, "必传参数为空");
		}
    	//处理图片
    	JSONArray imgsJson = new JSONArray();
    	for(MultipartFile file:files) {
    		imgsJson.add(uploadFile(file,uploadImgPath));
    	}
    	evaluate.setResources(imgsJson.toJSONString());
    	OrderItemEntity item = orderItemService.selectById(evaluate.getOrderitemid());
    	evaluate.setUserid(user.getUserId());
    	evaluate.setProductid(String.valueOf(item.getProductid()));
    	evaluate.setOrderid(String.valueOf(item.getOrderid()));
    	evaluate.setPublishtime(new Date());
    	evaluate.setCreatetime(new Date());
    	evaluateService.insert(evaluate);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:evaluate:update")
    public R update(@RequestBody EvaluateEntity evaluate){
			evaluateService.updateById(evaluate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:evaluate:delete")
    public R delete(@RequestBody String[] evaluateids){
			evaluateService.deleteBatchIds(Arrays.asList(evaluateids));

        return R.ok();
    }

}
