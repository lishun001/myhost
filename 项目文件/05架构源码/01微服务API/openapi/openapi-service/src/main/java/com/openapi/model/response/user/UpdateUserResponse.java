package com.openapi.model.response.user;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *  更新用户  响应
 *  @author Harry
 */
@XStreamAlias("updateUserResponse")
public class UpdateUserResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2102290845958276725L;
	private String result ;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
