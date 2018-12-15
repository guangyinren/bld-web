package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.MapUtils;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.AttentionEntity;
import io.renren.modules.app.service.AttentionService;



/**
 * 关注表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/attention")
public class AttentionApiController extends AbstractController{
    @Autowired
    private AttentionService attentionService;
    
    /**
     * 关注或取消关注(目前没有公众号之说)
     * @param id 用户或公众号id
     * @param type 类型 0:用户,1:公众号,2:空间动态
     * @param isAttention 0:取消关注 1:关注
     * @return
     */
    @RequestMapping("/attention")
    public R attention(String id,int type,int isAttention,String userId){
    	userId = (userId == null ? getUser().getUserId() : userId);
    	MapUtils params=new MapUtils();
    	params.put("type", type);
    	params.put("source_id", id);
    	params.put("user_id", userId);

        if(isAttention==0) {
            List<AttentionEntity> results = attentionService.selectByMap(params);
            if(results==null||results.size()==0){
                return R.error(1,"不存在符合要求的记录");
            }else{
                attentionService.deleteById(results.get(0).getAttentionId());
            }
        }else if(isAttention==1){
            AttentionEntity entity = new AttentionEntity();
            entity.setUserId(userId);
            entity.setType(String.valueOf(type));
            entity.setSourceId(id);
            entity.setCreateTime(new Date());
            attentionService.insert(entity);
        }else{
            return R.error(1,"参数有误");
        }
        return R.ok();
    }
    
    /**
     * 根据类型获取关注的信息
     * @param type 0:用户,1:公众号,2:话题,3:动态
     * @return
     */
    @RequestMapping("/queryMyAttention")
    public R queryMyAttention(String type,String userId){
    	userId = (userId == null ? getUser().getUserId() : userId);
    	List<Map<String, Object>> list=null;
        if("0".equals(type)) {
        	//用户信息
        	list=attentionService.queryAttentionUser(userId);
        }else if("1".equals(type)) {
        	//公众号信息
        	list=attentionService.queryAttentionPublicAccount(userId);
        }else if("2".equals(type)) {
        	//话题信息
        	list=attentionService.queryAttentionTopic(userId);
        }else if("3".equals(type)) {
        	//动态信息
        	list=attentionService.queryAttentionDynamic(userId);
        }
        
        return R.ok().put("list", list);
    }
    
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:attention:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attentionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attentionId}")
    @RequiresPermissions("app:attention:info")
    public R info(@PathVariable("attentionId") String attentionId){
			AttentionEntity attention = attentionService.selectById(attentionId);

        return R.ok().put("attention", attention);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:attention:save")
    public R save(AttentionEntity attention){
			attentionService.insert(attention);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:attention:update")
    public R update(AttentionEntity attention){
			attentionService.updateById(attention);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:attention:delete")
    public R delete(String[] attentionIds){
			attentionService.deleteBatchIds(Arrays.asList(attentionIds));

        return R.ok();
    }

}
