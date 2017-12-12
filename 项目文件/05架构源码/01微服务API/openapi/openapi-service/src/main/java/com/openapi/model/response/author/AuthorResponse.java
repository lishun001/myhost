package com.openapi.model.response.author;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("authorResponse")
public class AuthorResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;	//用户id
	private Integer status; //认证状态
	private String result;	//返回信息

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
