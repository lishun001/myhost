package com.openapi.model.request.user;

import com.jiuwu.openoo.common.openapi.request.Request;

public class UserCodeRequest extends Request {

	private static final long serialVersionUID = 1L;
	
	private String codeType;	//验证码类型1为注册 2为忘记密码
	private String phone;		//手机号
	
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
