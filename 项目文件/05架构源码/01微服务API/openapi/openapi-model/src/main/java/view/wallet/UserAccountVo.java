package view.wallet;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 根据userId查询出其所有的账户信息
 * @author grace
 *
 */
@XStreamAlias("userAccountVo")
public class UserAccountVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7178150605515388666L;

	private String userPayId;  //用户支付id
	private String accountType;  //AliPay=支付宝，WeChatPay=微信支付，UnionPay=银联卡
	private String account;  //账户（可以***号）
	private String accountName;  //账户名（用户填写的真实姓名）
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	
	
}
