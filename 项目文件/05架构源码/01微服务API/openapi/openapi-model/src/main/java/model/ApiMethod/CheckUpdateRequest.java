package model.ApiMethod;

import com.jiuwu.openoo.common.openapi.request.Request;

public class CheckUpdateRequest extends Request {

	private static final long serialVersionUID = 1L;
	/** app版本号 */
	private String appVersion;

	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
}
