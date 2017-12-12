package com.jiuwu.openoo.openapi.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.ApiMethod.ApiSystemParam;
import model.ApiMethod.OoApiMethodCategoryModel;
import model.ApiMethod.OoApiMethodModel;
import model.ApiMethod.OoApiMethodParamModel;
import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.jiuwu.openoo.dao.mapper.kamailio.method.OoApiMethodCategoryMapper;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoApiMethodCfgMapper;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoApiMethodMapper;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoApiMethodParamMapper;
import com.jiuwu.openoo.openapi.utils.JsonUtil;
import com.jiuwu.openoo.openapi.utils.OpenApiCommonConst;
import com.jiuwu.openoo.openapi.utils.PostClient;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 在线测试工具页面
 */
public class ApiToolsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private final Log log = LogFactory.getLog(getClass());

	/**方法类别ID*/
	private Integer methodType;
	
	/**方法ID*/
    private Integer methodId;
    
    /**方法列表*/
    private List<OoApiMethodModel>  apiMethodInfoList;
    
    /**系统级参数*/
    private ApiSystemParam systemParam;
    
    /**提交的参数*/
    private String postParams;
    
	/**请求的url地址*/
	private String postUrl;
    
    /**应用级参数英文名称数组(逗号,分隔)*/
    private String paramsNames;
    
    /**应用级参数"参数类型"(逗号,分隔)*/
    private String paramsTypes;
    
    /**SDK类型(1、JAVA；2、PHP；3、.NET)*/
    private Integer sdkType;
    
    /**返回结果*/
    private String appResult;
    
    /**要上传的文件*/
    private File logo;
    private File idCardPic;	//'身份证照片'
	private File businessPic;	//'企业的营业执照'
	private File operationCardPic;	//'运营证照片'
	private File carCardPic; //'驾驶证照片'
	private File xszPic;		//'机动车行驶证'
	private File yszPic;		//'道理运输证'
	private File qzxPic;		//'交通强制险'
	private File szxPic;		//'商业三责险'
	private File ssxPic;		//'货物损失险'
	private File txzPic;		//'通行证'
	private File finishAuthorPic;	//上传配送完成凭证
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private OoApiMethodCategoryMapper ooApiMethodCategoryMapper;
	
	@Autowired
	private OoApiMethodMapper ooApiMethodMapper;
	
	@Autowired
	private OoApiMethodCfgMapper ooApiMethodCfgMapper;
	
	@Autowired
	private OoApiMethodParamMapper ooApiMethodParamMapper;
	
	public String apiTools() {
		return SUCCESS;
	}
	
	/**
	 * 查询接口类别下拉列表
	 */
	public void queryMethodCategorys() {
		try{
			OoApiMethodCategoryModel obj = new OoApiMethodCategoryModel();
			List<OoApiMethodCategoryModel> apiCategoryList = ooApiMethodCategoryMapper.getListByModel(obj);
			JSONArray jsonArray = JSONArray.fromObject(apiCategoryList);
			JsonUtil.sendMsg(jsonArray.toString());
		} catch (Exception e) {
			log.error("测试页面错误", e);
		}
	}
	
	/**
	 * 查询方法名称下拉列表
	 */
	public void queryMethods() {
		try{
			//根据接口类别ID和方法名称查询接口基本信息
			OoApiMethodModel obj = new OoApiMethodModel();
			obj.setMethodType(methodType);
			List<OoApiMethodModel> apiMethodInfoList = ooApiMethodMapper.getListByModel(obj);
			JSONArray jsonArray = JSONArray.fromObject(apiMethodInfoList);
			JsonUtil.sendMsg(jsonArray.toString());
		} catch (Exception e) {
			log.error("测试页面错误", e);
		}
	}

	/**
	 * 根据方法ID查询输入参数
	 */
	public void queryMethodInParams() {
		try{
			//设置方法id，参数类型为输入参数
			OoApiMethodParamModel methodParamDto = new OoApiMethodParamModel();
			methodParamDto.setMethodId(methodId);
			methodParamDto.setParamClass(1);
			List<OoApiMethodParamModel> methodParamList = ooApiMethodParamMapper.getListByModel(methodParamDto);
			JSONArray jsonArray = JSONArray.fromObject(methodParamList);
			JsonUtil.sendMsg(jsonArray.toString());
		} catch (Exception e) {
			log.error("测试页面错误", e);
		}
	}
	
	/**
	 * 提交按钮提交内容处理
	 */
	public String handleSubmitRequest() {
		try{
			Map<String, String> appParamMap = new HashMap<String, String>();
			//设置用户输入的系统级参数appKey、sessionKey、format、method
			if(!StringUtils.isEmpty(systemParam.getAppKey())) {
				appParamMap.put(OpenApiCommonConst.STRING_APPKEY, systemParam.getAppKey());
			}
			if(!StringUtils.isEmpty(systemParam.getSessionKey())) {
				appParamMap.put(OpenApiCommonConst.STRING_SESSIONKEY, systemParam.getSessionKey());
			}
			appParamMap.put(OpenApiCommonConst.STRING_FORMAT, systemParam.getFormat());
			appParamMap.put(OpenApiCommonConst.STRING_METHOD, systemParam.getMethod());
			appParamMap.put(OpenApiCommonConst.STRING_VER, systemParam.getVer());
			
			//初始化request
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
			
			Map<String, String> paramMap = new HashMap<String, String>();
			//依次设置应用级参数到map中
			String paramNames[] = paramsNames.split(",");
			String paramTypes[] = paramsTypes.split(",");
			for(int i=0;i<paramNames.length;i++) {
				//输入的应用级参数
				String tmpAppParams = request.getParameter(paramNames[i]);
				//有输入值
				if(!StringUtils.isEmpty(tmpAppParams)) {
					appParamMap.put(paramNames[i], tmpAppParams.trim());
					
					if("String".equals(paramTypes[i])) {
						paramMap.put(paramNames[i], "\""+tmpAppParams+"\"");
					} else {
						paramMap.put(paramNames[i], tmpAppParams);
					}
				}
			}
			
			StringBuilder tmpPostParams = new StringBuilder();
			//向服务器发送请求，调用API接口
			String[] httpMethods = messageSource.getMessage("https_method", null, null).split(",");
			for(String item : httpMethods){
				if(appParamMap.get(OpenApiCommonConst.STRING_METHOD).indexOf(item) != -1){
					postUrl = postUrl.replace("http", "https");
					postUrl = postUrl.replace("8080", "443");
				}
			}
			Map<String, File> fileParams = new HashMap<String, File>();
			if(logo != null){
				fileParams.put("logo", logo);
			}
			if(idCardPic !=null){
				fileParams.put("idCardPic", idCardPic);
			}
			if(businessPic !=null){
				fileParams.put("businessPic", businessPic);
			}
			if(operationCardPic !=null){
				fileParams.put("operationCardPic", operationCardPic);
			}
			if(carCardPic !=null){
				fileParams.put("carCardPic", carCardPic);
			}
			if(xszPic !=null){
				fileParams.put("xszPic", xszPic);
			}
			if(yszPic !=null){
				fileParams.put("yszPic", yszPic);
			}
			if(qzxPic !=null){
				fileParams.put("qzxPic", qzxPic);
			}
			if(szxPic !=null){
				fileParams.put("szxPic", szxPic);
			}
			if(ssxPic !=null){
				fileParams.put("ssxPic", ssxPic);
			}
			if(txzPic !=null){
				fileParams.put("txzPic", txzPic);
			}
			if(finishAuthorPic !=null){
				fileParams.put("finishAuthorPic", finishAuthorPic);
			}
    		appResult = PostClient.sendRequest(postUrl, appParamMap, fileParams, systemParam.getAppSecret(), tmpPostParams);
			postParams = tmpPostParams.toString();
		} catch (Exception e) {
			log.error("测试页面错误", e);
		}
		return "success";

	}
	
	public Integer getMethodType() {
		return methodType;
	}

	public void setMethodType(Integer methodType) {
		this.methodType = methodType;
	}

	public OoApiMethodParamMapper getOoApiMethodParamMapper() {
		return ooApiMethodParamMapper;
	}

	public void setOoApiMethodParamMapper(
			OoApiMethodParamMapper ooApiMethodParamMapper) {
		this.ooApiMethodParamMapper = ooApiMethodParamMapper;
	}

	public Integer getMethodId() {
		return methodId;
	}

	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}

	public OoApiMethodCategoryMapper getOoApiMethodCategoryMapper() {
		return ooApiMethodCategoryMapper;
	}

	public void setOoApiMethodCategoryMapper(
			OoApiMethodCategoryMapper ooApiMethodCategoryMapper) {
		this.ooApiMethodCategoryMapper = ooApiMethodCategoryMapper;
	}

	public List<OoApiMethodModel> getApiMethodInfoList() {
		return apiMethodInfoList;
	}

	public void setApiMethodInfoList(List<OoApiMethodModel> apiMethodInfoList) {
		this.apiMethodInfoList = apiMethodInfoList;
	}

	public OoApiMethodCfgMapper getOoApiMethodCfgMapper() {
		return ooApiMethodCfgMapper;
	}

	public void setOoApiMethodCfgMapper(OoApiMethodCfgMapper ooApiMethodCfgMapper) {
		this.ooApiMethodCfgMapper = ooApiMethodCfgMapper;
	}

	public OoApiMethodMapper getOoApiMethodMapper() {
		return ooApiMethodMapper;
	}

	public void setOoApiMethodMapper(OoApiMethodMapper ooApiMethodMapper) {
		this.ooApiMethodMapper = ooApiMethodMapper;
	}

	public ApiSystemParam getSystemParam() {
		return systemParam;
	}

	public void setSystemParam(ApiSystemParam systemParam) {
		this.systemParam = systemParam;
	}

	public String getPostParams() {
		return postParams;
	}

	public void setPostParams(String postParams) {
		this.postParams = postParams;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	public String getParamsNames() {
		return paramsNames;
	}

	public void setParamsNames(String paramsNames) {
		this.paramsNames = paramsNames;
	}

	public String getParamsTypes() {
		return paramsTypes;
	}

	public void setParamsTypes(String paramsTypes) {
		this.paramsTypes = paramsTypes;
	}

	public Integer getSdkType() {
		return sdkType;
	}

	public void setSdkType(Integer sdkType) {
		this.sdkType = sdkType;
	}

	public String getAppResult() {
		return appResult;
	}

	public void setAppResult(String appResult) {
		this.appResult = appResult;
	}

	public Log getLog() {
		return log;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}

	public File getIdCardPic() {
		return idCardPic;
	}

	public void setIdCardPic(File idCardPic) {
		this.idCardPic = idCardPic;
	}

	public File getBusinessPic() {
		return businessPic;
	}

	public void setBusinessPic(File businessPic) {
		this.businessPic = businessPic;
	}

	public File getOperationCardPic() {
		return operationCardPic;
	}

	public void setOperationCardPic(File operationCardPic) {
		this.operationCardPic = operationCardPic;
	}

	public File getCarCardPic() {
		return carCardPic;
	}

	public void setCarCardPic(File carCardPic) {
		this.carCardPic = carCardPic;
	}

	public File getXszPic() {
		return xszPic;
	}

	public void setXszPic(File xszPic) {
		this.xszPic = xszPic;
	}

	public File getYszPic() {
		return yszPic;
	}

	public void setYszPic(File yszPic) {
		this.yszPic = yszPic;
	}

	public File getQzxPic() {
		return qzxPic;
	}

	public void setQzxPic(File qzxPic) {
		this.qzxPic = qzxPic;
	}

	public File getSzxPic() {
		return szxPic;
	}

	public void setSzxPic(File szxPic) {
		this.szxPic = szxPic;
	}

	public File getSsxPic() {
		return ssxPic;
	}

	public void setSsxPic(File ssxPic) {
		this.ssxPic = ssxPic;
	}

	public File getTxzPic() {
		return txzPic;
	}

	public void setTxzPic(File txzPic) {
		this.txzPic = txzPic;
	}

	public File getFinishAuthorPic() {
		return finishAuthorPic;
	}

	public void setFinishAuthorPic(File finishAuthorPic) {
		this.finishAuthorPic = finishAuthorPic;
	}
	
	
}
