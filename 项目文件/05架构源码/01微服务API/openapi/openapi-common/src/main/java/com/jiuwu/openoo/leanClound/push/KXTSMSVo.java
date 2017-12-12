package com.jiuwu.openoo.leanClound.push;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *  响应参数Vo
 *  <?xml version="1.0" encoding="utf-8" ?>
 *  <returnsms> 
 *  <returnstatus>Success</returnstatus> 
 *  <message>ok</message> 
 *  <remainpoint>10</remainpoint> 
 *  <taskID>1148693</taskID> 
 *  <successCounts>2</successCounts>
 *  </returnsms>
 *  
 *  <returnsms> 
 *  <returnstatus>Faild</returnstatus> 
 *  <message>用户名或密码错误</message> 
 *  <remainpoint>0</remainpoint> 
 *  <taskID>0</taskID> 
 *  <successCounts>0</successCounts>
 *  </returnsms>
 * 
 */
@XmlRootElement(name="returnsms")
public class KXTSMSVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2819201221864687496L;

	private String returnstatus;
	private String message;
	private int remainpoint;
	private String taskID;
	private int successCounts;
	
	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getRemainpoint() {
		return remainpoint;
	}
	public void setRemainpoint(int remainpoint) {
		this.remainpoint = remainpoint;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public int getSuccessCounts() {
		return successCounts;
	}
	public void setSuccessCounts(int successCounts) {
		this.successCounts = successCounts;
	}
	
	

}
