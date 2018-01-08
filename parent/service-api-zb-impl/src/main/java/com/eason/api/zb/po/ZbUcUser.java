package com.eason.api.zb.po;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "qvod_uc_users")
public class ZbUcUser  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private double deposit;
    private String phone;
    private Date birthday;
    private String signature;
    private String avatar;
    private short constellation;
    private String location;
    private short level;
    private short sex;
    private short vip;
    private Timestamp exVipTime;
    private String signage;
    private Double points;
    private Integer reSignage;
    private Integer isMute;
    private String salt;
    private Byte status;
    private Long exp;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "deposit")
    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "signature")
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return (avatar==null || "".equals(avatar))?"http://img.qstuanwei.com/baner/mrtx-1.jpg":avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "constellation")
    public short getConstellation() {
        return constellation;
    }

    public void setConstellation(short constellation) {
        this.constellation = constellation;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "level")
    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    @Basic
    @Column(name = "sex")
    public short getSex() {
        return sex;
    }

    public void setSex(short sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "vip")
    public short getVip() {
        return vip;
    }

    public void setVip(short vip) {
        this.vip = vip;
    }

    @Basic
    @Column(name = "ex_vip_time")
    public Timestamp getExVipTime() {
        return exVipTime;
    }

    public void setExVipTime(Timestamp exVipTime) {
        this.exVipTime = exVipTime;
    }

    @Basic
    @Column(name = "signage")
    public String getSignage() {
        return signage;
    }

    public void setSignage(String signage) {
        this.signage = signage;
    }

    @Basic
    @Column(name = "points")
    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    @Basic
    @Column(name = "re_signage")
    public Integer getReSignage() {
        return reSignage;
    }

    public void setReSignage(Integer reSignage) {
        this.reSignage = reSignage;
    }

    @Basic
    @Column(name = "is_mute")
    public Integer getIsMute() {
        return isMute;
    }

    public void setIsMute(Integer isMute) {
        this.isMute = isMute;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "exp")
    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZbUcUser zbUcUser = (ZbUcUser) o;
        return id == zbUcUser.id &&
                Double.compare(zbUcUser.deposit, deposit) == 0 &&
                constellation == zbUcUser.constellation &&
                level == zbUcUser.level &&
                sex == zbUcUser.sex &&
                vip == zbUcUser.vip &&
                Objects.equals(username, zbUcUser.username) &&
                Objects.equals(nickname, zbUcUser.nickname) &&
                Objects.equals(password, zbUcUser.password) &&
                Objects.equals(phone, zbUcUser.phone) &&
                Objects.equals(birthday, zbUcUser.birthday) &&
                Objects.equals(signature, zbUcUser.signature) &&
                Objects.equals(avatar, zbUcUser.avatar) &&
                Objects.equals(location, zbUcUser.location) &&
                Objects.equals(exVipTime, zbUcUser.exVipTime) &&
                Objects.equals(signage, zbUcUser.signage) &&
                Objects.equals(points, zbUcUser.points) &&
                Objects.equals(reSignage, zbUcUser.reSignage) &&
                Objects.equals(isMute, zbUcUser.isMute) &&
                Objects.equals(salt, zbUcUser.salt) &&
                Objects.equals(status, zbUcUser.status) &&
                Objects.equals(exp, zbUcUser.exp) &&
                Objects.equals(createdAt, zbUcUser.createdAt) &&
                Objects.equals(updatedAt, zbUcUser.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, nickname, password, deposit, phone, birthday, signature, avatar, constellation, location, level, sex, vip, exVipTime, signage, points, reSignage, isMute, salt, status, exp, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "ZbUcUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", deposit=" + deposit +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", signature='" + signature + '\'' +
                ", avatar='" + avatar + '\'' +
                ", constellation=" + constellation +
                ", location='" + location + '\'' +
                ", level=" + level +
                ", sex=" + sex +
                ", vip=" + vip +
                ", exVipTime=" + exVipTime +
                ", signage='" + signage + '\'' +
                ", points=" + points +
                ", reSignage=" + reSignage +
                ", isMute=" + isMute +
                ", salt='" + salt + '\'' +
                ", status=" + status +
                ", exp=" + exp +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
