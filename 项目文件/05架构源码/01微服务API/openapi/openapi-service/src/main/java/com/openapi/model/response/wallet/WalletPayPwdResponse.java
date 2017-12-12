package com.openapi.model.response.wallet;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("walletPayPwdResponse")
public class WalletPayPwdResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5805703063464091903L;
	
	private String result;	//结果
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
