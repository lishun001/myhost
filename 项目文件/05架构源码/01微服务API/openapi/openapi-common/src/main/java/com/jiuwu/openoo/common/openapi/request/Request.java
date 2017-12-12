package com.jiuwu.openoo.common.openapi.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求对象request
 * @author ouyangjian
 */
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 客户端IP */
	private String ip;
	
	/**用户类型*/
	private Integer userType;

	/** 语言设置默认1 （1：中文、2：英文、3：韩文） */
	private Integer language;
	
	/**appKey*/
	private String appKey;
	
	/**appUserTable*/
	private String appUserTable;
	
	/**系统版本号*/
	private String ver;

	/** 参数params */
	private Map<String, String> headerMap = new HashMap<String, String>();

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public Map<String, String> getHeaderMap() {
		return headerMap;
	}

	public void setHeaderMap(Map<String, String> headerMap) {
		this.headerMap = headerMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppUserTable() {
		return appUserTable;
	}

	public void setAppUserTable(String appUserTable) {
		this.appUserTable = appUserTable;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}
	
}
