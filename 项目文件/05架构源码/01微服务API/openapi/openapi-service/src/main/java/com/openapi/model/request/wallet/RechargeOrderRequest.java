package com.openapi.model.request.wallet;

import com.jiuwu.openoo.common.openapi.request.Request;

public class RechargeOrderRequest extends Request {

	/**
	 *  创建“充值订单”响应参数
	 */
	private static final long serialVersionUID = -6976170403653242769L;
	/**
	 * 
	 */
	private Integer userTaId; //用户ta币id
	private Double rechargeMny;	// 充值金额
	private String accountType; //账户类型（AliPay，WeChatPay，UnionPay）
	
	public Integer getUserTaId() {
		return userTaId;
	}
	public void setUserTaId(Integer userTaId) {
		this.userTaId = userTaId;
	}
	public Double getRechargeMny() {
		return rechargeMny;
	}
	public void setRechargeMny(Double rechargeMny) {
		this.rechargeMny = rechargeMny;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
