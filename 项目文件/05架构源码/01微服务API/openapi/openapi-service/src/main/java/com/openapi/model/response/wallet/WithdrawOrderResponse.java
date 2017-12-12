package com.openapi.model.response.wallet;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 提现订单插入的响应参数
 * @author grace
 *
 */
@XStreamAlias("withdrawOrderResponse")
public class WithdrawOrderResponse extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8880444577453946462L;
	
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
