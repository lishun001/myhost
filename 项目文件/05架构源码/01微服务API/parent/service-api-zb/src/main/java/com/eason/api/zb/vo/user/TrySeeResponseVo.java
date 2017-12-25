package com.eason.api.zb.vo.user;

import java.io.Serializable;
import java.sql.Timestamp;

public class TrySeeResponseVo implements Serializable {

     private Integer userId;	    //用户ID
	 private Integer isTrySee;      //0=未试看，1=已试看
    private Integer roomId;	    //用户ID
	 private Integer userLevel;      //用户等级
	 private Integer allowTime;      //允许试看时间
     private String trySeeTime;  //试看时间

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getIsTrySee() {
        return isTrySee;
    }

    public void setIsTrySee(Integer isTrySee) {
        this.isTrySee = isTrySee;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getAllowTime() {
        return allowTime;
    }

    public void setAllowTime(Integer allowTime) {
        this.allowTime = allowTime;
    }

    public String getTrySeeTime() {
        return trySeeTime;
    }

    public void setTrySeeTime(String trySeeTime) {
        this.trySeeTime = trySeeTime;
    }
}
