package com.jiuwu.openoo.leanClound.push;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.MessageSource;

/**
 * 类名:BaiDuMapUtil 功能:BaiDuMapUtil 调用百度
 * 
 * @author xiaoyong
 * @createDate 2015-02-27
 */
public class BaiDuMapUtil {
	
	/**
	 * 无法注入
	 */
	private static MessageSource ms;
	
	private static final String BAIDU_MAP_URL="http://api.map.baidu.com";
		
	private final static Log log = LogFactory.getLog(BaiDuMapUtil.class);
	/**
	 * 返回配置文件参数的值
	 */
	private static String getText(String code) {
		// 返回获取的地址
		return ms.getMessage(code, null, null);
	}
	
	/**
	 * 地址获取经纬度
	 * @param address 服务地址 必须
	 * @param city 所在城市 可选
	 * @return
	 */
	public static String getLatLog(String address, String city, MessageSource messageSource) throws Exception{
		ms = messageSource;
		//请求地址
		String url = getText("Geocoding_url");
		//请求参数
		Map<String,String> paramsMap = new LinkedHashMap<String, String>();
		paramsMap.put("address", address);
		paramsMap.put("ak", getText("baidumap_ak"));
		if(StringUtils.isNotBlank(city)){
			paramsMap.put("city", city);
		}
		paramsMap.put("output", "json");
		
		String paramsStr = toQueryString(paramsMap);
		
		String wholeStr = new String(url + "?" + paramsStr + getText("baidumap_sk"));
		// 对上面wholeStr再作utf8编码
		String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
		
		url = BAIDU_MAP_URL + url + "?" + paramsStr + "&sn=" + MD5(tempStr);
		//开始请求
		String resultJson =getBaiDuMap(url);
		JSONObject result =new JSONObject(resultJson);
		if(result.getInt("status") == 0){
			JSONObject location = result.getJSONObject("result").getJSONObject("location");
			return location.getString("lat") + "," + location.getString("lng");
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param origin		起点(地理位置|经纬度)		必须
	 * @param destination	终点(地址围栏|经纬度)		必须	
	 * @param city			城市						 必须
	 * @param messageSource
	 * http://developer.baidu.com/map/index.php?title=webapi/guide/webservice-geocoding
	 * @return
	 * @throws Exception
	 */
	public static Integer getDistance(String origin, String destination, String city,MessageSource messageSource) throws Exception{
		ms = messageSource;
		//请求地址
		String url = getText("Direction_url");
		//请求参数
		Map<String,String> paramsMap = new LinkedHashMap<String, String>();
		paramsMap.put("origin", origin);
		paramsMap.put("destination", destination);
		paramsMap.put("ak", getText("baidumap_ak"));
		paramsMap.put("output", "json");
		paramsMap.put("region", city);
		paramsMap.put("origin_region", city);
		paramsMap.put("destination_region", city);
		paramsMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
		
		
		String paramsStr = toQueryString(paramsMap);
		
		String wholeStr = new String(url + "?" + paramsStr + getText("baidumap_sk"));
		// 对上面wholeStr再作utf8编码
		String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
		
		url = BAIDU_MAP_URL + url + "?" + paramsStr + "&sn=" + MD5(tempStr);
		//开始请求
		String resultJson =getBaiDuMap(url);
		
		JSONObject result =new JSONObject(resultJson);
		if(result.getInt("type") == 2){
			return result.getJSONObject("result").getJSONArray("routes").getJSONObject(0).getInt("distance");
		}
		
		return null;
	}
	
	

	// 对Map内所有value作utf8编码，拼接返回结果
	private static String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
		StringBuffer queryString = new StringBuffer();
		for (Entry<?, ?> pair : data.entrySet()) {
			queryString.append(pair.getKey() + "=");
			queryString.append(URLEncoder.encode((String) pair.getValue(), "UTF-8") + "&");
		}
		if (queryString.length() > 0) {
			queryString.deleteCharAt(queryString.length() - 1);
		}
		return queryString.toString();
	}

	// 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
	private static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	
	/**
	 * @description 调用百度地图方法
	 * @param message 推送的内容json
	 * @return boolean true/false 成功/失败
	 * @author xiaoyong
	 * @createTime 2014-12-15
	 */
	private static String getBaiDuMap(String url) throws Exception{
		log.info("开始请求");
		try {
		    HttpClient client = new HttpClient(); 
			GetMethod get = new GetMethod(url);
			 //执行postMethod  
			int statusCode = client.executeMethod(get);  
			 if (statusCode != HttpStatus.SC_OK){  
				 log.error("发送失败，发送状态: "+ get.getStatusLine());
				 byte[] responseBody = get.getResponseBody();  
					// （7） 处理内容  
					//System.out.println(headerStr);  
				 log.error(new String(responseBody));  
				 return null;
			 }  
			//读取内容  
			byte[] responseBody = get.getResponseBody();  
			
		    return new String(responseBody);
		} catch (IOException e) {
			log.error("发送消息异常！！！", e);
			return null;
		}
  }

}
