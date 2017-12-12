package com.openapi.model.response.wallet;

import java.util.List;

import view.wallet.ExpenseVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("expenseListResponse")
public class ExpenseListResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7402539330633761080L;
	
	private List<ExpenseVo> expenseList;

	public List<ExpenseVo> getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List<ExpenseVo> expenseList) {
		this.expenseList = expenseList;
	}
	
}
