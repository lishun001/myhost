package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class LogisticsOrderRequest  extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private String cargoOrderId;
	
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	
}
