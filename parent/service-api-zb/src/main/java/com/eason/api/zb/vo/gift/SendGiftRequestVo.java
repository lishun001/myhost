package com.eason.api.zb.vo.gift;

import java.io.Serializable;

public class SendGiftRequestVo implements Serializable {

    private Integer giftId;         //礼物ID
    private Integer giftNum;     //礼物数

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(Integer giftNum) {
        this.giftNum = giftNum;
    }

    @Override
    public String toString() {
        return "SendGiftRequestVo{" +
                "giftId='" + giftId + '\'' +
                ", giftNum=" + giftNum +
                '}';
    }
}
