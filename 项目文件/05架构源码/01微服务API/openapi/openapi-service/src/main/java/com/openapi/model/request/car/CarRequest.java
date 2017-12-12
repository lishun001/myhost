package com.openapi.model.request.car;

import com.jiuwu.openoo.common.openapi.FileItem;
import com.jiuwu.openoo.common.openapi.request.Request;

public class CarRequest  extends Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012474749041145758L;
	private Integer carId;	//车辆id
	private Integer userId;
	private String carName;	//'车辆名称'
	private String carNo;	//'车牌号'
	private String carType;	//'车型：奥迪、宝马、小型三菱货车等'
	private Integer carSize;	//'车容'
	private String carLocation;
    private String carGps;
	private Integer tempType;	//'温度类型（1=双温，2=单温）'
	private Double loadWeight;	//'载重'
	
	private FileItem xszPic;		//'机动车行驶证'
	private FileItem yszPic;		//'道理运输证'
	private FileItem qzxPic;		//'交通强制险'
	private FileItem szxPic;		//'商业三责险'
	private FileItem ssxPic;		//'货物损失险'
	private FileItem txzPic;		//'通行证'
	
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
	public Double getLoadWeight() {
		return loadWeight;
	}
	public void setLoadWeight(Double loadWeight) {
		this.loadWeight = loadWeight;
	}
	public FileItem getXszPic() {
		return xszPic;
	}
	public void setXszPic(FileItem xszPic) {
		this.xszPic = xszPic;
	}
	public FileItem getQzxPic() {
		return qzxPic;
	}
	public void setQzxPic(FileItem qzxPic) {
		this.qzxPic = qzxPic;
	}
	public FileItem getSzxPic() {
		return szxPic;
	}
	public void setSzxPic(FileItem szxPic) {
		this.szxPic = szxPic;
	}
	public FileItem getSsxPic() {
		return ssxPic;
	}
	public void setSsxPic(FileItem ssxPic) {
		this.ssxPic = ssxPic;
	}
	public FileItem getTxzPic() {
		return txzPic;
	}
	public void setTxzPic(FileItem txzPic) {
		this.txzPic = txzPic;
	}
	public FileItem getYszPic() {
		return yszPic;
	}
	public void setYszPic(FileItem yszPic) {
		this.yszPic = yszPic;
	}
	
}
