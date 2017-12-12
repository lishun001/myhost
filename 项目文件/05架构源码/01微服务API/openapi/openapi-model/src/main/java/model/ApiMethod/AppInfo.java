package model.ApiMethod;

public class AppInfo {

	private Long id;
	private String appName;
	private String appKey;
	private String appSecret;
	private String appUserTable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppUserTable() {
		return appUserTable;
	}

	public void setAppUserTable(String appUserTable) {
		this.appUserTable = appUserTable;
	}
	
}
