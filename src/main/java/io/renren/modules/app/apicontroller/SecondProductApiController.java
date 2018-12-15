package io.renren.modules.app.apicontroller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.FileUtil;
import io.renren.common.utils.R;
import io.renren.common.utils.ValidateUtils;
import io.renren.modules.app.entity.ProductEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.DynamicSqlService;
import io.renren.modules.app.service.ProductService;
import io.renren.modules.app.service.UserService;



/**
 * 
 * 二手商品
 * @author lhc
 * @email 
 * @date 2018-12-05 22:01:50
 */
@RestController
@RequestMapping("api/sproduct")
public class SecondProductApiController extends AbstractController{
    @Autowired
    private ProductService productService;
    @Autowired
    private DynamicSqlService dynamicSqlService;
    @Autowired
    private UserService userService;
    @Value("${uploadImgPath}")
	private String uploadImgPath;

    /**
     * 首页推荐二手商品
     * @param type
     * @param cityName
     * @return
     */
    @RequestMapping("/index")
    public R index(String type,String cityName){
    	if(StringUtils.isEmpty(type)) {
    		return R.error("type不能为空");
    	}
    	String sql="";
    	
        if ("0".equals(type)) {//新鲜
			sql="SELECT u.headpic_path as userHeadpic,u.nickname,p.name,p.introduction,p.price,p.hits,p.productImage,p.createDate from shop_product p,tb_user u where p.type=1 AND p.isMarketable=1 AND p.objectId=u.user_id ORDER BY p.createDate desc LIMIT 10";
		}else if("1".equals(type)){//同城
			if(StringUtils.isEmpty(cityName)) {
				return R.error("cityName不能为空");
			}
			sql="SELECT u.headpic_path as userHeadpic,u.nickname,p.name,p.introduction,p.price,p.hits,p.productImage,p.createDate from shop_product p,tb_user u where p.type=1 AND p.isMarketable=1 AND p.objectId=u.user_id AND p.cityName=\'"+cityName+"\' LIMIT 10";
		}else if("2".equals(type)){//正品
			
		}else {
			return R.error("type类型错误");
		}
        List<Map<String, Object>> list = dynamicSqlService.selectSql(sql);
        return R.ok().put("list", list);
    }

    /*
     * 我发布的商品
     */
    @RequestMapping("/pubList")
    public R mylist(String userId){
    	if (StringUtils.isEmpty(userId)) {
			return R.error(1, "必传参数为空");
		}
		Wrapper<ProductEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("id,name,image,price,unit,caption,introduction,memo,productImage,labels,parameterValue,hits,commentNum,collectNum,isMarketable");
    	wrapper.eq("objectId", userId);
    	wrapper.eq("type", 1);
    	List<Map<String, Object>> list = productService.selectMaps(wrapper);
        return R.ok().put("list",list);
    }
    
    /*
     * 我售出的商品
     */
    @RequestMapping("/mySoldList")
    public R mySoldList(){
    	UserEntity user = getUser();
		if (user == null) {
			return R.error(10, "用户未登录");
		}
		Wrapper<ProductEntity> wrapper = new EntityWrapper<>();
    	wrapper.setSqlSelect("id,name,image,price,unit,caption,introduction,memo,productImage,labels,parameterValue,hits,commentNum,collectNum,isMarketable");
    	wrapper.eq("objectId", user.getUserId());
    	wrapper.eq("type", 1);
    	wrapper.eq("isMarketable", 0);
    	List<Map<String, Object>> list = productService.selectMaps(wrapper);
        return R.ok().put("list",list);
    }
    

    /**
     * 保存
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping("/save")
    public R save(ProductEntity product,String userId,@RequestParam("files") MultipartFile[] files) throws IllegalStateException, IOException{
    	
    	if(ValidateUtils.isContainEmpty(userId,product.getName(),product.getIntroduction())) {
    		return R.error(1,"必传参数为空");
    	}
    	UserEntity user = userService.selectById(userId);
    	if(user==null) {
    		return R.error(1,"用户不存在");
    	}
    	/*//处理图片
    	JSONArray imgsJson = new JSONArray();
    	for(MultipartFile file:files) {
    		imgsJson.add(uploadFile(file));
    	}*/
    	//传64位的图片数据
    	/*if(StringUtils.isEmpty(product.getResources())) {
    		product.setProductimage("[]");
		}else {
			JSONArray imgsArr = JSON.parseArray(product.getResources());
			System.out.println(product.getResources());
			JSONArray imgsJson = new JSONArray();
			for(Object object:imgsArr) {
				String o =(String) object;
				String path = getSession().getServletContext().getRealPath("upload")+"/";
				MultipartFile file1 = FileUtil.base64ToMultipart(o);
				String filename = file1.getOriginalFilename();
				String newFileName = UUID.randomUUID().toString().replace("-", "");// 文件名
				String suffix = filename.substring(filename.lastIndexOf("."));//后缀
				newFileName=newFileName+suffix;
				// 在要上传的路径下用图片的名称新建一个file
				logger.info("文件存储的路径"+path+newFileName);
				File file = new File(path+newFileName);
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				file1.transferTo(file);
				logger.info("文件访问的路径"+uploadImgPath+newFileName);
				imgsJson.add(uploadImgPath+newFileName);
			}
			//设置图片
	    	product.setImage(imgsJson.getString(0));
	    	product.setProductimage(imgsJson.toJSONString());
		}*/
    	
    	
    	product.setType("1");//二手商品
    	product.setIsmarketable(true);
    	product.setObjectid(user.getUserId());
    	product.setCreatedate(new Date());
    	product.setModifydate(new Date());
		productService.insert(product);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProductEntity product){
			productService.updateById(product);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] ids){
			productService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    public String uploadFile(MultipartFile file1){
    	String path = getSession().getServletContext().getRealPath("upload")+"/";
    	String filename = file1.getOriginalFilename();
		String newFileName = UUID.randomUUID().toString().replace("-", "");// 文件名
		String suffix = filename.substring(filename.lastIndexOf("."));//后缀
		newFileName=newFileName+suffix;
		// 在要上传的路径下用图片的名称新建一个file
		logger.info("文件存储的路径"+path+newFileName);
		File file = new File(path+newFileName);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file1.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return null;
		}
		logger.info("文件访问的路径"+uploadImgPath+newFileName);
    	return uploadImgPath+newFileName;
    }
}
