package com.openapi.model.response.wallet;

import java.util.List;

import view.wallet.UserAccountVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userAccountListResponse")
public class UserAccountListResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2143347035812691748L;
	
	private List<UserAccountVo> accountList;

	public List<UserAccountVo> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<UserAccountVo> accountList) {
		this.accountList = accountList;
	}
	
	
}
