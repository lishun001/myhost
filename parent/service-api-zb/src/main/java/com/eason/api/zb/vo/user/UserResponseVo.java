package com.eason.api.zb.vo.user;

import java.io.Serializable;

public class UserResponseVo implements Serializable {

    private Integer userId;        //用户ID
    private String nickName;   //用户昵称
    private String signature;     // 用户签名
    private Integer sex;    //用户性别
    private String userHeadImg;    // 用户头像
    private Integer userLevel;  //用户等级
    private Integer vipLevel;  //用户VIP等级

    private Integer isAttention;    //用户是否关注
    private Integer attentionUserTotal;         //粉丝
    private Integer diamondGiftUserTotal;   // 用户在当前房间累计收礼总数

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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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

    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }

    public Integer getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(Integer isAttention) {
        this.isAttention = isAttention;
    }

    public Integer getAttentionUserTotal() {
        return attentionUserTotal;
    }

    public void setAttentionUserTotal(Integer attentionUserTotal) {
        this.attentionUserTotal = attentionUserTotal;
    }

    public Integer getDiamondGiftUserTotal() {
        return diamondGiftUserTotal;
    }

    public void setDiamondGiftUserTotal(Integer diamondGiftUserTotal) {
        this.diamondGiftUserTotal = diamondGiftUserTotal;
    }
}
