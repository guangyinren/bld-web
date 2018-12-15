package io.renren.common.utils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.renren.common.exception.RRException;

public class HttpUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	//HTTP请求和响应的默认编码
	private static final String DEFAULT_CHARSET = "UTF-8";
    
	
	
	/**
     * 
     * @description 通过HTTP协议向服务器段发送GET请求,并得到响应结果，默认数据编码:UTF-8。
     * @param serviceUrl  	服务器地址
     */
    public static String get(String serviceUrl){
    	logger.info("服务器地址:{},编码格式:{}",serviceUrl,DEFAULT_CHARSET);
    	HttpClient httpclient = new DefaultHttpClient();
    	HttpGet httpGet = new HttpGet(serviceUrl);
		try {
			String result = null ;
			HttpResponse response = httpclient.execute(httpGet) ;
			HttpEntity entity = response.getEntity();
			if(200 == response.getStatusLine().getStatusCode()){
				result = EntityUtils.toString(entity,DEFAULT_CHARSET).trim();
				logger.info("服务器请求成功,返回结果:{}",result);
			}else{
				logger.error("服务器请求失败,失败HTTP状态码:{}",response.getStatusLine().getStatusCode());
			}
			return result ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RRException("请求参数不支持["+ DEFAULT_CHARSET +"]编码");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RRException("连接服务器失败");
		} finally{
			httpclient.getConnectionManager().shutdown();
		}
    }
    
	/**
     * 
     * @description 通过HTTP协议向服务器段发送请求,并得到响应结果，默认数据编码:UTF-8。
     * @param serviceUrl  	服务器地址
     * @param request		请求数据
     * @return String		返回数据
     */
    public static String post(String serviceUrl,String request){
    	logger.info("服务器地址:{},\r\n请求数据:\r\n{},编码格式:\r\n{}",serviceUrl,request,DEFAULT_CHARSET);
    	HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(serviceUrl);
		try {
			String result = null ;
			StringEntity stringEntity = new StringEntity(request, DEFAULT_CHARSET);
			httpPost.setEntity(stringEntity);
			HttpResponse response = httpclient.execute(httpPost) ;
			HttpEntity entity = response.getEntity();
			if(200 == response.getStatusLine().getStatusCode()){
				result = EntityUtils.toString(entity,DEFAULT_CHARSET).trim();
				logger.info("服务器请求成功,返回结果:{}",result);
			}else{
				logger.error("服务器请求失败,失败HTTP状态码:{}",response.getStatusLine().getStatusCode());
			}
			return result ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RRException("请求参数不支持["+ DEFAULT_CHARSET +"]编码");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RRException("连接服务器失败");
		} finally{
			httpclient.getConnectionManager().shutdown();
		}
    }
    
    /**
     * 
     * @description 通过HTTP协议向服务器段发送请求,并得到返回结果，可指定数据编码。
     * @param serviceUrl  	服务器地址
     * @param request		请求数据
     * @return String		返回数据
     */
    public static String post(String serviceUrl,String request,String charset){
    	logger.info("服务器地址:{},请求数据:{},编码格式:{}",serviceUrl,request,charset);
    	HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(serviceUrl);
		try {
			String result = null ;
			StringEntity stringEntity = new StringEntity(request, charset);
			httpPost.setEntity(stringEntity);
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
			throw new RRException("请求参数不支持["+ charset +"]编码");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RRException("连接服务器失败");
		} finally{
			httpclient.getConnectionManager().shutdown();
		}
    }
    
    /**
     * 
     * @description 通过HTTP协议向服务器段发送请求,并得到响应结果，默认字符集:UTF-8。
     * @param serviceUrl  	服务器地址
     * @param pMap			请求的键值对入参
     * @return String		返回数据
     */
    public static String post(String serviceUrl,Map<String,String> pMap){
    	HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(serviceUrl);
		try {
			String result = null ;
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            for (Map.Entry<String, String> entry : pMap.entrySet()) {
            	  nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps,DEFAULT_CHARSET));
			HttpResponse response = httpclient.execute(httpPost) ;
			HttpEntity entity = response.getEntity();
			if(200 == response.getStatusLine().getStatusCode()){
				result = EntityUtils.toString(entity,DEFAULT_CHARSET).trim();
				logger.info("服务器请求成功,返回结果:{}",result);
			}else{
				logger.error("服务器请求失败,失败HTTP状态码:{}",response.getStatusLine().getStatusCode());
			}
			return result ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RRException("请求参数不支持["+ DEFAULT_CHARSET +"]编码");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RRException("连接服务器失败");
		} finally{
			httpclient.getConnectionManager().shutdown();
		}
    }
    
    /**
     * 
     * @description 通过HTTP协议向服务器段发送请求,并得到返回结果，可指定数据编码。
     * @param serviceUrl  	服务器地址
     * @param pMap			请求的键值对入参
     * @return String		返回数据
     */
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
			throw new RRException("请求参数不支持["+ charset +"]编码");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RRException("连接服务器失败");
		} finally{
			httpclient.getConnectionManager().shutdown();
		}
    }
    
    
    /**
     * 
     * @description 通过HTTP协议向服务器段发送请求下载文件
     * @param serviceUrl  	服务器地址
     * @param pMap			请求的键值对入参
     * @param charset		请求参数的编码格式
     * @return byte[]		返回的文件流
     */
    public static byte[] download(String serviceUrl,Map<String,String> pMap,String charset){
    	HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(serviceUrl);
		InputStream is = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            for (Map.Entry<String, String> entry : pMap.entrySet()) {
            	  nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			HttpResponse response = httpclient.execute(httpPost) ;
			HttpEntity entity = response.getEntity();
			if(200 == response.getStatusLine().getStatusCode()){
				is = entity.getContent();
				byte[] b = new byte[8];
				int len ;
				while((len = is.read(b)) != -1){
					bos.write(b, 0, len);
				}
				return bos.toByteArray();
			}else{
				logger.error("服务器请求失败,失败HTTP状态码:{}",response.getStatusLine().getStatusCode());
				throw new RRException("服务器请求失败,失败HTTP状态码["+ response.getStatusLine().getStatusCode() +"]");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RRException("请求参数不支持["+ charset +"]编码");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RRException("连接服务器失败");
		} finally{
			httpclient.getConnectionManager().shutdown();
			if(null != bos){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != is){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
    }
    
    
    /**
     * 
     * @description 通过HTTP协议向服务器段发送请求,并得到返回结果，可指定数据编码。
     * @param serviceUrl  	服务器地址
     * @param request		请求数据 param1=value1&param2=value2
     * @return String		返回数据
     */
    public static String postStringAsForm(String serviceUrl,String request,String charset){
    	logger.info("服务器地址[{}],请求数据[{}],编码格式[{}]",serviceUrl,request,charset);
    	HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(serviceUrl);
		try {
			String result = null ;
			StringEntity stringEntity = new StringEntity(request,"application/x-www-form-urlencoded",charset);
			httpPost.setEntity(stringEntity);
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
			throw new RRException("请求参数不支持["+ charset +"]编码");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RRException("连接服务器失败");
		} finally{
			httpclient.getConnectionManager().shutdown();
		}
    
    }
    
    public static HttpClient getHttpClient() {
      	 DefaultHttpClient httpClient = new DefaultHttpClient();
      	 String proxyHost = "10.0.251.94";
      	 int proxyPort = 8080;
      	 String userName = "wuxue001";
      	 String password = "abcd123%";
      	 httpClient.getCredentialsProvider().setCredentials(
      	   new AuthScope(proxyHost, proxyPort),
      	   new UsernamePasswordCredentials(userName, password));
      	 HttpHost proxy = new HttpHost(proxyHost,proxyPort);
      	 httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
      	 return httpClient;
      }
    
//    public static void main(String[] args) {
//		System.out.println(get("http://10.0.63.42:8312/edocNo"));
//	}
}

