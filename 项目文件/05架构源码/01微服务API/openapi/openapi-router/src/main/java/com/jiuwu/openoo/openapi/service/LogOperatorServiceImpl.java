package com.jiuwu.openoo.openapi.service;

import java.util.ArrayList;
import java.util.List;

import model.ApiMethod.ApiMethodInfo;
import model.ApiMethod.AppInfo;
import model.ApiMethod.CheckUpdateRequest;
import model.ApiMethod.CheckUpdateResponse;
import model.ApiMethod.OoApiMethodModel;
import model.ApiMethod.OoAppInfoModel;
import model.ApiMethod.UserTokenInfo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.jiuwu.openoo.common.openapi.exception.OpenApiBaseException;
import com.jiuwu.openoo.common.openapi.utils.MessageConstant.CHECK_UPDATE;
import com.jiuwu.openoo.common.openapi.utils.MessageUtils;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoApiMethodMapper;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoAppInfoMapper;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoUserTokenInfoMapper;

public class LogOperatorServiceImpl{
	private final Log log = LogFactory.getLog(getClass());

	/** api错误信息配置文件 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private OoApiMethodMapper ooApiMethodMapper;
	@Autowired
	private OoAppInfoMapper ooAppInfoMapper;
	@Autowired
	private OoUserTokenInfoMapper ooUserTokenInfoMapper;

	public List<ApiMethodInfo> getApiMethodInfoList() {
		
		List<OoApiMethodModel> ooApiMethodModelList = ooApiMethodMapper.getApiMethodInfoList();
		
		List<ApiMethodInfo> apiMethodInfoList = new ArrayList<ApiMethodInfo>();
		if(ooApiMethodModelList != null && ooApiMethodModelList.size() > 0){
			for(OoApiMethodModel apiMethodModel : ooApiMethodModelList){
				
				ApiMethodInfo apiMethodInfo = new ApiMethodInfo();
				
				apiMethodInfo.setAuthLevel(apiMethodModel.getAuthLevel());
				apiMethodInfo.setId(apiMethodModel.getId());
				apiMethodInfo.setIsOpen(apiMethodModel.getIsOpen());
				apiMethodInfo.setMethod(apiMethodModel.getMethod());
				apiMethodInfo.setMethodCfg(apiMethodModel.getMethodCfg());
				apiMethodInfo.setMethodName(apiMethodModel.getMethodName());
				apiMethodInfo.setMethodType(apiMethodModel.getMethodType());
				apiMethodInfo.setMethodVer(apiMethodModel.getMethodVer());
				apiMethodInfoList.add(apiMethodInfo);
			}
		}
		
		return apiMethodInfoList;
	}
	
	public List<AppInfo> getAppinfoList() {
		return ooAppInfoMapper.getAppinfoList();
	}
	
	
	
	public UserTokenInfo getUserTokenInfoByToken(String token){
		return ooUserTokenInfoMapper.getUserTokenInfoByToken(token);
	}
	
	/**
	 * @FunName checkUpdate
	 * @Description 检测是否需要强制更新
	 * @param CheckUpdateRequest
	 * @return CheckUpdateResponse
	 * @author zhuchong
	 * @Create Date 2015-06-15
	 */
	public CheckUpdateResponse checkUpdate(CheckUpdateRequest request) {
		log.info("检测是否需要强制更新");
		String result = null;
		String msg = null;
		CheckUpdateResponse response = new CheckUpdateResponse();
		try {
			OoAppInfoModel appInfoModel=new OoAppInfoModel();
			int updateResult=0;
			if (StringUtils.isBlank(request.getAppVersion())) {
				result = CHECK_UPDATE.ERROR_102;
			}else {
				appInfoModel.setAppKey(request.getAppKey());
				appInfoModel=ooAppInfoMapper.getObjectByModel(appInfoModel);
				if (appInfoModel==null) {
					result = CHECK_UPDATE.ERROR_201;
				}
			}
			if (result != null) {
				msg = MessageUtils.getMessage(messageSource,
						CHECK_UPDATE.METHOD + result, null,
						request.getLanguage());
				response.addErrInfo(result, msg, null);
				return response;
			}
			try {
				updateResult=compareVersion(request.getAppVersion(), appInfoModel.getLowestVersion());
			} catch (Exception e) {
				log.error("最低版本为空");
			}
			if (updateResult<0) {
				response.setIsNeedUpdate(1);
			}else {
				response.setIsNeedUpdate(0);
			}
			response.setSuccessCount(1);
			return response;
		} catch (Exception e) {
			log.error("检测是否需要强制更新失败 appKey="+ request.getAppKey() +" appVersion="
					+ request.getAppVersion(), e);
			OpenApiBaseException excp = new OpenApiBaseException(e);
			excp.setErrorCode(CHECK_UPDATE.ERROR_300);
			excp.setErrorMsg(MessageUtils.getMessage(messageSource,
					CHECK_UPDATE.METHOD + CHECK_UPDATE.ERROR_300, null,
					request.getLanguage()));
			throw excp;
		}
	}
	
	/**
	 * 比较版本号的大小,不需要升级返回一个正数,需升级返回一个负数,相等则返回0
	 * @param appVision
	 * @param lowestVersion
	 * @return int
	 */
	public static int compareVersion(String appVision, String lowestVersion) throws Exception {
	    if (StringUtils.isBlank(lowestVersion)) {
	        throw new Exception("最低版本为空!");
	    }
	    String[] versionArray1 = appVision.split("\\.");
	    String[] versionArray2 = lowestVersion.split("\\.");
	    int idx = 0;
	    int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
	    int diff = 0;
	    while (idx < minLength
	            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
	            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
	        ++idx;
	    }
	    //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
	    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
	    return diff;
	}
	

}
