package com.eason.api.zb.vo.gift;

import java.io.Serializable;

public class SendGiftResponseVo implements Serializable {

    private Integer userId;         //用户ID
    private Double diamondBalance;     //用户钻石余额
    private Double cost;           //消费金额

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getDiamondBalance() {
        return diamondBalance;
    }

    public void setDiamondBalance(Double diamondBalance) {
        this.diamondBalance = diamondBalance;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
