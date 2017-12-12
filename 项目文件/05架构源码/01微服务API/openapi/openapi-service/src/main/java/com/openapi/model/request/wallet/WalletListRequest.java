package com.openapi.model.request.wallet;

import com.openapi.model.request.PageRequest;

/**
 * 充值和提现 表单实现的共同请求参数
 * @author grace
 *
 */
public class WalletListRequest extends PageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8326431050451290874L;
	
	private Integer userId;  //用户ID
	private Integer userTaId;  //用户Ta币ID
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
}
