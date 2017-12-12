package com.openapi.model.response.car;

import java.util.List;

import view.car.CarVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("carListResponse")
public class CarListResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private List<CarVo> carVoList;
	
	public List<CarVo> getCarVoList() {
		return carVoList;
	}
	public void setCarVoList(List<CarVo> carVoList) {
		this.carVoList = carVoList;
	}
	
}
