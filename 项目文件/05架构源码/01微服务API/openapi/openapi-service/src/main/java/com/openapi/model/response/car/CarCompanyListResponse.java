package com.openapi.model.response.car;

import java.util.List;

import view.car.CarCompanyVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("carCompanyListResponse")
public class CarCompanyListResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private List<CarCompanyVo> carCompanyVoList;

	public List<CarCompanyVo> getCarCompanyVoList() {
		return carCompanyVoList;
	}

	public void setCarCompanyVoList(List<CarCompanyVo> carCompanyVoList) {
		this.carCompanyVoList = carCompanyVoList;
	}
	
	
}
