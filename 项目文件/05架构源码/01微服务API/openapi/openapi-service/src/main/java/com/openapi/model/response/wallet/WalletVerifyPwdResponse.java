package com.openapi.model.response.wallet;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("walletVerifyPwdResponse")
public class WalletVerifyPwdResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5805703063464091903L;
	
	private String result;	//结果
	private String isVerifyLogin;	//是否验证登陆身份（0=未验证，1=验证）
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getIsVerifyLogin() {
		return isVerifyLogin;
	}
	public void setIsVerifyLogin(String isVerifyLogin) {
		this.isVerifyLogin = isVerifyLogin;
	}
	
}
