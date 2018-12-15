package io.renren.modules.app.apicontroller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.MsgListEntity;
import io.renren.modules.app.service.MsgListService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 会话列表
 *
 * @author lhc
 * @email 
 * @date 2018-12-13 22:49:04
 */
@RestController
@RequestMapping("api/msglist")
public class MsgListApiController {
    @Autowired
    private MsgListService msgListService;

}
