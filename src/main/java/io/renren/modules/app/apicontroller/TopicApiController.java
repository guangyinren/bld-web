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

import io.renren.modules.app.entity.TopicEntity;
import io.renren.modules.app.service.TopicService;
import io.renren.common.base.AbstractController;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 话题
 *
 * @author lhc
 * @email 
 * @date 2018-06-26 23:52:37
 */
@RestController
@RequestMapping("api/topic")
public class TopicApiController extends AbstractController{
    @Autowired
    private TopicService topicService;

    @RequestMapping("/queryTopicBySchool")
    public R queryTopicBySchool(String schoolId){
    	if(StringUtils.isEmpty(schoolId)) {
    		return R.error("schoolId不能为空");
    	}
    	List<Map<String, Object>> list=topicService.queryTopicBySchool(schoolId);
        return R.ok().put("list", list);
    }
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:topic:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = topicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{topicId}")
    @RequiresPermissions("app:topic:info")
    public R info(@PathVariable("topicId") String topicId){
			TopicEntity topic = topicService.selectById(topicId);

        return R.ok().put("topic", topic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:topic:save")
    public R save(TopicEntity topic){
			topicService.insert(topic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:topic:update")
    public R update(TopicEntity topic){
			topicService.updateById(topic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:topic:delete")
    public R delete(String[] topicIds){
			topicService.deleteBatchIds(Arrays.asList(topicIds));

        return R.ok();
    }

}
