package com.eason.api.zb.vo.room;

import java.io.Serializable;

public class RoomSetResponseVo implements Serializable {

    private String roomType;    //房间类型
//        private JSONObject [ticket]
//       private String} ticket.startTime 开始时间（yyyy-MM-dd HH:mm:ss）
//       private String} ticket.activityTime   继续时间=[30,60,90,120]
//       private String} ticket.price   每分钟单价=[1,2,5,10]
//       private JSONObject} [time]
//       private String} time.startTime 开始时间（yyyy-MM-dd HH:mm:ss）
//       private String} time.activityTime   继续时间=[30,60,90,120]
//       private String} time.price   门票单价=[20,50,100,120]
//       private JSONObject} [personal]
//       private String} personal.startTime 开始时间（yyyy-MM-dd HH:mm:ss）
//       private String} personal.activityTime   继续时间=[30,60,90,120]
//       private String} personal.userIds		贵宾的用户id=[user001,user002,user003]

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

}
