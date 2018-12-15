package io.renren.modules.app.apicontroller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.common.base.AbstractController;
import io.renren.common.utils.LogUtil;
import io.renren.common.utils.MapUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.entity.RelationUserEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.RelationUserForm;
import io.renren.modules.app.service.AttentionService;
import io.renren.modules.app.service.PublicAccountService;
import io.renren.modules.app.service.RelationUserService;
import io.renren.modules.app.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 联系人
 *
 * @author lhc
 * @email
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/relationuser")
public class RelationUserApiController extends AbstractController {
	@Autowired
	private RelationUserService relationUserService;
	@Autowired
	private PublicAccountService publicAccountService;
	@Autowired
	private UserService userService;
	@Autowired
	private AttentionService attentionService;

	/**
	 * 请求添加联系人
	 * @param form
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/add")
	public R add(RelationUserForm form) throws IllegalAccessException, InvocationTargetException {
		LogUtil.logBefore("请求添加新用户", "请求信息:{}", JSON.toJSON(form));
		ValidatorUtils.validateEntity(form);
		RelationUserEntity entity = new RelationUserEntity();
		BeanUtils.copyProperties(entity, form);
		UserEntity user = userService.selectById(form.getRelationUser());
		// 待添加
		entity.setStatus("0");
		entity.setHeadPic(user.getHeadpicPath());
		if(StringUtils.isEmpty(entity.getRelationName())){
			entity.setRelationName(user.getNickname()==null?user.getUsername():user.getNickname());
		}
		entity.setCreateTime(new Date());
		relationUserService.insert(entity);
		return R.ok();
	}

	/**
	 * 是否同意添加好友请求
	 * 
	 * @param relationUserId
	 * @param result
	 *            0:拒绝,1:同意
	 * @return
	 */
	@RequestMapping("/audit")
	public R audit(String relationId, String result, String name, String remark) {
		if (StringUtils.isEmpty(relationId)) {
			return R.error(1, "请求id不能为空");
		}
		if (StringUtils.isEmpty(result)) {
			return R.error(1, "是否同意不能为空");
		}
		RelationUserEntity entity = relationUserService.selectById(relationId);
		if (entity == null) {
			return R.error(1, "不存在请求记录");
		}
		if ("1".equals(result)) {//同意
			entity.setStatus(result);
			relationUserService.updateById(entity);
			RelationUserEntity entity1 = new RelationUserEntity();
			entity1.setStatus(result);
			entity1.setUserId(entity.getRelationUser());
			UserEntity user = userService.selectById(entity.getUserId());
			if (StringUtils.isEmpty(name)) {
				entity1.setRelationName(user.getNickname()==null?user.getUsername():user.getNickname());
			} else {
				entity1.setRelationName(name);
			}
			entity1.setHeadPic(user.getHeadpicPath());
			entity1.setRelationUser(entity.getUserId());
			entity1.setRelationRemark(remark);
			entity1.setCreateTime(new Date());
			relationUserService.insert(entity1);
		} else if ("0".equals(result)) {
			relationUserService.deleteById(relationId);
		}
		return R.ok();
	}

