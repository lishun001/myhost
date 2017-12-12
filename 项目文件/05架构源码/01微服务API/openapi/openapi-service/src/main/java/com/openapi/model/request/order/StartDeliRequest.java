package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class StartDeliRequest  extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private String cargoOrderId; //订单id
	private Integer userId;		 //当前配送人
	private Integer cargoDeliId; //订单配送id
	private String nowLocation;	//当前地点(经纬度指定的地点名)，用于物流登记
	private String nowGps;		//当前地理位置（ A,B），用于物流登记
	
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public String getNowLocation() {
		return nowLocation;
	}
	public void setNowLocation(String nowLocation) {
		this.nowLocation = nowLocation;
	}
	public String getNowGps() {
		return nowGps;
	}
	public void setNowGps(String nowGps) {
		this.nowGps = nowGps;
	}
	public Integer getCargoDeliId() {
		return cargoDeliId;
	}
	public void setCargoDeliId(Integer cargoDeliId) {
		this.cargoDeliId = cargoDeliId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
