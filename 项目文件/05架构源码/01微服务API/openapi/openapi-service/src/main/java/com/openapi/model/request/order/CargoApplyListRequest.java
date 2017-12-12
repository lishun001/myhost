package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class CargoApplyListRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520115154935104351L;
	
	private Integer orderStatId;		//订单统计id

	public Integer getOrderStatId() {
		return orderStatId;
	}

	public void setOrderStatId(Integer orderStatId) {
		this.orderStatId = orderStatId;
	}
	
}
