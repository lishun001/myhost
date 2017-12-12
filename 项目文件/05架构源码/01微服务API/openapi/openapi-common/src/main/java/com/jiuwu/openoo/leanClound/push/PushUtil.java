package com.jiuwu.openoo.leanClound.push;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.context.MessageSource;
import org.xml.sax.InputSource;

import com.jiuwu.openoo.common.openapi.utils.MessageConstant.GET_USERCODE;

/* *
 *类名:PushUtil
 *功能:leanClound消息推送
 */

public class PushUtil {
	/**
	 * 无法注入
	 */
	private static MessageSource ms;
	/**消息标题*/
	public static String message_titile = "系统消息";
	/**消息类型*/
	public static String message_type_order = "0";
	//支付消息
	public static String message_type_pay = "1";
	
	public static final String chat_log = "chat_log";
		
	private final static Log log = LogFactory.getLog(PushUtil.class);
	/**
	 * 返回配置文件参数的值
	 */
	private static String getText(String code) {
		// 返回获取的地址
		return ms.getMessage(code, null, null);
	}
	
	/**
	 * @description 推送给指定用户
	 * @param message 用户消息
	 * @param userId 用户Id
	 * @param userType 用户类型
	 * @param messageTitle 标题
	 * @param url 跳转的url
	 * @param noticeId 通知Id
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2014-12-15
	 */
	public static boolean pushToUser(String message, Integer userId, MessageSource messageSource, String userType, String messageTitle, String url, Integer noticeId, String orderId,int num){
		log.info("推送给指定用户！");
		if(userId == null || StringUtils.isBlank(message)){
			log.error("消息或用户Id为空");
			return false;
		}
		//消息源
		if(messageSource != null){
			ms = messageSource;   
		}else{
			log.error("messageSource不能为空！");
			return false;
		}

		try{
			//消息体
			JSONObject pushMessage = new JSONObject();
			JSONObject data = new JSONObject();
			//ios
			JSONObject ios = new JSONObject();
			//消息内容
			ios.put("alert", message);
			//未读消息数目，应用图标边上的小红点数字，可以是数字，也可以设置为Increment字符
			ios.put("badge", 1);
			//声音文件名，前提在应用里存在
			ios.put("sound", "");
			//如果你在使用Newsstand, 设置为1来开始一次后台下载
			//ios.put("content-available", "");
			//跳转的
			ios.put("url", url);
			//订单号
			ios.put("noticeId", noticeId);
			
			ios.put("orderId", orderId);
			
			ios.put("number", num);
			
			//android
			JSONObject android = new JSONObject();
			//消息内容
			android.put("alert", message);
			//显示在通知栏的标题
			android.put("title", messageTitle);
			//安卓自定义
			android.put("action", "com.avos.JOB_MESSAGES");
			//跳转的
			android.put("url", url);
			//通知Id
			android.put("noticeId", noticeId);
			//订单号
			android.put("orderId", orderId);
			//未读消息的数量
			android.put("number", num);
		
			data.put("ios", ios);
			data.put("android", android);
			
			
			//条件--指定用户
			JSONObject where = new JSONObject();
			where.put("userId", userId +"");
			pushMessage.put("where", where);
			pushMessage.put("data", data);
			//发送消息
			return push(pushMessage.toString(), userType);
		}catch(Exception e){
			log.error("推送用户【" + userId + "】异常",e);
			return false;
		}
	}
	
	
	/**
	 * @description 通知数给指定用户
	 * @param message 用户消息
	 * @param userId 用户Id
	 * @param userType 用户类型
	 * @param messageTitle 标题
	 * @param url 跳转的url
	 * @param noticeId 通知Id
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2014-12-15
	 */
	public static boolean pushToUser(String message, Integer userId, MessageSource messageSource, String userType){
		log.info("推送给指定用户！");
		if(userId == null || StringUtils.isBlank(message)){
			log.error("消息或用户Id为空");
			return false;
		}
		//消息源
		if(messageSource != null){
			ms = messageSource;   
		}else{
			log.error("messageSource不能为空！");
			return false;
		}

		try{
			//消息体
			JSONObject pushMessage = new JSONObject();
			JSONObject data = new JSONObject();
			//ios
			JSONObject ios = new JSONObject();
			//消息内容
			ios.put("alert", message);
			//未读消息数目，应用图标边上的小红点数字，可以是数字，也可以设置为Increment字符
			ios.put("badge", 1);
			//声音文件名，前提在应用里存在
			ios.put("sound", "");
			//如果你在使用Newsstand, 设置为1来开始一次后台下载
			//ios.put("content-available", "");
			
			
			//android
			JSONObject android = new JSONObject();
			//消息内容
			android.put("alert", message);
			//显示在通知栏的标题
			android.put("title", "");
			//安卓自定义
			android.put("action", "com.avos.AGENT_MESSAGES");
			
		
			data.put("ios", ios);
			data.put("android", android);
			
			
			//条件--指定用户
			JSONObject where = new JSONObject();
			where.put("userId", userId +"");
			pushMessage.put("where", where);
			pushMessage.put("data", data);
			//发送消息
			return push(pushMessage.toString(), userType);
		}catch(Exception e){
			log.error("推送用户【" + userId + "】异常",e);
			return false;
		}
	}
	
	
	/**
	 * 推送未读消息的数量
	 * @author xiaoyong
	 * @date 2014-01-20
	 */
	public static boolean pushUnreadNum(String message, Integer userId, MessageSource messageSource, String userType){
		log.info("推送给指定用户！");
		if(userId == null || StringUtils.isBlank(message)){
			log.error("消息或用户Id为空");
			return false;
		}
		//消息源
		if(messageSource != null){
			ms = messageSource;   
		}else{
			log.error("messageSource不能为空！");
			return false;
		}

		try{
			//消息体
			JSONObject pushMessage = new JSONObject();
			JSONObject data = new JSONObject();
			//ios
			JSONObject ios = new JSONObject();
			//消息内容
			ios.put("alert", message);
			//未读消息数目，应用图标边上的小红点数字，可以是数字，也可以设置为Increment字符
			ios.put("badge", 1);
			//声音文件名，前提在应用里存在
			ios.put("sound", "");
			
			//android
			JSONObject android = new JSONObject();
			//消息内容
			android.put("alert", message);
			//安卓自定义
			android.put("action", "com.avos.JOB_MESSAGES_CHANGE");
		
			data.put("ios", ios);
			data.put("android", android);
			
			
			//条件--指定用户
			JSONObject where = new JSONObject();
			where.put("userId", userId +"");
			pushMessage.put("where", where);
			pushMessage.put("data", data);
			//发送消息
			return push(pushMessage.toString(), userType);
		}catch(Exception e){
			log.error("推送用户【" + userId + "】异常",e);
			return false;
		}
	}
	
