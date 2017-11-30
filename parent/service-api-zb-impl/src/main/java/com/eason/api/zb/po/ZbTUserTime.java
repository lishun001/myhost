package com.eason.api.zb.po;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the zb_t_user_time database table.
 * 
 */
@Entity
@Table(name="qvod_zb_t_user_time")
@NamedQuery(name="ZbTUserTime.findAll", query="SELECT z FROM ZbTUserTime z")
public class ZbTUserTime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_time_id")
	private Integer userTimeId;

	@Column(name="activity_time")
	private String activityTime;

	@Column(name="cost_count")
	private Integer costCount;

	@Column(name="over_time")
	private Timestamp overTime;

	@Column(name="plan_id")
	private String planId;

	private double price;

	@Column(name="start_time")
	private Timestamp startTime;

	@Column(name="used_count")
	private Integer usedCount;

	@Column(name="user_id")
	private Integer userId;

	public ZbTUserTime() {
	}

	public Integer getUserTimeId() {
		return this.userTimeId;
	}

	public void setUserTimeId(Integer userTimeId) {
		this.userTimeId = userTimeId;
	}

	public String getActivityTime() {
		return this.activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public Integer getCostCount() {
		return this.costCount;
	}

	public void setCostCount(Integer costCount) {
		this.costCount = costCount;
	}

	public Timestamp getOverTime() {
		return this.overTime;
	}

	public void setOverTime(Timestamp overTime) {
		this.overTime = overTime;
	}

	public String getPlanId() {
		return this.planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Integer getUsedCount() {
		return this.usedCount;
	}

	public void setUsedCount(Integer usedCount) {
		this.usedCount = usedCount;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}