	/**
	 * 获取待审核的列表
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/auditList")
	public R auditList(String userId) {
		userId = (userId == null ? getUser().getUserId() : userId);
		List<MapUtils> list = new ArrayList<>();
		List<RelationUserEntity> relationUserList = relationUserService
				.selectList(new EntityWrapper<RelationUserEntity>().eq("relation_user", userId).eq("status", "0"));
		for (RelationUserEntity entity : relationUserList) {
			MapUtils userMap = new MapUtils();
			userMap.put("relationId", entity.getRelationUserId());
			userMap.put("id", entity.getUserId());// 发起申请的用户id
			userMap.put("name", entity.getRelationName());
			UserEntity ruser = userService.selectById(entity.getUserId());
			if(ruser==null) {
				continue;
			}else {
				userMap.put("headPic", ruser.getHeadpicPath());
			}
			userMap.put("remark", entity.getRelationRemark());
			list.add(userMap);
		}
		return R.ok().put("list", list);
	}

	/**
	 * 搜索已添加的联系人
	 * 
	 * @param key
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/search")
	public R search(String userId, String key) {
		MapUtils map = new MapUtils();
		List<MapUtils> list = new ArrayList<>();
		List<RelationUserEntity> relationUserList = relationUserService
				.selectList(new EntityWrapper<RelationUserEntity>().eq("user_id", userId).andNew()
						.like("relation_user", key).or().like("relation_name", key));
		// List<PublicAccountEntity>
		// publicAccoubtList=publicAccountService.selectList(new
		// EntityWrapper<PublicAccountEntity>().eq("user_id",
		// userId).andNew().like("relation_user", key).or().like("relation_name", key));
		// 搜索关注的账号
		List<Map<String, Object>> attentionUserList = relationUserService.queryAttentionByKey(userId, key);
		for (RelationUserEntity entity : relationUserList) {
			MapUtils userMap = new MapUtils();
			userMap.put("id", entity.getRelationUser());
			userMap.put("name", entity.getRelationName());
			userMap.put("headPic", entity.getHeadPic());
			userMap.put("remark", entity.getRelationRemark());
			list.add(userMap);
		}
		for (Map<String, Object> entity : attentionUserList) {
			MapUtils userMap = new MapUtils();
			userMap.put("id", entity.get("user_id"));
			userMap.put("name", entity.get("username"));
			userMap.put("headPic", entity.get("headpic_path"));
			userMap.put("remark", entity.get("nickname"));
			list.add(userMap);
		}
		return R.ok().put("list", list);
	}

	/**
	 * 当前用户的联系人列表
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public R list(String userId) {
		userId = (userId == null ? getUser().getUserId() : userId);
		UserEntity u = userService.selectById(userId);
		if (u == null) {
			return R.error(1, "用户信息为空");
		}
		MapUtils map = new MapUtils();
		// 同学
		List<MapUtils> schoolmate = new ArrayList<>();
		// 校友
		List<MapUtils> schoolfellow = new ArrayList<>();
		// 联系人
		List<MapUtils> relationuser = new ArrayList<>();
		// 关注
		List<MapUtils> attention = new ArrayList<>();

		List<RelationUserEntity> relationUserList = relationUserService
				.selectList(new EntityWrapper<RelationUserEntity>().eq("user_id", u.getUserId()).eq("status", "1"));
		for (RelationUserEntity entity : relationUserList) {
			MapUtils userMap = new MapUtils();
			userMap.put("id", entity.getRelationUser());
			userMap.put("name", entity.getRelationName());
			userMap.put("headPic", entity.getHeadPic());
			userMap.put("remark", entity.getRelationRemark());
			if (ValidateUtils.isEmpty(u.getSchool())) {
				relationuser.add(userMap);
			} else {
				UserEntity userEntity = userService.selectById(entity.getRelationUser());
				if (userEntity!=null&&u.getSchool().equals(userEntity.getSchool())) {
					if ((!ValidateUtils.isEmpty(u.getUclass())) && u.getUclass().equals(userEntity.getUclass())) {
						schoolmate.add(userMap);
					} else {
						schoolfellow.add(userMap);
					}
				} else {
					relationuser.add(userMap);
				}
			}
		}
		List<Map<String, Object>> queryAttentionUser = attentionService.queryAttentionUser(u.getUserId());
		for (Map<String, Object> entity : queryAttentionUser) {
			MapUtils userMap = new MapUtils();
			userMap.put("id", entity.get("user_id"));
			userMap.put("name", entity.get("username"));
			userMap.put("headPic", entity.get("headpic_path"));
			userMap.put("remark", entity.get("nickname"));
			attention.add(userMap);
		}
		map.put("schoolmate", schoolmate);
		map.put("schoolfellow", schoolfellow);
		map.put("relationuser", relationuser);
		map.put("attention", attention);
		return R.ok(map);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{relationUserId}")
	@RequiresPermissions("app:relationuser:info")
	public R info(@PathVariable("relationUserId") String relationUserId) {
		RelationUserEntity relationUser = relationUserService.selectById(relationUserId);
		return R.ok().put("relationUser", relationUser);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("app:relationuser:save")
	public R save(RelationUserEntity relationUser) {
		relationUserService.insert(relationUser);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(RelationUserEntity relationUser) {
		if(StringUtils.isEmpty(relationUser.getUserId())) {
			return R.error(1, "用户id不能为空");
		}
		if(StringUtils.isEmpty(relationUser.getRelationUser())) {
			return R.error(1, "联系人id不能为空");
		}
		RelationUserEntity entity=relationUserService.selectOne(new EntityWrapper<RelationUserEntity>().eq("user_id", relationUser.getUserId()).eq("relation_user", relationUser.getRelationUser()));
		if(entity==null) {
			return R.error(1, "不存在此联系人");
		}
		if(StringUtils.isNotEmpty(relationUser.getRelationName())) {
			entity.setRelationName(relationUser.getRelationName());
		}
		if(StringUtils.isNotEmpty(relationUser.getRelationRemark())) {
			entity.setRelationRemark(relationUser.getRelationRemark());
		}
		relationUserService.updateById(entity);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(String relationUserId, String userId) {
		RelationUserEntity user = relationUserService.selectOne(
				new EntityWrapper<RelationUserEntity>().eq("user_id", userId).eq("relation_user", relationUserId));
		RelationUserEntity relationUser = relationUserService.selectOne(
				new EntityWrapper<RelationUserEntity>().eq("user_id", relationUserId).eq("relation_user", userId));
		if (user == null || relationUser == null) {
			return R.error(1, "不存在此联系人");
		}
		relationUserService.deleteBatchIds(Arrays.asList(user.getRelationUserId(), relationUser.getRelationUserId()));
		return R.ok();
	}

}
