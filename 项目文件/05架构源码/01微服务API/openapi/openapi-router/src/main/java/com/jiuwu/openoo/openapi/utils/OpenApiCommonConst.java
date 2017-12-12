package com.jiuwu.openoo.openapi.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ApiMethod.ApiMethodInfo;
import model.ApiMethod.AppInfo;


public final class OpenApiCommonConst {

	private OpenApiCommonConst() {
		
	}
	
	/** 每个接口每天限定访问次数 */
	public static final String STRING_TOTAL_NUM_DAY_PER = "TOTAL_NUM_DAY_PER";

	/** 每个接口每分钟限定访问次数 */
	public static final String STRING_TOTAL_NUM_MIN_PER = "TOTAL_NUM_MIN_PER";
	
	/** APP调用接口的频率限制*/
	public static final String STRING_TOTAL_NUM_APP_DAY_PER = "TOTAL_NUM_APP_DAY_PER";
	
	/** 重定向的服务器地址 */
	public static final String REDIRECT_HOST = "REDIRECT_HOST";

	/**接口版本号(1.0)*/
	public static final String METHOD_VER = "1.0";
	
	/**所有接口频率控制接口名称*/
	public static final String YHD_COMMON_VISIT_SET = "jiuwu.common.visit.set";
	
	/**所有接口频率*/
	public static final Map<String,Long> allMethodLimit = new HashMap<String,Long>();
	
	/**所有接口及级别*/
	public static final Map<String, ApiMethodInfo> allMethodInfoMap = new HashMap<String, ApiMethodInfo>();
	/**所有app信息*/
	public static final Map<String, AppInfo> allAppInfoMap = new HashMap<String, AppInfo>();
	
	public static final Map<String, String> generalCfgMap = new HashMap<String, String>();
	
	public static final String DOULBE_REGEX = "^(0|[1-9][0-9]{0,8})(\\.[0-9]{1,2})?$";
	public static final String DATETIME_REGEX = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
	public static final String IP_REGEX = "^((([1-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5])))\\.((([0-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5])))\\.((([0-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5]))|\\*)\\.((([0-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5]))|\\*)$";

	
	
	public static final String DEFAULT_SIGN_SECRET = "sdfCXGH45tergehHKAHICVDlkhjY";
	
	
	/**所有增值包对应的增值接口*/
	public static final Map<Integer, List<String>> allExtraPackageMethod = new HashMap<Integer, List<String>>();
	
	/**INSHOP_API_METHOD_INVOKE_LIMIT表记录变更时间*/
	public static final Map<String,Date> changeTime = new HashMap<String,Date>();
	
	/**记录增值包变更时间*/
	public static final Map<String,Date> ExtraPackageChangeTime = new HashMap<String,Date>();
	
	/**记录所有app的ip白名单，若某个app还没有设置ip白名单，则为null
	 * @param key   => appId
	 * @param value => whiteIps
	 */
	public static final Map<Integer,String> whiteIpMap = new HashMap<Integer,String>();
	
	/** 返回数据格式 xml/json */
	public static final String FORMAT_JSON = "json";
	/** 返回数据格式 xml/json */
	public static final String FORMAT_XML = "xml";
	
	/**错误编码*/
	public static final String ERRORCODE = "errorCode";
	
	/** 返回数据格式 xml/json */
	public static final String APPLICATION_JSON = "application/json";
	/** 返回数据格式 xml/json */
	public static final String APPLICATION_XML = "application/xml";
	
	
	/** 系统级参数 */
	public static String[] SYSTEM_PARAM_ARRAY = new String[]{"method", "ver", "sign"};
	/** timestamp */
	public static final String STRING_TIMESTAMP = "timestamp";
	/** 返回数据格式 xml/json */
	public static final String STRING_FORMAT = "format";
	/** 验证码 */
	public static final String STRING_SIGN = "sign";
	/** 版本号 */
	public static final String STRING_VER = "ver";
	/** 调用的接口名称 */
	public static final String STRING_METHOD = "method";
	/** 选择显示字段 */
	public static final String STRING_FIELDS = "fields";
	/** appKey */
	public static final String STRING_APPKEY = "appKey";
	/** sessionKey */
	public static final String STRING_SESSIONKEY = "sessionKey";
	/**app对应的用户表*/
	public static final String APP_USER_TABLE = "appUserTable";
	
	/** sdk的版本类型*/
	public static final String STRING_SDK = "sdkType";

	/** merchantId */
	public static final String STRING_MERCHANT_ID = "merchantId";
	/** SupplierId */
	public static final String STRING_SUPPLIER_ID = "supplierId";
	/** 应用id*/
	public static final String STRING_APP_ID = "appId";
	/**应用编码*/
	public static final String STRING_APP_CODE = "appCode";
	/** sby用户id（内部获取）*/
	public static final String STRING_USER_ID = "userId";
	/**用户类型 */
	public static final String STRING_USER_TYPE = "userType";
	/**OO用户*/
	public static final String STRING_USER_TYPE_OO = "0";
	/**大博用户*/
	public static final String STRING_USER_TYPE_DB = "1";
	
