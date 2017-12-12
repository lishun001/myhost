package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class CargoOrderAdjustRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520195154935104251L;
	//货物参数
	private String cargoOrderId;	//货物订单id
	private Integer cargoNum;	//货物数量
	private String adjustRemark;
	
	public String getAdjustRemark() {
		return adjustRemark;
	}
	public void setAdjustRemark(String adjustRemark) {
		this.adjustRemark = adjustRemark;
	}
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public Integer getCargoNum() {
		return cargoNum;
	}
	public void setCargoNum(Integer cargoNum) {
		this.cargoNum = cargoNum;
	}
	
	
}
