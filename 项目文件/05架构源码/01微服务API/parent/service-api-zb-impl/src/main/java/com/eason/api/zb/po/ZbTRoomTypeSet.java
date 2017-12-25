package com.eason.api.zb.po;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the qvod_zb_t_room_type_set database table.
 */
@Entity
@Table(name = "qvod_zb_t_room_type_set")
@NamedQuery(name = "ZbTRoomTypeSet.findAll", query = "SELECT z FROM ZbTRoomTypeSet z")
public class ZbTRoomTypeSet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_set_id")
    private Integer typeSetId;

    @Column(name = "opt_time")
    private Timestamp optTime;

    @Column(name = "opt_user")
    private String optUser;

    private Integer price01;

    private Integer price02;

    private Integer price03;

    private Integer price04;

    private Integer price05;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "time_interval")
    private Integer timeInterval;

    private Integer time01;

    private Integer time02;

    private Integer time03;

    private Integer time04;

    private Integer time05;

    public ZbTRoomTypeSet() {
    }

    public Integer getTypeSetId() {
        return this.typeSetId;
    }

    public void setTypeSetId(Integer typeSetId) {
        this.typeSetId = typeSetId;
    }

    public Timestamp getOptTime() {
        return this.optTime;
    }

    public void setOptTime(Timestamp optTime) {
        this.optTime = optTime;
    }

    public String getOptUser() {
        return this.optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    public Integer getPrice01() {
        return this.price01;
    }

    public void setPrice01(Integer price01) {
        this.price01 = price01;
    }

    public Integer getPrice02() {
        return this.price02;
    }

    public void setPrice02(Integer price02) {
        this.price02 = price02;
    }

    public Integer getPrice03() {
        return this.price03;
    }

    public void setPrice03(Integer price03) {
        this.price03 = price03;
    }

    public Integer getPrice04() {
        return this.price04;
    }

    public void setPrice04(Integer price04) {
        this.price04 = price04;
    }

    public Integer getPrice05() {
        return this.price05;
    }

    public void setPrice05(Integer price05) {
        this.price05 = price05;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

    public Integer getTime01() {
        return this.time01;
    }

    public void setTime01(Integer time01) {
        this.time01 = time01;
    }

    public Integer getTime02() {
        return this.time02;
    }

    public void setTime02(Integer time02) {
        this.time02 = time02;
    }

    public Integer getTime03() {
        return this.time03;
    }

    public void setTime03(Integer time03) {
        this.time03 = time03;
    }

    public Integer getTime04() {
        return this.time04;
    }

    public void setTime04(Integer time04) {
        this.time04 = time04;
    }

    public Integer getTime05() {
        return this.time05;
    }

    public void setTime05(Integer time05) {
        this.time05 = time05;
    }

}