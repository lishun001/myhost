package com.openapi.model.request.wallet;

import com.jiuwu.openoo.common.openapi.request.Request;

/**
 * 删除用户账户时需要传递的请求参数
 * @author grace
 *
 */
public class DelUserAccountRequest extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8963936473852741190L;
	
	private String userPayId;
	private Integer userId;
	public String getUserPayId() {
		return userPayId;
	}
	public void setUserPayId(String userPayId) {
		this.userPayId = userPayId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
