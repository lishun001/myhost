package com.openapi.model.response.push;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("pushSystemResponse")
public class PushSystemResponse extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3002331050673915684L;
	/**
	 */
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
