package view.wallet;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 支出列表
 * @author grace
 *
 */
@XStreamAlias("expenseVo")
public class ExpenseVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5744008842573038856L;	
	
	private Integer dealId;  //交易id
	private Double dealAmount; //成交金额
	private String taskTitle;  //任务名称
	private String createTime;  //成交时间
	private String userLogo;  //猎人的图像
	public Integer getDealId() {
		return dealId;
	}
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	public Double getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(Double dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUserLogo() {
		return userLogo;
	}
	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}
	
}
