package io.renren.modules.app.apicontroller;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.LogUtil;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.entity.CommentEntity;
import io.renren.modules.app.entity.SpaceDynamicEntity;
import io.renren.modules.app.form.CommentForm;
import io.renren.modules.app.service.CommentService;
import io.renren.modules.app.service.SpaceDynamicService;



/**
 * 评论
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/comment")
public class CommentApiController extends AbstractController{
    @Autowired
    private CommentService commentService;
    @Autowired
    private SpaceDynamicService spaceDynamicService;
    
   /**
    * 添加一条评论
    * @param comment
    * @return
 * @throws InvocationTargetException 
 * @throws IllegalAccessException 
    */
    @RequestMapping("/save")
    public R save(CommentForm comment) throws IllegalAccessException, InvocationTargetException{
    	LogUtil.logBefore("添加评论", "请求数据:{}", JSON.toJSONString(comment));
		ValidatorUtils.validateEntity(comment);
		CommentEntity entity=new CommentEntity();
		BeanUtils.copyProperties(entity, comment);
		if(StringUtils.isEmpty(comment.getReplyId())) {
			entity.setProp1(comment.getUserId());
		}else {
			CommentEntity replyComment = commentService.selectById(comment.getReplyId());
			entity.setProp1(replyComment.getUserId());
			if(StringUtils.isEmpty(replyComment.getReplyId())) {
				entity.setConfig(replyComment.getCommentId());
			}else {
				entity.setConfig(replyComment.getConfig());
			}
		}
		entity.setPublishTime(new Date());
		entity.setCreateTime(new Date());
    	commentService.insert(entity);
    	SpaceDynamicEntity spaceDynamicEntity = spaceDynamicService.selectById(comment.getSourceId());
    	if(spaceDynamicEntity.getComment()==null) {
    		spaceDynamicEntity.setComment(1);
    	}else {
    		spaceDynamicEntity.setComment(1+spaceDynamicEntity.getComment());
    	}
    	//TODO 添加用户提醒
    	
        return R.ok();
    }
    
    
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:comment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{commentId}")
    @RequiresPermissions("app:comment:info")
    public R info(@PathVariable("commentId") String commentId){
			CommentEntity comment = commentService.selectById(commentId);

        return R.ok().put("comment", comment);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:comment:update")
    public R update(CommentEntity comment){
			commentService.updateById(comment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:comment:delete")
    public R delete(String[] commentIds){
			commentService.deleteBatchIds(Arrays.asList(commentIds));

        return R.ok();
    }

}
