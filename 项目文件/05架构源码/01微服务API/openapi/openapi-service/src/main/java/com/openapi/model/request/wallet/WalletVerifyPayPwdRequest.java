package com.openapi.model.request.wallet;

import com.openapi.model.request.PageRequest;

/**
 * 判断支付密码
 * @author lishun
 *
 */
public class WalletVerifyPayPwdRequest extends PageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8326431050451290874L;
	
	private Integer userId;  //用户ID
	private String  payPwd;	//支付密码，请客户端MD5加密
	
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
