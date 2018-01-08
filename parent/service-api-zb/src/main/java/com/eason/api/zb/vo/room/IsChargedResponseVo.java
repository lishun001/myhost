package com.eason.api.zb.vo.room;

import java.io.Serializable;

public class IsChargedResponseVo implements Serializable {

    private Integer roomId;     //房间ID
    private Integer zbId;   //主播ID
    private String roomType;   //房间类型
    private Integer userId;
    private Integer isTrySee;
    private Integer isCharge;
    private Integer allowTime;
    private Integer ticketStatus;
    private Integer selectPrice;
    private Integer timeInterval;

    private Long usedTime;  //已播时长
    private Long remainTime;    //剩余时长

    private Integer personalStatus;


    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getZbId() {
        return zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsTrySee() {
        return isTrySee;
    }

    public void setIsTrySee(Integer isTrySee) {
        this.isTrySee = isTrySee;
    }

    public Integer getAllowTime() {
        return allowTime;
    }

    public void setAllowTime(Integer allowTime) {
        this.allowTime = allowTime;
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Integer getSelectPrice() {
        return selectPrice;
    }

    public void setSelectPrice(Integer selectPrice) {
        this.selectPrice = selectPrice;
    }

    public Integer getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

    public Integer getPersonalStatus() {
        return personalStatus;
    }

    public void setPersonalStatus(Integer personalStatus) {
        this.personalStatus = personalStatus;
    }

    public Integer getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(Integer isCharge) {
        this.isCharge = isCharge;
    }

    public Long getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Long usedTime) {
        this.usedTime = usedTime;
    }

    public Long getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(Long remainTime) {
        this.remainTime = remainTime;
    }
}