	/**
	 * @description 推送给用户组
	 * @param message 用户消息
	 * @param userIdList 用户组
	 * @param userType 标记为大博，还是圈圈用户
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2014-12-15
	 */
	public static boolean pushToUserList(String message, List<Integer> userIdList,String userType, MessageSource messageSource){
		log.info("推送给所有用户！");
		//消息源
		if(messageSource != null){
			ms = messageSource;
		}else{
			log.error("messageSource不能为空！");
			return false;
		}
		if( StringUtils.isBlank(message)){
			log.error("消息为空");
			return false;
		}
		if(userIdList != null && userIdList.size() > 1){
			try{
				//消息体
				JSONObject pushMessage = new JSONObject();
				JSONObject data = new JSONObject();
				//ios
				JSONObject ios = new JSONObject();
				//消息内容
				ios.put("alert", message);
				//未读消息数目，应用图标边上的小红点数字，可以是数字，也可以设置为Increment字符
				ios.put("badge", 1);
				//声音文件名，前提在应用里存在
				ios.put("sound", "");
				//如果你在使用Newsstand, 设置为1来开始一次后台下载
				//ios.put("content-available", "");
				
				//android
				JSONObject android = new JSONObject();
				//消息内容
				android.put("alert", message);
				//显示在通知栏的标题
				android.put("title", "零工订单通知");
				//安卓自定义
				android.put("action", "com.avos.JOB_MESSAGES");
			
				data.put("ios", ios);
				data.put("android", android);
				pushMessage.put("data", data);
				StringBuffer userIdBuffer = new StringBuffer().append(userIdList.get(0));
				for(int index = 1; index < userIdList.size(); index++){
					userIdBuffer.append(",").append(userIdList.get(index));
				}
				pushMessage.put("cql", "select * from _Installation where userId in (" + userIdBuffer.toString() + ")");
				log.info("select * from _Installation where userId in (" + userIdBuffer.toString() + ")");
				//发送消息
				return push(pushMessage.toString(), userType);
			}catch(Exception e){
				log.error("推送所用用户异常",e);
				return false;
			}
		}else{
			log.error("用户Id组为空");
			return false;
		}
	}
	
