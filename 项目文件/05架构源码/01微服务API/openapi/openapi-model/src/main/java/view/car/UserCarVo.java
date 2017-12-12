package view.car;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userCarVo")
public class UserCarVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6268805560285333326L;
	
	private String cargoOrderId;
	private Integer userId;
	private String logo;
	private String phone;
	private String nickName;
	private String tempEnvType;
	private String cargoOrderName;
	private String endLocation;
	private String endGps;
	private String carLocation;
    private String carGps;
	private String carName;
	private String carNo;
	private String carType;
	private Integer tempType;
	private Integer tempMin;
	private Integer tempMax;
	private Double userScore;
	private Integer cargoDeliId;
	private String carAuthorName;
	
	public String getCarAuthorName() {
		return carAuthorName;
	}
	public void setCarAuthorName(String carAuthorName) {
		this.carAuthorName = carAuthorName;
	}
	public Integer getCargoDeliId() {
		return cargoDeliId;
	}
	public void setCargoDeliId(Integer cargoDeliId) {
		this.cargoDeliId = cargoDeliId;
	}
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public Double getUserScore() {
		return userScore;
	}
	public void setUserScore(Double userScore) {
		this.userScore = userScore;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public Integer getTempType() {
		return tempType;
	}
	public void setTempType(Integer tempType) {
		this.tempType = tempType;
	}
	public Integer getTempMin() {
		return tempMin;
	}
	public void setTempMin(Integer tempMin) {
		this.tempMin = tempMin;
	}
	public Integer getTempMax() {
		return tempMax;
	}
	public void setTempMax(Integer tempMax) {
		this.tempMax = tempMax;
	}
	public String getTempEnvType() {
		return tempEnvType;
	}
	public void setTempEnvType(String tempEnvType) {
		this.tempEnvType = tempEnvType;
	}
	public String getCargoOrderName() {
		return cargoOrderName;
	}
	public void setCargoOrderName(String cargoOrderName) {
		this.cargoOrderName = cargoOrderName;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public String getEndGps() {
		return endGps;
	}
	public void setEndGps(String endGps) {
		this.endGps = endGps;
	}
	public String getCarLocation() {
		return carLocation;
	}
	public void setCarLocation(String carLocation) {
		this.carLocation = carLocation;
	}
	public String getCarGps() {
		return carGps;
	}
	public void setCarGps(String carGps) {
		this.carGps = carGps;
	}
	
}
