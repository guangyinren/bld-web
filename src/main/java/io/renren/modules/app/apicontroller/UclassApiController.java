package io.renren.modules.app.apicontroller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.UclassEntity;
import io.renren.modules.app.service.UclassService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 班级
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/uclass")
public class UclassApiController {
    @Autowired
    private UclassService uclassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:uclass:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = uclassService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uclassId}")
    @RequiresPermissions("app:uclass:info")
    public R info(@PathVariable("uclassId") String uclassId){
			UclassEntity uclass = uclassService.selectById(uclassId);

        return R.ok().put("uclass", uclass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:uclass:save")
    public R save(UclassEntity uclass){
			uclassService.insert(uclass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:uclass:update")
    public R update(UclassEntity uclass){
			uclassService.updateById(uclass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:uclass:delete")
    public R delete(String[] uclassIds){
			uclassService.deleteBatchIds(Arrays.asList(uclassIds));
        return R.ok();
    }
    
    @RequestMapping("/file")
    public R file(HttpServletResponse response) throws IOException{
    	response.setStatus(HttpServletResponse.SC_OK);  
    	response.setContentType("application/pdf;charset=UTF-8"); 
    	File file=new File("D:\\index.pdf");
    	if(file==null) {
    		System.out.println("文件为空");
    		return R.error("文件为空");
    	}
    	BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));  
    	byte buffBytes[] = new byte[1024];  
    	ServletOutputStream out = response.getOutputStream();  
    	int read = 0;    
    	while ((read = input.read(buffBytes)) != -1) {    
    	    out.write(buffBytes, 0, read);    
    	}  
    	out.flush();
        input.close();
    	out.close(); 
        return R.ok();
    }

}
