package com.eason.api.zb.vo.user;

import java.io.Serializable;

public class UserLevelRankResponseVo implements Serializable {

     private Integer userId;		//用户ID
	 private String nickName	;   //用户昵称
	 private String sex;    //用户性别
	 private String userHeadImg;    // 用户头像
	 private String userLevel;  //用户等级

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

}
