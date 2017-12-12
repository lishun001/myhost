package com.openapi.model.request.user;

import com.jiuwu.openoo.common.openapi.request.Request;

public class UserLoginRequest extends Request {

	private static final long serialVersionUID = 1L;
	
	private String account;
	private String password;
	private String registrationID;	//极光推送需要推送的对象id
	private String deviceToken;		//官推需要的对象id
	private String name;	//varchar(50) NOT NULL设备名称
	private String osversion;	//varchar(100) NULL系统版本号
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistrationID() {
		return registrationID;
	}
	public void setRegistrationID(String registrationID) {
		this.registrationID = registrationID;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOsversion() {
		return osversion;
	}
	public void setOsversion(String osversion) {
		this.osversion = osversion;
	}
	
}
