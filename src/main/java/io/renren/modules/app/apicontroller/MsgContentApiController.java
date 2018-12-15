package io.renren.modules.app.apicontroller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.entity.MsgContentEntity;
import io.renren.modules.app.entity.MsgListEntity;
import io.renren.modules.app.entity.MsgListUserEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.MsgContentService;
import io.renren.modules.app.service.MsgListService;
import io.renren.modules.app.service.MsgListUserService;
import io.renren.modules.app.service.UserService;



/**
 * 即时消息内容
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:05
 */
@RestController
@RequestMapping("api/msg")
public class MsgContentApiController extends AbstractController{
    @Autowired
    private MsgContentService msgContentService;
    @Autowired
    private MsgListService msgListService;
    @Autowired
    private MsgListUserService msgListUserService;
    @Autowired
    private UserService userService;
    @Value("${chatImgPath}")
	private String chatImgPath;
    
    /**
     * 发送消息
     * @param userId
     * @param toUserId
     * @param content
     * @param type
     * @param file
     * @return
     */
    @RequestMapping("/send")
	public R send(String userId,String toUserId,String content,String type,@RequestParam("file") MultipartFile file) {
    	if (ValidateUtils.isContainEmpty(userId, toUserId,type)) {
			return R.error(1, "必传参数为空");
		}
    	String uploadFile="";
    	if("0".equals(type)) {//文本消息
    		if (ValidateUtils.isContainEmpty(content)) {
    			return R.error(1, "消息不能为空");
    		}
    	}else if("1".equals(type)) {//图片
    		if(StringUtils.isEmpty(file.getOriginalFilename())) {
    			return R.error(1, "图片不能为空");
    		}
    		uploadFile = uploadFile(file,chatImgPath);
    	}
    	UserEntity user=userService.selectById(userId);
    	UserEntity toUser=userService.selectById(toUserId);
    	if(user==null||toUser==null) {
    		return R.error(1, "用户不存在");
    	}
    	//查找是否有已存在的会话
    	MsgListEntity msgList=msgListService.selectOne(new EntityWrapper<MsgListEntity>().eq("userId", userId).eq("toUserId", toUserId));
    	if(msgList==null) {
    		msgList=msgListService.selectOne(new EntityWrapper<MsgListEntity>().eq("userId", toUserId).eq("toUserId", userId));
    	}
    	MsgListUserEntity msgListUser = msgListUserService.selectOne(new EntityWrapper<MsgListUserEntity>().eq("userId", userId).eq("toUserId", toUserId));
    	MsgListUserEntity toMsgListUser=msgListUserService.selectOne(new EntityWrapper<MsgListUserEntity>().eq("userId", toUserId).eq("toUserId", userId));
    	if(msgList==null||msgListUser==null||toMsgListUser==null) {
    		//创建msglist
    		msgList=new MsgListEntity();
    		msgList.setStatus("0");//正常
    		msgList.setUserid(userId);
    		msgList.setTouserid(toUserId);
    		msgList.setMsgnum(0);
    		msgList.setCreatetime(new Date());
    		msgListService.insert(msgList);
    		//创建msgListUser和toMsgListUser
    		msgListUser=new MsgListUserEntity();
    		msgListUser.setUserid(userId);
    		msgListUser.setTouserid(toUserId);
    		msgListUser.setListid(msgList.getMsglistid());
    		msgListUser.setStatus("0");
    		msgListUser.setToheadpic(toUser.getHeadpicPath());
    		msgListUser.setName(toUser.getUsername());
    		msgListUser.setNewnum(0);
    		if("0".equals(type)) {//文字
    			msgListUser.setConfig("0");
    			msgListUser.setLastmsg(content);
    		}else if("1".equals(type)){//图片
    			msgListUser.setConfig("1");
    			msgListUser.setLastmsg(uploadFile);
			}
    		msgListUser.setLasttime(new Date());
    		msgListUser.setCreatetime(new Date());
    		msgListUserService.insert(msgListUser);
    		
    		//toMsgListUser
    		toMsgListUser=new MsgListUserEntity();
    		toMsgListUser.setUserid(toUserId);
    		toMsgListUser.setTouserid(userId);
    		toMsgListUser.setListid(msgList.getMsglistid());
    		toMsgListUser.setStatus("0");
    		toMsgListUser.setToheadpic(user.getHeadpicPath());
    		toMsgListUser.setName(user.getUsername());
    		toMsgListUser.setNewnum(1);
    		if("0".equals(type)) {//文字
    			toMsgListUser.setConfig("0");
    			toMsgListUser.setLastmsg(content);
    		}else if("1".equals(type)){//图片
    			toMsgListUser.setConfig("1");
    			toMsgListUser.setLastmsg(uploadFile);
			}
    		toMsgListUser.setLasttime(new Date());
    		toMsgListUser.setCreatetime(new Date());
    		msgListUserService.insert(toMsgListUser);
    	}else {
    		//更新消息列表
    		msgList.setMsgnum(msgList.getMsgnum()+1);
    		msgList.setModifytime(new Date());
    		msgListService.updateById(msgList);
    		//更新msgListUser和toMsgListUser
    		msgListUser.setNewnum(0);
    		if("0".equals(type)) {//文字
    			msgListUser.setConfig("0");
    			msgListUser.setLastmsg(content);
    		}else if("1".equals(type)){//图片
    			msgListUser.setConfig("1");
    			msgListUser.setLastmsg(uploadFile);
			}
    		msgListUser.setLasttime(new Date());
    		msgListUser.setModifytime(new Date());
    		msgListUserService.updateById(msgListUser);
    		
    		toMsgListUser.setNewnum(toMsgListUser.getNewnum()+1);
    		if("0".equals(type)) {//文字
    			toMsgListUser.setConfig("0");
    			toMsgListUser.setLastmsg(content);
    		}else if("1".equals(type)){//图片
    			toMsgListUser.setConfig("1");
    			toMsgListUser.setLastmsg(uploadFile);
			}
    		toMsgListUser.setLasttime(new Date());
    		toMsgListUser.setModifytime(new Date());
    		msgListUserService.updateById(toMsgListUser);
    	}
    	
    	//保存消息
    	MsgContentEntity msg=new MsgContentEntity();
    	msg.setListid(msgList.getMsglistid());
    	msg.setType(type);
    	if("0".equals(type)) {//文字
    		msg.setContent(content);
		}else if("1".equals(type)){//图片
			msg.setResource(uploadFile);
		}
    	msg.setUserid(userId);
    	msg.setUsername(user.getUsername());
    	msg.setHeadpic(user.getHeadpicPath());
    	
    	msg.setTouserid(toUserId);
    	msg.setTousername(user.getUsername());
    	msg.setToheadpic(user.getHeadpicPath());
    	msg.setSendtime(new Date());
    	msg.setCreatetime(new Date());
    	msgContentService.insert(msg);
    	return R.ok();
    }
    
   /**
    * 默认10条
    * @param userId
    * @param toUserId
    * @param num
    * @return
    */
    @RequestMapping("/log")
	public R log(String userId,String toUserId,Integer num) {
    	if (ValidateUtils.isContainEmpty(userId, toUserId)) {
			return R.error(1, "必传参数为空");
		}
    	if(num==null||num==0) {
    		num=10;
    	}
    	String sql="SELECT msgContentId,type,resource,userId,userName,headPic,toUserId,toUserName,toHeadPic,content,createTime from msg_content WHERE (userId="+userId+" AND toUserId="+toUserId+") or (userId="+toUserId+" AND toUserId="+userId+") ORDER BY createTime ASC LIMIT "+num+";";
    	List<Map<String, Object>> list = userService.selectSql(sql);
    	for(int i=0;i<list.size();i++) {
    		Map<String, Object> msg=list.get(i);
    		if(userId.equals(msg.get("userId"))) {
    			msg.put("isSelf", 1);//是自己,显示在左边
    		}else {
    			msg.put("isSelf", 0);//不是自己,显示在聊天框右边
    		}
    		list.set(i, msg);
    	}
    	return R.ok().put("list", list);
    }
}
