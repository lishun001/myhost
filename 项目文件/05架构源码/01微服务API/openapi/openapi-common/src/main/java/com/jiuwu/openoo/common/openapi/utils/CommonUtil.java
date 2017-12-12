package com.jiuwu.openoo.common.openapi.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工具类
 * @author mazhengzheng
 *
 */
public class CommonUtil {
	private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);
	/**
	 * http请求
	 * @param requestUrl	url(如果含有中文、特殊字符等需要自己编码)
	 * @param method		请求方式(默认为GET)
	 * @param body			请求体(不需要编码)
	 * @param urlParam		url参数(不需要编码)
	 * @param charSet		编码(默认使用UTF-8)
	 * @param head			请求头
	 * @return				响应字符串
	 */
	public static String httpRequest(String requestUrl,String method,String body,
			Map<String, String> urlParam,String charSet,Map<String, String> head){
		HttpURLConnection httpUrlConn=null;
		OutputStream os=null;
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		
		charSet=charSet==null?"UTF-8":charSet;
		method=method==null?"GET":method.toUpperCase();
		requestUrl=getUrl(urlParam, requestUrl, charSet);
		
		try {
			URL url=new URL(requestUrl);
			httpUrlConn=(HttpURLConnection)url.openConnection();
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
		    httpUrlConn.setRequestMethod(method);
		    boolean isJson=false;
		    if(head!=null){
		    	for(String key:head.keySet()){
		    		if("Content-type".equalsIgnoreCase(key) && ("application/json".equalsIgnoreCase(head.get(key)) || "text/json".equalsIgnoreCase(head.get(key)))){
		    			isJson=true;
		    		}
		    		httpUrlConn.setRequestProperty(key, head.get(key));
		    	}
		    }
		    httpUrlConn.connect();
		    
		    if("POST".equals(method) && body!=null){
		    	if(!isJson){
		    		body=body.replaceAll("%", "%25");
		    	}
		    	os=httpUrlConn.getOutputStream();
		    	os.write(strToByte(body,charSet));
		    	os.flush();
		    }
		    
		    is=httpUrlConn.getInputStream();
		    isr=new InputStreamReader(is, charSet);
		    br=new BufferedReader(isr);
		    
		    StringBuilder sb=new StringBuilder();
		    String line=null;
		    while((line=br.readLine())!=null){
		    	sb.append(line);
		    }
		    
		    return sb.toString();
		} catch (MalformedURLException e) {
			log.error("",e);
		} catch (IOException e) {
			log.error("",e);
		} finally{
			try {
				if(os!=null){
					os.close();
				}
				if(br!=null){
					br.close();
				}
				if(isr!=null){
					isr.close();
				}
				if(is!=null){
					is.close();
				}
				if(httpUrlConn!=null){
					httpUrlConn.disconnect();
				}
			} catch (IOException e) {
				log.error("",e);
			}
		}
		
		return null;
	}
	
	
	public static String httpRequest(String requestUrl,String method,String body,
			Map<String, String> urlParam,String charSet,Map<String, String> head, int timeout){
		HttpURLConnection httpUrlConn=null;
		OutputStream os=null;
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		
		charSet=charSet==null?"UTF-8":charSet;
		method=method==null?"GET":method.toUpperCase();
		requestUrl=getUrl(urlParam, requestUrl, charSet);
		
		try {
			URL url=new URL(requestUrl);
			httpUrlConn=(HttpURLConnection)url.openConnection();
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
		    httpUrlConn.setRequestMethod(method);
		    httpUrlConn.setConnectTimeout(timeout);
		    boolean isJson=false;
		    if(head!=null){
		    	for(String key:head.keySet()){
		    		if("Content-type".equalsIgnoreCase(key) && ("application/json".equalsIgnoreCase(head.get(key)) || "text/json".equalsIgnoreCase(head.get(key)))){
		    			isJson=true;
		    		}
		    		httpUrlConn.setRequestProperty(key, head.get(key));
		    	}
		    }
		    httpUrlConn.connect();
		    
		    if("POST".equals(method) && body!=null){
		    	if(!isJson){
		    		body=body.replaceAll("%", "%25");
		    	}
		    	os=httpUrlConn.getOutputStream();
		    	os.write(strToByte(body,charSet));
		    	os.flush();
		    }
		    
		    is=httpUrlConn.getInputStream();
		    isr=new InputStreamReader(is, charSet);
		    br=new BufferedReader(isr);
		    
		    StringBuilder sb=new StringBuilder();
		    String line=null;
		    while((line=br.readLine())!=null){
		    	sb.append(line);
		    }
		    
		    return sb.toString();
		} catch (MalformedURLException e) {
			log.error("",e);
		} catch (IOException e) {
			log.error("",e);
		} finally{
			try {
				if(os!=null){
					os.close();
				}
				if(br!=null){
					br.close();
				}
				if(isr!=null){
					isr.close();
				}
				if(is!=null){
					is.close();
				}
				if(httpUrlConn!=null){
					httpUrlConn.disconnect();
				}
			} catch (IOException e) {
				log.error("",e);
			}
		}
		
		return null;
	}
	/**
	 * 字符串转换成字节
	 * @param str		待转换字符串
	 * @param charSet	编码(默认使用Java内部编码)
	 * @return
	 */
	public static byte[] strToByte(String... params){
		if(params==null || params.length==0 || params[0]==null){
			return null;
		}
		
		if(params.length==1 || params[1]==null){
			return params[0].getBytes();
		}
		
		try {
			return params[0].getBytes(params[1]);
		} catch (UnsupportedEncodingException e) {
			log.error("",e);
		}
		
		return null;
	}
	
	/**
	 * 获取url
	 * @param urlParam		url参数
	 * @param requestUrl	url
	 * @param charSet		编码(默认UTF-8)
	 * @return
	 */
	public static String getUrl(Map<String, String> urlParam,
			String... params){
		String requestUrl="";
		String charSet="UTF-8";
		if(params!=null){
			if(params.length>0 && params[0]!=null){
				requestUrl=params[0];
			}
			if(params.length>1 && params[1]!=null){
				charSet=params[1];
			}
		}
		
		if(urlParam!=null && !urlParam.isEmpty()){
			String urlEnd="";
			StringBuilder sb=new StringBuilder();
			
			int index=requestUrl.indexOf("#");
			if(index>=0){
				urlEnd=requestUrl.substring(index);
				requestUrl=requestUrl.substring(0, index);
			}
			
			sb.append(requestUrl);
			index=requestUrl.indexOf("?");
			if(index<0){
				sb.append("?");
			}else{
				if(requestUrl.charAt(requestUrl.length()-1)!='&' && 
						requestUrl.charAt(requestUrl.length()-1)!='?'){
					sb.append("&");
				}
			}
			
			try {
				for(String key:urlParam.keySet()){
					sb.append(URLEncoder.encode(key, charSet));
					sb.append("=");
					sb.append(URLEncoder.encode(urlParam.get(key), charSet));
					sb.append("&");
				}
			} catch (UnsupportedEncodingException e) {
				log.error("",e);
			}
			
			if(sb.charAt(sb.length()-1)=='&'){
				sb.deleteCharAt(sb.length()-1);
			}
			
			sb.append(urlEnd);
			
			return sb.toString();
		}
		
		return requestUrl;
	}
	
	public static void main(String[] args){
		httpRequest("http://localhost:8080/weixin/excel", "POST", "a=%哈&b=哈哈哈", null, "UTF-8", null);
	}
	/**
	 * @FunName:sendRequestToNet
	 * @Description:发送请求
	 * @param: Integer userId  用户id
	 *         Integer type    用户类型
	 *         String  appkey  
	 *         String  token   
	 *         String  bodyParam  post提交的参数
	 *         String  method     请求的方法名
	 * @return   结果集
	 * @Author:fengchao
	 * @Create Date: 2015-04-09
	 */
	public static String sendRequestToNet(Integer userId,Integer type,String appkey,String token,String bodyParam,String url){
		
		Map<String, String> head = new HashMap<String,String>();
		head.put("Authorization","Bearer "+token);
		head.put("ClientId",appkey);
    	head.put("content-type", "application/json");
    	//设置3秒超时
		String jsonString = CommonUtil.httpRequest(url,"POST",bodyParam,null,"UTF-8", head, 3000);
		return jsonString;
	}
	/**
	 * @FunName:sendRequestToNet
	 * @Description:发送请求
	 * @param: String  appkey  
	 *         String  token   
	 *         String  bodyParam  post提交的参数
	 *         String  method     请求的方法名
	 * @return   结果集
	 * @Author:fengchao
	 * @Create Date: 2015-04-09
	 */
	public static String sendRequestToNet(String appkey,String token,String bodyParam,String url){
		
		Map<String, String> head = new HashMap<String,String>();
		head.put("Authorization","Bearer "+token);
		head.put("ClientId",appkey);
    	head.put("content-type", "application/json");
		String jsonString = CommonUtil.httpRequest(url,"POST",bodyParam,null,"UTF-8", head);
		return jsonString;
	    
	}
	/**
	 * 发送请求
	 */
	public static String sendRequestToNet(String appkey,String token,String bodyParam, Map<String, String> urlParam,String url){
		
		Map<String, String> head = new HashMap<String,String>();
		head.put("Authorization","Bearer "+ token);
		head.put("ClientId",appkey);
    	head.put("content-type", "application/json");
		String jsonString = CommonUtil.httpRequest(url,"POST",bodyParam, urlParam, "UTF-8", head);
		return jsonString;
	    
	}
}

