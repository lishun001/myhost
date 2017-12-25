package com.eason.api.zb.vo.gift;

import java.io.Serializable;

public class GiftResponseVo implements Serializable {

    private Integer giftId;         //礼物ID
    private String giftName;     //礼物名称
    private String giftImg;       //礼物图片
    private Double giftPrice;     //礼物价格
    private String specialStyle;//特效方式

    public GiftResponseVo() {
    }

    public GiftResponseVo(Integer giftId) {
        this.giftId = giftId;
    }

    public GiftResponseVo(Integer giftId, String giftName, String giftImg, Double giftPrice, String specialStyle) {
        this.giftId = giftId;
        this.giftName = giftName;
        this.giftImg = giftImg;
        this.giftPrice = giftPrice;
        this.specialStyle = specialStyle;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftImg() {
        return giftImg;
    }

    public void setGiftImg(String giftImg) {
        this.giftImg = giftImg;
    }

    public Double getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(Double giftPrice) {
        this.giftPrice = giftPrice;
    }

    public String getSpecialStyle() {
        return specialStyle;
    }

    public void setSpecialStyle(String specialStyle) {
        this.specialStyle = specialStyle;
    }
}
