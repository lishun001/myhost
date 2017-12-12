package com.openapi.model.request.user;



import com.jiuwu.openoo.common.openapi.request.Request;

public class UpdateUserRequest extends Request {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8464567801556395024L;
	
	private Integer userId;  //用户id
	private String nickName;	//昵称
	private String gender;
	private String area;		// 用户居住地  
	private String trade;
	private String profession;	//贸易行业
	private String introduction;//公司职业职位
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	 
	
}	
