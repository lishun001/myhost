package com.openapi.model.request.user;

import com.jiuwu.openoo.common.openapi.request.Request;

public class UserRegisterStep02Request extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2883166894027123149L;
	private Integer userId;	 //用户id
	private String phone;	//用户的电话
	//2. 基本信息完善
	private String gender;			//性别 0女1男
	private String nickName;	//昵称
	private String area;		//地区
	private String birth;		//生日 2015-01-01
	private String introduction;	//个性签名
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
