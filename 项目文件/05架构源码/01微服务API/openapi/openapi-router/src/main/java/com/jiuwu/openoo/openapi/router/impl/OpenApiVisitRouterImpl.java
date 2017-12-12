package com.jiuwu.openoo.openapi.router.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MultivaluedMap;

import model.ApiMethod.ApiMethodInfo;
import model.ApiMethod.OoApiAccessLogModel;
import model.ApiMethod.UserTokenInfo;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.danga.MemCached.MemCachedClient;
import com.jiuwu.openoo.common.openapi.ErrDetailInfo;
import com.jiuwu.openoo.common.openapi.FileItem;
import com.jiuwu.openoo.common.openapi.exception.OpenApiBaseException;
import com.jiuwu.openoo.common.openapi.response.Response;
import com.jiuwu.openoo.common.openapi.utils.MessageConstant.REQUEST_HTTPS;
import com.jiuwu.openoo.common.openapi.utils.MessageUtils;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoApiAccessLogMapper;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoUserTokenInfoMapper;
import com.jiuwu.openoo.openapi.filter.OpenApiSystemParamFilterBean;
import com.jiuwu.openoo.openapi.router.OpenApiVisitRouter;
import com.jiuwu.openoo.openapi.utils.OpenApiCommonConst;
import com.jiuwu.openoo.openapi.utils.OpenApiCommonConst.ERROR_MSG;
import com.jiuwu.openoo.openapi.utils.OpenApiCommonUtil;

