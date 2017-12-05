package com.eason.api.zb.po;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the qvod_zb_t_user_blacklist database table.
 * 
 */
@Entity
@Table(name="qvod_zb_t_user_blacklist")
@NamedQuery(name="ZbTUserBlacklist.findAll", query="SELECT z FROM ZbTUserBlacklist z")
public class ZbTUserBlacklist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="blacklist_id")
	private Integer blacklistId;

	@Column(name="black_time")
	private Timestamp blackTime;

	@Column(name="blacklist_user_id")
	private Integer blacklistUserId;

	@Column(name="user_id")
	private Integer userId;

    private Integer channel;

	public ZbTUserBlacklist() {
	}

	public Integer getBlacklistId() {
		return this.blacklistId;
	}

	public void setBlacklistId(Integer blacklistId) {
		this.blacklistId = blacklistId;
	}

	public Timestamp getBlackTime() {
		return this.blackTime;
	}

	public void setBlackTime(Timestamp blackTime) {
		this.blackTime = blackTime;
	}

	public Integer getBlacklistUserId() {
		return this.blacklistUserId;
	}

	public void setBlacklistUserId(Integer blacklistUserId) {
		this.blacklistUserId = blacklistUserId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}