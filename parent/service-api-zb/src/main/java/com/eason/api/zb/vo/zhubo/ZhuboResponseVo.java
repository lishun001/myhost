package com.eason.api.zb.vo.zhubo;

import java.io.Serializable;

public class ZhuboResponseVo implements Serializable {

    private Integer zbId;    //主播ID
    private Integer userId;
    private String zbNickname;  //主播昵称
    private Integer zbLevel;            //主播等级
    private String zbHeadImg;    //主播头像
    private Integer zbUserLevel;    //主播用户等级
    private Integer zbUserVIP;    //主播用户VIP
    private Integer isAttention;    //用户是否关注
    private Integer isBook;
    private String zbSignature;
    private String zbBackgroundImg;
    private Integer attentionUserTotal;
    private Integer diamondGiftZBTotal;
    private Integer costTotal;

    public Integer getZbId() {
        return zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsBook() {
        return isBook;
    }

    public void setIsBook(Integer isBook) {
        this.isBook = isBook;
    }

    public String getZbNickname() {
        return zbNickname;
    }

    public void setZbNickname(String zbNickname) {
        this.zbNickname = zbNickname;
    }

    public Integer getZbLevel() {
        return zbLevel;
    }

    public void setZbLevel(Integer zbLevel) {
        this.zbLevel = zbLevel;
    }

    public Integer getZbUserLevel() {
        return zbUserLevel;
    }

    public void setZbUserLevel(Integer zbUserLevel) {
        this.zbUserLevel = zbUserLevel;
    }

    public Integer getZbUserVIP() {
        return zbUserVIP;
    }

    public void setZbUserVIP(Integer zbUserVIP) {
        this.zbUserVIP = zbUserVIP;
    }

    public String getZbHeadImg() {
        return zbHeadImg;
    }

    public void setZbHeadImg(String zbHeadImg) {
        this.zbHeadImg = zbHeadImg;
    }

    public Integer getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(Integer isAttention) {
        this.isAttention = isAttention;
    }

    public String getZbSignature() {
        return zbSignature;
    }

    public void setZbSignature(String zbSignature) {
        this.zbSignature = zbSignature;
    }

    public String getZbBackgroundImg() {
        return zbBackgroundImg;
    }

    public void setZbBackgroundImg(String zbBackgroundImg) {
        this.zbBackgroundImg = zbBackgroundImg;
    }

    public Integer getAttentionUserTotal() {
        return attentionUserTotal;
    }

    public void setAttentionUserTotal(Integer attentionUserTotal) {
        this.attentionUserTotal = attentionUserTotal;
    }

    public Integer getDiamondGiftZBTotal() {
        return diamondGiftZBTotal;
    }

    public void setDiamondGiftZBTotal(Integer diamondGiftZBTotal) {
        this.diamondGiftZBTotal = diamondGiftZBTotal;
    }

    public Integer getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(Integer costTotal) {
        this.costTotal = costTotal;
    }
}
