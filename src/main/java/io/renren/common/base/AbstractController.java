package io.renren.common.base;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import io.renren.modules.app.entity.UserEntity;

/**
 * Controller公共组件
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}
	/*
	 * response对象
	 */
	public HttpServletResponse getResponse() {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getResponse();
		return response;
	}
	
	/**
	 * context对象
	 */
	public ServletContext getContext() {
		ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		return context;
	}
	
	
	
	/**
	 * 获取session
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
	public UserEntity getUser(){
		return (UserEntity) getSession().getAttribute("user");
	}
	
	public boolean isLogin(){
		return getSession().getAttribute("user")!=null;
	}
	
	public String uploadFile(MultipartFile file1,String serverUploadUrl){
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
		logger.info("文件访问的路径"+serverUploadUrl+newFileName);
    	return serverUploadUrl+newFileName;
    }
}
