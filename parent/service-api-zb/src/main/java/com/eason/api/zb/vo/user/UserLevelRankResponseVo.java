package com.eason.api.zb.vo.user;

import java.io.Serializable;

public class UserLevelRankResponseVo implements Serializable {

     private Integer userId;		//用户ID
	 private String nickName	;   //用户昵称
	 private Integer sex;    //用户性别
	 private String userHeadImg;    // 用户头像
	 private Integer userLevel;  //用户等级

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

}
