package com.openapi.model.response.wallet;

import java.util.List;

import view.wallet.IncomeVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("incomeListResponse")
public class IncomeListResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 664580645304346146L;
	
	private List<IncomeVo> incomeList;

	public List<IncomeVo> getIncomeList() {
		return incomeList;
	}

	public void setIncomeList(List<IncomeVo> incomeList) {
		this.incomeList = incomeList;
	}
	
	
}
