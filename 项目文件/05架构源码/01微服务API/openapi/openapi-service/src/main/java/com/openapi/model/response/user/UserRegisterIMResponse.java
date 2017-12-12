package com.openapi.model.response.user;

import java.util.Map;

import com.jiuwu.openoo.common.openapi.response.Response;

public class UserRegisterIMResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -697895421275805108L;
	
	private String result;
	
	private Map<String, Object> dataNode;
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Map<String, Object> getDataNode() {
		return dataNode;
	}

	public void setDataNode(Map<String, Object> dataNode) {
		this.dataNode = dataNode;
	}
	
}
