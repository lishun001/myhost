package com.eason.api.zb.vo.room;

import java.io.Serializable;

public class IsChargedResponseVo implements Serializable {

     private Integer roomId;     //房间ID
	 private Integer zbId;   //主播ID
	 private String roomType;   //房间类型
    /*
    *   ticket.ticketStatus 0=未购买，1=购买，2=使用中，3=已使用，4=已作废
    *   ticket.price   门票单价
    *   -
    *    time.price 时长单价
    *    time.unit   时长单位
    *    -
    *    personalStatus 0=未预约，1=已预约
     */

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

}
