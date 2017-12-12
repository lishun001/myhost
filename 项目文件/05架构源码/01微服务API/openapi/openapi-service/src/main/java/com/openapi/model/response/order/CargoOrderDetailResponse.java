package com.openapi.model.response.order;

import view.order.CargoOrderVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cargoOrderDetailResponse")
public class CargoOrderDetailResponse extends Response {

	private static final long serialVersionUID = 1L;
	private CargoOrderVo cargoOrderVo;
	
	public CargoOrderVo getCargoOrderVo() {
		return cargoOrderVo;
	}
	public void setCargoOrderVo(CargoOrderVo cargoOrderVo) {
		this.cargoOrderVo = cargoOrderVo;
	}
}