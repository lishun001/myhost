package com.openapi.model.response.wallet;


import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("balanceResponse")
public class UserTaBalanceResponse extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7159855823833830756L;
	/**账户余额*/
	private String taBalance;  
	/**货币等值比例*/
	private Double rates;   
	/**积分等值比例*/
	private Double integralRates; 
	/**用户Ta币ID*/
	private Integer userTaId;  
	/**提现规则*/
	private String introduce; 
	/**是否需要初始化密码*/
	private String isInit;  
	public String getTaBalance() {
		return taBalance;
	}
	public void setTaBalance(String taBalance) {
		this.taBalance = taBalance;
	}
	public Double getRates() {
		return rates;
	}
	public void setRates(Double rates) {
		this.rates = rates;
	}
	public Integer getUserTaId() {
		return userTaId;
	}
	public void setUserTaId(Integer userTaId) {
		this.userTaId = userTaId;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getIsInit() {
		return isInit;
	}
	public void setIsInit(String isInit) {
		this.isInit = isInit;
	}
	public Double getIntegralRates() {
		return integralRates;
	}
	public void setIntegralRates(Double integralRates) {
		this.integralRates = integralRates;
	}
	
	
}
