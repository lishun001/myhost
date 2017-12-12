package model.ApiMethod;

/**
 * app接口系统级参数
 */
public class ApiSystemParam {

	/**应用key*/
	private String appKey;
	
	/**回话session*/
	private String sessionKey;
	
	/**方法英文名称*/
	private String method;

	/**返回数据格式 xml/json*/
	private String format;
	
	/**接口版本号*/
	private String ver = "1.0";
	
	/**加密密钥*/
	private String appSecret;

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
}
