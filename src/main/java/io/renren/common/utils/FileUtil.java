package io.renren.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

import sun.misc.BASE64Decoder;

/**
 * 
 * @author niuzeliang
 *
 */
public class FileUtil {
	/**
	 * @功能描述:保存文件
	 */
	public static void saveFile(MultipartFile file, String path) throws IllegalStateException, IOException {
		FileUtil.createDir(path);
		file.transferTo(new File(path));
		/*
		 * String path =
		 * "D:/guanxiaobao/seerkey-iif-solution/seerkey-iif-web/src/main/webapp/static/backstage/displayPicture";
		 */
		//file.transferTo(new File(path));

	}

	/**
	 * @功能描述:删除文件
	 */
	public static void deleteFile(String path){
		//根据路径获取文件
		File file = new File(path);
		//判断该文件是否存在
		if(file.exists()){
			file.delete();
		}
	}

	/**
	 * @功能描述:创建文件夹
	 */
	public static void createDir(String path) {
		File file = new File(path);
		File parent = file.getParentFile();
		if (parent != null && !parent.exists()) {
			parent.mkdirs();
		}
	}



	public static String getWord(String path) throws Exception {
		String content = "";
		// 创建一个读取流对象和文件相关联
		File file = new File(path);
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "gbk");
		// 为了提高字符读取流效率，加入了缓冲技术
		// 只要将需要被提高效率的流对象作为参数传给缓冲区的构造函数。
		BufferedReader bufr = new BufferedReader(read);
		String line = null;
		while ((line = bufr.readLine()) != null) {
			// String
			// s=bufr.readLine();//读取一个文本行，包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回
			// null
			content += line;
		}
		bufr.close();
		return content;
	}

	/**
	 * base64图片转换
	 * @param base64
	 * @return
	 */
	public static MultipartFile base64ToMultipart(String base64) {
	    try {
	        String[] baseStrs = base64.split(",");

	        BASE64Decoder decoder = new BASE64Decoder();
	        byte[] b = new byte[0];
	        b = decoder.decodeBuffer(baseStrs[1]);

	        for(int i = 0; i < b.length; ++i) {
	            if (b[i] < 0) {
	                b[i] += 256;
	            }
	        }

	        return new BASE64DecodedMultipartFile(b, baseStrs[0]);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}

