package io.renren.modules.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.modules.app.form.RegisterForm;
import io.renren.modules.sys.service.SysCaptchaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 验证码
 * 
 * @author LHC 2018年6月2日
 */
@RestController
@RequestMapping("/tool/captcha")
@Api("验证码接口")
public class CaptchaController extends AbstractController {
	@Autowired
	private SysCaptchaService sysCaptchaService;

	@PostMapping("/send")
	@ApiOperation("发送验证码")
	public R register(@RequestBody RegisterForm form) {
		Assert.isBlank(form.getUuid(), "uuid不能为空");
		// 生成文字验证码
		String code = sysCaptchaService.getTextCaptcha(form.getUuid());
		logger.info("@@@验证码:{}", code);
		logger.info("@@@uuid:{}", form.getUuid());
		if (!StringUtils.isEmpty(form.getMobile())) {
			// TODO 发送短信
		}
		if (!StringUtils.isEmpty(form.getEmail())) {
			// TODO 发送邮件
		}
		return R.ok();
	}
}
