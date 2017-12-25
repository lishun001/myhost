package com.eason.api.zb.po;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the zb_t_appy database table.
 * 
 */
@Entity
@Table(name="qvod_zb_t_appy")
@NamedQuery(name="ZbTAppy.findAll", query="SELECT z FROM ZbTAppy z")
public class ZbTAppy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appy_id")
	private Integer appyId;

	@Column(name="appy_context")
	private String appyContext;

	@Column(name="appy_status")
	private Integer appyStatus;

	@Column(name="appy_time")
	private Timestamp appyTime;

	private String remark;

	//bi-directional many-to-one association to ZbTZhubo
	@ManyToOne
	@JoinColumn(name="user_id")
	private ZbTZhubo zbTZhubo;

	public ZbTAppy() {
	}

	public Integer getAppyId() {
		return this.appyId;
	}

	public void setAppyId(Integer appyId) {
		this.appyId = appyId;
	}

	public String getAppyContext() {
		return this.appyContext;
	}

	public void setAppyContext(String appyContext) {
		this.appyContext = appyContext;
	}

	public Integer getAppyStatus() {
		return this.appyStatus;
	}

	public void setAppyStatus(Integer appyStatus) {
		this.appyStatus = appyStatus;
	}

	public Timestamp getAppyTime() {
		return this.appyTime;
	}

	public void setAppyTime(Timestamp appyTime) {
		this.appyTime = appyTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ZbTZhubo getZbTZhubo() {
		return this.zbTZhubo;
	}

	public void setZbTZhubo(ZbTZhubo zbTZhubo) {
		this.zbTZhubo = zbTZhubo;
	}

}