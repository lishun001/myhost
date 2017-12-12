package com.openapi.model.request.car;

import com.openapi.model.request.PageRequest;

public class CarTravelListRequest  extends PageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private String locationGps;	//当前的地理位置（ A,B）
	private Integer travelType;	//行程类型（1=拼车，2=包车）
	
	public String getLocationGps() {
		return locationGps;
	}

	public void setLocationGps(String locationGps) {
		this.locationGps = locationGps;
	}

	public Integer getTravelType() {
		return travelType;
	}

	public void setTravelType(Integer travelType) {
		this.travelType = travelType;
	}
	
	
}
