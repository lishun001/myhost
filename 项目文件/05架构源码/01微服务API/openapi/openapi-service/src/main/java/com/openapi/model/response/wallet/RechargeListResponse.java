package com.openapi.model.response.wallet;

import java.util.List;

import view.wallet.RechargeVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("rechargeListResponse")
public class RechargeListResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3113899899712950065L;
	
	private List<RechargeVo> rechargeList;

	public List<RechargeVo> getRechargeList() {
		return rechargeList;
	}

	public void setRechargeList(List<RechargeVo> rechargeList) {
		this.rechargeList = rechargeList;
	}

}