public class OpenApiVisitRouterImpl implements OpenApiVisitRouter{
	
	
	private final static Log log = LogFactory.getLog(OpenApiVisitRouterImpl.class);
	/** 系统级参数校验 */
	private OpenApiSystemParamFilterBean openApiSystemParamFilterBean;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private OoApiAccessLogMapper ooApiAccessLogMapper;
	@Autowired
	private OoUserTokenInfoMapper ooUserTokenInfoMapper;
	@Autowired
	private MemCachedClient memCachedClient;
	/**
	 * 跳转ws路由器（不可接收附件）
	 * 
	 * @param multivaluedMap
	 * @param request
	 */
	public String router(MultivaluedMap<String, String> multivaluedMap,HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		httpResponse.addHeader("Access-Control-Allow-Origin","*");
		httpResponse.addHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS"); 
		
		// 记录开始访问时间
		Long startTime = System.currentTimeMillis();
		// 获取语言环境
		int language = 1;
		try{
			if(multivaluedMap.get("language") != null){
				List<String> languages = multivaluedMap.get("language");
				if(languages.get(0) != null){
						language = Integer.parseInt(languages.get(0));
				}
			}
		} catch (Exception e){
			language = 1;
		}
		
		// 把参数保存到paramMap中
		Map<String, String> paramMap = new HashMap<String, String>();
		Iterator<Entry<String, List<String>>> entryIterator = multivaluedMap.entrySet().iterator();
		while(entryIterator.hasNext()) {
			Entry<String, List<String>> entry = entryIterator.next();
			String key = entry.getKey();
			paramMap.put(key, multivaluedMap.getFirst(key));
		}
		
		//format参数
		String format = OpenApiCommonConst.FORMAT_JSON;
		if(paramMap.containsKey(OpenApiCommonConst.STRING_FORMAT)){
			format = paramMap.get(OpenApiCommonConst.STRING_FORMAT);
		}	
		String method = multivaluedMap.getFirst(OpenApiCommonConst.STRING_METHOD);
		//获取https请求的方法
		String httpsMethod = MessageUtils.getMessage(messageSource, OpenApiCommonConst.HTTPS_METHOD, null, language);
		//是否需要HTTPS请求
		if(StringUtils.isNotBlank(method) && httpsMethod.indexOf(method + ",") != -1){
			if(!httpRequest.isSecure()){
				log.error("需要用https访问此接口。");
				//不安全的请求
				Response response = new Response();
				String result = REQUEST_HTTPS.ERROR_399;
				String msg = MessageUtils.getMessage(messageSource, REQUEST_HTTPS.METHOD + result, null, language);
				response.addErrInfo(result, msg, null);	
				
				//String responseReslut = JSONObject.fromObject(response).toString();
				String responseReslut = OpenApiCommonUtil.getResponseInfo(response, format);
				return responseReslut;
			}else{
				log.info("开始https请求");
			}
		}
		
		
		// 调用ws
		Response response = invokeRouter(paramMap, null, httpRequest, language);

		//插入log记录
		insertIntoLog(paramMap, httpRequest, response, startTime);
		
		//解析response对象
		String responseReslut = OpenApiCommonUtil.getResponseInfo(response, format);
		
		return responseReslut;
		

	}
	
	
	
	
	public String routerWithFile(MultipartBody body, HttpServletRequest httpRequest, HttpServletResponse httpResponse){
		httpResponse.addHeader("Access-Control-Allow-Origin","*");
		httpResponse.addHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS"); 
		
		// 记录开始访问时间
		Long startTime = System.currentTimeMillis();
		
		//参数Map
		Map<String, String> paramMap = new HashMap<String, String>();
		//附件list
		Map<String, FileItem> fileItemMap = new HashMap<String, FileItem>();
		
		//解析文本参数与附件
		OpenApiCommonUtil.parseParamAttachment(body, paramMap, fileItemMap);
		
		// 获取语言环境
		int language = 1;
		try{
			language = Integer.parseInt(paramMap.get("language"));
		} catch (Exception e){
			language = 1;
		}
		String method = paramMap.get(OpenApiCommonConst.STRING_METHOD);
		
		//format参数
		String format = OpenApiCommonConst.FORMAT_JSON;
		if(paramMap.containsKey(OpenApiCommonConst.STRING_FORMAT)){
			format = paramMap.get(OpenApiCommonConst.STRING_FORMAT);
		}
		//获取https请求的方法
		String httpsMethod = MessageUtils.getMessage(messageSource, OpenApiCommonConst.HTTPS_METHOD, null, language);
		//是否需要HTTPS请求
		if(StringUtils.isNotBlank(method) && httpsMethod.indexOf(method + ",") != -1){
			if(!httpRequest.isSecure()){
				log.error("需要用https访问此接口。");
				//不安全的请求
				Response response = new Response();
				String result = REQUEST_HTTPS.ERROR_399;
				String msg = MessageUtils.getMessage(messageSource, REQUEST_HTTPS.METHOD + result, null, language);
				response.addErrInfo(result, msg, null);	
				
				//String responseReslut = JSONObject.fromObject(response).toString();
				String responseReslut = OpenApiCommonUtil.getResponseInfo(response, format);
				return responseReslut;
			}else{
				log.info("开始https请求");
			}
		}
		
	
		// 调用ws
		Response response = invokeRouter(paramMap, fileItemMap, httpRequest, language);
		//插入log记录
		insertIntoLog(paramMap, httpRequest, response, startTime);
		
		//解析response对象
		String responseReslut = OpenApiCommonUtil.getResponseInfo(response, format);
		
		return responseReslut;
		
	}
	
	
	
	private Response invokeRouter(Map<String, String> paramMap, Map<String, FileItem> fileItemMap, HttpServletRequest request, int language){
		// 系统级参数校验
		Response response = openApiSystemParamFilterBean.checkSystemParam(paramMap, request, 0, language);
		// 替换sessionKey非法消息、sign非法消息
		if(response != null && response.getErrInfoList() != null && response.getErrInfoList().size() > 0){
			for(ErrDetailInfo item : response.getErrInfoList()){
				if(StringUtils.isNotBlank(item.getErrorDes()) && item.getErrorDes().equals("系统参数sessionKey为空或非法")){
					item.setErrorDes("您的账号出现异地登录，请修改密码");
				}
				if(StringUtils.isNotBlank(item.getErrorDes()) && item.getErrorDes().indexOf("系统参数sign") != -1){
					item.setErrorDes("您的秘钥不匹配");
				}
			}
		}
		if(response != null) {
			return response;
		}
		
		// 调用ws
		response = invokeService(paramMap, fileItemMap, request, language);
		
		return response;
		
	}
	
	
	
