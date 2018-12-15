package io.renren.modules.app.apicontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

import com.alibaba.fastjson.JSONObject;

import io.renren.modules.app.entity.InformEntity;
import io.renren.modules.app.service.CommentService;
import io.renren.modules.app.service.InformService;
import io.renren.modules.app.service.SpaceDynamicService;
import io.renren.common.base.AbstractController;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 通知
 *
 * @author lhc
 * @email 
 * @date 2018-07-08 18:51:20
 */
@RestController
@RequestMapping("api/inform")
public class InformApiController extends AbstractController{
    @Autowired
    private InformService informService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private SpaceDynamicService spaceDynamicService;

    @RequestMapping("/queryMyInform")
    public R queryMyInform(){
    	String userId=getUser().getUserId();
    	if(StringUtils.isEmpty(userId)) {
    		return R.error("userId不能为空");
    	}
    	List<Map<String, Object>> informList=informService.queryMyInform(userId);
    	List<Map<String, Object>> list=new ArrayList<>();
    	for(Map<String, Object> informMap:informList) {
    		Map<String, Object> dataMap=new HashMap<>();
    		String informType=(String) informMap.get("type");
    		String sourceUser=(String) informMap.get("source_user");
    		String sourceId=(String) informMap.get("source_id");
    		//根据不同类型获取不同的数据
    		if("0".equals(informType)) {
    			//点赞
    			dataMap=spaceDynamicService.queryInformPraiseDetail(sourceUser,sourceId);
    			dataMap.put("praise", JSONObject.parseObject((String)dataMap.get("praise")).getIntValue("total"));
    		}else if("1".equals(informType)) {
    			//关于动态评论
    			dataMap=commentService.queryInformCommonDetail(sourceUser,sourceId);
    			
    		}
    	}
        return R.ok().put("list", list);
    }
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:inform:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = informService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{informId}")
    @RequiresPermissions("app:inform:info")
    public R info(@PathVariable("informId") String informId){
			InformEntity inform = informService.selectById(informId);

        return R.ok().put("inform", inform);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:inform:save")
    public R save(InformEntity inform){
			informService.insert(inform);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:inform:update")
    public R update(InformEntity inform){
			informService.updateById(inform);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:inform:delete")
    public R delete(String[] informIds){
			informService.deleteBatchIds(Arrays.asList(informIds));
        return R.ok();
    }

}
