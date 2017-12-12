package com.openapi.model.request.wallet;

import com.jiuwu.openoo.common.openapi.request.Request;

public class UserTaBalanceRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8294346162831315080L;
	
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
