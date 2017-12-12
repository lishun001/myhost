package com.openapi.model.response.user;

import view.user.UserDetailVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userDetailResponse")
public class UserDetailResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8736093738258772134L;
	
	private UserDetailVo userDetailVo;

	public UserDetailVo getUserDetailVo() {
		return userDetailVo;
	}

	public void setUserDetailVo(UserDetailVo userDetailVo) {
		this.userDetailVo = userDetailVo;
	}
    
    
}
