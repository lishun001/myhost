package com.openapi.model.response.order;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *  更新用户  响应
 *  @author Harry
 */
@XStreamAlias("cargoApplyResponse")
public class CargoApplyResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2102290845958276725L;
	private Integer cargoDeliId;
	private Integer carId;
	private String result ;

	public Integer getCargoDeliId() {
		return cargoDeliId;
	}

	public void setCargoDeliId(Integer cargoDeliId) {
		this.cargoDeliId = cargoDeliId;
	}

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
