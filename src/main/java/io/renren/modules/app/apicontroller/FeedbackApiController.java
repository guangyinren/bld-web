package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.entity.FeedbackEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.FeedbackService;

/**
 * 意见反馈
 *
 * @author lhc
 * @email
 * @date 2018-12-13 10:17:55
 */
@RestController
@RequestMapping("api/feedback")
public class FeedbackApiController extends AbstractController {
	@Autowired
	private FeedbackService feedbackService;
	@Value("${uploadImgPath}")
	private String uploadImgPath;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = feedbackService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{feedbackid}")
	public R info(@PathVariable("feedbackid") String feedbackid) {
		FeedbackEntity feedback = feedbackService.selectById(feedbackid);

		return R.ok().put("feedback", feedback);
	}

	/**
     * 保存
     */
    @RequestMapping("/save")
    public R save(FeedbackEntity feedback, @RequestParam("files") MultipartFile[] files){
    	UserEntity user = getUser();
    	if(user!=null) {
    		feedback.setUserid(user.getUserId());
    		feedback.setInforminfo(user.getMobile());
    	}
    	if (ValidateUtils.isContainEmpty(feedback.getType(), feedback.getContext())) {
			return R.error(1, "必传参数为空");
		}
    	if(files.length>0) {
			JSONArray imgsJson = new JSONArray();
			for (MultipartFile file : files) {
				imgsJson.add(uploadFile(file, uploadImgPath));
			}
			feedback.setResources(imgsJson.toJSONString());
    	}
    	feedback.setStatus("0");//未处理
    	feedback.setCreatetime(new Date());
    	feedbackService.insert(feedback);
        return R.ok();
    }

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody FeedbackEntity feedback) {
		feedbackService.updateById(feedback);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody String[] feedbackids) {
		feedbackService.deleteBatchIds(Arrays.asList(feedbackids));

		return R.ok();
	}

}
