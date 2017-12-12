package com.openapi.model.response.order;

import java.util.Date;
import java.util.List;

import view.order.LogisticsVo;

import com.jiuwu.openoo.common.openapi.response.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("locadAndDeliCargoResponse")
public class LogisticsOrderResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;			//发布人
	private String cargoName;		//货品名称
	private String startLocation;	//出货地点(经纬度指定的地点)
	private String startGps;		//出货经纬度（A，B）
	private Date createTime;		//创建时间
	private String shipperName;		//发货人
	private String shipperPhone;	//发货电话
	private String startTime;		//出货时间段（2016-4-20 12：00：00 到 2016-4-21 12：00：00）
	private Integer ifLoadCargo;		//是否装货（0=否，1=是）
	private Integer ifDischargeCargo;	//是否卸货（0=否，1=是）
	private String endLocation;		//收货人地址(经纬度指定的地点)
	private String endGps;			//取货经纬度（A，B）
	private String receiverName;	//收货人名称
	private String receiverPhone;	//收货人电话
	private Integer tempMin;		//温度最低
	private Integer tempMax;		//温度最高
	private Integer cargoNum;	//货物数量
	private String cargoZhg;	//货物的长宽高，格式：长*宽*高
	private Integer cargoSize;	//格式：只存单位体积（立方米）
	private Integer cargoWeight;	//货物重量，单位吨
	private String remark;	 //留言（货物描述）
	//订单参数
	private Integer sendType; //订单类型（1=拼车，2=包车）
	private String cargoOrderId;  //订单号
	private String amount;	//价格
	//时间参数
	private Date publishTime;
	private Date deliTime;
	private Date cancelTime;
	private Date finishTime;
	
	private String distance; //距离
	//司机信息
	private String carAccount; //司机的帐号
	private String carNickName; //司机的昵称
	private Integer carUserId;  //司机的id
	private Integer carId; 		//车的id
	private String carNo;		//车牌号
	
	private List<LogisticsVo> logisticsList;
	
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Integer getCargoSize() {
		return cargoSize;
	}

	public void setCargoSize(Integer cargoSize) {
		this.cargoSize = cargoSize;
	}

	public Integer getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(Integer cargoWeight) {
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

	public String getCargoOrderId() {
		return cargoOrderId;
	}

	public void setCargoOrderId(String cargoOrderId) {
		this.cargoOrderId = cargoOrderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getDeliTime() {
		return deliTime;
	}

	public void setDeliTime(Date deliTime) {
		this.deliTime = deliTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public List<LogisticsVo> getLogisticsList() {
		return logisticsList;
	}

	public void setLogisticsList(List<LogisticsVo> logisticsList) {
		this.logisticsList = logisticsList;
	}

	public String getCarAccount() {
		return carAccount;
	}

	public void setCarAccount(String carAccount) {
		this.carAccount = carAccount;
	}

	public String getCarNickName() {
		return carNickName;
	}

	public void setCarNickName(String carNickName) {
		this.carNickName = carNickName;
	}

	public Integer getCarUserId() {
		return carUserId;
	}

	public void setCarUserId(Integer carUserId) {
		this.carUserId = carUserId;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	
}