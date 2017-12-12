package view.wallet;

import java.io.Serializable;

/**
 * 封装从用户Ta币(user_ta)和充值明细表(user_recharge_details)中查询出的数据
 * @author grace
 *
 */
public class RechargeVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8494565673456235464L;
	
	private String rechargeOrderId;  //充值明细id
	private Double rechargeMny;  //充值金额
	private Double rechargeTa;   //等值的Ta币
	private String rechargeTime;  //充值时间
	private String rechargeSubject;  // 账单标题
	private String accountType; //账户类型（AliPay，WeChatPay，UnionPay）
	private String userPayStatus;  //支付状态：  1=待支付 2=支付成功  3=支付失败
	private String userPayId;  //用户支付id
	public String getRechargeOrderId() {
		return rechargeOrderId;
	}
	public void setRechargeOrderId(String rechargeOrderId) {
		this.rechargeOrderId = rechargeOrderId;
	}
	public Double getRechargeMny() {
		return rechargeMny;
	}
	public void setRechargeMny(Double rechargeMny) {
		this.rechargeMny = rechargeMny;
	}
	public Double getRechargeTa() {
		return rechargeTa;
	}
	public void setRechargeTa(Double rechargeTa) {
		this.rechargeTa = rechargeTa;
	}
	public String getRechargeTime() {
		return rechargeTime;
	}
	public void setRechargeTime(String rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	public String getRechargeSubject() {
		return rechargeSubject;
	}
	public void setRechargeSubject(String rechargeSubject) {
		this.rechargeSubject = rechargeSubject;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getUserPayStatus() {
		return userPayStatus;
	}
	public void setUserPayStatus(String userPayStatus) {
		this.userPayStatus = userPayStatus;
	}
	public String getUserPayId() {
		return userPayId;
	}
	public void setUserPayId(String userPayId) {
		this.userPayId = userPayId;
	}
	
}