	public static boolean push(String message, Integer userType,  MessageSource messageSource) throws Exception{
		if(messageSource != null){
			ms = messageSource;
		}
		return push(message, String.valueOf(userType));
	}
	
	
	/**
	 * @description 推送基础类型
	 * @param message 推送的内容json
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2014-12-15
	 */
	public static boolean push(String message, String userType) throws Exception{
		log.info("开始推送消息！！！");
		if(StringUtils.isBlank(message)){
			log.error("消息体不能为空");
			return false;
		}
		try {
		    HttpClient client = new HttpClient(); 
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);   
			PostMethod post = new PostMethod(getText("push_url")); 
			
			String appId = getText("app_id" + userType);
			String appkey = getText("app_key" + userType);
			
			//设置http request头 
			List<Header> headers = new ArrayList<Header>();
			headers.add(new Header("Content-Type", "application/json"));
			headers.add(new Header("X-AVOSCloud-Application-Id",appId));
			//时间戳
			long time = System.currentTimeMillis();
			String key = time + appkey;
			String sign = Md5Util.makeMd5Sum(key.getBytes()) + "," + time;
			headers.add(new Header("x-avoscloud-request-sign", sign));
			client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
			//client.getHostConfiguration().getParams().setParameter("http.headers", headers);
			post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			RequestEntity entity = null;
			entity = new StringRequestEntity(message, "application/json", "UTF-8");
			//设置消息体
			post.setRequestEntity(entity);
			 //执行postMethod  
			int statusCode = client.executeMethod(post);  
			 if (statusCode != HttpStatus.SC_OK){  
				 log.error("发送失败，发送状态: "+ post.getStatusLine());
				 byte[] responseBody = post.getResponseBody();  
					// （7） 处理内容  
					//System.out.println(headerStr);  
				 log.error(new String(responseBody));  
				 return false;
			 }  
			//读取内容  
			byte[] responseBody = post.getResponseBody();  
			// （7） 处理内容  
		    JSONObject  responseObj= new JSONObject(new String(responseBody));
		    String objectId = responseObj.getString("objectId");
		    if(StringUtils.isNotBlank(objectId)){
		    	 log.info("发送成功，objectId=" + objectId);
				return true;
		    }else{
		    	log.error("发送失败，objectId=" + objectId);
				return false;
		    }
		} catch (IOException e) {
			log.error("发送消息异常！！！", e);
			throw e;
		}
  }
	
	
	/**
	 * @description 创建对象
	 * @param message 对象的内容
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2015-03-30
	 */
	public static String addData(String message, String objcetId, Integer userType, String className, MessageSource messageSource) throws Exception{
		log.info("添加对象！！！");
		if(messageSource != null){
			ms = messageSource;
		}else{
			log.error("messageSource不能为空！");
			return null;
		}
		if(StringUtils.isBlank(message)){
			log.error("消息体不能为空");
			return null;
		}
		try {
		    HttpClient client = new HttpClient(); 
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);   
			
			PostMethod post = new PostMethod(getText("avos_class") + className); 
			
			String appId = getText("app_id" + userType);
			String appkey = getText("app_key" + userType);
			
			//设置http request头 
			List<Header> headers = new ArrayList<Header>();
			headers.add(new Header("Content-Type", "application/json"));
			headers.add(new Header("X-AVOSCloud-Application-Id",appId));
			//时间戳
			long time = System.currentTimeMillis();
			String key = time + appkey;
			String sign = Md5Util.makeMd5Sum(key.getBytes()) + "," + time;
			headers.add(new Header("x-avoscloud-request-sign", sign));
			client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
			//client.getHostConfiguration().getParams().setParameter("http.headers", headers);
			post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			RequestEntity entity = null;
			entity = new StringRequestEntity(message, "application/json", "UTF-8");
			//设置消息体
			post.setRequestEntity(entity);
			 //执行postMethod  
			int statusCode = client.executeMethod(post);
			//读取内容  
			byte[] responseBody = post.getResponseBody();  
			log.error(new String(responseBody)); 
			// （7） 处理内容  
		    JSONObject  responseObj= new JSONObject(new String(responseBody));
			if (statusCode != HttpStatus.SC_CREATED){  
				log.error("添加失败，发送状态: "+ post.getStatusLine());
				//对象已经存在
				return objcetId;
			}  
			
			
		    String objectId = responseObj.getString("objectId");
		    if(StringUtils.isNotBlank(objectId)){
		    	 log.info("添加成功，objectId=" + objectId);
				return objectId;
		    }
		} catch (IOException e) {
			log.error("添加对象消息异常！！！", e);
			throw e;
		}
		return null;
  }
	
	
	/**
	 * @description 创建对象
	 * @param message 发送消息
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2015-03-30
	 */
	public static boolean sendData(String message, Integer userType, MessageSource messageSource) throws Exception{
		log.info("发送消息！！！");
		if(messageSource != null){
			ms = messageSource;
		}else{
			log.error("messageSource不能为空！");
			return false;
		}
		if(StringUtils.isBlank(message)){
			log.error("消息体不能为空");
			return false;
		}
		try {
		    HttpClient client = new HttpClient(); 
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);   
			
			PostMethod post = new PostMethod(getText("chat_send")); 
			
			String appId = getText("app_id" + userType);
			String appkey = getText("app_Master_Key");
			
			//设置http request头 
			List<Header> headers = new ArrayList<Header>();
			headers.add(new Header("Content-Type", "application/json"));
			headers.add(new Header("X-AVOSCloud-Application-Id",appId));
			//主钥key
			headers.add(new Header("X-AVOSCloud-Master-Key",appkey));
			//时间戳
			/*long time = System.currentTimeMillis();
			String key = time + appkey;
			String sign = Md5Util.makeMd5Sum(key.getBytes()) + "," + time;
			headers.add(new Header("x-avoscloud-request-sign", sign));*/
			client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
			//client.getHostConfiguration().getParams().setParameter("http.headers", headers);
			post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			RequestEntity entity = null;
			entity = new StringRequestEntity(message, "application/json", "UTF-8");
			//设置消息体
			post.setRequestEntity(entity);
			 //执行postMethod  
			int statusCode = client.executeMethod(post);  
			//读取内容  
			 byte[] responseBody = post.getResponseBody();  
			 if (statusCode != HttpStatus.SC_OK){  
				 log.error("添加失败，发送状态: "+ post.getStatusLine());
				
					// （7） 处理内容  
					//System.out.println(headerStr);  
				 log.error(new String(responseBody));  
				 return false;
			 }  
			// （7） 处理内容  
		    JSONObject  responseObj= new JSONObject(new String(responseBody));
		    
		    log.info(responseObj.toString());
		    
		    return true;
		} catch (IOException e) {
			log.error("添加对象消息异常！！！", e);
			throw e;
		}
  }
	
	
	/**
	 * @description 更新对象
	 * @param message 对象的内容
	 * @param url GameScore/51e3a334e4b0b3eb44adbe1a
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2015-03-30
	 */
	public static boolean updateData(String message, Integer userType, String url, MessageSource messageSource) throws Exception{
		log.info("更新对象！！！");
		if(messageSource != null){
			ms = messageSource;
		}else{
			log.error("messageSource不能为空！");
			return false;
		}
		if(StringUtils.isBlank(message)){
			log.error("消息体不能为空");
			return false;
		}
		try {
		    HttpClient client = new HttpClient(); 
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);   
			
			PutMethod post = new PutMethod(getText("avos_class") + url); 
			
			String appId = getText("app_id" + userType);
			String appkey = getText("app_key" + userType);
			
			//设置http request头 
			List<Header> headers = new ArrayList<Header>();
			headers.add(new Header("Content-Type", "application/json"));
			headers.add(new Header("X-AVOSCloud-Application-Id",appId));
			//时间戳
			long time = System.currentTimeMillis();
			String key = time + appkey;
			String sign = Md5Util.makeMd5Sum(key.getBytes()) + "," + time;
			headers.add(new Header("x-avoscloud-request-sign", sign));
			client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
			//client.getHostConfiguration().getParams().setParameter("http.headers", headers);
			post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			RequestEntity entity = null;
			entity = new StringRequestEntity(message, "application/json", "UTF-8");
			//设置消息体
			post.setRequestEntity(entity);
			 //执行postMethod  
			int statusCode = client.executeMethod(post);  
			 if (statusCode != HttpStatus.SC_OK){  
				 log.error("更新失败，发送状态: "+ post.getStatusLine());
				 byte[] responseBody = post.getResponseBody();  
					// （7） 处理内容  
					//System.out.println(headerStr);  
				 log.error(new String(responseBody));  
				 return false;
			 }  
			//读取内容  
			byte[] responseBody = post.getResponseBody();  
			// （7） 处理内容  
		    JSONObject  responseObj= new JSONObject(new String(responseBody));
		    String updatedAt = responseObj.getString("updatedAt");
		    if(StringUtils.isNotBlank(updatedAt)){
		    	 log.info("更新成功，updatedAt=" + updatedAt);
				return true;
		    }else{
		    	log.error("更新失败");
				return false;
		    }
		} catch (IOException e) {
			log.error("更新对象异常！！！", e);
			throw e;
		}
  }
	
	/**
	 * @description 删除对象
	 * @param message 对象的内容
	 * @param url GameScore/51e3a334e4b0b3eb44adbe1a
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2015-03-30
	 */
	public static boolean deleteData(Integer userType, String url, MessageSource messageSource) throws Exception{
		log.info("删除对象！！！");
		if(messageSource != null){
			ms = messageSource;
		}
		try {
		    HttpClient client = new HttpClient(); 
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);   
			
			DeleteMethod post = new DeleteMethod(getText("avos_class") + url); 
			
			String appId = getText("app_id" + userType);
			String appkey = getText("app_key" + userType);
			
			//设置http request头 
			List<Header> headers = new ArrayList<Header>();
			headers.add(new Header("Content-Type", "application/json"));
			headers.add(new Header("X-AVOSCloud-Application-Id",appId));
			//时间戳
			long time = System.currentTimeMillis();
			String key = time + appkey;
			String sign = Md5Util.makeMd5Sum(key.getBytes()) + "," + time;
			headers.add(new Header("x-avoscloud-request-sign", sign));
			client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
			//client.getHostConfiguration().getParams().setParameter("http.headers", headers);
			post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			
			 //执行postMethod  
			int statusCode = client.executeMethod(post);  
			 if (statusCode != HttpStatus.SC_OK){ 
				 log.error("删除失败，发送状态: "+ post.getStatusLine());
				 byte[] responseBody = post.getResponseBody();  
					// （7） 处理内容  
					//System.out.println(headerStr);  
				 log.error(new String(responseBody));  
				 return false;
			 }else{ 
		    	log.info("删除成功");
				return true;
			 }
		  
		} catch (IOException e) {
			log.error("更新对象异常！！！", e);
			throw e;
		}
  }
	
	
	/**
	 * @description 查询结果
	 * @param message 对象的内容
	 * @param url GameScore/51e3a334e4b0b3eb44adbe1a
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2015-03-30
	 */
	public static JSONObject getData(Map<String,String> paramMap, Integer userType, String url, MessageSource messageSource) throws Exception{
		log.info("查询对象！！！");
		if(messageSource != null){
			ms = messageSource;
		}
		String message = "";
		if(paramMap != null){
			for(String key : paramMap.keySet()){
				message += key + "=" + URLEncoder.encode(paramMap.get(key), "UTF-8") +"&";
			}
		}
		try {
		    HttpClient client = new HttpClient(); 
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);   
			GetMethod post = new GetMethod(  getText("avos_class")  +  url + "?" + message);
			
			String appId = getText("app_id" + userType);
			String appkey = getText("app_key" + userType);
			//设置http request头 
			List<Header> headers = new ArrayList<Header>();
			headers.add(new Header("Content-Type", "application/json"));
			headers.add(new Header("X-AVOSCloud-Application-Id",appId));
			//时间戳
			long time = System.currentTimeMillis();
			String key = time + appkey;
			String sign = Md5Util.makeMd5Sum(key.getBytes()) + "," + time;
			headers.add(new Header("x-avoscloud-request-sign", sign));
			client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
			//client.getHostConfiguration().getParams().setParameter("http.headers", headers);
			post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			 //执行postMethod  
			int statusCode = client.executeMethod(post);  
			 if (statusCode != HttpStatus.SC_OK){ 
				 log.error("查询失败，发送状态: "+ post.getStatusLine());
				 byte[] responseBody = post.getResponseBody();  
					// （7） 处理内容  
					//System.out.println(headerStr);  
				 log.error(new String(responseBody)); 
				 return null;
			 }  
			//读取内容  
			byte[] responseBody = post.getResponseBody();  
			// （7） 处理内容  
		   JSONObject  responseObj= new JSONObject(new String(responseBody));
		   return responseObj;
		} catch (IOException e) {
			log.error("查询对象异常！！！", e);
			throw e;
		}
  }
	
	
	/**
	 * @description 获取聊天记录
	 * @param paramMap 参数
	 * @param url GameScore/51e3a334e4b0b3eb44adbe1a
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2015-03-30
	 */
	public static JSONArray getCharLog(Map<String,String> paramMap, Integer userType, MessageSource messageSource) throws Exception{
		log.info("获取聊天记录！");
		if(messageSource != null){
			ms = messageSource;
		}
		String message = "";
		if(paramMap != null){
			for(String key : paramMap.keySet()){
				message += key + "=" + URLEncoder.encode(paramMap.get(key), "UTF-8") +"&";
			}
		}
		try {
		    HttpClient client = new HttpClient(); 
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);   
			

			GetMethod post = new GetMethod(getText(chat_log)  + "?" + message);

			String appId = getText("app_id" + userType);
			String appkey = getText("app_key" + userType);
			
			//设置http request头 
			List<Header> headers = new ArrayList<Header>();
			headers.add(new Header("Content-Type", "application/json"));
			headers.add(new Header("X-AVOSCloud-Application-Id",appId));
			//时间戳
			long time = System.currentTimeMillis();
			String key = time + appkey;
			String sign = Md5Util.makeMd5Sum(key.getBytes()) + "," + time;
			headers.add(new Header("x-avoscloud-request-sign", sign));
			client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
			//client.getHostConfiguration().getParams().setParameter("http.headers", headers);
			post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			 //执行postMethod  
			int statusCode = client.executeMethod(post);  
			 if (statusCode != HttpStatus.SC_OK){ 
				 log.error("查询失败，发送状态: "+ post.getStatusLine());
				 byte[] responseBody = post.getResponseBody();  
					// （7） 处理内容  
					//System.out.println(headerStr);  
				 log.error(new String(responseBody)); 
				 return null;
			 }  
			//读取内容  
			byte[] responseBody = post.getResponseBody();  
			// （7） 处理内容  
		   JSONArray  responseObj= new JSONArray(new String(responseBody));
		   return responseObj;
		} catch (IOException e) {
			log.error("查询对象异常！！！", e);
			throw e;
		}
  }
	
	
	/**
	 * @description 查询结果
	 * @param message 对象的内容
	 * @param url GameScore/51e3a334e4b0b3eb44adbe1a
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2015-03-30
	 */
	public static JSONArray getBathData(String message, Integer userType , MessageSource messageSource) throws Exception{
		log.info("批量操作对象！！！");
		if(messageSource != null){
			ms = messageSource;
		}
		try {
		    HttpClient client = new HttpClient(); 
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
			Protocol.registerProtocol("https", myhttps);   
			
			PostMethod post = new PostMethod(getText("avos_class_bath")); 
			
			String appId = getText("app_id" + userType);
			String appkey = getText("app_key" + userType);
			
			//设置http request头 
			List<Header> headers = new ArrayList<Header>();
			headers.add(new Header("Content-Type", "application/json"));
			headers.add(new Header("X-AVOSCloud-Application-Id",appId));
			//时间戳
			long time = System.currentTimeMillis();
			String key = time + appkey;
			String sign = Md5Util.makeMd5Sum(key.getBytes()) + "," + time;
			headers.add(new Header("x-avoscloud-request-sign", sign));
			client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
			//client.getHostConfiguration().getParams().setParameter("http.headers", headers);
			post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			RequestEntity entity = null;
			entity = new StringRequestEntity(message, "application/json", "UTF-8");
			//设置消息体
			post.setRequestEntity(entity);
			//执行postMethod  
			int statusCode = client.executeMethod(post);  
			 if (statusCode != HttpStatus.SC_OK){ 
				 log.error("批量操作失败，发送状态: "+ post.getStatusLine());
				 byte[] responseBody = post.getResponseBody();  
					// （7） 处理内容  
					//System.out.println(headerStr);  
				 log.error(new String(responseBody)); 
				 return null;
			 }  
			//读取内容  
			byte[] responseBody = post.getResponseBody();  
			// （7） 处理内容  
			JSONArray  responseObj= new JSONArray(new String(responseBody));
		   return responseObj;
		} catch (IOException e) {
			log.error("批量操作对象异常！！！", e);
			throw e;
		}
  }
	
	
	/**
	 * FunName:sendCode Description:发送验证码到手机
	 * 
	 * @param: 调用短信接口的url
	 * @return boolean
	 * @Create Date: 2014-7-22
	 * @Author:fengchao
	 */
	public static boolean sendCode(String url, MessageSource messageSource, Integer areaNo) {

		boolean flag = false;
		URL u;
		String isSend ="";
		try {
			isSend = messageSource.getMessage("isDevelop", null, null);
			if(isSend.equals("Yes")){
			u = new URL(url);
			BufferedReader buffered = new BufferedReader(new InputStreamReader(u.openStream()));
			String message = "" ;
			String line = "" ;
			switch (areaNo) {
				case 852:
					int index = 0;
					while((line = buffered.readLine())!=null){
								if(index++ > 0){
									message += line;
								}
					}
					break;
				default:
					message = buffered.readLine();
				break;
			}
			
			//如果有“<”，代表采用的是中舜的短信接口，返回的是xml字符串格式,需xml解析
			if(message.contains("<")){
			try {
				StringReader xmlReader = new StringReader(message);  
				InputSource xmlSource = new InputSource(xmlReader);
				SAXBuilder builder = new SAXBuilder();  
			    Document doc = builder.build(xmlSource);  
			    Element elt = doc.getRootElement();
			    switch (areaNo) {
					case 852:
						elt = elt.getChild("msg").getChild("msg_status");
						line = elt.getText();
					break;
					default:
						 line = elt.getText();
					break;
			    }
			   
			} catch (Exception e) {
				log.error("返回短信发送状态时解析xml错误",e);
			}
		 }else{
			 line = message.substring(0,2);
		 }
			 //如果发送成功，短信网关会返回0
			if (String.valueOf(GET_USERCODE.SEND_CODE_SUCCESS).equals(line)) {
				flag = true;
			}else if("0".equals(line)){
				flag = true;
			}else if(line.equals("100")){
				flag = true;
			}else{
				log.error(message);
			}
		  }else{
			  //是测试环境，则不发送短信
			  flag = true;
		  }
		} catch (IOException e) {
			 log.error("发送验证码异常",e);
		}
		return flag;
	}
	
	/**
	 * 发送文本验证码
	 */
	public static boolean sendTextCodeForKXTSmsSDK(String code, String phone, MessageSource messageSource){
//		log.info("发送文本验证码" + code);
//		if(messageSource != null){
//			ms = messageSource;
//		}
//		String address = "120.76.25.160";//远程地址：不带http://
//		int port = 7788;//远程端口
//		String account = "xxll";//账户
//		String token = "520620";//token
//		String mobile = phone;//发送手机号
//		String body = "【卓尔冷链】验证码："+code;//短信内容
//		int userId=186;//用户Id
//		KXTSmsSDK kxtsms = new KXTSmsSDK();
//		kxtsms.init(address, port, account, token,userId);
//		try{
//			body = URLEncoder.encode(body,"UTF-8");//URL编码 UTF-8方式
//			String result = kxtsms.send(mobile,body);
//			JAXBContext context = JAXBContext.newInstance(KXTSMSVo.class);  
//	        Unmarshaller unmarshaller = context.createUnmarshaller();  
//	        KXTSMSVo vo = (KXTSMSVo)unmarshaller.unmarshal(new StringReader(result));  
//	        System.out.println(vo.getReturnstatus());  
//	        System.out.println(vo.getSuccessCounts()); 
//	        if("Success".equals(vo.getReturnstatus())){
//	        	return true;
//	        }else{
//	        	log.error("错误码=" + vo.getReturnstatus() +" 错误信息= "+vo.getMessage());
//	        	return false;
//	        }
//		}catch (Exception e) {
//			log.error("发送验证码异常",e);
//		}
		return false;
	}
	
	/**
	 * 发送文本验证码
	 */
	public static boolean sendTextCode(String code, String phone, MessageSource messageSource){
		log.info("发送文本验证码" + code);
//		if(messageSource != null){
//			ms = messageSource;
//		}
//		HashMap<String, Object> result = null;
//		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
//		restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
//		restAPI.setAccount(getText("accountSid"), getText("accountToken"));// 初始化主帐号名称和主帐号令牌
//		restAPI.setAppId(getText("AppId"));// 初始化应用ID
//		long verifyTime = Long.parseLong(getText("verify_time"));
//		String verifyCount=verifyTime/60+"";
//		result = restAPI.sendTemplateSMS(phone,getText("templateId") ,new String[]{code,verifyCount});
//		if("000000".equals(result.get("statusCode"))){
//			//正常返回输出data包体信息（map）
//			@SuppressWarnings("unchecked")
//			HashMap<String, Object> hashMap = (HashMap<String, Object>) result.get("data");
//			HashMap<String,Object> data = hashMap;
//			Set<String> keySet = data.keySet();
//			for(String key:keySet){
//				Object object = data.get(key);
//				log.info(key +" = "+object);
//			}
//			return true;
//		}else{
//			//异常返回输出错误码和错误信息
//			log.error("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
//			return false;
//		}
		return true;
	}
	
	
	/**
	 * 发送语音验证码
	 */
