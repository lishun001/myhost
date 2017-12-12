package com.jiuwu.openoo.openapi.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.context.MessageSource;

import com.jiuwu.openoo.common.openapi.FileItem;
import com.jiuwu.openoo.common.openapi.exception.OpenApiBaseException;
import com.jiuwu.openoo.common.openapi.json.JsonConfigFactory;
import com.jiuwu.openoo.common.openapi.response.Response;
import com.jiuwu.openoo.common.openapi.typeConvert.PropertyConverts;
import com.jiuwu.openoo.common.openapi.utils.MessageUtils;
import com.jiuwu.openoo.common.openapi.xml.XmlDateValueConverter;
import com.jiuwu.openoo.openapi.utils.OpenApiCommonConst.ERROR_MSG;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public final class OpenApiCommonUtil {

	private OpenApiCommonUtil() {
		
	}
	
	/**
	 * 按post请求来提交url
	 * 
	 * @param urlPath
	 * @param postData
	 * @param contentType
	 * @return
	 * @throws OpenapiBaseException 
	 */
	public static String postData(String urlPath, String postData, String contentType) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		
		OutputStream outputStream = null;
		InputStream inputStream = null;
		BufferedReader reader = null;
		
		try {
			url = new URL(urlPath);

			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.setRequestProperty("Content-type", contentType);
			//设置参数信息
			outputStream = httpurlconnection.getOutputStream();
			outputStream.write(postData.getBytes("UTF-8"));
			
			//获取返回的流信息
			inputStream = httpurlconnection.getInputStream();
			StringBuffer postResult = new StringBuffer();
			String readLine = null ;
			reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			while ((readLine = reader.readLine()) != null) {
				postResult.append(readLine);
			}
			
			return postResult.toString();
		} catch (OpenApiBaseException openapiBaseException) {
			throw openapiBaseException;
		} catch (Exception e) {
			throw new OpenApiBaseException(ERROR_MSG.SYSTEM_ERROR, null);
		} finally {
			try {
				if(reader != null) {
					reader.close();
				}
				if(inputStream != null){
					inputStream.close();
				}
				if(outputStream != null){
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
			}
			
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
		}
	}
	
	/**
	 * 设置返回的错误信息
	 * 
	 * @param errCode
	 * @param params
	 * @param messageSource
	 * @param response
	 * @throws IOException
	 */
	public static String setResponseInfoByError(String errCode, String[] params, MessageSource messageSource, 
						String format, ServletRequest request, String pkInfo,Map<String, String> paramMap, int type){
		
		//获取返回的错误信息
		String resultData = getResponseInfo(errCode, params, messageSource, format, pkInfo, type);
		
		return resultData;
		
	}
	
	
	public static Response setResponseObjByError(String errCode, String[] params, String pkInfo, MessageSource messageSource, int language){

		//根据错误编码获取错误消息
		String message = MessageUtils.getMessage(messageSource, errCode, params, language);
		
		Response response = new Response();
		response.addErrInfo(errCode, message, pkInfo);
		
		return response;
		
	}
	
	
	/**
	 * 设置返回的错误信息
	 * 
	 * @param errCode
	 * @param params
	 * @param messageSource
	 * @param response
	 * @throws IOException
	 */
	public static String getResultByError(String errCode, String[] params, MessageSource messageSource, 
						String format, ServletRequest request,String pkInfo,Map<String, String> paramMap, int type) {
		
		//获取返回的错误信息
		String resultData = getResponseInfo(errCode, params, messageSource, format, pkInfo, type);
		
//		if(routerParameter != null){
//			routerParameter.setResultType(OpenApiCommonConst.RESULT_TYPE_2);
//		}
		
		return resultData;
		
	}
	
	public static String getNewResultByError(String errCode, String[] params,
			MessageSource messageSource, String format) {
		
		String resultData = null;
		
		//根据错误编码获取错误消息
		String message = messageSource.getMessage(errCode, params, null);
		
		
		//判断输出格式  xml/json
		if(OpenApiCommonConst.FORMAT_JSON.equals(format)){
			//返回json格式的信息
			resultData = getNewResponseJsonInfo(errCode, message);
		}else{
			//编辑返回的错误信息
			resultData = getNewResponseXmlInfo(errCode, message);
		}
		
//		if(routerParameter != null){
//			routerParameter.setResultType(OpenApiCommonConst.RESULT_TYPE_2);
//
//		}
		
		return resultData;
	}

	public static String getNewResponseXmlInfo(String errCode, String errMsg ) {
	    StringBuffer responseBuffer = new StringBuffer();
	    responseBuffer.append("<error_response><code>");
	    responseBuffer.append(errCode);
	    responseBuffer.append("</code><msg>");
	    responseBuffer.append(errMsg);
	    responseBuffer.append("</msg>");
	    responseBuffer.append("</error_response>");

		return responseBuffer.toString();
	}
	
	public static String getNewResponseJsonInfo(String errCode, String errMsg ) {
		StringBuffer responseBuffer = new StringBuffer();
	    responseBuffer.append("{\"error_response\":{\"code\":\"");
	    responseBuffer.append(errCode);
	    responseBuffer.append("\",\"msg\":\"");
	    responseBuffer.append(errMsg);
	    responseBuffer.append("\"}}");
	    return responseBuffer.toString();
	}
	
		
	/**
	 * 获取返回的错误信息
	 * 
	 * @param errCode
	 * @param params
	 * @param messageSource
	 * @param response ty
	 * @throws IOException
	 */
	public static String getResponseInfo(String errCode, String[] params, MessageSource messageSource, 
						String format, String pkInfo, int type) {
		
		//根据错误编码获取错误消息
		String message = messageSource.getMessage(errCode, params, null);
		
		Response response = new Response();
		response.addErrInfo(errCode, message, pkInfo);
		
		return getResponseInfo(response, format);
		
	}
	
	/**
	 * 解析response对象
	 * 
	 * @param response
	 * @param format
	 * @return
	 */
	public static String getResponseInfo(Response response, String format){
		
		String resultData = null;
		
		//判断输出格式  xml/json
		if(OpenApiCommonConst.FORMAT_JSON.equals(format)){
			
			JsonConfig jsonConfig = JsonConfigFactory.getInstance();
			//返回json格式的信息
			resultData = JSONObject.fromObject(response, jsonConfig).toString();
			
		}else{
			//编辑返回的错误信息
			XStream xstream = new XStream(new DomDriver());
			xstream.autodetectAnnotations(true);
			xstream.registerConverter(new XmlDateValueConverter());
			
			resultData = xstream.toXML(response);
			
		}
		return resultData;
	}
	
	
	
	
	
	
	
	
	/**
	 * 记录访问的log日志信息 
	 * 
	 * @param errCode
	 * @param params
	 * @param messageSource
	 * @param response
	 * @throws IOException
	 */
	public static void getVisitLogInfo(String errCode,  ServletRequest request, Integer resultType,Map<String, String> paramMap,Long startTime){
		
//		AccessLogDto accessLogDto = new AccessLogDto();
//		accessLogDto.setErp(getParamValue(paramMap, OpenApiCommonConst.STRING_APP_ID));
//		accessLogDto.setInvokeMethod(getParamValue(paramMap, OpenApiCommonConst.STRING_METHOD));
//		accessLogDto.setInvokeParam(hashMapToJson(paramMap));
//		
//		//获取真实IP地址
//		String ip = getRealIp((HttpServletRequest)request);
//		accessLogDto.setIp(ip);
//		//获取商家Id
//		if(getParamLongValue(paramMap, OpenApiCommonConst.STRING_MERCHANT_ID) != null){
//			accessLogDto.setMerchantId(getParamLongValue(paramMap, OpenApiCommonConst.STRING_MERCHANT_ID));
//		}
//		//获取供应商Id
//		if(getParamLongValue(paramMap, OpenApiCommonConst.STRING_SUPPLIER_ID) != null){
//			accessLogDto.setMerchantId(getParamLongValue(paramMap, OpenApiCommonConst.STRING_SUPPLIER_ID));
//		}
//		accessLogDto.setMethodVer(getParamValue(paramMap, OpenApiCommonConst.STRING_VER));
//		accessLogDto.setResultCode(errCode);
//		accessLogDto.setResultType(resultType);
//		accessLogDto.setVisitTimeCost(Math.round((System.nanoTime()-startTime)*1.0/1000));
//		Calendar date = Calendar.getInstance();
//		Date currentTime = date.getTime();
//		accessLogDto.setVisitDate(currentTime);
//		
//		//SDK的版本类型情况
//		accessLogDto.setSdkType(getParamValue(paramMap, OpenApiCommonConst.STRING_SDK));
	}
	 
	
	/**把数据源HashMap转换成json
	 * @param map 
	 */
	public static String hashMapToJson(Map<String, String> map) {
		String result = JSONObject.fromObject(map).toString();
		return result.replaceAll("\\[", "").replaceAll("\\]", "");
	}
	
	
	
	/**
	 * 获取字符串的参数信息
	 * 
	 * @param paramMap
	 * @param key
	 * @return
	 */
	public static String getParamValue(Map<String, String> paramMap, String key){
		if(paramMap.containsKey(key)){
			return paramMap.get(key);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取long型的参数信息
	 * 
	 * @param paramMap
	 * @param key
	 * @return
	 */
	public static Long getParamLongValue(Map<String, String> paramMap, String key){
		if(paramMap.containsKey(key)){
			String value = paramMap.get(key);
			if(! StringUtils.isEmpty(value)){
				try{
					return Long.valueOf(value);
				}catch (Exception e) {
				}
			}
		}
		
		return null;
	}
	
	
	/**
	 * 根据url和参数来获取请求返回的信息
	 * 
	 * @param paramMap
	 * @param postUrl
	 * @return
	 * @throws IOException
	 */
	public static String sendPostByUrl(Map<String, String[]> paramMap, String postUrl) throws OpenApiBaseException{
		
		StringBuffer paramBuffer = new StringBuffer();
		paramBuffer.append("<request>");
		
		Iterator<Entry<String, String[]>> iterator = paramMap.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String[]> entry = iterator.next();
			String param = entry.getKey();
			paramBuffer.append("<").append(param).append(">");
			paramBuffer.append(((String[])paramMap.get(param))[0]);
			paramBuffer.append("</").append(param).append(">");
		}
		
		paramBuffer.append("</request>");
		
		//重定向到内部服务器
		String postResult = postData(postUrl, paramBuffer.toString(), OpenApiCommonConst.APPLICATION_XML);
		
		return postResult;
		
	}
	
	
//	/**
//	 * 解析验证checkcode返回结果
//	 * 
//	 * @param xmlInfo
//	 * @return
//	 */
//	public static String parseCheckCodeXml(String xmlInfo){
//		
//		try {
//			Document document = XmlUtil.createDocument(xmlInfo.getBytes("UTF-8"));
//			Element rootElement = XmlUtil.getElementByTagName(document, "response");
//			Element element = XmlUtil.getChildElementByTagName(rootElement, "check_result");
//			
//			return XmlUtil.getTextValue(element);
//		} 
//		catch (Exception e) {
//			return null;
//		}
//	}
	
	
	/**
	 * 配置json格式输出信息
	 * 
	 * @param datePattern
	 * @return
	 */
	public static JsonConfig configJson() {

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "" });
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		//TODO DateJsonValueProcessor
		//jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());

		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object arg0, String key, Object value) {
				if (value == null) {
					return true;
				}
				return false;
			}
		});
		return jsonConfig;
	}

	
	/**
	 * 获取json格式的返回信息
	 * 
	 * @param obj
	 * @return
	 */
	public static String getReponseJsonInfo(Object obj) {

		return "{\"response\":" + JSONObject.fromObject(obj, configJson()).toString() + "}";
	}
	
	/**
	 * 验证字符串是否包含非法字符
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkIllegalChar(String str){
		//!@#$^&*|\\/<>
		String regEx = "&";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		
		return matcher.find();
	}
	
	/**
	 * 判断2个日期是否是同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean checkDateEquale(Date date1, Date date2){
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		
		if(calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) 
				&& calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH) 
				&& calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH) ){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 获取商家访问api接口的最大次数（每分钟的调用次数）
	 * 
	 * @param proxy
	 * @param merchantId
	 * @param merthod
	 * @param ver
	 * @return
	 */
	public static Long getVisitNumByMin(String merchantId, String merthod, String ver){
		
		Long visitNum = null;
		
		//格式：TOTAL_NUM_MIN_PER_商家id_方法名_版本号
		String visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_MIN_PER + "_" + merchantId + "_" + merthod + "_" + ver;
		visitNum = OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		
		//格式：TOTAL_NUM_MIN_PER_商家id_方法名
		visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_MIN_PER + "_" + merchantId + "_" + merthod;
		visitNum = OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		
		//格式：TOTAL_NUM_MIN_PER_方法名_版本号
		visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_MIN_PER + "_" + merthod + "_" + ver;;
		visitNum = OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		
		//格式：TOTAL_NUM_MIN_PER_方法名
		visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_MIN_PER + "_" + merthod;
		visitNum = OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		
		//格式：TOTAL_NUM_MIN_PER
		visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_MIN_PER;
		visitNum = OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		return 0L;
	}
	
	/**
	 * 获取商家访问api接口的最大次数(每天的调用次数)
	 * 
	 * @param proxy
	 * @param merchantId
	 * @param merthod
	 * @param ver
	 * @return
	 */
	public static Long getVisitTotalNumByDay( String merchantId, String merthod, String ver){
		
		Long visitNum = null;
		
		//格式：TOTAL_NUM_DAY_PER_商家id_方法名_版本号
		String visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_DAY_PER + "_" + merchantId + "_" + merthod + "_" + ver;
		visitNum = OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		
		//格式：TOTAL_NUM_DAY_PER_商家id_方法名
		visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_DAY_PER + "_" + merchantId + "_" + merthod;
		visitNum =  OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		
		//格式：TOTAL_NUM_DAY_PER_方法名_版本号
		visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_DAY_PER + "_" + merthod + "_" + ver;
		visitNum = OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		
		//格式：TOTAL_NUM_DAY_PER_方法名
		visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_DAY_PER + "_" + merthod;
		visitNum = OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		
		//格式：TOTAL_NUM_DAY_PER
		visitKey = OpenApiCommonConst.STRING_TOTAL_NUM_DAY_PER;
		visitNum = OpenApiCommonConst.allMethodLimit.get(visitKey);
		if(visitNum != null){
			return visitNum;
		}
		return 0L;
	}
	
	
	/**
	 * 解析文本参数与附件
	 * 
	 * @param body
	 * @param paramMap
	 * @param attachmentFileList
	 */
	public static void parseParamAttachment(MultipartBody body, Map<String, String> paramMap, Map<String, FileItem> attachmentFileMap){
		List<Attachment> attachments = body.getAllAttachments();
		try {
			for (Attachment attachment : attachments) {
				if ("text".equals(attachment.getContentType().getType())) {
					String keyName = attachment.getContentDisposition().getParameters().get("name").replaceAll("\"", "");
					byte[] bytes = IOUtils.toByteArray(attachment.getDataHandler().getInputStream());
					String value = URLDecoder.decode(new String(bytes, "utf-8"), "utf-8").replaceAll("\"", "");
					paramMap.put(keyName, value);
				} else {
					String keyName = attachment.getContentDisposition().getParameters().get("name").replaceAll("\"", "");
					String fileName = URLDecoder.decode(attachment.getContentDisposition().getParameters().get("filename"), "utf-8").replaceAll("\"", "");
					String mimeType = attachment.getContentType().getSubtype();
					
					FileItem fileItem = new FileItem();
					fileItem.setContent(IOUtils.toByteArray(attachment.getDataHandler().getInputStream()));
					fileItem.setFileName(fileName);
					fileItem.setMimeType(mimeType);
					
					//上传附件
					attachmentFileMap.put(keyName, fileItem);
				}
			}
		} catch (Exception e) {
		}
	}
	
	
	/**
	 * 判断文件是否为图片文件（且图片大小比例不能小于9.8:10）
	 * 图片的最小分辨率不能小于widthSize × heightSize
	 * 返回值 0：OK、1：不是图片文件、2：分辨率不够、3：图片大小比例错误
	 * 
	 * @param file
	 * @param widthSize
	 * @param heightSize
	 * @return
	 */
	public static int checkImageFile(File file, int widthSize, int heightSize , boolean flag){
		int result = 0;
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			//此文件不为图片文件
			if (bufferedImage == null) {
				return 1;
			}
			
			//对商家进行校验，如果是团购商家就不用对图片尺寸的校验，否则验证，true为团购商家（白名单商家），false为非团购商家
			if(!flag){
				int width = bufferedImage.getWidth();
				int height = bufferedImage.getHeight();
				
				//分辨率不够
				if(width < widthSize || height < heightSize){
					return 2;
				}
				
				// 图片 比例不能小于9.8:10
				if(9.8/ 10 > 1.0*width/height || 1.0*width/height > 10/9.8){
					return 3;
				}
			}
		} catch (IOException e) {
			//此文件不为图片文件
			return 1;
		}
		
		return result;
		
	}
	
	/**
	 * @discription 验证SourceIP是否与strIP相匹配，strIP可以包含通配符 SourceIP必须为规则ip地址
	 * @param String sourceIP 待验证的源IP
	 * @param String targetIP 可以包含通配符（*）的目标IP
	 * @return boolean 匹配返回true,否则返回false
	 */
	public static boolean ValidIPForm(String sourceIP, String targetIP) {
		String[] arr_Source = sourceIP.split("\\.");
		String[] arr_target = targetIP.split("\\.");
		for (int i = 0; i < arr_Source.length; i++) {
			if ((!arr_target[i].equals("*"))
					&& (!arr_Source[i].equals(arr_target[i]))) {
				return false;
			}
		}
		return true;
	}
	
	public static String stringTrim(String str){
		if(str != null){
			return str.trim();
		}else{
			return null;
		}
	}
	
	/**
	 * 过滤代理服务器，获取源端真实IP地址
	 * @param request
	 * @return
	 */
	
	public static String getRealIp(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		
		return ip;
	}
	
	
	/**
	 * @param request
	 * @return ip address
	 */
	public static String getRemoteIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		} else {
			ip = ip.trim().replaceAll("\\s", "");
			String[] ipList = ip.split(",");
			for(int i=0; i<ipList.length; i++){
				if(!ipList[i].equalsIgnoreCase("unknown") && ipList[i].matches(OpenApiCommonConst.IP_REGEX)) {
					ip = ipList[i];
					break;
				}
			}
		}
		if(ip == null || StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	
	
	
	
	/**
	 * 格式转换（ssD1F2G3gH4h  to  ss_d1_f2_g3g_h4h）
	 * 
	 * @param property
	 * @return
	 */
	public static String getReturnStr(String property, int type) {
		
		//type=0，表示为老的接口方式
		if(type == 0){
			return property;
		}
		
		StringBuffer resultStr = new StringBuffer();
		
		for(int i = 0 ; i < property.length() ; i++){
			if(Character.isUpperCase(property.charAt(i))){
				resultStr.append("_").append(property.charAt(i));
			}else{
				resultStr.append(property.charAt(i));
			}
		}
		
		return resultStr.toString().toLowerCase();
	}
	
	
	
	/**
	 * 格式转换（ss_d1_f2_g3g_h4h  to  ssD1F2G3gH4h）
	 * 
	 * @param returnStr
	 * @return
	 */
	public static String getPropertyStr(String returnStr, int type) {
		
		//type=0，表示为老的接口方式
		if(type == 0){
			return returnStr;
		}
		
		StringBuffer resultStr = new StringBuffer();
		
		for(int i = 0 ; i < returnStr.length() ; i++){
			if('_' == returnStr.charAt(i)){
				i++;
				resultStr.append(Character.toUpperCase(returnStr.charAt(i)));
			}else{
				resultStr.append(returnStr.charAt(i));
			}
		}
		
		return resultStr.toString();
	}
	
	
	/**
	 * 设置obj属性值
	 * 
	 * @param obj
	 * @param keyValueMap
	 */
	public static void setBeanPropertyValue(Object obj, Map<String, String> keyValueMap, Map<String, FileItem> fileItemMap){
		if(keyValueMap != null){
			Iterator<Entry<String, String>> keyIterator = keyValueMap.entrySet().iterator();   
			
			while(keyIterator.hasNext()){
				Entry<String, String> e = keyIterator.next();   
				PropertyConverts.setProperty(obj, e.getKey(), e.getValue());
			}
		}
		
		if(fileItemMap != null){
			Iterator<Entry<String, FileItem>> keyIterator = fileItemMap.entrySet().iterator();   
			
			while(keyIterator.hasNext()){
				Entry<String, FileItem> entry = keyIterator.next();   
				PropertyConverts.setObjPropertyValue(obj, entry.getKey(), entry.getValue());
			}
		}
	}
	
	
}
