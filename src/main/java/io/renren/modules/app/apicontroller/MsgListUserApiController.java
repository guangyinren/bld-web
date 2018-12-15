package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.modules.app.entity.MsgListUserEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.MsgListUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户会话列表
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 22:57:39
 */
@RestController
@RequestMapping("api/msglistuser")
public class MsgListUserApiController {
    @Autowired
    private MsgListUserService msgListUserService;
    
    @RequestMapping("/list")
	public R quick(String userId) {
    	if (StringUtils.isEmpty(userId)) {
			return R.error(1, "必传参数为空");
		}
    	List<Map<String, Object>> listmap = msgListUserService.selectMaps(new EntityWrapper<MsgListUserEntity>().setSqlSelect("userId,listId,toUserId,toHeadPic,name,newNum,lastMsg,lastTime").eq("userId", userId).orderBy("lastTime", false));
    	return R.ok().put("list", listmap);
    }
    
}
