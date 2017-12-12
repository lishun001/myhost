package view.push;

import java.io.Serializable;
import java.sql.Timestamp;

public class SystemListViewVo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3612634904590754451L;
	/**系统消息  ID*/
	private int id ;
	/**APP图标*/
	private int appId; 
	/**APP图标*/
	private String appImage;
	/**推送标题*/
	private String pushTitle;
	/**推送内容*/
	private String pushContent;
	/**推送时间*/
	private Timestamp pushTime;
	
	/**模板code*/
	private String code ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppImage() {
		return appImage;
	}
	public void setAppImage(String appImage) {
		this.appImage = appImage;
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
	public Timestamp getPushTime() {
		return pushTime;
	}
	public void setPushTime(Timestamp pushTime) {
		this.pushTime = pushTime;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
