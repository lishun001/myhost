package com.openapi.model.request.user;

import com.jiuwu.openoo.common.openapi.request.Request;

public class UserDetailRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 231612212902363399L;

	private Integer userId;
	private String phone;

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
