package com.openapi.model.response.car;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("carResponse")
public class CarResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private Integer carId;	//用户id
	private String result;	//返回信息

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	
}
