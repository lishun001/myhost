package com.openapi.model.response.order;

import java.util.List;

import view.car.UserCarVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("carUserResponse")
public class CarUserResponse extends Response {

	private static final long serialVersionUID = 1L;
	private List<UserCarVo> carUserVo;
	
	public List<UserCarVo> getCarUserVo() {
		return carUserVo;
	}
	public void setCarUserVo(List<UserCarVo> carUserVo) {
		this.carUserVo = carUserVo;
	}
	
}