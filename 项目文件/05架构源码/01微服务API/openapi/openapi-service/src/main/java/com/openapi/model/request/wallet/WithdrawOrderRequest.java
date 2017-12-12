package com.openapi.model.request.wallet;

import com.jiuwu.openoo.common.openapi.request.Request;

/**
 * 创建提现表单的请求参数
 * @author grace
 *
 */

public class WithdrawOrderRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7985579260467524896L;
	
	private Integer userId; // 用户ID
	private Integer userTaId; //用户ta币id
//	private Double withdrawMny;	// 提现金额
	private Double withdrawTa; // 提现ta币
	private String userPayId ; // 提现账户Id
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserTaId() {
		return userTaId;
	}
	public void setUserTaId(Integer userTaId) {
		this.userTaId = userTaId;
	}
//	public Double getWithdrawMny() {
//		return withdrawMny;
//	}
//	public void setWithdrawMny(Double withdrawMny) {
//		this.withdrawMny = withdrawMny;
//	}
	public Double getWithdrawTa() {
		return withdrawTa;
	}
	public void setWithdrawTa(Double withdrawTa) {
		this.withdrawTa = withdrawTa;
	}
	public String getUserPayId() {
		return userPayId;
	}
	public void setUserPayId(String userPayId) {
		this.userPayId = userPayId;
	}
	
}
