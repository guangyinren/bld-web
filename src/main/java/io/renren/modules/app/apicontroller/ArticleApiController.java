package io.renren.modules.app.apicontroller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.ArticleEntity;
import io.renren.modules.app.service.ArticleService;

/**
 * 文章
 *
 * @author lhc
 * @email
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/article")
public class ArticleApiController extends AbstractController {
	@Autowired
	private ArticleService articleService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(String userId) {
		userId = (userId == null ? getUser().getUserId() : userId);
		if (StringUtils.isEmpty(userId)) {
			return R.error(1,"userId不能为空");
		}
		List<ArticleEntity> list = articleService.selectList(new EntityWrapper<ArticleEntity>().eq("user_id", userId).orderBy("create_time", false));
		return R.ok().put("list", list);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info")
	public R info(String articleId) {
		ArticleEntity article = articleService.selectById(articleId);
		return R.ok().put("article", article);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(ArticleEntity article) {
		if (StringUtils.isEmpty(article.getUserId())) {
			return R.error(1,"userId不能为空");
		}
		article.setCreateTime(new Date());
		articleService.insert(article);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(ArticleEntity article) {
		if(StringUtils.isEmpty(article.getArticleId())) {
			return R.error(1, "文学id不能为空");
		}
		ArticleEntity entity=articleService.selectById(article.getArticleId());
		if(!StringUtils.isEmpty(article.getTitle())) {
			entity.setTitle(article.getTitle());
		}
		if(!StringUtils.isEmpty(article.getContent())) {
			entity.setContent(article.getContent());
		}
		entity.setModifyTime(new Date());
		articleService.updateById(article);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(String articleIds) {
		if(StringUtils.isEmpty(articleIds)) {
			return R.error(1, "articleIds不能为空");
		}
		JSONArray idArr = JSON.parseArray(articleIds);
		List<String> idList = idArr.toJavaList(String.class);
		if(idList!=null&&idList.size()>0) {
			if(!articleService.deleteBatchIds(idList)) {
				R.error(1, "删除失败");
			}
		}
		return R.ok();
	}

}