	private void insertIntoLog(Map<String, String> paramMap, HttpServletRequest request, Response response, Long startTime ){
		try{
			Long endTime = System.currentTimeMillis();
			Integer cost = (int) (endTime - startTime);
			if(paramMap == null){
				return ;
			}
			/** IP */
			String ip = OpenApiCommonUtil.getRemoteIp(request);
			/** 设备厂商 */
			String	deviceManufacturer = paramMap.get("deviceManufacturer");
			/** 设备型号 */
			String	deviceModel = paramMap.get("deviceModel");
			/** 系统版本号 */
			String	systemVer = paramMap.get("systemVer");
			/** app版本号 */
			String	appVer = paramMap.get("appVer");
			
			String resultCode = null;
			Integer resultType = 1;
			
			if(response.getErrInfoList() != null && response.getErrInfoList().size() > 0){
				//有错误信息,默认参数问题
				resultType = 3;
				for(ErrDetailInfo errDetailInfo : response.getErrInfoList()){
					if(StringUtils.isNotBlank(errDetailInfo.getErrorCode())){
						if(errDetailInfo.getErrorCode().startsWith(ERROR_MSG.SYSTEM_ERROR) || 
								errDetailInfo.getErrorCode().startsWith(ERROR_MSG.HEDWIG_SERVICE_ERROR)){
							resultType = 2;
							resultCode = errDetailInfo.getErrorCode();
							break;
						} else {
							resultCode = errDetailInfo.getErrorCode();
						}
					}
				}
			}
			
			Integer userId = null;
			if(StringUtils.isNotBlank(paramMap.get("sessionKey"))){
				UserTokenInfo token = ooUserTokenInfoMapper.getUserTokenInfoByToken(paramMap.get("sessionKey"));
				if(token != null){
					userId = Integer.parseInt(token.getUserId());
				}else{
					//从缓存中获取token
					try{
						userId = (Integer)memCachedClient.get(paramMap.get("sessionKey"));
					}catch(Exception e){
						log.error(memCachedClient.get(paramMap.get("sessionKey")).getClass().getName());
						log.error("缓存信息错误,Key=[" + paramMap.get("sessionKey") + "], value =[" + memCachedClient.get(paramMap.get("sessionKey")) + "]", e);
						memCachedClient.delete(paramMap.get("sessionKey"));
					}
				}
			}
			OoApiAccessLogModel accessLog = new OoApiAccessLogModel();
			accessLog.setAppVer(appVer);
			accessLog.setDeviceManufacturer(deviceManufacturer);
			accessLog.setDeviceModel(deviceModel);
			accessLog.setInvokeMethod(paramMap.get("method"));
			String param = paramMap.toString();
			if(StringUtils.isNotBlank(param) && param.length() > 3000){
				param = param.substring(0, 3000);
			} 
			
			accessLog.setInvokeParam(param);
			accessLog.setIp(ip);
			accessLog.setMethodVer(paramMap.get("ver"));
			accessLog.setResultCode(resultCode);
			accessLog.setResultType(resultType);
			accessLog.setSystemVer(systemVer);
			accessLog.setUserId(userId);
			accessLog.setVisitDate(new Date());
			accessLog.setVisitTimeCost(cost);
			accessLog.setResultMsg(response.toString());
			if(StringUtils.isNotBlank(response.getException())){
				if(response.getException().length() > 4000){
					accessLog.setException(response.getException().substring(0, 4000));
				} else {
					accessLog.setException(response.getException());
				}
			}
			 ooApiAccessLogMapper.insertModel(accessLog);
		} catch (Exception e){
			log.error("日志插入错误", e);
		}
		response.setException("");
		
	}
	
	
	/**
	 * 调用ws服务
	 * 
	 * @param paramMap
	 * @param request
	 * @return
	 */
	private Response invokeService(Map<String, String> paramMap, Map<String, FileItem> fileItemMap, HttpServletRequest request, int language){
		
		//调用接口的版本
		String ver = paramMap.get(OpenApiCommonConst.STRING_VER);
		//调用接口的方法名
		String merthod = paramMap.get(OpenApiCommonConst.STRING_METHOD);
		
		// 系统级参数校验
		Response response = null;
		
		//URL 重定向配置的key
		String key = merthod + "_" + ver ;
		ApiMethodInfo apiMethodInfo = OpenApiCommonConst.allMethodInfoMap.get(key);
		
		String redirectValue = OpenApiCommonUtil.stringTrim(apiMethodInfo.getMethodCfg());
		
		if(StringUtils.isEmpty(redirectValue)){
			
			return OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.EDIRECT_ERROR, null, null, messageSource, language);
		}
		
