package com.openapi.model.response.demo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("demoResponse")
public class DemoResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "DemoResponse [result=" + result + "]";
	}
	
}
