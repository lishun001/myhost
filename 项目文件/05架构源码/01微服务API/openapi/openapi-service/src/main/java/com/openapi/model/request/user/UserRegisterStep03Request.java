package com.openapi.model.request.user;

import com.jiuwu.openoo.common.openapi.FileItem;
import com.jiuwu.openoo.common.openapi.request.Request;

public class UserRegisterStep03Request extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2883166894027123149L;
	private Integer userId;	//用户id
	//3. 上传图片
	private FileItem logo;	//用户头像
	
	public FileItem getLogo() {
		return logo;
	}
	public void setLogo(FileItem logo) {
		this.logo = logo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
