package view.wallet;

import java.io.Serializable;
import java.util.Date;

public class UserTaVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 244750505842090177L;
	
	private Integer userTaId;
	private Integer userId;
    private Double taBalance;
    private Double rates;   //货币等值比例
    private Date rechargeTime; //充值时间（最新）
    private Date withdrawTime; //提现时间（最新）
    private Date createTime;
    
    public Integer getUserTaId() {
		return userTaId;
	}
	public void setUserTaId(Integer userTaId) {
		this.userTaId = userTaId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getTaBalance() {
		return taBalance;
	}
	public void setTaBalance(Double taBalance) {
		this.taBalance = taBalance;
	}
	public Double getRates() {
		return rates;
	}
	public void setRates(Double rates) {
		this.rates = rates;
	}
	public Date getRechargeTime() {
		return rechargeTime;
	}
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	public Date getWithdrawTime() {
		return withdrawTime;
	}
	public void setWithdrawTime(Date withdrawTime) {
		this.withdrawTime = withdrawTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
