package com.openapi.model.response.wallet;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("walletInitPwdResponse")
public class WalletInitPwdResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5805703063464091903L;
	
	private String result;	//结果
	private String isShow;	//0=弹出“请输入支付密码”	1=弹出“请初始化设置支付密码”
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
}
