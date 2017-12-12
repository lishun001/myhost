package com.openapi.model.response.wallet;

import com.jiuwu.openoo.common.openapi.response.Response;

public class AddUserAccountResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3052582686427068333L;
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