	public static final String STRING_IP = "ip";
	/** appKey */
	public static final String APP_KEY = "appKey";
	
	
	/**
	 * 需要http请求的方法表
	 */
	public static final String HTTPS_METHOD ="https_method";
	
	/** sign密钥 */
	public static final String STRING_SIGN_SECRET = "SIGN_SECRET";
	
	/** 是否为图书（1：是、0：否） */
	public static final String STRING_PRODUCT_TYPE = "productType";
		
	/** 彩票商家 */
	public static final String CAIPIAO_MERCHANT = "CAIPIAO_MERCHANT";
	/** 彩票接口 */
	public static final String CAIPIAO_METHOD = "CAIPIAO_METHOD";
	
	/** 验证商家checkcode是否合法 */
	public static final String MERCHANT_CHECKCODE_CHECK = "merchant.checkcode.check";
	
	/**验证商家merchantType接口调用权限*/
	
	public static final String MERCHANT_ROLE = "MERCHANT_ROLE";
	
	/**商家基本权限*/
	public static final String MERCHANT_ROLE_0 = "MERCHANT_ROLE_0";
	
	/**商家额外权限*/
	public static final String MERCHANT_ROLE_1 = "MERCHANT_ROLE_";
	
	/** 产品名称*/
	public static final String STRING_PRODUCT_CNAME = "productCname";
	
	/** 产品名称前缀*/
	public static final String STRING_PRODUCT_NAME_PREFIX = "productNamePrefix";
	
	/** 产品文描*/
	public static final String STRING_PRODUCT_DESCRIPTION = "productDescription";
	
	/** api调用正常 */
	public static final Integer RESULT_TYPE_1 = 1;
	
	/** api调用失败 */
	public static final Integer RESULT_TYPE_2 = 2;
	
	/** api调用正常、包含部分错误信息 */
	public static final Integer RESULT_TYPE_3 = 3;
	
	/** api被禁止，由于成功率过低 */
	public static final Integer RESULT_TYPE_4 = 4;
	
	/**接口级别0:不需要appKey和sessionKey*/
	public static final Integer L0 =0;
	/**接口级别1:不需要appKey*/
	public static final Integer L1 =1;
	/**接口级别2:需要appKey和sessionKey*/
	public static final Integer L2 =2;
	/**接口级别3:需要appKey和sessionKey，一次失效*/
	public static final Integer L3 =3;
	
	public interface ERROR_MSG{
		
		/** 每分钟的访问频率 */
		public static final String MIN_PRE_VISIT_OVER = "jiuwu.visit.error.min_pre_visit_over";
		/** 每天的访问总数 */
		public static final String DAY_PRE_VISIT_OVER = "jiuwu.visit.error.day_pre_visit_over";
		/** APP每天访问总数*/
		public static final String DAY_PER_APP_VISIT_OVER = "jiuwu.visit.error.day_pre_app_visit_over";
		
		/** 系统参数{0}为空或非法 */
		public static final String SYSTEM_PARAM_ERROR = "jiuwu.system.param.error";
		/** 请求时间超过误差限制（最大10分钟） */
		public static final String TIMESTAMP_INVALID  = "jiuwu.system.param.timestamp_invalid";
		/** 接口名称或者版本非法 */
		public static final String METHOD_VER_INVALID = "jiuwu.system.param.method_ver_invalid";
		/** 接口级别信息未找到 */
		public static final String METHOD_LEVEL_NOT_FOUND = "jiuwu.system.param.method_level_not_found";
		/** 接口级别有误（0、1、2、3） */
		public static final String METHOD_LEVEL_INVALID = "jiuwu.system.param.method_level_invalid";
		/** app无权限调用该增值接口 */
		public static final String METHOD_EXTRA_INVALID = "jiuwu.system.param.method_extra_invalid";
		/** 校验app调用增值接口出错 */
		public static final String METHOD_EXTRA_ERROR = "jiuwu.system.param.method_extra_error";
		/** 服务跳转有误，请检查配置是否正确 */
		public static final String EDIRECT_ERROR = "jiuwu.system.param.redirect_error";
		/** sign非法 */
		public static final String SIGN_INVALID = "jiuwu.system.param.sign_invalid";
		/** 系统错误 */
		public static final String SYSTEM_ERROR = "jiuwu.system.error";
		/** 接口错误 */
		public static final String METHOD_ERROR = "jiuwu.system.method.error";
		/** Hedwig服务调用异常:{0} */
		public static final String HEDWIG_SERVICE_ERROR = "jiuwu.system.service.error";
		
		/** SDK调用方法未找到 */
		public static final String SDK_REQUEST_METHOD_NOT_FOUND = "jiuwu.system.sdk.request_method_not_found";
		
		/** SDK请求类未找到 */
		public static final String SDK_REQUEST_CLASS_NOT_FOUND = "jiuwu.system.sdk.request_class_not_found";
		
