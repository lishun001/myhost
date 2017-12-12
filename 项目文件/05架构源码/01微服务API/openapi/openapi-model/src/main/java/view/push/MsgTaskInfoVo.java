package view.push;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 指定任务的推送消息列表  响应
 */
@XStreamAlias("msgTaskInfo")
public class MsgTaskInfoVo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3316285211771718546L;
	/**任务信息表ID*/
	private int id ;
	/**任务ID*/
	private int taskId;
	/**推送标题*/
	private String pushTitle;
	/**推送内容*/
	private String pushContent;
	/**推送时间*/
	private String pushTime;
	/**CODE*/
	private String code;
	/**订单ID*/	
	private String orderId;
	/**0=系统消息，1=任务消息，2=推送消息模板，3=支付消息*/
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getPushTitle() {
		return pushTitle;
	}
	public void setPushTitle(String pushTitle) {
		this.pushTitle = pushTitle;
	}
	public String getPushContent() {
		return pushContent;
	}
	public void setPushContent(String pushContent) {
		this.pushContent = pushContent;
	}
	public String getPushTime() {
		return pushTime;
	}
	public void setPushTime(String pushTime) {
		this.pushTime = pushTime;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
