package io.renren.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.LiteratureActivityEntity;
import io.renren.modules.app.service.LiteratureActivityService;

/**
 * 文学活动表
 *
 * @author lhc
 * @email
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/literatureactivity")
public class LiteratureActivityController {
	@Autowired
	private LiteratureActivityService literatureActivityService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("app:literatureactivity:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = literatureActivityService.queryPage(params);
		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{literatureActivityId}")
	@RequiresPermissions("app:literatureactivity:info")
	public R info(@PathVariable("literatureActivityId") String literatureActivityId) {
		LiteratureActivityEntity entity = literatureActivityService.selectById(literatureActivityId);
		return R.ok().put("literatureActivity", entity);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("app:literatureactivity:save")
	public R save(@RequestBody LiteratureActivityEntity literatureActivity) {

		literatureActivityService.insert(literatureActivity);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("app:literatureactivity:update")
	public R update(@RequestBody LiteratureActivityEntity literatureActivity) {
		literatureActivityService.updateById(literatureActivity);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody String[] literatureActivityIds) {
		literatureActivityService.deleteBatchIds(Arrays.asList(literatureActivityIds));
		return R.ok();
	}

}
