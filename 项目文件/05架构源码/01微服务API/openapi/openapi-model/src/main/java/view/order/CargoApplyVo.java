package view.order;

import java.io.Serializable;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cargoApplyVo")
public class CargoApplyVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5701195930037166419L;
	private Integer cargoApplyId;
	private Integer userId;
	private String nickName;
	private String phone;
	private Integer orderStatId;
	private String cargoOrderId;
	private Integer carComanyAuthorId;
	private Date applyTime;
	private String applyType;
	
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getCargoApplyId() {
		return cargoApplyId;
	}
	public void setCargoApplyId(Integer cargoApplyId) {
		this.cargoApplyId = cargoApplyId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getOrderStatId() {
		return orderStatId;
	}
	public void setOrderStatId(Integer orderStatId) {
		this.orderStatId = orderStatId;
	}
	public Integer getCarComanyAuthorId() {
		return carComanyAuthorId;
	}
	public void setCarComanyAuthorId(Integer carComanyAuthorId) {
		this.carComanyAuthorId = carComanyAuthorId;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	
	
}
