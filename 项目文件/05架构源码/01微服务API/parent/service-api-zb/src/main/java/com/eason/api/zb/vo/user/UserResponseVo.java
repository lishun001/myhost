package com.eason.api.zb.vo.user;

import java.io.Serializable;

public class UserResponseVo implements Serializable {

     private Integer userId;		//用户ID
	 private String nickName	;   //用户昵称
	 private Integer sex;    //用户性别
	 private String userHeadImg;    // 用户头像
	 private Integer userLevel;  //用户等级
	 private Double diamondBalance;     //用户钻石余额
	 private Integer giftRankNo1;    //当前房间送礼排行
	 private Integer diamondGiftUserTotal;   // 当前用户在当前房间累计送礼总数

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

    public Double getDiamondBalance() {
        return diamondBalance;
    }

    public void setDiamondBalance(Double diamondBalance) {
        this.diamondBalance = diamondBalance;
    }

    public Integer getGiftRankNo1() {
        return giftRankNo1;
    }

    public void setGiftRankNo1(Integer giftRankNo1) {
        this.giftRankNo1 = giftRankNo1;
    }

    public Integer getDiamondGiftUserTotal() {
        return diamondGiftUserTotal;
    }

    public void setDiamondGiftUserTotal(Integer diamondGiftUserTotal) {
        this.diamondGiftUserTotal = diamondGiftUserTotal;
    }
}
