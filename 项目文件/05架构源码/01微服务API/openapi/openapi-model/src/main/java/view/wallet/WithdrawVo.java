package view.wallet;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 封装从用户Ta币(user_ta)和充值明细表(user_withdraw_details)中查询出的数据
 * @author grace
 *
 */
@XStreamAlias("withdrawVo")
public class WithdrawVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7211003355543074090L;
	
	private String withdrawOrderId;  //充值明细id
	private Double withdrawMny;  //充值金额
	private Double withdrawTa;  //等值的Ta币
	private String withdrawTime;  //充值时间
	private String withdrawSubject;  //账单标题
	private String userPayId;	//用户支付id
	private String accountType;  //账户类型（AliPay，WeChatPay，UnionPay）
	private String userPayStatus;  //提现状态：1=待提现 2=提现成功  3=提现失败
	public String getWithdrawOrderId() {
		return withdrawOrderId;
	}
	public void setWithdrawOrderId(String withdrawOrderId) {
		this.withdrawOrderId = withdrawOrderId;
	}
	public Double getWithdrawMny() {
		return withdrawMny;
	}
	public void setWithdrawMny(Double withdrawMny) {
		this.withdrawMny = withdrawMny;
	}
	public Double getWithdrawTa() {
		return withdrawTa;
	}
	public void setWithdrawTa(Double withdrawTa) {
		this.withdrawTa = withdrawTa;
	}
	public String getWithdrawTime() {
		return withdrawTime;
	}
	public void setWithdrawTime(String withdrawTime) {
		this.withdrawTime = withdrawTime;
	}
	public String getWithdrawSubject() {
		return withdrawSubject;
	}
	public void setWithdrawSubject(String withdrawSubject) {
		this.withdrawSubject = withdrawSubject;
	}
	public String getUserPayId() {
		return userPayId;
	}
	public void setUserPayId(String userPayId) {
		this.userPayId = userPayId;
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
	
}
