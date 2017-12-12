package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class FeedBackRequest  extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private String cargoOrderId; //订单id
	private Integer userId;		 //当前配送人
	private String feekBack;	//反馈信息
	
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
	public String getFeekBack() {
		return feekBack;
	}
	public void setFeekBack(String feekBack) {
		this.feekBack = feekBack;
	}
	
	
	
}
