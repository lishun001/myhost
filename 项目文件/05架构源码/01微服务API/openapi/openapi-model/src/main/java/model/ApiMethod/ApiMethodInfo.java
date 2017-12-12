package model.ApiMethod;

public class ApiMethodInfo {

	private Integer id;
	private Integer methodType;
	private String method;
	private String methodVer;
	private String methodName;
	private Integer authLevel;
	private Integer isOpen;
	private String redirectValue;
	private String methodCfg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMethodType() {
		return methodType;
	}

	public void setMethodType(Integer methodType) {
		this.methodType = methodType;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethodVer() {
		return methodVer;
	}

	public void setMethodVer(String methodVer) {
		this.methodVer = methodVer;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Integer getAuthLevel() {
		return authLevel;
	}

	public void setAuthLevel(Integer authLevel) {
		this.authLevel = authLevel;
	}

	public Integer getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

	public String getRedirectValue() {
		return redirectValue;
	}

	public void setRedirectValue(String redirectValue) {
		this.redirectValue = redirectValue;
	}

	public String getMethodCfg() {
		return methodCfg;
	}

	public void setMethodCfg(String methodCfg) {
		this.methodCfg = methodCfg;
	}
	
	
	

}
