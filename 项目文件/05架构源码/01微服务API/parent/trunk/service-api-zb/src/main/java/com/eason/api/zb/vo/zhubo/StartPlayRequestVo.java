package com.eason.api.zb.vo.zhubo;

import java.io.Serializable;

public class StartPlayRequestVo implements Serializable {
    private Integer roomId;     //房间id
    private String roomType;   //房间类型
    private String roomTitle;      //房间标题
    private String activityTime;     //继续时间=[30,60,90,120]
    private String price;    //每分钟单价=[1,2,5,10],门票单价=[20,50,100,120]
    private String userIds;        //贵宾的用户id=[user001,user002,user003]

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }
}
