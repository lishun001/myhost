package com.openapi.model.request.wallet;

import com.jiuwu.openoo.common.openapi.request.Request;

public class AddUserAccountRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2832461455518356838L;
	
	private Integer userId;
	private String accountType;
	private String account;
	private String accountName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
