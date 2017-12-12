package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class CargoApplyRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520115154935104351L;
	
	private Integer userId;		//接单人
	private String cargoOrderId; //订单id
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	
}
