package com.openapi.model.response.user;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userCodeResponse")
public class UserCodeResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private String code;	//手机验证吗

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
