package com.eason.api.zb.cache;

import java.io.Serializable;


public class ZbTUserTrysee implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer isTrysee;

    private Integer userId;

    public ZbTUserTrysee() {
    }

    public Integer getIsTrysee() {
        return this.isTrysee;
    }

    public void setIsTrysee(Integer isTrysee) {
        this.isTrysee = isTrysee;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}