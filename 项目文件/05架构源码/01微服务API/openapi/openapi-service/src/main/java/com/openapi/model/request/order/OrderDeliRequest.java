package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class OrderDeliRequest  extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private Integer carUserId;		 //提醒当前司机的userid
	private Integer cargoDeliId; //订单配送id
	
	public Integer getCarUserId() {
		return carUserId;
	}
	public void setCarUserId(Integer carUserId) {
		this.carUserId = carUserId;
	}
	public Integer getCargoDeliId() {
		return cargoDeliId;
	}
	public void setCargoDeliId(Integer cargoDeliId) {
		this.cargoDeliId = cargoDeliId;
	}
	
	
}
