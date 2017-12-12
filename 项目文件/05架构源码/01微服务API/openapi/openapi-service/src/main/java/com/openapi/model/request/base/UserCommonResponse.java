package com.openapi.model.request.base;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userResponse")
public class UserCommonResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;	//用户id
	private String result;	//返回信息

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