//	public static boolean sendVoiceCode(String code, String phone, MessageSource messageSource){
//		log.info("发送语音验证码" + code);
//		if(messageSource != null){
//			ms = messageSource;
//		}
//		HashMap<String, Object> result = null;
//		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
//		restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
//		restAPI.setAccount(getText("accountSid"), getText("accountToken"));// 初始化主帐号名称和主帐号令牌
//		restAPI.setAppId(getText("AppId"));// 初始化应用ID
//		result = restAPI.voiceVerify(code, phone,getText("view_phone"),getText("play_count"),"");
//
//		result = restAPI.sendTemplateSMS("18672317241","1" ,new String[]{"6532","5"});
////		result = restAPI.voiceVerify("1234", "18672317241","18672317241",3,"");
//		if("000000".equals(result.get("statusCode"))){
//			//正常返回输出data包体信息（map）
//			@SuppressWarnings("unchecked")
//			HashMap<String, Object> hashMap = (HashMap<String, Object>) result.get("data");
//			HashMap<String,Object> data = hashMap;
//			Set<String> keySet = data.keySet();
//			for(String key:keySet){
//				Object object = data.get(key);
//				log.info(key +" = "+object);
//			}
//			return true;
//		}else{
//			//异常返回输出错误码和错误信息
//			log.error("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
//			return false;
//		}
//		
//	}
	
}
