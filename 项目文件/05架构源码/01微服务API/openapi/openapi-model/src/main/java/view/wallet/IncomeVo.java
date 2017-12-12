package view.wallet;

import java.io.Serializable;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 收入列表
 * 
 * @author grace
 * 
 */
@XStreamAlias("incomeVo")
public class IncomeVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 896186786247527628L;

	private Integer dealId;
	private Integer userId;
	private Integer dealType;
	private String cargoOrderId;
	private Double dealAmount;
	private Double taBalance;
	private String dealDesc;
	private Date dealTime;
	
	public Integer getDealId() {
		return dealId;
	}
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDealType() {
		return dealType;
	}
	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public Double getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(Double dealAmount) {
		this.dealAmount = dealAmount;
	}
	public Double getTaBalance() {
		return taBalance;
	}
	public void setTaBalance(Double taBalance) {
		this.taBalance = taBalance;
	}
	public String getDealDesc() {
		return dealDesc;
	}
	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	
}
