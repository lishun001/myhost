package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class LocadAndDeliCargoRequest  extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private String cargoOrderId;
	private String locationGps;	//装货车当前的地理位置（ A,B）
	
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public String getLocationGps() {
		return locationGps;
	}
	public void setLocationGps(String locationGps) {
		this.locationGps = locationGps;
	}
	
	
	
}
