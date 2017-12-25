package com.eason.api.zb.po;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the zb_t_room_plan_stat database table.
 * 
 */
@Entity
@Table(name="qvod_zb_t_room_plan_stat")
@NamedQuery(name="ZbTRoomPlanStat.findAll", query="SELECT z FROM ZbTRoomPlanStat z")
public class ZbTRoomPlanStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="record_id")
	private Integer recordId;

	@Column(name="plan_id")
	private Integer planId;

	@Column(name="room_id")
	private Integer roomId;

	@Column(name="activity_time")
	private Long activityTime;

	private Integer bombScreen_count;

	@Column(name="close_time")
	private Timestamp closeTime;

	private Timestamp create_Time;

	@Column(name="gift_count")
	private Integer giftCount;

	@Column(name="income_amount")
	private Integer incomeAmount;

	@Column(name="open_time")
	private Timestamp openTime;

	@Column(name="is_video")
	private Integer isVideo;

	@Column(name="record_status")
	private Integer recordStatus;

	@Column(name="room_title")
	private String roomTitle;

	@Column(name="room_type")
	private String roomType;

	@Column(name="view_count")
	private Integer viewCount;

	@Column(name="zb_id")
	private Integer zbId;

	@Column(name="zb_room_conf")
	private String zbRoomConf;

	public ZbTRoomPlanStat() {
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Long getActivityTime() {
		return this.activityTime;
	}

	public void setActivityTime(Long activityTime) {
		this.activityTime = activityTime;
	}

	public Integer getBombScreen_count() {
		return this.bombScreen_count;
	}

	public void setBombScreen_count(Integer bombScreen_count) {
		this.bombScreen_count = bombScreen_count;
	}

	public Timestamp getCloseTime() {
		return this.closeTime;
	}

	public void setCloseTime(Timestamp closeTime) {
		this.closeTime = closeTime;
	}

	public Timestamp getCreate_Time() {
		return this.create_Time;
	}

	public void setCreate_Time(Timestamp create_Time) {
		this.create_Time = create_Time;
	}

	public Integer getGiftCount() {
		return this.giftCount;
	}

	public void setGiftCount(Integer giftCount) {
		this.giftCount = giftCount;
	}

	public Integer getIncomeAmount() {
		return this.incomeAmount;
	}

	public void setIncomeAmount(Integer incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public Timestamp getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Timestamp openTime) {
		this.openTime = openTime;
	}

	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getIsVideo() {
		return isVideo;
	}

	public void setIsVideo(Integer isVideo) {
		this.isVideo = isVideo;
	}

	public Integer getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getRoomTitle() {
		return this.roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getZbId() {
		return this.zbId;
	}

	public void setZbId(Integer zbId) {
		this.zbId = zbId;
	}

	public String getZbRoomConf() {
		return this.zbRoomConf;
	}

	public void setZbRoomConf(String zbRoomConf) {
		this.zbRoomConf = zbRoomConf;
	}

}