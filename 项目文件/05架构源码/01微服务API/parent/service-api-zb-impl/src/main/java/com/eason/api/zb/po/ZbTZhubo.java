package com.eason.api.zb.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the zb_t_zhubo database table.
 */
@Entity
@Table(name = "qvod_zb_t_zhubo")
@NamedQuery(name = "ZbTZhubo.findAll", query = "SELECT z FROM ZbTZhubo z")
public class ZbTZhubo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zb_id")
    private Integer zbId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "vip_level")
    private Integer vipLevel;

    @Column(name = "zb_status")
    private Integer zbStatus;

    //bi-directional many-to-one association to ZbTAppy
    @OneToMany(mappedBy = "zbTZhubo")
    private List<ZbTAppy> zbTAppies;

    public ZbTZhubo() {
    }

    public Integer getZbId() {
        return this.zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVipLevel() {
        return this.vipLevel;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }

    public Integer getZbStatus() {
        return this.zbStatus;
    }

    public void setZbStatus(Integer zbStatus) {
        this.zbStatus = zbStatus;
    }

    public List<ZbTAppy> getZbTAppies() {
        return this.zbTAppies;
    }

    public void setZbTAppies(List<ZbTAppy> zbTAppies) {
        this.zbTAppies = zbTAppies;
    }

    public ZbTAppy addZbTAppy(ZbTAppy zbTAppy) {
        getZbTAppies().add(zbTAppy);
        zbTAppy.setZbTZhubo(this);

        return zbTAppy;
    }

    public ZbTAppy removeZbTAppy(ZbTAppy zbTAppy) {
        getZbTAppies().remove(zbTAppy);
        zbTAppy.setZbTZhubo(null);

        return zbTAppy;
    }

}