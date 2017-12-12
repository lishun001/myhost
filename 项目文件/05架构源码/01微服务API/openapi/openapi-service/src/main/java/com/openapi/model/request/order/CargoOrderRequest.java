package com.openapi.model.request.order;

import com.jiuwu.openoo.common.openapi.request.Request;

public class CargoOrderRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520195154935104251L;
	//货物参数
	private String cargoOrderId;	//货物订单id
	private Integer status;			//订单状态
	private Integer userId;			//发布人
	private String cargoName;		//货品名称
	private String startLocation;	//出货地点(经纬度指定的地点)
	private String startGps;		//出货经纬度（A，B）
	private String startTime;		//出货时间段（2016-4-20 12：00：00 到 2016-4-21 12：00：00）
	private String shipperName;		//出货人
	private String shipperPhone;	//出货人电话 
	private Integer ifLoadCargo;		//是否装货（0=否，1=是）
	private Integer ifDischargeCargo;	//是否卸货（0=否，1=是）
	private String endLocation;		//取货地点(经纬度指定的地点)
	private String endGps;			//取货经纬度（A，B）
	private String receiverName;	//收货人名称
	private String receiverPhone;	//收货人电话
	private Integer tempMin;		//温度最低
	private Integer tempMax;		//温度最高
	private Integer cargoNum;	//货物数量
	private String cargoZhg;	//货物的长宽高，格式：长*宽*高
	private Double cargoSize;	//格式：只存单位体积（立方米）
	private Double cargoWeight;	//货物重量，单位吨
	private String remark;	 //留言
	//订单参数
	private Integer sendType; //订单类型（1=拼车，2=包车）
	private Double tip;			//小费
	private Double goCharge;	//运费
	private Integer isInvoice;  //是否需要发票（0=不限、1=否、2=是）
	
	//删除订单ids
	private String cargoOrderIds;
	
	public String getCargoOrderId() {
		return cargoOrderId;
	}
	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCargoName() {
		return cargoName;
	}
	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getStartGps() {
		return startGps;
	}
	public void setStartGps(String startGps) {
		this.startGps = startGps;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Integer getIfLoadCargo() {
		return ifLoadCargo;
	}
	public void setIfLoadCargo(Integer ifLoadCargo) {
		this.ifLoadCargo = ifLoadCargo;
	}
	public Integer getIfDischargeCargo() {
		return ifDischargeCargo;
	}
	public void setIfDischargeCargo(Integer ifDischargeCargo) {
		this.ifDischargeCargo = ifDischargeCargo;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public String getEndGps() {
		return endGps;
	}
	public void setEndGps(String endGps) {
		this.endGps = endGps;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public Integer getTempMin() {
		return tempMin;
	}
	public void setTempMin(Integer tempMin) {
		this.tempMin = tempMin;
	}
	public Integer getTempMax() {
		return tempMax;
	}
	public void setTempMax(Integer tempMax) {
		this.tempMax = tempMax;
	}
	public Integer getCargoNum() {
		return cargoNum;
	}
	public void setCargoNum(Integer cargoNum) {
		this.cargoNum = cargoNum;
	}
	public String getCargoZhg() {
		return cargoZhg;
	}
	public void setCargoZhg(String cargoZhg) {
		this.cargoZhg = cargoZhg;
	}
	public Double getCargoSize() {
		return cargoSize;
	}
	public void setCargoSize(Double cargoSize) {
		this.cargoSize = cargoSize;
	}
	public Double getCargoWeight() {
		return cargoWeight;
	}
	public void setCargoWeight(Double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getSendType() {
		return sendType;
	}
	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
	public Double getTip() {
		return tip;
	}
	public void setTip(Double tip) {
		this.tip = tip;
	}
	public Double getGoCharge() {
		return goCharge;
	}
	public void setGoCharge(Double goCharge) {
		this.goCharge = goCharge;
	}
	public Integer getIsInvoice() {
		return isInvoice;
	}
	public void setIsInvoice(Integer isInvoice) {
		this.isInvoice = isInvoice;
	}
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getShipperPhone() {
		return shipperPhone;
	}
	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}
	public String getCargoOrderIds() {
		return cargoOrderIds;
	}
	public void setCargoOrderIds(String cargoOrderIds) {
		this.cargoOrderIds = cargoOrderIds;
	}
}
