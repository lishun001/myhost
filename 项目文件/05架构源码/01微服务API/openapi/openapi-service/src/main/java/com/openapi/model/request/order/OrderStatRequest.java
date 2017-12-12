package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class OrderStatRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520115154935104251L;
	
	private Integer userId;
	private String ownerName;
	private String ownePhone;
	private String cargoOrderIds; //多个订单用","分隔
	private Double statAmount;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnePhone() {
		return ownePhone;
	}
	public void setOwnePhone(String ownePhone) {
		this.ownePhone = ownePhone;
	}
	public Double getStatAmount() {
		return statAmount;
	}
	public void setStatAmount(Double statAmount) {
		this.statAmount = statAmount;
	}
	public String getCargoOrderIds() {
		return cargoOrderIds;
	}
	public void setCargoOrderIds(String cargoOrderIds) {
		this.cargoOrderIds = cargoOrderIds;
	}
	
}
