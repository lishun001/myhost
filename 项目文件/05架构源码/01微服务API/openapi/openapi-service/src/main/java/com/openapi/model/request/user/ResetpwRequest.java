package com.openapi.model.request.user;

import com.jiuwu.openoo.common.openapi.request.Request;

public class ResetpwRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2883166894027123149L;
	//1. 注册信息
	private String phone;		//否	手机号
	private String password;	//密码 md5加密
	private String validateCode; //验证码
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
}
