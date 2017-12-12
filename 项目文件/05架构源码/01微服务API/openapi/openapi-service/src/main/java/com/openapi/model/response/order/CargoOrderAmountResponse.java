package com.openapi.model.response.order;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cargoOrderAmountResponse")
public class CargoOrderAmountResponse extends Response {

	private static final long serialVersionUID = 1L;
	private String cargoName;		//货品名称
	private Double loadAmount;
	private Double dischargeAmount;
	private Double rangeCharge;
	private Double goCharge;
	private Double tip;
	
	public String getCargoName() {
		return cargoName;
	}
	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}
	public Double getLoadAmount() {
		return loadAmount;
	}
	public void setLoadAmount(Double loadAmount) {
		this.loadAmount = loadAmount;
	}
	public Double getDischargeAmount() {
		return dischargeAmount;
	}
	public void setDischargeAmount(Double dischargeAmount) {
		this.dischargeAmount = dischargeAmount;
	}
	public Double getRangeCharge() {
		return rangeCharge;
	}
	public void setRangeCharge(Double rangeCharge) {
		this.rangeCharge = rangeCharge;
	}
	public Double getGoCharge() {
		return goCharge;
	}
	public void setGoCharge(Double goCharge) {
		this.goCharge = goCharge;
	}
	public Double getTip() {
		return tip;
	}
	public void setTip(Double tip) {
		this.tip = tip;
	}

	

}