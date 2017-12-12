package com.openapi.model.response.user;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("logoResponse")
public class UserRegisterStep03Response extends Response {

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String url;	//手机验证吗

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
