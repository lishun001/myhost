package com.openapi.model.request.wallet;

import com.openapi.model.request.PageRequest;

public class IncomeExpenseRequest extends PageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2551005398710917160L;
	
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
