package com.openapi.model.response.wallet;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("rechargeOrderResponse")
public class RechargeOrderResponse extends Response {

	
	/**
	 * 创建“充值订单”响应参数
	 */
	private static final long serialVersionUID = -8224406232031664532L;
	private String result;
	private String rechargeOrderId;	//订单号
	private String rechargeSubject;//显示名称
	private Double rechargeMny;//充值金额
	private Double rechargeTa; //货币等值比例
	private String notifyUrl;	//异步通知url
	private String returnUrl;	//支付宝填写支付请求url
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRechargeOrderId() {
		return rechargeOrderId;
	}
	public void setRechargeOrderId(String rechargeOrderId) {
		this.rechargeOrderId = rechargeOrderId;
	}
	public Double getRechargeMny() {
		return rechargeMny;
	}
	public void setRechargeMny(Double rechargeMny) {
		this.rechargeMny = rechargeMny;
	}
	public String getRechargeSubject() {
		return rechargeSubject;
	}
	public void setRechargeSubject(String rechargeSubject) {
		this.rechargeSubject = rechargeSubject;
	}
	public Double getRechargeTa() {
		return rechargeTa;
	}
	public void setRechargeTa(Double rechargeTa) {
		this.rechargeTa = rechargeTa;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	
}
