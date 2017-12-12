package com.openapi.model.response.order;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cargoOrderResponse")
public class CargoOrderResponse extends Response {

	private static final long serialVersionUID = 1L;

	private String cargoOrderId; // 订单号
	private Integer cargoId; // 货物号
	private String cargoName; // 货物名称
	private Double cargoSize; // 格式：只存单位体积（立方米）
	private Double cargoWeight; // 货物重量
	private Double amount; // 金额
	private Integer status; //订单状态
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCargoOrderId() {
		return cargoOrderId;
	}

	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}

	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	public Double getCargoSize() {
		return cargoSize;
	}

	public void setCargoSize(Double cargoSize) {
		this.cargoSize = cargoSize;
	}

	public Double getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(Double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}

}