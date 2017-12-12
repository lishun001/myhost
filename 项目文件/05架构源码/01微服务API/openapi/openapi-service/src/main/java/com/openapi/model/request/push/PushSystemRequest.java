package com.openapi.model.request.push;

import com.jiuwu.openoo.common.openapi.request.Request;

/**
 * 系统消息推送  请求
 * @author eason
 */
public class PushSystemRequest extends Request{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6222491355567686681L;
	private Integer appId=2;		//推送应用id 固定值2号应用
    private String pushTitle;	//推送标题
    private String pushContent;	//推送内容
    
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getPushTitle() {
		return pushTitle;
	}
	public void setPushTitle(String pushTitle) {
		this.pushTitle = pushTitle;
	}
	public String getPushContent() {
		return pushContent;
	}
	public void setPushContent(String pushContent) {
		this.pushContent = pushContent;
	}
}
