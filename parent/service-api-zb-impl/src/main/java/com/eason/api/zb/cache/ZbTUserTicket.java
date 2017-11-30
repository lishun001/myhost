package com.eason.api.zb.cache;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


@Document(collection = "zb_t_user_ticket")
public class ZbTUserTicket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userTicketId;

	private Integer userId;

	private Integer planId;

	private Integer zbId;

	private Integer roomId;

	private String activityTime;

	private Date buyTime;

	private Integer price;

	private Date startTime;

	public String getUserTicketId() {
		return userTicketId;
	}

	public void setUserTicketId(String userTicketId) {
		this.userTicketId = userTicketId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getZbId() {
		return zbId;
	}

	public void setZbId(Integer zbId) {
		this.zbId = zbId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
}