package com.openapi.model.request.wallet;

import com.jiuwu.openoo.common.openapi.request.Request;

/**
 * 判断登陆密码
 * @author lishun
 *
 */
public class WalletVerifyPwdRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8326431050451290874L;
	
	private Integer userId;  //用户ID
	private String verifyPwd;	//验证登陆密码
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getVerifyPwd() {
		return verifyPwd;
	}
	public void setVerifyPwd(String verifyPwd) {
		this.verifyPwd = verifyPwd;
	}
	
}
