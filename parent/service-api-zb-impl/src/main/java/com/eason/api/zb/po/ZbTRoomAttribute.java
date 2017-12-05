package com.eason.api.zb.po;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the zb_t_room_attribute database table.
 * 
 */
@Entity
@Table(name="qvod_zb_t_room_attribute")
@NamedQuery(name="ZbTRoomAttribute.findAll", query="SELECT z FROM ZbTRoomAttribute z")
public class ZbTRoomAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="attribute_id")
	private Integer attributeId;

	@Column(name="attribute_key")
	private String attributeKey;

	@Column(name="attribute_value")
	private String attributeValue;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="create_user")
	private String createUser;

	private String remark;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="update_user")
	private String updateUser;

	public ZbTRoomAttribute() {
	}

	public Integer getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeKey() {
		return this.attributeKey;
	}

	public void setAttributeKey(String attributeKey) {
		this.attributeKey = attributeKey;
	}

	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}