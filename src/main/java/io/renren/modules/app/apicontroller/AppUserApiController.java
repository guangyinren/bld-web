package io.renren.modules.app.apicontroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.FileUtil;
import io.renren.common.utils.LogUtil;
import io.renren.common.utils.MapUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.SmsUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.entity.AccountEntity;
import io.renren.modules.app.entity.AttentionEntity;
import io.renren.modules.app.entity.RelationUserEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.form.RegisterForm;
import io.renren.modules.app.service.AccountService;
import io.renren.modules.app.service.AttentionService;
import io.renren.modules.app.service.RelationUserService;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.JwtUtils;
import io.renren.modules.sys.service.SysCaptchaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * APP用户接口
 *
 * @author lhc
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("api/user")
@Api("APP用户接口")
public class AppUserApiController extends AbstractController {
    @Autowired
    private UserService userService;
    @Autowired
    private SysCaptchaService sysCaptchaService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RelationUserService relationUserService;
    @Autowired
    private AttentionService attentionService;
    @Autowired
    private AccountService accountService;

    @Value("${uploadImgPath}")
    private String uploadImgPath;

    @RequestMapping("/register")
    @ApiOperation("注册")
    public R register(RegisterForm form) {
        LogUtil.logBefore("注册", "请求数据:{}", JSON.toJSONString(form));
        // 表单校验
        ValidatorUtils.validateEntity(form);
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            return R.error("验证码不正确");
        }
        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getMobile());
        user.setNickname(form.getMobile());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setEmail(form.getEmail());
        user.setIdNum(form.getIdNum());
        user.setCreateTime(new Date());
        userService.insert(user);
        UserEntity userEntity = userService.queryByMobileOrEmail(form.getMobile());
        //同时创建一个账户
        AccountEntity account=new AccountEntity();
        account.setUserid(userEntity.getUserId());
        account.setCreatetime(new Date());
        accountService.insert(account);
        return R.ok().put("userId", userEntity.getUserId());
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public R login(LoginForm form) {
        LogUtil.logBefore("登录", "请求数据:{}", JSON.toJSONString(form));
        // 表单校验
        ValidatorUtils.validateEntity(form);

        // 用户登录
        UserEntity user = userService.login(form);
        LogUtil.info("用户信息放在session：{}", user);
        getSession().setAttribute("user", user);
        // 生成token
        String token = jwtUtils.generateToken(Long.valueOf(user.getUserId()));

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        map.put("userId", user.getUserId());
        logger.info("@@@登录的token:{},用户信息:{}", token, user);
        return R.ok(map);
    }

    /**
     * 发送验证码
     *
     * @param mobile
     * @param uuid
     * @param type   0:注册 1：找回密码
     * @return
     * @throws ClientException
     */
    @RequestMapping("/sendCaptcha")
    public R sendCaptcha(String mobile, String uuid, Integer type) throws ClientException {
        if (StringUtils.isEmpty(mobile)) {
            return R.error(1, "手机号不能为空");
        }
        if (type == null) {
            return R.error(1, "业务类型不能为空");
        }
        // 生成验证码
        if (StringUtils.isBlank(uuid)) {
            return R.error(1, "uuid不能为空");
        }
        //判断手机号是否存在
        UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("mobile", mobile));
        if(user!=null) {
        	return R.error(1, "手机号已经存在");
        }
        String captcha = sysCaptchaService.getTextCaptcha(uuid);
        String templateCode = null;
        String templateParam = null;
        JSONObject jo = new JSONObject();
        if (type == 1) {
            templateCode = "SMS_138077860";
            jo.put("code", captcha);
            templateParam = jo.toJSONString();
        } else if (type == 2) {
            templateCode = "SMS_138072868";
            jo.put("code", captcha);
            templateParam = jo.toJSONString();
        } else {
            return R.error(1, "type只能为指定值");
        }
        SendSmsResponse sendSmsResponse = SmsUtils.sendSms(mobile, templateCode, templateParam);
        LogUtil.info("返回的信息:" + JSON.toJSONString(sendSmsResponse));
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return R.ok().put("uuid", uuid);
        }
        return R.error(1, "发送短信失败,失败原因:" + sendSmsResponse.getMessage());
    }

    /**
     * 验证验证码
     *
     * @param uuid
     * @param captcha
     * @return
     */
    @RequestMapping("/verifyCaptcha")
    public R verifyCaptcha(String uuid, String captcha) {
        if (!sysCaptchaService.validate(uuid, captcha)) {
            return R.error(1, "验证码不正确");
        }
        return R.ok();
    }

    /**
     * 重置密码(前端必须验证通过才能调用此接口)
     *
     * @param mobile
     * @param password
     * @param newpassword
     * @return
     */
    @RequestMapping("/resetPwd")
    public R resetPwd(String mobile, String newpassword) {
        UserEntity user = userService.queryByMobileOrEmail(mobile);
        if (user == null) {
            return R.error(1, "不存在此用户");
        }
        user.setPassword(DigestUtils.sha256Hex(newpassword));
        userService.updateById(user);
        return R.ok();
    }

    /**
     * 根据旧密码修改新密码
     *
     * @param mobile
     * @param newpassword
     * @param oldpassword
     * @return
     */
    @RequestMapping("/changePwdByOld")
    public R changePwdByOld(String mobile, String oldpassword, String newpassword) {
        UserEntity user = userService.queryByMobileOrEmail(mobile);
        if (user == null) {
            return R.error(1, "不存在此用户");
        }
        if (StringUtils.isEmpty(oldpassword)) {
            return R.error(1, "旧密码不能为空");
        }
        if (StringUtils.isEmpty(newpassword)) {
            return R.error(1, "新密码不能为空");
        }
        if (DigestUtils.sha256Hex(oldpassword).equals(user.getPassword())) {
            user.setPassword(DigestUtils.sha256Hex(newpassword));
            userService.updateById(user);
            return R.ok();
        } else {
            return R.error(1, "密码错误");
        }
    }

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping("/userInfo")
    public R userInfo(String userId) {
        if (StringUtils.isBlank(userId)) {
            return R.error(1, "用户id不能为空");
        }
        UserEntity user = userService.selectById(userId);
        if (user == null) {
            return R.error(1, "用户不存在");
        }
        //我的粉丝数量
        int fansNum = attentionService.selectCount(new EntityWrapper<AttentionEntity>().eq("source_id", userId).eq("type", "0"));
        //我关注的人的数量
        int attentionNum=attentionService.selectCount(new EntityWrapper<AttentionEntity>().eq("user_id", userId).eq("type", "0"));
        //诚信分
        int honestNum=Integer.valueOf(user.getProp1());
        //赞
        int praiseNum=Integer.valueOf(user.getProp2());
        return R.ok().put("user", user).put("fansNum", fansNum).put("attentionNum", attentionNum).put("honestNum", honestNum).put("praiseNum", praiseNum);
    }

    /**
     * 完善信息
     *
     * @param entity
     * @return
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping("/update")
    public R update(UserEntity entity) throws IllegalStateException, IOException {
        LogUtil.logBefore("保存用户信息", "请求数据:{}", JSON.toJSONString(entity));
        String userId = entity.getUserId();
        userId = (userId == null ? getUser().getUserId() : userId);
        if (StringUtils.isBlank(userId)) {
            return R.error(1, "用户id不能为空");
        }
        UserEntity user = userService.selectById(userId);
        if (user == null) {
            return R.error(1, "用户id不能为空");
        }
        if (StringUtils.isNotEmpty(entity.getHeadpicPath())) {
            user.setHeadpicPath(entity.getHeadpicPath());
        }
        if (entity.getType() != null) {
            user.setType(entity.getType());
        }
        if (StringUtils.isNotEmpty(entity.getNickname())) {
            user.setNickname(entity.getNickname());
        }
        if (StringUtils.isNotEmpty(entity.getSchool())) {
            user.setSchool(entity.getSchool());
        }
        if (StringUtils.isNotEmpty(entity.getGrade())) {
            user.setGrade(entity.getGrade());
        }
        if (StringUtils.isNotEmpty(entity.getUclass())) {
            user.setUclass(entity.getUclass());
        }
        if (entity.getBirthday() != null) {
            user.setBirthday(entity.getBirthday());
        }
        if (entity.getSex() != null) {
            user.setSex(entity.getSex());
        }
        if (StringUtils.isNotEmpty(entity.getMobile())) {
            user.setMobile(entity.getMobile());
        }
        if (StringUtils.isNotEmpty(entity.getIntro())) {
            user.setIntro(entity.getIntro());
        }
        if (StringUtils.isNotEmpty(entity.getHeadpicPath())) {
            String path = getSession().getServletContext().getRealPath("upload") + "/";
            MultipartFile file1 = FileUtil.base64ToMultipart(entity.getHeadpicPath());
            String filename = file1.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString().replace("-", "");// 文件名
            String suffix = filename.substring(filename.lastIndexOf("."));//后缀
            newFileName = newFileName + suffix;
            // 在要上传的路径下用图片的名称新建一个file
            File file = new File(path + newFileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file1.transferTo(file);
            logger.info("文件上传的路径" + uploadImgPath + newFileName);
            user.setHeadpicPath(uploadImgPath + newFileName);
        }
        //入学日期
        if (StringUtils.isNotEmpty(entity.getProp1())) {
            user.setProp1(entity.getProp1());
        }
        userService.updateById(user);
        return R.ok();
    }

    @RequestMapping("/openVip")
    public R openVip(String userId) {
        userId = (userId == null ? getUser().getUserId() : userId);
        LogUtil.logBefore("开通会员(或升级)", "请求数据:{}", userId);
        if (StringUtils.isBlank(userId)) {
            return R.error(1, "用户id不能为空");
        }
        UserEntity user = getUser();
        if (user.getViplevel() != 0) {
            return R.error(1, "用户已经是vip会员了");
        }
        user.setViplevel(1);
        userService.updateById(user);
        return R.ok();
    }

    /**
     * 获取我的粉丝
     *
     * @param userId
     * @return
     */
    @RequestMapping("/queryMyFans")
    public R queryMyFans(String userId) {
        userId = (userId == null ? getUser().getUserId() : userId);
        List<MapUtils> list = new ArrayList<>();
        List<UserEntity> userlist = userService.queryMyFans(userId);
        for (UserEntity entity : userlist) {
            MapUtils userMap = new MapUtils();
            if (entity.getUserId().equals(userId)) {
                continue;
            }
            RelationUserEntity relationUserEntity = relationUserService
                    .selectOne(new EntityWrapper<RelationUserEntity>().eq("user_id", userId).eq("relation_user",
                            entity.getUserId()));
            if (relationUserEntity != null) {
                userMap.put("isRelation", 1);
            } else {
                userMap.put("isRelation", 0);
            }
            AttentionEntity attentionEntity = attentionService.selectOne(
                    new EntityWrapper<AttentionEntity>().eq("user_id", userId).eq("source_id", entity.getUserId()));
            if (attentionEntity != null) {
                userMap.put("isAttention", 1);
            } else {
                userMap.put("isAttention", 0);
            }
            userMap.put("id", entity.getUserId());
            userMap.put("name", entity.getNickname() == null ? entity.getUsername() : entity.getNickname());
            userMap.put("headPic", entity.getHeadpicPath());
            list.add(userMap);
        }
        return R.ok().put("list", list);
    }

    /**
     * 搜索用户,可根据id,名称,注册时的微博微信号等进行搜索
     *
     * @param userId
     * @param key
     * @return
     */
    @RequestMapping("/search")
    public R search(String userId, String key) {
        userId = (userId == null ? getUser().getUserId() : userId);
        UserEntity userEntity = userService.selectById(userId);
        if (userEntity == null) {
            return R.error(1, "不存在该用户");
        }
        List<MapUtils> list = new ArrayList<>();
        List<UserEntity> userlist = userService
                .selectList(new EntityWrapper<UserEntity>().like("user_id", key).or().like("mobile", key).or()
                        .like("username", key).or().like("nickname", key).or().like("third_numbers", key));
        for (UserEntity entity : userlist) {
            MapUtils userMap = new MapUtils();
            if (entity.getUserId().equals(userId)) {
                continue;
            }
            RelationUserEntity relationUserEntity = relationUserService
                    .selectOne(new EntityWrapper<RelationUserEntity>().eq("user_id", userEntity.getUserId())
                            .eq("relation_user", entity.getUserId()));
            if (relationUserEntity != null) {
                continue;
//				userMap.put("is_relation", 1);
            } else {
                userMap.put("is_relation", 0);
            }
            AttentionEntity attentionEntity = attentionService.selectOne(new EntityWrapper<AttentionEntity>()
                    .eq("user_id", userEntity.getUserId()).eq("source_id", entity.getUserId()));
            if (attentionEntity != null) {
                userMap.put("is_attention", 1);
            } else {
                userMap.put("is_attention", 0);
            }
            userMap.put("id", entity.getUserId());
            userMap.put("name", entity.getNickname() == null ? entity.getUsername() : entity.getNickname());
            userMap.put("headPic", entity.getHeadpicPath());
            list.add(userMap);
        }
        return R.ok().put("list", list);
    }

    /**
     * 获取官方推荐的账号
     *
     * @return
     */
    @RequestMapping("/recommend")
    public R recommend(String userId) {
        List<MapUtils> list = new ArrayList<>();
        List<UserEntity> userlist = userService.selectList(new EntityWrapper<UserEntity>().eq("settings", "1"));
        for (UserEntity entity : userlist) {
            if (entity.getUserId().equals(userId)) {
                continue;
            }
            MapUtils userMap = new MapUtils();
            userMap.put("id", entity.getUserId());
            userMap.put("viplevel", entity.getViplevel());
            userMap.put("name", entity.getNickname() == null ? entity.getUsername() : entity.getNickname());
            userMap.put("headPic", entity.getHeadpicPath());
            list.add(userMap);
        }
        return R.ok().put("list", list);
    }

    /**
     * 推荐同班同学
     *
     * @param userId
     * @return
     */
    @RequestMapping("/recommendSchoolmate")
    public R recommendSchoolmate(String userId) {
        userId = (userId == null ? getUser().getUserId() : userId);
        UserEntity userEntity = userService.selectById(userId);
        if (userEntity == null) {
            return R.error(1, "不存在该用户");
        }
        List<MapUtils> list = new ArrayList<>();
        List<UserEntity> userlist = userService.selectList(new EntityWrapper<UserEntity>()
                .eq("school", userEntity.getSchool()).eq("uclass", userEntity.getUclass()));
        for (UserEntity entity : userlist) {
            if (entity.getUserId().equals(userId)) {
                continue;
            }
            RelationUserEntity relationUserEntity = relationUserService
                    .selectOne(new EntityWrapper<RelationUserEntity>().eq("user_id", userEntity.getUserId())
                            .eq("relation_user", entity.getUserId()));
            if (relationUserEntity != null) {
                continue;
            }
            AttentionEntity attentionEntity = attentionService.selectOne(new EntityWrapper<AttentionEntity>()
                    .eq("user_id", userEntity.getUserId()).eq("source_id", entity.getUserId()));
            if (attentionEntity != null) {
                continue;
            }
            MapUtils userMap = new MapUtils();
            userMap.put("id", entity.getUserId());
            userMap.put("viplevel", entity.getViplevel());
            userMap.put("name", entity.getNickname() == null ? entity.getUsername() : entity.getNickname());
            userMap.put("headPic", entity.getHeadpicPath());
            list.add(userMap);
        }
        return R.ok().put("list", list);
    }

}
