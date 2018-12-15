package io.renren.modules.app.apicontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.entity.ForumEntity;
import io.renren.modules.app.entity.ForumUserEntity;
import io.renren.modules.app.entity.SpaceDynamicEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.ForumService;
import io.renren.modules.app.service.ForumUserService;
import io.renren.modules.app.service.SpaceDynamicService;
import io.renren.modules.app.service.UserService;



/**
 * 论坛/封地
 *
 * @author lhc
 * @email 
 * @date 2018-12-09 17:04:37
 */
@RestController
@RequestMapping("api/forum")
public class ForumApiController extends AbstractController{
    @Autowired
    private ForumService forumService;
    @Autowired
    private ForumUserService forumUserService;
    @Value("${uploadImgPath}")
	private String uploadImgPath;
    @Autowired
	private SpaceDynamicService spaceDynamicService;
    @Autowired
    private UserService userService;
    
    /**
     * 封地热门帖子
     * @param forumId
     * @return
     */
    @RequestMapping("/hotarticle")
	public R hotarticle(String forumId) {
    	if (StringUtils.isEmpty(forumId)) {
			return R.error(1, "必传参数为空");
		}
    	List<Map<String, Object>> listmap = spaceDynamicService.selectMaps(new EntityWrapper<SpaceDynamicEntity>().setSqlSelect("space_dynamic_id,user_id,sourceId,content,resources,praise,comment,publish_time,create_time").eq("type", 2).eq("sourceId", forumId).eq("is_hot", 1).orderBy("create_time", false));
    	for (int i = 0; i < listmap.size(); i++) {
    		Map<String, Object> map=listmap.get(i);
    		UserEntity user = userService.selectById(String.valueOf(map.get("user_id")));
    		map.put("userName", user.getUsername());
    		map.put("headPic", user.getHeadpicPath());
    		listmap.set(i, map);
		}
    	return R.ok().put("list", listmap);
    }
    /**
     * 详情
     * @param forumId
     * @return
     */
    @RequestMapping("/info")
	public R info(String forumId) {
    	if (StringUtils.isEmpty(forumId)) {
			return R.error(1, "必传参数为空");
		}
    	ForumEntity entity = forumService.selectById(forumId);
    	if (entity==null) {
    		return R.error(1, "此封地不存在");
		}
    	HashMap<String, Object> resultMap=new HashMap<>();
		resultMap.put("forumid", entity.getForumid());
		resultMap.put("name", entity.getName());
		resultMap.put("status", entity.getStatus());
		resultMap.put("showpic", entity.getShowpic());
		resultMap.put("intro", entity.getIntro());
		resultMap.put("labels", entity.getLabels());
		resultMap.put("organizationname", entity.getOrganizationname());
		resultMap.put("areaname", entity.getAreaname());
		resultMap.put("memnernum", entity.getMemnernum());
		resultMap.put("cityname", entity.getCityname());
		resultMap.put("locationxy", entity.getLocationxy());
    	return R.ok().put("data", resultMap);
    }
    
    /**
     *  申请加入封地
     * @param forumId
     * @return
     */
    @RequestMapping("/apply")
	public R apply(String forumId) {
    	UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
    	if (StringUtils.isEmpty(forumId)) {
			return R.error(1, "必传参数为空");
		}
    	ForumEntity entity = forumService.selectById(forumId);
    	if (entity==null) {
    		return R.error(1, "此封地不存在");
		}
    	if (!"2".equals(entity.getStatus())) {
    		return R.error(1, "此封地暂时不能加入");
		}
    	ForumUserEntity fu = forumUserService.selectOne(new EntityWrapper<ForumUserEntity>().eq("userId", user.getUserId()).eq("forumId", forumId));
    	if(fu!=null) {
    		if ("0".equals(fu.getStatus())) {
    			return R.error(1, "用户已经申请过此封地");
			} else if("1".equals(fu.getStatus())){
				return R.error(1, "用户已经加入此封地");
			}else {
				return R.error(1, "申请状态有误");
			}
    	}
    	ForumUserEntity fue =new ForumUserEntity();
    	fue.setUserid(user.getUserId());
    	fue.setUsername(user.getUsername());
    	fue.setHeadpic(user.getHeadpicPath());
    	fue.setForumid(forumId);
    	fue.setStatus("0");
    	forumUserService.insert(fue);
    	return R.ok();
    }
    
