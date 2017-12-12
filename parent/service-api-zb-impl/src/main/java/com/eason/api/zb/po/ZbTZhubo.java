package com.eason.api.zb.po;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "qvod_zb_t_zhubo")
public class ZbTZhubo {
    private Integer zbId;
    private Integer userId;
    private Integer vipLevel;
    private Integer zbStatus;
    private int billingCycle;
    private int gainSharing;
    private BigDecimal maxWithdraw;
    private int minHours;
    private int validHours;
    private BigDecimal minIncome;
    private int timeState;
    private int ticketState;
    private int personalState;
    private int gameState;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "zb_id")
    public Integer getZbId() {
        return zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "vip_level")
    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }

    @Basic
    @Column(name = "zb_status")
    public Integer getZbStatus() {
        return zbStatus;
    }

    public void setZbStatus(Integer zbStatus) {
        this.zbStatus = zbStatus;
    }

    @Basic
    @Column(name = "billing_cycle")
    public int getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(int billingCycle) {
        this.billingCycle = billingCycle;
    }

    @Basic
    @Column(name = "gain_sharing")
    public int getGainSharing() {
        return gainSharing;
    }

    public void setGainSharing(int gainSharing) {
        this.gainSharing = gainSharing;
    }

    @Basic
    @Column(name = "max_withdraw")
    public BigDecimal getMaxWithdraw() {
        return maxWithdraw;
    }

    public void setMaxWithdraw(BigDecimal maxWithdraw) {
        this.maxWithdraw = maxWithdraw;
    }

    @Basic
    @Column(name = "min_hours")
    public int getMinHours() {
        return minHours;
    }

    public void setMinHours(int minHours) {
        this.minHours = minHours;
    }

    @Basic
    @Column(name = "valid_hours")
    public int getValidHours() {
        return validHours;
    }

    public void setValidHours(int validHours) {
        this.validHours = validHours;
    }

    @Basic
    @Column(name = "min_income")
    public BigDecimal getMinIncome() {
        return minIncome;
    }

    public void setMinIncome(BigDecimal minIncome) {
        this.minIncome = minIncome;
    }

    @Basic
    @Column(name = "time_state")
    public int getTimeState() {
        return timeState;
    }

    public void setTimeState(int timeState) {
        this.timeState = timeState;
    }

    @Basic
    @Column(name = "ticket_state")
    public int getTicketState() {
        return ticketState;
    }

    public void setTicketState(int ticketState) {
        this.ticketState = ticketState;
    }

    @Basic
    @Column(name = "personal_state")
    public int getPersonalState() {
        return personalState;
    }

    public void setPersonalState(int personalState) {
        this.personalState = personalState;
    }

    @Basic
    @Column(name = "game_state")
    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZbTZhubo that = (ZbTZhubo) o;
        return zbId == that.zbId &&
                billingCycle == that.billingCycle &&
                gainSharing == that.gainSharing &&
                minHours == that.minHours &&
                validHours == that.validHours &&
                timeState == that.timeState &&
                ticketState == that.ticketState &&
                personalState == that.personalState &&
                gameState == that.gameState &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(vipLevel, that.vipLevel) &&
                Objects.equals(zbStatus, that.zbStatus) &&
                Objects.equals(maxWithdraw, that.maxWithdraw) &&
                Objects.equals(minIncome, that.minIncome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(zbId, userId, vipLevel, zbStatus, billingCycle, gainSharing, maxWithdraw, minHours, validHours, minIncome, timeState, ticketState, personalState, gameState);
    }
}
