package com.eason.api.zb.po;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the qvod_zb_t_recrecords_logs database table.
 * 
 */
@Entity
@Table(name="qvod_zb_t_recrecords_logs")
@NamedQuery(name="ZbTRecrecordsLog.findAll", query="SELECT z FROM ZbTRecrecordsLog z")
public class ZbTRecrecordsLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="plan_id")
	private int planId;

	@Column(name="play_url")
	private String playUrl;

	private double price;

	private short rank;

	@Column(name="thumb_img_url")
	private String thumbImgUrl;

	private String title;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private int views;

	@Column(name="zb_id")
	private int zbId;

	public ZbTRecrecordsLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getPlanId() {
		return this.planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlayUrl() {
		return this.playUrl;
	}

	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public short getRank() {
		return this.rank;
	}

	public void setRank(short rank) {
		this.rank = rank;
	}

	public String getThumbImgUrl() {
		return this.thumbImgUrl;
	}

	public void setThumbImgUrl(String thumbImgUrl) {
		this.thumbImgUrl = thumbImgUrl;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getZbId() {
		return this.zbId;
	}

	public void setZbId(int zbId) {
		this.zbId = zbId;
	}

}