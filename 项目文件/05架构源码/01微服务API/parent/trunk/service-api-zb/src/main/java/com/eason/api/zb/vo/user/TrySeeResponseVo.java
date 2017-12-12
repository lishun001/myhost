package com.eason.api.zb.vo.user;

import java.io.Serializable;
import java.sql.Timestamp;

public class TrySeeResponseVo implements Serializable {

     private Integer userId;	    //用户ID
	 private Integer isTrySee;      //1=未试看，2=已试看
	 private String userLevel;      //用户等级
	 private String allowTime;      //允许试看时间
	 private Timestamp overTime;       //试看结束时间

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

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getAllowTime() {
        return allowTime;
    }

    public void setAllowTime(String allowTime) {
        this.allowTime = allowTime;
    }

    public Timestamp getOverTime() {
        return overTime;
    }

    public void setOverTime(Timestamp overTime) {
        this.overTime = overTime;
    }
}
