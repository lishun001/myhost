package com.eason.api.zb.cache;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;

@Document(collection = "zb_t_room_cron")
public class ZbTRoomCron implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private BigInteger id;
    private Integer zbId;                   //主播ID
    private String cron;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getZbId() {
        return zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}