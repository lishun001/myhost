package com.openapi.model.request.car;

import com.openapi.model.request.PageRequest;

public class CarListRequest  extends PageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private Integer userId;	//用户id
	private String result;	//返回信息
	private String locationGps;	//当前的地理位置（ A,B）
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLocationGps() {
		return locationGps;
	}

	public void setLocationGps(String locationGps) {
		this.locationGps = locationGps;
	}
	
	
}
