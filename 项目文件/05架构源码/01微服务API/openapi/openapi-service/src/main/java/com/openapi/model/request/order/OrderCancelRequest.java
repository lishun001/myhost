package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class OrderCancelRequest  extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private String cargoOrderId; //订单id
	private Integer userId;		 //当前申请人
	private Integer userCancelType; //取消类型（1=车主，2=货主）
	private String reason;	//取消理由
	
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getUserCancelType() {
		return userCancelType;
	}
	public void setUserCancelType(Integer userCancelType) {
		this.userCancelType = userCancelType;
	}
	
}
