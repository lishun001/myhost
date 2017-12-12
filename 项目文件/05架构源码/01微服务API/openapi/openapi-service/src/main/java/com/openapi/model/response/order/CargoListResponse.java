package com.openapi.model.response.order;

import java.util.List;

import view.order.CargoOrderVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cargoListResponse")
public class CargoListResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5110946465490237430L;
	private List<CargoOrderVo> list;
	
	public List<CargoOrderVo> getList() {
		return list;
	}
	public void setList(List<CargoOrderVo> list) {
		this.list = list;
	}
	
}
