package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class OrderScoreRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520115154935104251L;
	
	private String cargoOrderId;
	private Double score;
	private String desc;
	
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
