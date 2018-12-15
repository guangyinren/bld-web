package io.renren.modules.app.apicontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.LogUtil;
import io.renren.common.utils.MapUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.entity.AttentionEntity;
import io.renren.modules.app.entity.CommentEntity;
import io.renren.modules.app.entity.RelationUserEntity;
import io.renren.modules.app.entity.SpaceDynamicEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.AttentionService;
import io.renren.modules.app.service.CommentService;
import io.renren.modules.app.service.RelationUserService;
import io.renren.modules.app.service.SpaceDynamicService;
import io.renren.modules.app.service.UserService;

/**
 * 空间动态
 *
 * @author lhc
 * @email
 * @date 2018-06-06 23:21:07
 */
@RestController
@RequestMapping("api/spacedynamic")
public class SpaceDynamicApiController extends AbstractController {
	@Autowired
	private SpaceDynamicService spaceDynamicService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	@Autowired
	private RelationUserService relationUserService;
	@Autowired
	private AttentionService attentionService;
	@Value("${uploadImgPath}")
	private String uploadImgPath;
	
	/**
	 * 查看朋友圈(朋友圈的动态)
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/queryFriendDynamic")
	public R queryFriendDynamic(String userId) {
		/*
		 * 获取朋友列表 除去黑名单的朋友 获取朋友和自己的动态 除去已屏蔽的动态
		 * 
		 */
		userId = (userId == null ? getUser().getUserId() : userId);
		if (StringUtils.isEmpty(userId)) {
			return R.error("userId不能为空");
		}
		Set<Map<String, Object>> list = spaceDynamicService.queryFriendDynamic(userId);
		Set<Map<String, Object>> list2 = spaceDynamicService.queryAttentionAccountDynamic(userId);
		if (list2.size() > 0) {
			list.addAll(list2);
		}
		for (Map<String, Object> map : list) {
			// 处理点赞
			JSONObject praiseObject = null;
			if (!StringUtils.isEmpty(map.get("praise"))) {
				praiseObject = JSONObject.parseObject((String) map.get("praise"));
				map.put("praise", praiseObject.getIntValue("total"));
			} else {
				map.put("praise", 0);
			}
			if (StringUtils.isEmpty(map.get("nickname"))) {
				map.put("name", map.get("username"));
			} else {
				map.put("name", map.get("nickname"));
			}
			if (userId.equals(map.get("user_id"))) {
				map.put("isSelf", 1);
			} else {
				map.put("isSelf", 0);
			}
		}
		List<Map<String, Object>> listArr = new ArrayList<Map<String, Object>>(list);
		Collections.sort(listArr, new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				Date d1 = (Date) o1.get("create_time");
				Date d2 = (Date) o2.get("create_time");
				return d2.compareTo(d1);
			}
		});
		return R.ok().put("list", listArr);
	}

	/**
	 * 我关注的公账号的动态
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/queryAttentionAccountDynamic")
	public R queryAttentionAccountDynamic(String userId) {
		userId = (userId == null ? getUser().getUserId() : userId);
		if (StringUtils.isEmpty(userId)) {
			return R.error(1, "userId不能为空");
		}
		Set<Map<String, Object>> list = spaceDynamicService.queryAttentionAccountDynamic(userId);
		return R.ok().put("list", list);
	}

	/**
	 * 查看单个用户的动态(要提前登录)
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/queryMySpaceDynamic")
	public R queryMySpaceDynamic(String userId,String type) {
		if (StringUtils.isEmpty(userId)) {
			return R.error(1, "userId不能为空");
		}
		if(StringUtils.isEmpty(type)) {
			type="0";
		}
		MapUtils resultMap = new MapUtils();
		List<MapUtils> spaceDynamicList = new ArrayList<>();
		MapUtils userMap = new MapUtils();
		resultMap.put("user", userMap);
		resultMap.put("spaceDynamicList", spaceDynamicList);

		UserEntity user = userService.selectById(userId);
		if (user == null) {
			return R.error(1, "不存在此用户");
		}

		userMap.put("user_id", user.getUserId());
		userMap.put("headpic_path", user.getHeadpicPath());
		userMap.put("viplevel", user.getViplevel());
		userMap.put("name", user.getNickname() == null ? user.getUsername() : user.getNickname());

		// 是否是好友,是否是否已关注
		UserEntity loginUser = getUser();
		if (loginUser != null && loginUser.getUserId() != userId) {
			RelationUserEntity relationUserEntity = relationUserService
					.selectOne(new EntityWrapper<RelationUserEntity>().eq("user_id", loginUser.getUserId())
							.eq("relation_user", userId));
			if (relationUserEntity == null) {
				userMap.put("is_relation", 0);
			} else {
				userMap.put("is_relation", 1);
			}
			AttentionEntity attentionEntity = attentionService.selectOne(
					new EntityWrapper<AttentionEntity>().eq("user_id", loginUser.getUserId()).eq("source_id", userId));
			if (attentionEntity == null) {
				userMap.put("is_attention", 0);
			} else {
				userMap.put("is_attention", 1);
			}
		}

		SpaceDynamicEntity entity = new SpaceDynamicEntity();
		entity.setUserId(userId);
		List<SpaceDynamicEntity> list = spaceDynamicService
				.selectList(new EntityWrapper<SpaceDynamicEntity>(entity).eq("type", type).orderBy("create_time", false));
		if (list.size() == 0) {
			return R.ok(resultMap);
		}
		for (SpaceDynamicEntity spaceDynamic : list) {
			MapUtils spaceDynamicMap = new MapUtils();
			spaceDynamicList.add(spaceDynamicMap);
			spaceDynamicMap.put("space_dynamic_id", spaceDynamic.getSpaceDynamicId());
			spaceDynamicMap.put("publish_time", spaceDynamic.getPublishTime());
			spaceDynamicMap.put("content", spaceDynamic.getContent());
			spaceDynamicMap.put("comment", spaceDynamic.getComment());
			spaceDynamicMap.put("location", spaceDynamic.getLocation());
			spaceDynamicMap.put("resources", spaceDynamic.getResources());
			spaceDynamicMap.put("share", spaceDynamic.getShare());
			// 处理点赞
			JSONObject praiseObject = null;
			if (!StringUtils.isEmpty(spaceDynamic.getPraise())) {
				praiseObject = JSONObject.parseObject(spaceDynamic.getPraise());
				spaceDynamicMap.put("praise", praiseObject.getIntValue("total"));
			} else {
				spaceDynamicMap.put("praise", 0);
			}

			if (userId.equals(loginUser.getUserId())) {
				spaceDynamicMap.put("isSelf", 1);
			} else {
				spaceDynamicMap.put("isSelf", 0);
			}
		}
		return R.ok(resultMap);
	}

	/**
	 * 
	 * @param userId
	 * @param dynamicId
	 * @param ispraise  1:点赞,0:取消赞
	 * @return
	 */
	@RequestMapping("/praise")
	public R praise(String userId, String dynamicId, Integer isPraise) {
		userId = (userId == null ? getUser().getUserId() : userId);
		SpaceDynamicEntity entity = spaceDynamicService.selectById(dynamicId);
		JSONObject praiseObject = null;
		if (StringUtils.isEmpty(entity.getPraise())) {
			praiseObject = new JSONObject();
			praiseObject.put("total", 0);
			praiseObject.put("info", new JSONArray());
		} else {
			praiseObject = JSONObject.parseObject(entity.getPraise());
		}
		int total = praiseObject.getIntValue("total");
		JSONArray info = praiseObject.getJSONArray("info");
		// 是否点过赞
		boolean isUserPraise = false;
		int index = -1;
		for (int i = 0; i < info.size(); i++) {
			if (((JSONObject) info.get(i)).getString("userId") == userId) {
				isUserPraise = true;
				index = i;
			}
		}
		if (isPraise == 1 && isUserPraise == false) {
			// 点赞
			JSONObject operObject = new JSONObject();
			operObject.put("userId", userId);
			operObject.put("time", new Date());
			info.add(operObject);
			total += 1;
			praiseObject.put("total", total);
			praiseObject.put("info", info);
			entity.setPraise(praiseObject.toJSONString());
			entity.setModifyTime(new Date());
			spaceDynamicService.insertOrUpdate(entity);
		} else if (isPraise == 0 && isUserPraise == true) {
			// 取消点赞
			info.remove(index);
			total -= 1;
			praiseObject.put("total", total);
			praiseObject.put("info", info);
			entity.setPraise(praiseObject.toJSONString());
			entity.setModifyTime(new Date());
			spaceDynamicService.insertOrUpdate(entity);
		}
		return R.ok();
	}

	/**
	 * 转发
	 * 
	 * @param userId
	 * @param dynamicId
	 * @return
	 */
	@RequestMapping("/transmit")
	public R transmit(String userId, String dynamicId) {
		userId = (userId == null ? getUser().getUserId() : userId);
		SpaceDynamicEntity entity = spaceDynamicService.selectById(dynamicId);
		int num = Integer.valueOf(entity.getShare()) + 1;
		entity.setShare(String.valueOf(num));
		entity.setModifyTime(new Date());
		spaceDynamicService.insertOrUpdate(entity);
		// 转发
		entity = new SpaceDynamicEntity();
		entity.setUserId(userId);
		entity.setCreateTime(new Date());
		entity.setIsLink(1);
		entity.setLinkid(dynamicId);
		spaceDynamicService.insertOrUpdate(entity);
		return R.ok();
	}

	/**
	 * 分享
	 * 
	 * @param dynamicId
	 * @return
	 */
	@RequestMapping("/share")
	public R share(String dynamicId) {
		SpaceDynamicEntity entity = spaceDynamicService.selectById(dynamicId);
		int num = Integer.valueOf(entity.getShare()) + 1;
		entity.setShare(String.valueOf(num));
		spaceDynamicService.insertOrUpdate(entity);
		return R.ok();
	}

	/**
	 * 发布一条动态
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping("/addSpaceDynamic")
	public R addSpaceDynamic(@RequestBody SpaceDynamicEntity spaceDynamic, @RequestParam("files") MultipartFile[] files)
			throws IllegalStateException, IOException {
		LogUtil.logBefore("发布动态", "请求参数:{}", JSON.toJSON(spaceDynamic));
		
		UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		if (ValidateUtils.isContainEmpty(spaceDynamic.getType(), spaceDynamic.getContent())) {
			return R.error(1, "必传参数为空");
		}
		if("2".equals(spaceDynamic.getType())) {//论坛帖子
			if (StringUtils.isEmpty(spaceDynamic.getSourceid())) {
				return R.error(1, "封地id不能为空");
			}
		}
		
		// 处理图片
		if (files.length>=0) {
			spaceDynamic.setResources(null);
		} else {
			// 处理图片
			JSONArray imgsJson = new JSONArray();
			for (MultipartFile file : files) {
				imgsJson.add(uploadFile(file, uploadImgPath));
			} 
			// 设置图片
			spaceDynamic.setResources(imgsJson.toJSONString());

		}
		spaceDynamic.setUserId(user.getUserId());
		spaceDynamic.setPublishTime(new Date());
		spaceDynamic.setCreateTime(new Date());
		spaceDynamicService.insert(spaceDynamic);
		return R.ok();
	}


	/**
	 * 获取动态详情
	 */
	@RequestMapping("/info")
	public R info(String spaceDynamicId) {
		SpaceDynamicEntity spaceDynamic = spaceDynamicService.selectById(spaceDynamicId);
		if (spaceDynamic == null) {
			return R.error(1, "动态不存在");
		}
		UserEntity user = userService.selectById(spaceDynamic.getUserId());

		MapUtils resultMap = new MapUtils();
		MapUtils spaceDynamicMap = new MapUtils();
		List<MapUtils> commentList = new ArrayList<>();

		spaceDynamicMap.put("user_id", user.getUserId());
		spaceDynamicMap.put("headpic_path", user.getHeadpicPath());
		spaceDynamicMap.put("viplevel", user.getViplevel());
		spaceDynamicMap.put("name", user.getNickname() == null ? user.getUsername() : user.getNickname());
		spaceDynamicMap.put("space_dynamic_id", spaceDynamic.getSpaceDynamicId());
		spaceDynamicMap.put("publish_time", spaceDynamic.getPublishTime());
		spaceDynamicMap.put("content", spaceDynamic.getContent());
		spaceDynamicMap.put("location", spaceDynamic.getLocation());
		spaceDynamicMap.put("comment", spaceDynamic.getComment());
		spaceDynamicMap.put("location", spaceDynamic.getLocation());
		spaceDynamicMap.put("resources", spaceDynamic.getResources());
		spaceDynamicMap.put("share", spaceDynamic.getShare());
		// 处理点赞
		JSONObject praiseObject = null;
		if (!StringUtils.isEmpty(spaceDynamic.getPraise())) {
			praiseObject = JSONObject.parseObject(spaceDynamic.getPraise());
			spaceDynamicMap.put("praise", praiseObject.getIntValue("total"));
		} else {
			spaceDynamicMap.put("praise", 0);
		}

		// 获取评论详情
		List<CommentEntity> rootCommentList = commentService
				.selectList(new EntityWrapper<CommentEntity>().eq("source_id", spaceDynamicId).isNull("config"));
		for (CommentEntity rootComment : rootCommentList) {
			MapUtils rootCommentMap = new MapUtils();
			commentList.add(rootCommentMap);
			UserEntity commentUser = null;
			UserEntity replyCommentUser = null;
			if (rootComment.getUserId().equals(user.getUserId())) {
				commentUser = user;
			} else {
				commentUser = userService.selectById(rootComment.getUserId());
			}
			if (rootComment.getProp1().equals(user.getUserId())) {
				replyCommentUser = user;
			} else {
				replyCommentUser = userService.selectById(rootComment.getProp1());
			}
			rootCommentMap.put("user_id", commentUser.getUserId());
			rootCommentMap.put("headpic_path", commentUser.getHeadpicPath());
			rootCommentMap.put("viplevel", commentUser.getViplevel());
			rootCommentMap.put("name",
					commentUser.getNickname() == null ? commentUser.getUsername() : commentUser.getNickname());

			rootCommentMap.put("reply_user_id", replyCommentUser.getUserId());
			rootCommentMap.put("reply_headpic_path", replyCommentUser.getHeadpicPath());
			rootCommentMap.put("reply_viplevel", replyCommentUser.getViplevel());
			rootCommentMap.put("reply_name", replyCommentUser.getNickname() == null ? replyCommentUser.getUsername()
					: replyCommentUser.getNickname());

			rootCommentMap.put("content", rootComment.getContent());
			rootCommentMap.put("comment_id", rootComment.getCommentId());
			rootCommentMap.put("publish_time", rootComment.getPublishTime());
			rootCommentMap.put("resources", rootComment.getResources());
			List<MapUtils> sonCommentResultList = new ArrayList<>();
			rootCommentMap.put("sonCommentList", sonCommentResultList);

			List<CommentEntity> sonCommentList = commentService.selectList(new EntityWrapper<CommentEntity>()
					.eq("source_id", spaceDynamicId).eq("config", rootComment.getCommentId()).orderBy("publish_time"));
			for (CommentEntity sonComment : sonCommentList) {
				MapUtils sonCommentMap = new MapUtils();
				sonCommentResultList.add(sonCommentMap);
				UserEntity sonCommentUser = null;
				UserEntity sonReplyCommentUser = null;
				if (rootComment.getUserId().equals(user.getUserId())) {
					sonCommentUser = user;
				} else {
					sonCommentUser = userService.selectById(rootComment.getUserId());
				}
				if (rootComment.getProp1().equals(user.getUserId())) {
					sonReplyCommentUser = user;
				} else {
					sonReplyCommentUser = userService.selectById(rootComment.getProp1());
				}
				sonCommentMap.put("user_id", sonCommentUser.getUserId());
				sonCommentMap.put("headpic_path", sonCommentUser.getHeadpicPath());
				sonCommentMap.put("viplevel", sonCommentUser.getViplevel());
				sonCommentMap.put("name", sonCommentUser.getNickname() == null ? sonCommentUser.getUsername()
						: sonCommentUser.getNickname());

				sonCommentMap.put("reply_user_id", sonReplyCommentUser.getUserId());
				sonCommentMap.put("reply_headpic_path", sonReplyCommentUser.getHeadpicPath());
				sonCommentMap.put("reply_viplevel", sonReplyCommentUser.getViplevel());
				sonCommentMap.put("reply_name",
						sonReplyCommentUser.getNickname() == null ? replyCommentUser.getUsername()
								: replyCommentUser.getNickname());

				sonCommentMap.put("content", sonComment.getContent());
				sonCommentMap.put("comment_id", sonComment.getCommentId());
				sonCommentMap.put("publish_time", sonComment.getPublishTime());
				sonCommentMap.put("resources", sonComment.getResources());

			}
		}
		resultMap.put("spaceDynamic", spaceDynamicMap);
		resultMap.put("commentList", commentList);
		return R.ok(resultMap);
	}

	/**
	 * 动态图册
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/spaceDynamicImgs")
	public R spaceDynamicImgs(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return R.error(1, "用户id不能为空");
		}
		UserEntity user = userService.selectById(userId);
		if (user == null) {
			return R.error(1, "用户不存在");
		}
		MapUtils map = new MapUtils();
		List<SpaceDynamicEntity> list = spaceDynamicService
				.selectList(new EntityWrapper<SpaceDynamicEntity>().eq("user_id", userId).isNotNull("resources"));
		JSONArray resultArr = new JSONArray();
		for (SpaceDynamicEntity entity : list) {
			String resources = entity.getResources();
			JSONArray resourcesArr = JSON.parseArray(resources);
			resultArr.add(resourcesArr);
		}
		map.put("total", resultArr.size());
		map.put("imgs", resultArr);
		map.put("name", user.getNickname() == null ? user.getUsername() : user.getNickname());
		return R.ok(map);
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(String spaceDynamicId) {
		spaceDynamicService.deleteById(spaceDynamicId);
		return R.ok();
	}

}
