package com.openapi.model.response.car;

import java.util.List;

import view.car.CarTravelVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("carTravelResponse")
public class CarTravelListResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private List<CarTravelVo> carTravelVoList;

	public List<CarTravelVo> getCarTravelVoList() {
		return carTravelVoList;
	}

	public void setCarTravelVoList(List<CarTravelVo> carTravelVoList) {
		this.carTravelVoList = carTravelVoList;
	}
	
	
	
}
