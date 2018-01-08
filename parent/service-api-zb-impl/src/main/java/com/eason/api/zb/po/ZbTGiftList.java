package com.eason.api.zb.po;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the zb_t_gift_list database table.
 * 
 */
@Entity
@Table(name="qvod_zb_t_gift_list")
@NamedQuery(name="ZbTGiftList.findAll", query="SELECT z FROM ZbTGiftList z")
public class ZbTGiftList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gift_id")
	private Integer giftId;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="create_user")
	private String createUser;

	@Column(name="gift_img")
	private String giftImg;

	@Column(name="gift_name")
	private String giftName;

	@Column(name="gift_price")
	private double giftPrice;

	@Column(name="order_field")
	private Integer orderField;

	@Column(name="category")
	private Integer category;

	@Column(name="special_style")
	private String specialStyle;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="update_user")
	private String updateUser;

	@Column(name="status")
	private Integer status;

	public ZbTGiftList() {
	}

	public Integer getGiftId() {
		return this.giftId;
	}

	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
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

	public String getGiftImg() {
		return this.giftImg;
	}

	public void setGiftImg(String giftImg) {
		this.giftImg = giftImg;
	}

	public String getGiftName() {
		return this.giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public Integer getOrderField() {
		return orderField;
	}

	public void setOrderField(Integer orderField) {
		this.orderField = orderField;
	}

	public double getGiftPrice() {
		return this.giftPrice;
	}

	public void setGiftPrice(double giftPrice) {
		this.giftPrice = giftPrice;
	}

	public String getSpecialStyle() {
		return this.specialStyle;
	}

	public void setSpecialStyle(String specialStyle) {
		this.specialStyle = specialStyle;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}
}