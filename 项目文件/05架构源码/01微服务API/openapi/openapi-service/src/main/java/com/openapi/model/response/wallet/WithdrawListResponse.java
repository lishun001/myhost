package com.openapi.model.response.wallet;

import java.util.List;

import view.wallet.WithdrawVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("withdrawListResponse")
public class WithdrawListResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5805703063464091903L;
	
	private List<WithdrawVo> withdrawList;

	public List<WithdrawVo> getWithdrawList() {
		return withdrawList;
	}

	public void setWithdrawList(List<WithdrawVo> withdrawList) {
		this.withdrawList = withdrawList;
	}
	
}