		/** SDK解析异常 */
		public static final String SDK_PARSE_ERROR = "jiuwu.system.sdk.parse_error";
		
		/** 商家接口调用成功率低被限制 */
		public static final String METHOD_SERVICE_LIMIT = "jiuwu.system.method.limit";
		
		/** 参数包含非法字符 */
		public static final String PARAM_INVALID = "jiuwu.system.param.invalid";
		/** 图片上传失败 */
		public static final String IMG_UPLOAD_ERROR = "jiuwu.system.img.upload_error";
		/** 上传图片数量超过设置上限 */
		public static final String IMG_NUM_OVER = "jiuwu.system.img.num_over";
		/** 上传图片大小超过1m */
		public static final String IMG_SIZE_OVER = "jiuwu.system.img.size_over";
		/**上传的图片数量不能为0*/
		public static final String IMG_NUM_NULL = "jiuwu.system.img.num_null";
		/** 上传图片文件格式错误 */
		public static final String IMG_FORMAT_ERROR = "jiuwu.system.img.format_error";
		/** 上传图片分辨率错误 */
		public static final String IMG_RESOLUTION_ERROR = "jiuwu.system.img.resolution_error";
		/** 上传图片 比例错误 */
		public static final String IMG_SCALE_ERROR = "jiuwu.system.img.scale_error";
		/**商家权限不足*/
		public static final String MERCHANT_TYPE_ERROR = "jiuwu.system.merchant.type.error";
		
		//SBY异常信息
		/** SBY接口异常 :{0}*/
		public static final String SBY_ERROR = "jiuwu.system.sby.error";
		/** AppKey({0})不存在*/
		public static final String APPKEY_NOT_FPUND = "jiuwu.system.param.appkey_not_found";
		/** SessionKey({0})不存在*/
		public static final String SESSIONKEY_NOT_FOUND = "jiuwu.system.param.sessionkey_not_found";
		/** SBY用户不存在*/
		public static final String SBYUSER_NOT_FOUND = "jiuwu.system.param.sbyuser_not_found";
		/** AppKey({0})和SessionKey({1})不匹配*/
		public static final String SBY_APPKEY_SESSIONKEY_NOT_MATCH = "jiuwu.system.param.appkey_sessionkey_not_match";
		/** Sessionkey({0})已失效*/
		public static final String SBY_SESSIONKEY_EXPIRED = "jiuwu.system.param.sessionkey_expired";
		/** SessionKey({0})的失效时间格式不正确*/
		public static final String SBY_SESSIONKEY_EXPIREDATE_INVALID = "jiuwu.system.param.sessionkey_expiredate_invalid";
		/** SBY用户不存在*/
		public static final String SBY_USER_NOT_FOUND = "jiuwu.system.param.user_not_found";
		/** SBY用户对应的商家不存在*/
		public static final String SBY_MERCHANT_NOT_FOUND = "jiuwu.system.param.merchantid_not_found";
		/** SBY用户类型错误，与应用接口类型不匹配*/
		public static final String SBY_USER_TYPE_ERROR = "jiuwu.system.param.sby_user_type_error";
		/** Category type不存在*/
		public static final String CATEGORY_TYPE_NOT_FOUND = "jiuwu.system.param.category_type_not_found";
		/** 访问接口的IP白名单中不包含用户的IP*/
		public static final String USER_IP_NOT_IN_WHITEIP = "jiuwu.system.param.suer_ip_not_in_whiteip";
		
		/**批量上传图片失败{0}*/
		public static final String YHD_PIC_SPACE_PICS_UPLOAD_ERROR = "jiuwu.pic.space.pics.upload.error";
		/**图片分类ID有误*/
		public static final String YHD_PIC_SPACE_PICS_UPLOAD_PARAM_INVALID = "jiuwu.pic.space.pics.upload.param_invalid";
		
	}
	
	public interface UPLOAD_ATTACHMENT{
			
			/** 支持上传附件的接口定义（用;号分隔） */
			public static final String UPLOAD_ATTACHMENT_METHOD = "UPLOAD_ATTACHMENT_METHOD";
			
			/** 最多上传文件的数量 */
			public static final String UPLOAD_ATTACHMENT_MAX_NUM = "UPLOAD_ATTACHMENT_MAX_NUM";
			
			/** 新增系列子品图片最大数量 */
			public static final String UPLOAD_ATTACHMENT_MAX_NUM_SERIAL_IMG = "UPLOAD_ATTACHMENT_MAX_NUM_SERIAL_IMG";
			/** 每个附件的最大size限制（1M） */
			public static final String UPLOAD_ATTACHMENT_FILE_SIZE = "UPLOAD_ATTACHMENT_FILE_SIZE";
			
			/** 上传临时文件的路径设置 */
			public static final String UPLOAD_ATTACHMENT_TEMP_PATH = "UPLOAD_ATTACHMENT_TEMP_PATH";
			
			
	}
	
	
	
	
	
	
}