		try{
			
			if("local".equals(redirectValue.substring(0, 5))){
				
				String[] hedwigBeanValues = redirectValue.split(";");
				
				if( hedwigBeanValues.length != 4 || StringUtils.isEmpty(hedwigBeanValues[1]) 
						|| StringUtils.isEmpty(hedwigBeanValues[2]) || StringUtils.isEmpty(hedwigBeanValues[3])){
					
					return OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.EDIRECT_ERROR, null, null, messageSource, language);
				}
				
				//获取service bean
				ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
				Object serviceObj = context.getBean(OpenApiCommonUtil.stringTrim(hedwigBeanValues[1]));
				
				//设置request对象
				Class<?> hedwigRequest = Class.forName(OpenApiCommonUtil.stringTrim(hedwigBeanValues[3]));
				Object objRequest = hedwigRequest.newInstance();
				OpenApiCommonUtil.setBeanPropertyValue(objRequest, paramMap, fileItemMap);
				
				String methodName = OpenApiCommonUtil.stringTrim(hedwigBeanValues[2]) ;
				
				try{
					response = (Response) serviceObj.getClass().getMethod(methodName, new Class[]{objRequest.getClass()}).invoke(serviceObj, new Object[]{objRequest});
				} catch(InvocationTargetException baseException){
					baseException.printStackTrace();
					try{
						OpenApiBaseException e = (OpenApiBaseException) baseException.getTargetException();
						if(response == null){
							response = new Response();
						}
						response.addErrInfo(e.getErrorCode(), e.getErrorMsg(), e.getPkinfo());
			//			response.setException(baseException);
						return response;
					} catch (Exception exception) {
						response = OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.METHOD_ERROR, null, null, messageSource, language);
						response.setException(exception);
						return response;
					}
				} catch (Exception exception) {
					log.error(exception);
					response = OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.METHOD_ERROR, null, null, messageSource, language);
					response.setException(exception);
					return response;
				}
				
				if(response == null){
					log.error("调用服务返回空！");
					String[] params = new String[]{"返回值为空"};
					return OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.HEDWIG_SERVICE_ERROR, params, redirectValue, messageSource, language);
				}
				
				//解析response对象
				return response;
				
			}
		}catch(NoSuchBeanDefinitionException noSuchBeanException){
			String[] params = new String[]{"客户端配置错误"};
			return OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.HEDWIG_SERVICE_ERROR, params, null, messageSource, language);
		}catch (Exception exception) {
			exception.printStackTrace();
			return OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.SYSTEM_ERROR, null, null, messageSource, language);
		}
		return response;
	}
	

	public OpenApiSystemParamFilterBean getOpenApiSystemParamFilterBean() {
		return openApiSystemParamFilterBean;
	}


	public void setOpenApiSystemParamFilterBean(
			OpenApiSystemParamFilterBean openApiSystemParamFilterBean) {
		this.openApiSystemParamFilterBean = openApiSystemParamFilterBean;
	}

}
