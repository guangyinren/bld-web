package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.entity.ForumEntity;
import io.renren.modules.app.entity.NoticeEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.ForumService;
import io.renren.modules.app.service.NoticeService;



/**
 * 通知
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/notice")
public class NoticeApiController extends AbstractController{
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ForumService forumService;

    /**
     *    获取封地公告列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public R list(String forumId){
    	if (StringUtils.isEmpty(forumId)) {
			return R.error(1, "必传参数为空");
		}
    	ForumEntity forum = forumService.selectById(forumId);
		if (forum == null) {
			return R.error(10, "此封地不存在");
		}
		List<Map<String, Object>> listmap = noticeService.selectMaps(new EntityWrapper<NoticeEntity>().setSqlSelect("noticeId,title,content,sendTime").eq("objectType", 1).eq("objectId", forumId).eq("status",0).orderBy("createTime", false));
        return R.ok().put("list", listmap);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{noticeId}")
    @RequiresPermissions("app:notice:info")
    public R info(@PathVariable("noticeId") String noticeId){
			NoticeEntity notice = noticeService.selectById(noticeId);

        return R.ok().put("notice", notice);
    }

   /**
    *    发布公告(目前默认为封地的公告)
    * @param notice
    * @return
    */
    @RequestMapping("/save")
    public R save(NoticeEntity notice){
    	UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		if (ValidateUtils.isContainEmpty(notice.getTitle(), notice.getContent(),notice.getObjectid())) {
			return R.error(1, "必传参数为空");
		}
		ForumEntity forum = forumService.selectById(notice.getObjectid());
		if (forum == null) {
			return R.error(10, "此封地不存在");
		}
		if(!user.getUserId().equals(forum.getUserid())) {
			return R.error(1, "没有权限操作");
		}
		notice.setObjectid("1");//封地/论坛
		notice.setUserid(user.getUserId());
		notice.setType("0");
		notice.setStatus("0");
    	notice.setCreatetime(new Date());
    	notice.setSendtime(new Date());
		noticeService.insert(notice);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:notice:update")
    public R update(NoticeEntity notice){
			noticeService.updateById(notice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:notice:delete")
    public R delete(String[] noticeIds){
			noticeService.deleteBatchIds(Arrays.asList(noticeIds));

        return R.ok();
    }

}
