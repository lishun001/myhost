package com.eason.api.zb.po;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the qvod_zb_t_room_media_delete_log database table.
 */
@Entity
@Table(name = "qvod_zb_t_room_media_delete_log")
@NamedQuery(name = "ZbTRoomMediaDeleteLog.findAll", query = "SELECT z FROM ZbTRoomMediaDeleteLog z")
public class ZbTRoomMediaDeleteLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Integer logId;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "delete_api")
    private String deleteApi;

    @Lob
    private String result;

    @Column(name = "rmtp_url")
    private String rmtpUrl;

    @Column(name = "zb_id")
    private Integer zbId;

    public ZbTRoomMediaDeleteLog() {
    }

    public Integer getLogId() {
        return this.logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getDeleteApi() {
        return this.deleteApi;
    }

    public void setDeleteApi(String deleteApi) {
        this.deleteApi = deleteApi;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRmtpUrl() {
        return this.rmtpUrl;
    }

    public void setRmtpUrl(String rmtpUrl) {
        this.rmtpUrl = rmtpUrl;
    }

    public Integer getZbId() {
        return this.zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

}