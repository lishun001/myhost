package com.openapi.model.response.order;

import java.util.List;

import view.order.CargoApplyVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cargoApplyListResponse")
public class CargoApplyListResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5110946465490237430L;
	private List<CargoApplyVo> list;
	
	public List<CargoApplyVo> getList() {
		return list;
	}
	public void setList(List<CargoApplyVo> list) {
		this.list = list;
	}
	
}
