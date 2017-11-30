package com.eason.api.zb.vo.zhubo;

import java.io.Serializable;

public class StartPlayResponseVo implements Serializable {
    private Integer planId;
    private Integer roomStatus;   //0=创建，1=直播中，2=未开播，3=回放中
    private String result;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
