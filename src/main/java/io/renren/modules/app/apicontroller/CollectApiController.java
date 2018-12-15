package io.renren.modules.app.apicontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.MapUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.entity.CollectEntity;
import io.renren.modules.app.entity.SpaceDynamicEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.CollectService;
import io.renren.modules.app.service.SpaceDynamicService;
import io.renren.modules.app.service.UserService;

/**
 * 收藏表
 *
 * @author lhc
 * @email
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/collect")
public class CollectApiController extends AbstractController {
	@Autowired
	private CollectService collectService;
	@Autowired
	private UserService userService;
	@Autowired
	private SpaceDynamicService spaceDynamicService;

	/**
	 * 添加收藏
	 * 
	 * @param id
	 *            收藏的资源id
	 * @param type
	 *            收藏的类型 (0:动态)
	 * @param userId
	 * @return
	 */
	@RequestMapping("/save")
	public R save(String id, Integer type, String userId) {
		userId = (userId == null ? getUser().getUserId() : userId);
		if (userId == null) {
			return R.error(1, "用户id为空");
		}
		if (ValidateUtils.isContainEmpty(id, type, userId)) {
			return R.error(1, "必传参数为空");
		}
		userId = (userId == null ? getUser().getUserId() : userId);
		CollectEntity entity = new CollectEntity();
		entity.setUserId(userId);
		entity.setSourceId(id);
		entity.setType(String.valueOf(type));
		entity.setCreateTime(new Date());
		collectService.insert(entity);
		return R.ok();
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return R.error(1, "用户id不能为空");
		}
		UserEntity userEntity = userService.selectById(userId);
		if (userEntity == null) {
			return R.error(1, "不存在该用户");
		}
		List<MapUtils> list = new ArrayList<>();
		List<CollectEntity> cEntityList = collectService
				.selectList(new EntityWrapper<CollectEntity>().eq("user_id", userId).orderBy("create_time", false));
		for (CollectEntity entity : cEntityList) {
			SpaceDynamicEntity sentity = spaceDynamicService.selectById(entity.getSourceId());
			if(sentity!=null){
				MapUtils rMap = new MapUtils();
				rMap.put("collectId", entity.getCollectId());
				rMap.put("spaceDynamicId", sentity.getSpaceDynamicId());
				rMap.put("resources", sentity.getResources());
				rMap.put("content", sentity.getContent());
				list.add(rMap);
			}else {
				collectService.deleteById(entity.getCollectId());
			}
		}
		return R.ok().put("list", list);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{collectId}")
	@RequiresPermissions("app:collect:info")
	public R info(@PathVariable("collectId") String collectId) {
		CollectEntity collect = collectService.selectById(collectId);

		return R.ok().put("collect", collect);
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("app:collect:update")
	public R update(CollectEntity collect) {
		collectService.updateById(collect);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(String collectIds) {
		if(StringUtils.isEmpty(collectIds)) {
			return R.error(1, "collectIds不能为空");
		}
		JSONArray idArr = JSON.parseArray(collectIds);
		List<String> idList = idArr.toJavaList(String.class);
		if(idList!=null&&idList.size()>0) {
			if(!collectService.deleteBatchIds(idList)) {
				R.error(1, "删除失败");
			}
		}
		return R.ok();
	}

}
