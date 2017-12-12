package com.openapi.model.request.wallet;

import com.jiuwu.openoo.common.openapi.request.Request;

/**
 * 提现判断支付密码
 * @author lishun
 *
 */
public class WalletInitPwdRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8326431050451290874L;
	
	private Integer userId;  //用户ID
	private Double withdrawMny;	//提现金额
	private String userPayId;	//提现账户Id
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getWithdrawMny() {
		return withdrawMny;
	}
	public void setWithdrawMny(Double withdrawMny) {
		this.withdrawMny = withdrawMny;
	}
	public String getUserPayId() {
		return userPayId;
	}
	public void setUserPayId(String userPayId) {
		this.userPayId = userPayId;
	}
	
	
}
