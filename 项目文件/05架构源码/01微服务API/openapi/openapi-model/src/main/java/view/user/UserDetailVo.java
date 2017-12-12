package view.user;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userDetailVo")
public class UserDetailVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6268805560285333396L;
	
	private Integer userId;
    private String phone;
    private String logo;
    private String nickname;
    private String gender;
    private String area;
    private Double score;		//评分
    private Integer carAuthor;	//车主认证（（0=未认证、1=认证中、2=已认证、3=认证失败）
    private Integer cargoAuthor; //货主认证（（0=未认证、1=认证中、2=已认证、3=认证失败）
    private Double amount;
    private String isVip; //VIP（0=普通(未认证)，1=VIP合同用户（已认证））
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getCarAuthor() {
		return carAuthor;
	}
	public void setCarAuthor(Integer carAuthor) {
		this.carAuthor = carAuthor;
	}
	public Integer getCargoAuthor() {
		return cargoAuthor;
	}
	public void setCargoAuthor(Integer cargoAuthor) {
		this.cargoAuthor = cargoAuthor;
	}
	public String getIsVip() {
		return isVip;
	}
	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
