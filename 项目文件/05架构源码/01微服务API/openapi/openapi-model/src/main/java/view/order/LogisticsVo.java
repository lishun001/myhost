package view.order;

import java.io.Serializable;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("logisticsVo")
public class LogisticsVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6268805560285333326L;
	
    private Integer cargoLogisticsId;
    private String cargoOrderId;
    private Integer cargoDeliId;
    private Integer userId;
    private String logisticsInfo;
    private Date updateTime;
    private String nowLocation;
    private String nowGps;
    
	public Integer getCargoLogisticsId() {
		return cargoLogisticsId;
	}
	public void setCargoLogisticsId(Integer cargoLogisticsId) {
		this.cargoLogisticsId = cargoLogisticsId;
	}
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public Integer getCargoDeliId() {
		return cargoDeliId;
	}
	public void setCargoDeliId(Integer cargoDeliId) {
		this.cargoDeliId = cargoDeliId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLogisticsInfo() {
		return logisticsInfo;
	}
	public void setLogisticsInfo(String logisticsInfo) {
		this.logisticsInfo = logisticsInfo;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getNowLocation() {
		return nowLocation;
	}
	public void setNowLocation(String nowLocation) {
		this.nowLocation = nowLocation;
	}
	public String getNowGps() {
		return nowGps;
	}
	public void setNowGps(String nowGps) {
		this.nowGps = nowGps;
	}
	
    
}
