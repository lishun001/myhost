package com.openapi.model.request.car;

import com.openapi.model.request.PageRequest;

public class CarTravelRequest  extends PageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private String userName;	//用户id
	private Integer carId;		
	private Integer travelType;		//'行程类型（1=拼车，2=包车）'
	private Integer travelSize;		//内空
	private Double loadWeight;		//承载重量，单位吨
	private Integer tempType;		//温度类型 1=冷冻、2=冷藏、3=恒温
	
	private String startLocation;
    private String startGps;
    private String travelLocation;
    private String endLocation;
    private String endGps;
    private String startTime;	//yyyy-MM-dd HH:mm:ss
    private String remark;
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Integer getTravelType() {
		return travelType;
	}
	public void setTravelType(Integer travelType) {
		this.travelType = travelType;
	}
	public Integer getTravelSize() {
		return travelSize;
	}
	public void setTravelSize(Integer travelSize) {
		this.travelSize = travelSize;
	}
	public Double getLoadWeight() {
		return loadWeight;
	}
	public void setLoadWeight(Double loadWeight) {
		this.loadWeight = loadWeight;
	}
	public Integer getTempType() {
		return tempType;
	}
	public void setTempType(Integer tempType) {
		this.tempType = tempType;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getStartGps() {
		return startGps;
	}
	public void setStartGps(String startGps) {
		this.startGps = startGps;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public String getEndGps() {
		return endGps;
	}
	public void setEndGps(String endGps) {
		this.endGps = endGps;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getTravelLocation() {
		return travelLocation;
	}
	public void setTravelLocation(String travelLocation) {
		this.travelLocation = travelLocation;
	}
	
    
}
