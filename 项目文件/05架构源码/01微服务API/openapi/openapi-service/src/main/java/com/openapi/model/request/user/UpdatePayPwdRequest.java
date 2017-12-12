package com.openapi.model.request.user;



import com.jiuwu.openoo.common.openapi.request.Request;

public class UpdatePayPwdRequest extends Request {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8464567801556395024L;
	
	private Integer userId;  //用户id
	private String payPwd;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPayPwd() {
		return payPwd;
	}
	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}
	
	
}	
