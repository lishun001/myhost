package com.openapi.model.request.wallet;

import com.jiuwu.openoo.common.openapi.request.Request;

public class UserAccountListRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5985349444973379642L;
	
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
