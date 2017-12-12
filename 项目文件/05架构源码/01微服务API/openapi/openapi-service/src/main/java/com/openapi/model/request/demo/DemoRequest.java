package com.openapi.model.request.demo;

import com.jiuwu.openoo.common.openapi.request.Request;

public class DemoRequest extends Request {

	private static final long serialVersionUID = 1L;
	
	private String param;
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
	@Override
	public String toString() {
		return "DemoRequest [param=" + param + "]";
	}
	
}
