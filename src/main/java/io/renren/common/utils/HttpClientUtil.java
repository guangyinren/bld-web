package io.renren.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * HttpClient4.3工具类
 * 
 * @date 2018-05-22
 * 
 */
public class HttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class); // 日志记录
	private static RequestConfig requestConfig = null;
	//HTTP请求和响应的默认编码
	private static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * post请求传输String参数 例如：name=Jack&sex=1&type=2
	 * Content-type:application/x-www-form-urlencoded
	 * 
	 * @param url
	 *            url地址
	 * @param strParam
	 *            参数
	 * @param noNeedResponse
	 *            不需要返回结果
	 * @return
	 */
	public static JSONObject httpPostJson(String url, String strParam) {
		// post请求返回结果
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpPost httpPost = new HttpPost(url);
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
		httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
		// httpPost.setConfig(requestConfig);
		try {
			if (null != strParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(strParam, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/x-www-form-urlencoded");
				httpPost.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(httpPost);
			// 请求发送成功，并得到响应
			if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String str = "";
				try {
					// 读取服务器返回过来的json字符串数据
					str = EntityUtils.toString(result.getEntity(), "utf-8");
					// 把json字符串转换成json对象
					jsonResult = JSONObject.parseObject(str);
				} catch (Exception e) {
					logger.error("post请求提交失败:" + url, e);
				}
			}
		} catch (IOException e) {
			logger.error("post请求提交失败:" + url, e);
		} finally {
			httpPost.releaseConnection();
		}
		return jsonResult;
	}

	/**
	 * post请求传输String参数 例如：name=Jack&sex=1&type=2
	 * Content-type:application/x-www-form-urlencoded
	 * 
	 * @param url
	 *            url地址
	 * @param strParam
	 *            参数
	 * @param noNeedResponse
	 *            不需要返回结果
	 * @return
	 */
	public static String httpPostXml(String url, String strParam) {
		// post请求返回结果
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String xml = null;
		HttpPost httpPost = new HttpPost(url);
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
		httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
		// httpPost.setConfig(requestConfig);
		try {
			if (null != strParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(strParam, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/x-www-form-urlencoded");
				httpPost.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(httpPost);
			// 请求发送成功，并得到响应
			if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				try {
					// 读取服务器返回过来的xml
					xml = EntityUtils.toString(result.getEntity(), "utf-8");
				} catch (Exception e) {
					logger.error("post请求提交失败:" + url, e);
				}
			}
		} catch (IOException e) {
			logger.error("post请求提交失败:" + url, e);
		} finally {
			httpPost.releaseConnection();
		}
		return xml;
	}
	 /**
     * 
     * @description 通过HTTP协议向服务器段发送请求,并得到返回结果，可指定数据编码。
     * @param serviceUrl  	服务器地址
     * @param pMap			请求的键值对入参
     * @return String		返回数据
     */
	@SuppressWarnings({ "resource", "deprecation" })
	public static String post(String serviceUrl,Map<String,String> pMap,String charset){
    	HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(serviceUrl);
		try {
			String result = null ;
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            for (Map.Entry<String, String> entry : pMap.entrySet()) {
            	  nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps,charset));
            /*调用阿里云邮件推送服务,访问方式为post时,需要
             * 修改请求头Content-Type: application/x-www-form-urlencoded*/
//            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
            httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);
            httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 3000);
			HttpResponse response = httpclient.execute(httpPost) ;
			HttpEntity entity = response.getEntity();
			if(200 == response.getStatusLine().getStatusCode()){
				result = EntityUtils.toString(entity,charset).trim();
				logger.info("服务器请求成功,返回结果:{}",result);
			}else{
				logger.error("服务器请求失败,失败HTTP状态码:{}",response.getStatusLine().getStatusCode());
			}
			return result ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			httpclient.getConnectionManager().shutdown();
		}
		return null;
    }

	public static String readData(HttpServletRequest request) {
		BufferedReader br = null;
		try {
			StringBuilder ret;
			br = request.getReader();
			
			String line = br.readLine();
			if (line != null) {
				ret = new StringBuilder();
				ret.append(line);
			} else {
				return "";
			}
			
			while ((line = br.readLine()) != null) {
				ret.append('\n').append(line);
			}
			
			return ret.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (br != null) {
				try {br.close();} catch (IOException e) {e.printStackTrace();;}
			}
		}
	}
	
}