    /**
     *   申请加入封地的列表
     * @param forumId
     * @return
     */
    @RequestMapping("/applylist")
	public R applylist(String forumId) {
    	UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
    	if (!StringUtils.isEmpty(forumId)) {
    		ForumEntity entity = forumService.selectById(forumId);
        	if (entity==null) {
        		return R.error(1, "此封地不存在");
    		}
        	if(!user.getUserId().equals(entity.getUserid())) {
        		return R.error(1, "没有权限操作");
        	}
        	List<Map<String, Object>> listmap = forumUserService.selectMaps(new EntityWrapper<ForumUserEntity>().setSqlSelect("forumUserId,userId,userName,headPic,forumId").eq("forumId", forumId));
			return R.ok().put("list", listmap);
		}
    	List<Object> forumIds = forumService.selectObjs(new EntityWrapper<ForumEntity>().setSqlSelect("forumId").eq("userId", user.getUserId()).eq("status", 2));
    	if(forumIds!=null&&forumIds.size()>0) {
    		List<Map<String, Object>> listmap = forumUserService.selectMaps(new EntityWrapper<ForumUserEntity>().setSqlSelect("forumUserId,userId,userName,headPic,forumId").in("forumId", forumIds));
    		return R.ok().put("list", listmap);
    	}
    	return R.ok();
    }
    
    /**
     *  审核通过不通过加入封地申请
     * @param forumUserId
     * @param isPass
     * @return
     */
    @RequestMapping("/applypass")
	public R applypass(String forumUserId,String isPass) {
    	UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		if (ValidateUtils.isContainEmpty(forumUserId, isPass)) {
			return R.error(1, "必传参数为空");
		}
		ForumUserEntity forumUser=forumUserService.selectById(forumUserId);
		if (forumUser == null) {
			return R.error(1, "此记录不存在");
		}
		if (!"0".equals(forumUser.getStatus())) {
			return R.error(1, "此记录已审批");
		}
		ForumEntity entity = forumService.selectById(forumUser.getForumid());
    	if (entity==null) {
    		return R.error(1, "此封地不存在");
		}
    	if(!user.getUserId().equals(entity.getUserid())) {
    		return R.error(1, "没有权限操作");
    	}
		if("0".equals(isPass)) {
			forumUser.setStatus("2");
		}else if("1".equals(isPass)) {
			forumUser.setStatus("1");
		}
		forumUserService.updateById(forumUser);
    	return R.ok();
    }
    

    /**
     * 创建封地
     * @param entity
     * @param file
     * @return
     */
    @RequestMapping("/save")
    public R save(ForumEntity entity,@RequestParam("file") MultipartFile file){
    	UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		if(ValidateUtils.isContainEmpty(entity.getLabels(),entity.getName())) {
    		return R.error(1,"必传参数为空");
    	}
		String uploadFile = uploadFile(file,uploadImgPath);
		entity.setUserid(user.getUserId());
		entity.setShowpic(uploadFile);
		entity.setStatus("1");//待审核
		forumService.insert(entity);
        return R.ok();
    }
    
    /*
     *  我的封地列表
     */
    @RequestMapping("/mylist")
	public R mylist() {
    	UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
    	List<Map<String, Object>> listmap = forumService.selectMaps(new EntityWrapper<ForumEntity>().setSqlSelect("forumId,name,showPic").eq("userId", user.getUserId()));
    	return R.ok().put("list", listmap);
    }
    
    /**
     * 附件封地
     * @param cityName
     * @return
     */
    @RequestMapping("/nearlist")
	public R nearlist(String cityName) {
    	if (StringUtils.isEmpty(cityName)) {
			return R.error(1, "必传参数为空");
		}
    	List<Map<String, Object>> listmap = forumService.selectMaps(new EntityWrapper<ForumEntity>().setSqlSelect("forumId,name,showPic").eq("cityName", cityName));
    	return R.ok().put("list", listmap);
    }
    
    /**
     *   封地成员列表
     * @return
     */
    @RequestMapping("/memberlist")
    public R memberlist(String forumId) {
    	UserEntity user = getUser();
    	if (user == null) {
    		return R.error(10, "用户未登录");
    	}
    	if (StringUtils.isEmpty(forumId)) {
			return R.error(1, "必传参数为空");
		}
    	ForumEntity forum = forumService.selectById(forumId);
		if (forum == null) {
			return R.error(10, "此封地不存在");
		}
		
    	List<Map<String, Object>> listmap = forumUserService.selectMaps(new EntityWrapper<ForumUserEntity>().setSqlSelect("userId,userName,headPic").eq("forumId", forumId));
    	return R.ok().put("list", listmap);
    }
    
}
