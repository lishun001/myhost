package com.openapi.model.response.user;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("updatePwdResponse")
public class UpdatePwdResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7411106673995463235L;
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
