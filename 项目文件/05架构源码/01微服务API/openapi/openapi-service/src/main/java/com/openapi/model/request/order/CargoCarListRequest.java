package com.openapi.model.request.order;

import com.openapi.model.request.PageRequest;

public class CargoCarListRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520115154935104351L;
	
	private String sortType;	//price=价格排序、size=空间排序、time=时间排序,distance=距离排序（默认时间排序）
	private Integer carUserId;		//车主carUserId
	private String status;		//（-1=调整中,0=已创建，1=已取消，2=发布中，3=取货中，4=配送中，5=车主完成(车主上图)，6=货主完成(货主收图)）
	private String locationGps;	//当前位置的经纬度（A，B）
	
	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getLocationGps() {
		return locationGps;
	}

	public void setLocationGps(String locationGps) {
		this.locationGps = locationGps;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCarUserId() {
		return carUserId;
	}

	public void setCarUserId(Integer carUserId) {
		this.carUserId = carUserId;
	}

}
