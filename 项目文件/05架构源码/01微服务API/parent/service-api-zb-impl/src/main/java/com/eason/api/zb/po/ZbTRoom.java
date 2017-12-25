package com.eason.api.zb.po;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the zb_t_room database table.
 * 
 */
@Entity
@Table(name="qvod_zb_t_room")
@NamedQuery(name="ZbTRoom.findAll", query="SELECT z FROM ZbTRoom z")
public class ZbTRoom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="room_id")
	private Integer roomId;

	private Timestamp create_Time;

	@Column(name="is_video")
	private Integer isVideo;

	@Column(name="order_field")
	private Integer orderField;

	@Column(name="room_bg_pic")
	private String roomBgPic;

	@Column(name="room_watermark")
	private String roomWatermark;

	@Column(name="room_info")
	private String roomInfo;

	@Column(name="room_status")
	private Integer roomStatus;

	@Column(name="room_title")
	private String roomTitle;

	@Column(name="`total_activity_time`")
	private Integer total_ActivityTime;

	@Column(name="zb_id")
	private Integer zbId;

	public ZbTRoom() {
	}

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Timestamp getCreate_Time() {
		return this.create_Time;
	}

	public void setCreate_Time(Timestamp create_Time) {
		this.create_Time = create_Time;
	}

	public Integer getIsVideo() {
		return this.isVideo;
	}

	public void setIsVideo(Integer isVideo) {
		this.isVideo = isVideo;
	}

	public Integer getOrderField() {
		return this.orderField;
	}

	public void setOrderField(Integer orderField) {
		this.orderField = orderField;
	}

	public String getRoomBgPic() {
		return this.roomBgPic;
	}

	public void setRoomBgPic(String roomBgPic) {
		this.roomBgPic = roomBgPic;
	}

	public String getRoomWatermark() {
		return roomWatermark;
	}

	public void setRoomWatermark(String roomWatermark) {
		this.roomWatermark = roomWatermark;
	}

	public String getRoomInfo() {
		return this.roomInfo;
	}

	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}

	public Integer getRoomStatus() {
		return this.roomStatus;
	}

	public void setRoomStatus(Integer roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomTitle() {
		return this.roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public Integer getTotal_ActivityTime() {
		return this.total_ActivityTime;
	}

	public void setTotal_ActivityTime(Integer total_ActivityTime) {
		this.total_ActivityTime = total_ActivityTime;
	}

	public Integer getZbId() {
		return this.zbId;
	}

	public void setZbId(Integer zbId) {
		this.zbId = zbId;
	}

}