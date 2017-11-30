package com.eason.api.zb.vo.zhubo;

import java.io.Serializable;
import java.sql.Timestamp;

public class StartPlayRequestVo implements Serializable {
    private String roomType;   //房间类型
    private String roomTitle;      //房间标题
    private Long startTime;    //开始时间
    private Integer activityTime;     //继续时间=[30,60,90,120]
    private Integer price;    //每分钟单价=[1,2,5,10],门票单价=[20,50,100,120]
    private Integer userId;        //贵宾的用户id=user001

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
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

    public Integer getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Integer activityTime) {
        this.activityTime = activityTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
