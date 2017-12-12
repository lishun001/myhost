package com.openapi.model.request.user;

import com.jiuwu.openoo.common.openapi.request.Request;

public class UpdatePwdRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = -577879327630643950L;
	/**
	 * 
	 */
	
	private Integer userId; //用户ID
	private String newPwd;  //新密码
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	
}
