package view.car;

import java.io.Serializable;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("carTravelVo")
public class CarCompanyVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6268805560285333326L;

	private Integer carTravelId;

	private String userName;

	private Integer carId;
	
	private String carNo;

	private Integer travelType;

	private Integer travelRange;

	private Integer travelSize;

	private Double loadWeight;

	private Double lowTemp;

	private String startLocation;

	private String startGps;
	
	private String distance;

	private String travelLocation; // 途经点（地址|经纬度，地址|经纬度）

	private String endLocation;

	private String endGps;

	private Date startTime;

	private String remark;

	private Date createTime;
	
	private Integer carCompanyAuthorId;
	
	private String companyName;
	
	private String logo;
	
	private String authorName;
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getCarCompanyAuthorId() {
		return carCompanyAuthorId;
	}

	public void setCarCompanyAuthorId(Integer carCompanyAuthorId) {
		this.carCompanyAuthorId = carCompanyAuthorId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCarTravelId() {
		return carTravelId;
	}

	public void setCarTravelId(Integer carTravelId) {
		this.carTravelId = carTravelId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public Integer getTravelType() {
		return travelType;
	}

	public void setTravelType(Integer travelType) {
		this.travelType = travelType;
	}

	public Integer getTravelRange() {
		return travelRange;
	}

	public void setTravelRange(Integer travelRange) {
		this.travelRange = travelRange;
	}

	public Integer getTravelSize() {
		return travelSize;
	}

	public void setTravelSize(Integer travelSize) {
		this.travelSize = travelSize;
	}

	public Double getLoadWeight() {
		return loadWeight;
	}

	public void setLoadWeight(Double loadWeight) {
		this.loadWeight = loadWeight;
	}

	public Double getLowTemp() {
		return lowTemp;
	}

	public void setLowTemp(Double lowTemp) {
		this.lowTemp = lowTemp;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getStartGps() {
		return startGps;
	}

	public void setStartGps(String startGps) {
		this.startGps = startGps;
	}

	public String getTravelLocation() {
		return travelLocation;
	}

	public void setTravelLocation(String travelLocation) {
		this.travelLocation = travelLocation;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	
}
