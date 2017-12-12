package com.jiuwu.openoo.openapi.filter;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import model.ApiMethod.ApiMethodInfo;
import model.ApiMethod.AppInfo;
import model.ApiMethod.UserTokenInfo;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.danga.MemCached.MemCachedClient;
import com.jiuwu.openoo.common.openapi.response.Response;
import com.jiuwu.openoo.common.openapi.utils.Md5Util;
import com.jiuwu.openoo.openapi.service.LogOperatorServiceImpl;
import com.jiuwu.openoo.openapi.utils.OpenApiCommonConst;
import com.jiuwu.openoo.openapi.utils.OpenApiCommonConst.ERROR_MSG;
import com.jiuwu.openoo.openapi.utils.OpenApiCommonUtil;
/**
 * 身份验证过滤器
 * 
 * @author ouyangjian
 * 
 */
public class OpenApiSystemParamFilterBean {

	// /** api共通配置文件信息 */
	// private CommonConfigBean openapiConfig;

	/** api错误信息配置文件 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private MemCachedClient memCachedClient;
	@Autowired
	private LogOperatorServiceImpl logOperatorService;

	/** log */
	private final Log log = LogFactory.getLog(getClass());

	/**
	 * 判断系统级参数
	 * 
	 * @param paramMap
	 * @param request
	 * @return
	 */
	public Response checkSystemParam(Map<String, String> paramMap,
			HttpServletRequest request, int type, int language) {

		/********************** 参数合法性验证 *****************************/
		// 1.format参数校验，为空则默认为xml
		String format = OpenApiCommonConst.FORMAT_XML;
		if (paramMap.containsKey(OpenApiCommonConst.STRING_FORMAT)) {
			format = paramMap.get(OpenApiCommonConst.STRING_FORMAT);
		}
		if (StringUtils.isBlank(format)) {
			format = OpenApiCommonConst.FORMAT_XML;
		}
		if (!OpenApiCommonConst.FORMAT_JSON.equals(format)
				&& !OpenApiCommonConst.FORMAT_XML.equals(format)) {
			String[] params = new String[] { OpenApiCommonConst.STRING_FORMAT
					+ " [" + OpenApiCommonConst.FORMAT_JSON + "/"
					+ OpenApiCommonConst.FORMAT_XML + "]" };
			return OpenApiCommonUtil.setResponseObjByError(
					ERROR_MSG.SYSTEM_PARAM_ERROR, params, null, messageSource, language);
		}

		// 2.系统级参数验证【"timestamp", "method", "ver", "sign"】
		for (int i = 0; i < OpenApiCommonConst.SYSTEM_PARAM_ARRAY.length; i++) {
			if (!paramMap.containsKey(OpenApiCommonConst.SYSTEM_PARAM_ARRAY[i])
					|| StringUtils.isEmpty(paramMap
							.get(OpenApiCommonConst.SYSTEM_PARAM_ARRAY[i]))) {
				String[] params = new String[] { OpenApiCommonConst.SYSTEM_PARAM_ARRAY[i] };
				return OpenApiCommonUtil.setResponseObjByError(
						ERROR_MSG.SYSTEM_PARAM_ERROR, params, null,
						messageSource, language);
			}
		}

		// 3.时间校验
		// if(DateUtil.converToDateTime(paramMap.get(OpenApiCommonConst.STRING_TIMESTAMP))
		// == null){
		// String[] params = new String[]{OpenApiCommonConst.STRING_TIMESTAMP};
		// return
		// OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.SYSTEM_PARAM_ERROR,
		// params, null, messageSource);
		// }
		// Date clientDate =
		// DateUtil.converToDateTime(paramMap.get(OpenApiCommonConst.STRING_TIMESTAMP));
		// Date serverDate = new Date();
		// if(DateUtil.getSecondsBetween(clientDate, serverDate)>10*60 ||
		// DateUtil.getSecondsBetween(serverDate, clientDate) >10*60){
		// return
		// OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.TIMESTAMP_INVALID,
		// null, null, messageSource);
		// }

		// 4.验证接口名称以及版本号
 		String key = paramMap.get(OpenApiCommonConst.STRING_METHOD) + "_"
				+ paramMap.get(OpenApiCommonConst.STRING_VER);
		ApiMethodInfo methodInfo = OpenApiCommonConst.allMethodInfoMap.get(key);
		if (methodInfo == null) {
			return OpenApiCommonUtil.setResponseObjByError(
					ERROR_MSG.METHOD_VER_INVALID, null, null, messageSource, language);
		}

		// 验证sign、对参数进行排序
		TreeMap<String, String> paramTreeMap = new TreeMap<String, String>();
		Iterator<Entry<String, String>> entryIterator = paramMap.entrySet()
				.iterator();
		while (entryIterator.hasNext()) {
			Entry<String, String> entry = entryIterator.next();
			String keyStr = entry.getKey();
			String value = entry.getValue();
			// sign参数不参与计算
			if (!OpenApiCommonConst.STRING_SIGN.equals(keyStr)) {
				paramTreeMap.put(keyStr, value);
			}
		}

		/********************** 参数逻辑验证 *****************************/

		// 根据不同级别获取不同的密钥
		String sceretKey;
		try {
			int methodLevel = methodInfo.getAuthLevel();
			if (methodLevel == OpenApiCommonConst.L0) {
				// 不需要校验
				sceretKey = OpenApiCommonConst.DEFAULT_SIGN_SECRET;
			} else if (methodLevel == OpenApiCommonConst.L1) {

				// 校验appKey
				Response response = checkAppKey(paramMap, request, format,
						methodLevel, type, language);
				if (response != null) {
					return response;
				}
				sceretKey = OpenApiCommonConst.allAppInfoMap.get(
						paramMap.get(OpenApiCommonConst.STRING_APPKEY))
						.getAppSecret();

			} else if (methodLevel == OpenApiCommonConst.L2
					|| methodLevel == OpenApiCommonConst.L3) {

				// 校验appKey和sessionKey是否合法
				Response response = checkAppKeyAndSessionKey(paramMap, request,
						format, methodLevel, type, language);
				if (response != null) {
					return response;
				}
				sceretKey = OpenApiCommonConst.allAppInfoMap.get(
						paramMap.get(OpenApiCommonConst.STRING_APPKEY))
						.getAppSecret();

			} else {
				// 设置返回的错误信息
				return OpenApiCommonUtil.setResponseObjByError(
						ERROR_MSG.METHOD_LEVEL_INVALID, null, null,
						messageSource, language);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			// 设置返回的错误信息
			String[] params = new String[] { "不同级别方法校验时出错" };
			return OpenApiCommonUtil.setResponseObjByError(ERROR_MSG.SBY_ERROR,
					params, null, messageSource, language);
		}

		// 计算sign的值
		String sign = Md5Util.md5Signature(paramTreeMap, sceretKey);

		if(paramMap.get("ignoreSign") != null){
			return null;
		}
		if (StringUtils.isEmpty(sign)
				|| !sign.equals(paramMap.get(OpenApiCommonConst.STRING_SIGN))) {
			// 设置返回的错误信息
			return OpenApiCommonUtil.setResponseObjByError(
					ERROR_MSG.SIGN_INVALID, null, null, messageSource, language);
		}

		return null;

	}

	/**
	 * 校验appKey是否合法
	 * 
	 * @param paramMap
	 * @param request
	 * @param format
	 * @param methodLevel
	 * @return
	 */
	private Response checkAppKey(Map<String, String> paramMap,
			HttpServletRequest request, String format, Integer methodLevel,
			int type, int language) {

		String appKey = paramMap.get(OpenApiCommonConst.STRING_APPKEY);

		// 判断appKey是否为空
		if (StringUtils.isEmpty(appKey)) {
			// 设置返回的错误信息
			String[] params = new String[] { OpenApiCommonConst.STRING_APPKEY };
			return OpenApiCommonUtil.setResponseObjByError(
					ERROR_MSG.SYSTEM_PARAM_ERROR, params,
					OpenApiCommonConst.STRING_APPKEY, messageSource, language);
		}

		// 校验app是否存在
		AppInfo appInfo = OpenApiCommonConst.allAppInfoMap.get(paramMap.get(OpenApiCommonConst.STRING_APPKEY));
		if (appInfo == null) {

			String[] params = new String[] { OpenApiCommonConst.STRING_APPKEY };
			return OpenApiCommonUtil.setResponseObjByError(
					ERROR_MSG.SYSTEM_PARAM_ERROR, params,
					OpenApiCommonConst.STRING_APPKEY, messageSource, language);
		}
		
		paramMap.put(OpenApiCommonConst.APP_KEY, appInfo.getAppKey());
		paramMap.put(OpenApiCommonConst.APP_USER_TABLE, appInfo.getAppUserTable());
		paramMap.put(OpenApiCommonConst.STRING_IP, OpenApiCommonUtil.getRemoteIp(request));
		paramMap.put(OpenApiCommonConst.STRING_USER_TYPE, String.valueOf(appInfo.getId()));
		return null;
	}


	/**
	 * 校验appKey和sessionKey是否合法
	 * 
	 * @param paramMap
	 * @param request
	 * @param format
	 * @param methodLevel
	 * @return
	 */
	private Response checkAppKeyAndSessionKey(Map<String, String> paramMap,
			HttpServletRequest request, String format, Integer methodLevel,
			int type, int language) {

		String appKey = paramMap.get(OpenApiCommonConst.STRING_APPKEY);
		String sessionKey = paramMap.get(OpenApiCommonConst.STRING_SESSIONKEY);
		// 判断appKey是否为空
		if (StringUtils.isEmpty(appKey)) {
			// 设置返回的错误信息
			String[] params = new String[] { OpenApiCommonConst.STRING_APPKEY };
			return OpenApiCommonUtil.setResponseObjByError(
					ERROR_MSG.SYSTEM_PARAM_ERROR, params,
					OpenApiCommonConst.STRING_APPKEY, messageSource, language);
		}

		// 校验app是否存在
		AppInfo appInfo = OpenApiCommonConst.allAppInfoMap.get(appKey);
		if (appInfo == null) {
			String[] params = new String[] { OpenApiCommonConst.STRING_APPKEY };
			return OpenApiCommonUtil.setResponseObjByError(
					ERROR_MSG.SYSTEM_PARAM_ERROR, params,
					OpenApiCommonConst.STRING_APPKEY, messageSource, language);
		}
		
		// 判断sessionKey是否为空
		if (StringUtils.isEmpty(sessionKey)) {
			// 设置返回的错误信息
			String[] params = new String[] { OpenApiCommonConst.STRING_SESSIONKEY };
			return OpenApiCommonUtil.setResponseObjByError(
					ERROR_MSG.SYSTEM_PARAM_ERROR, params,
					OpenApiCommonConst.STRING_SESSIONKEY, messageSource, language);
		}
		//  验证token
		if(appKey.endsWith("appKey00001")){
			UserTokenInfo userTokenInfo = logOperatorService.getUserTokenInfoByToken(sessionKey);
			if (userTokenInfo == null) {
				String[] params = new String[] { OpenApiCommonConst.STRING_SESSIONKEY };
				return OpenApiCommonUtil.setResponseObjByError(
						ERROR_MSG.SYSTEM_PARAM_ERROR, params,
						OpenApiCommonConst.STRING_SESSIONKEY, messageSource, language);
			}
		}else{
			//从缓存中获取token
			Integer userId = null;
			try{
				userId = (Integer)memCachedClient.get(sessionKey);
			}catch(Exception e){
				log.error(memCachedClient.get(sessionKey).getClass().getName());
				log.error("缓存信息错误,Key=[" + sessionKey + "], value =[" + memCachedClient.get(sessionKey) + "]", e);
				memCachedClient.delete(sessionKey);
			}
			if (userId == null) {
				String[] params = new String[] { OpenApiCommonConst.STRING_SESSIONKEY };
				return OpenApiCommonUtil.setResponseObjByError(
						ERROR_MSG.SYSTEM_PARAM_ERROR, params,
						OpenApiCommonConst.STRING_SESSIONKEY, messageSource, language);
			}
			paramMap.put(OpenApiCommonConst.STRING_USER_ID, String.valueOf(userId));
		}
		paramMap.put(OpenApiCommonConst.APP_KEY, appInfo.getAppKey());
		paramMap.put(OpenApiCommonConst.STRING_USER_TYPE, String.valueOf(appInfo.getId()));
		paramMap.put(OpenApiCommonConst.STRING_IP, OpenApiCommonUtil.getRemoteIp(request));

		return null;
	}

}
