package com.openapi.model.response.order;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("orderStatResponse")
public class OrderStatResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private Integer orderStatId; // 订单统计号
	private String result;	//返回信息
	
	public Integer getOrderStatId() {
		return orderStatId;
	}
	public void setOrderStatId(Integer orderStatId) {
		this.orderStatId = orderStatId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}