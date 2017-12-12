package com.openapi.model.response.wallet;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("walletPayPwdResponse")
public class WalletVerifyPayPwdResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5805703063464091903L;
	
	private String result;	//结果
	private long endTime;	//倒计时毫秒
	private int allowMinute;		//应许分钟
	private String verifyResult;	//验证结果
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getVerifyResult() {
		return verifyResult;
	}
	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
	}
	
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public int getAllowMinute() {
		return allowMinute;
	}
	public void setAllowMinute(int allowMinute) {
		this.allowMinute = allowMinute;
	}
	
}
