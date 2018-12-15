package io.renren.modules.app.apicontroller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;

/**
 * demo代码
 * 
 * @author H
 *
 */
@RestController
@RequestMapping("api/demo")
public class DemoApiController extends AbstractController {
	@Autowired
	private UserService userService;
	@Value("${uploadImgPath}")
	private String uploadImgPath;

	// 快速查询
	@RequestMapping("/quick")
	public R quick(String type) {
		// 多条
		List<UserEntity> list = userService.selectList(new EntityWrapper<UserEntity>().setSqlSelect("id,areaName").eq("id", 3));
		List<UserEntity> list1 = userService.selectList(new EntityWrapper<UserEntity>().eq("id", 3));
		List<Map<String, Object>> listmap = userService.selectMaps(new EntityWrapper<UserEntity>().setSqlSelect("id,areaName").eq("id", 3));
		// 查询单个字段
		List<Object> listObj = userService.selectObjs(new EntityWrapper<UserEntity>().setSqlSelect("forumId").eq("userId", 1));
		// 一条
		UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("id", 3));
		Map<String, Object> map = userService.selectMap(new EntityWrapper<UserEntity>().eq("id", 3));
		Object o = userService.selectObj(new EntityWrapper<UserEntity>().eq("id", 3));
		// 数量
		int count = userService.selectCount(new EntityWrapper<UserEntity>().eq("id", 3));

		// 返回map
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("name", 1);
		return R.ok().put("data", dataMap);
	}

	// service查询部分字段
	@RequestMapping("/servicelist")
	public R servicelist(String type) {
		if (StringUtils.isEmpty(type)) {
			return R.error("type不能为空");
		}
		Wrapper<UserEntity> wrapper = new EntityWrapper<>();
		wrapper.setSqlSelect("title,image,url");
		wrapper.eq("type", type).eq("status", 1);
		List<Map<String, Object>> list = userService.selectMaps(wrapper);
		return R.ok().put("list", list);
	}

	// 查询一条数据转换成map
	@RequestMapping("/serviceObjOrMap")
	public R serviceObjOrMap() {
		Wrapper<UserEntity> wrapper = new EntityWrapper<>();
		wrapper.setSqlSelect("title,image,url");
		Map<String, Object> map = userService.selectMap(wrapper);
		return R.ok().put("data", map);
	}

	// 原生sql查询
	@RequestMapping("/sqllist")
	public R sqllist(String type, String status) {
		if (StringUtils.isEmpty(type)) {
			return R.error(1, "type不能为空");
		}
//    	String sql="";
		String sql = "SELECT u.headpic_path as userHeadpic,u.nickname,p.name,p.price,p.hits,p.createDate from shop_product p,tb_user u where p.type=2 AND p.isMarketable=1 AND p.objectId=u.user_id ORDER BY p.createDate desc LIMIT 10";
		if ("0".equals(type)) {// 新鲜
			sql = "SELECT u.headpic_path as userHeadpic,u.nickname,p.name,p.price,p.hits,p.createDate from shop_product p,tb_user u where p.type=2 AND p.isMarketable=1 AND p.objectId=u.user_id ORDER BY p.createDate desc LIMIT 10";
		} else if ("1".equals(type)) {// 同城
			if (StringUtils.isEmpty(status)) {
				return R.error(1, "status不能为空");
			}
			sql = "SELECT u.headpic_path as userHeadpic,u.nickname,p.name,p.price,p.hits,p.createDate from shop_product p,tb_user u where p.type=2 AND p.isMarketable=1 AND p.objectId=u.user_id AND p.cityName="
					+ status + " LIMIT 10";
		}
		List<Map<String, Object>> list = userService.selectSql(sql);
		return R.ok().put("list", list);
	}

	// 是否登录
	@RequestMapping("/isLogin")
	public R isLogined() {
		UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}

		if (!isLogin()) {
			return R.error(10, "用户未登录");
		}
		return R.ok();
	}

	// 校验
	@RequestMapping("/checkNull")
	public R checkNull(String type) {
		if (StringUtils.isEmpty(type)) {
			return R.error(1, "必传参数为空");
		} else if ("1".equals(type)) {

		}
		if (ValidateUtils.isContainEmpty(type, type)) {
			return R.error(1, "必传参数为空");
		}
		return R.ok();
	}

	@RequestMapping("/save")
	public R save(UserEntity entity, @RequestParam("files") MultipartFile[] files) {
		UserEntity user = getUser();
    	if(user==null) {
    		return R.error(10,"用户未登录");
    	}
		if (ValidateUtils.isContainEmpty(entity.getNickname(), entity.getMobile())) {
			return R.error(1, "必传参数为空");
		}
		if(files.length>0) {
			//处理图片 
			JSONArray imgsJson = new JSONArray(); 
			for(MultipartFile file:files) {
			  imgsJson.add(uploadFile(file,uploadImgPath)); 
			} 
			//设置图片
//			entity.setImage(imgsJson.getString(0));
//			entity.setProductimage(imgsJson.toJSONString());
		}
		
		entity.setCreateTime(new Date());
		userService.insert(entity);
		return R.ok();
	}

	@RequestMapping("/info")
	public R info(String id) {
		if (StringUtils.isEmpty(id)) {
			return R.error(1, "必传参数为空");
		}
		UserEntity entity = userService.selectById(id);
		if (entity == null) {
			return R.error(1, "此封地不存在");
		}
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("name", entity.getNickname());
		return R.ok().put("data", resultMap);
	}

	// 删除
	@RequestMapping("/delete")
	public R delete(String id) {
		UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		if (StringUtils.isEmpty(id)) {
			return R.error(1, "id不能为空");
		}
		userService.deleteById(id);
		return R.ok();
	}

	// 更新
	@RequestMapping("/update")
	public R update(@RequestBody UserEntity data) {
		UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		if (StringUtils.isEmpty(data.getUserId())) {
			return R.error(1, "id不能为空");
		}
		UserEntity entity = userService.selectById(data.getUserId());
		if (entity == null) {
			return R.error(1, "不存在此id的记录");
		}
		if (!StringUtils.isEmpty(data.getType())) {
			entity.setType(data.getType());
		}
		entity.setModifyTime(new Date());
		userService.updateById(entity);
		return R.ok();
	}

	public void fori(List<?> list) {
		for (int i = 0; i < list.size(); i++) {

		}
	}
}
