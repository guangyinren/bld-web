package io.renren.modules.app.apicontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.CourseBookEntity;
import io.renren.modules.app.service.CourseBookService;

/**
 * 课程表(自己设置自己的课程表)
 *
 * @author lhc
 * @email
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/coursebook")
public class CourseBookApiController extends AbstractController {
	@Autowired
	private CourseBookService courseBookService;

	/**
	 * 创建或更新课程表
	 * 
	 * @param forum
	 * @return
	 */
	@RequestMapping("/save")
	public R save(String content, String userId) {
		if (StringUtils.isEmpty(userId)) {
			return R.error(1,"userId不能为空");
		}
		CourseBookEntity courseBookEntity = courseBookService
				.selectOne(new EntityWrapper<CourseBookEntity>().eq("creator", userId));
		if (courseBookEntity == null) {
			courseBookEntity = new CourseBookEntity();
			courseBookEntity.setKc0(content);
			courseBookEntity.setCreator(userId);
			courseBookService.insert(courseBookEntity);
		} else if (!StringUtils.isEmpty(content)) {
			courseBookEntity.setKc0(content);
			courseBookService.updateById(courseBookEntity);
		}
		return R.ok();
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/queryUserCourseBook")
	public R queryUserCourseBook(String userId) {
		userId = (userId == null ? getUser().getUserId() : userId);
		if (StringUtils.isEmpty(userId)) {
			return R.error(1,"userId不能为空");
		}
		CourseBookEntity courseBook = new CourseBookEntity();
		courseBook.setUclass(getUser().getUclass());
		courseBook = courseBookService.selectOne(new EntityWrapper<CourseBookEntity>(courseBook));
		return R.ok().put("courseBook", courseBook);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list( Map<String, Object> params) {
		PageUtils page = courseBookService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info")
	public R info(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return R.error(1,"userId不能为空");
		}
		CourseBookEntity courseBook = courseBookService.selectOne(new EntityWrapper<CourseBookEntity>().eq("creator", userId));;
		if (courseBook==null) {
			return R.error(1,"该用户未设置课程表");
		}
		return R.ok().put("content", courseBook.getKc0());
	}

}
