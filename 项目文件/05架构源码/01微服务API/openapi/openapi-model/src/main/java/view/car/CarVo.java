package view.car;

import java.io.Serializable;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("carVo")
public class CarVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4396886681760619829L;

	private Integer carId;

	private Integer userId;

	private String carName;

	private String carNo;

	private String carType;

	private Integer carSize;
	private String carLocation;
    private String carGps;
	private Integer tempType;

	private Integer tempMin;

	private Integer tempMax;

	private Double loadWeight;

	private String xszPic;

	private String yszPic;

	private String qzxPic;

	private String szxPic;

	private String ssxPic;

	private String txzPic;

	private Date createTime;

	private Date updateTime;

	private String createBy;

	private String updateBy;
	
	private Integer status;
	//车主基本信息
	private String account;
	private String logo;
	private String nickName;
	private Double score;
	private Character isVip;
	  

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Integer getCarSize() {
		return carSize;
	}

	public void setCarSize(Integer carSize) {
		this.carSize = carSize;
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

	public Double getLoadWeight() {
		return loadWeight;
	}

	public void setLoadWeight(Double loadWeight) {
		this.loadWeight = loadWeight;
	}

	public String getXszPic() {
		return xszPic;
	}

	public void setXszPic(String xszPic) {
		this.xszPic = xszPic;
	}

	public String getYszPic() {
		return yszPic;
	}

	public void setYszPic(String yszPic) {
		this.yszPic = yszPic;
	}

	public String getQzxPic() {
		return qzxPic;
	}

	public void setQzxPic(String qzxPic) {
		this.qzxPic = qzxPic;
	}

	public String getSzxPic() {
		return szxPic;
	}

	public void setSzxPic(String szxPic) {
		this.szxPic = szxPic;
	}

	public String getSsxPic() {
		return ssxPic;
	}

	public void setSsxPic(String ssxPic) {
		this.ssxPic = ssxPic;
	}

	public String getTxzPic() {
		return txzPic;
	}

	public void setTxzPic(String txzPic) {
		this.txzPic = txzPic;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Character getIsVip() {
		return isVip;
	}

	public void setIsVip(Character isVip) {
		this.isVip = isVip;
	}
	
}
