package com.eason.api.zb.vo.room;

import java.io.Serializable;

public class RoomStatResponseVo implements Serializable {
    private Integer statId;
    private Integer planId;
    private Long activityTime;
    private Integer incomeAmount;
    private Integer attentionCount;
    private Integer onlineUser;  //房间当前在线用户
    private Integer machineUser;  //房间用户
    private Integer viewCount;
    private Integer watchCount;
    private Integer giftCount;
    private Integer bombScreenCount;
    private String roomTitle;
    private String roomBgPic;           //房间背景图

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getStatId() {
        return statId;
    }

    public void setStatId(Integer statId) {
        this.statId = statId;
    }

    public Long getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Long activityTime) {
        this.activityTime = activityTime;
    }

    public Integer getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Integer incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(Integer giftCount) {
        this.giftCount = giftCount;
    }

    public Integer getBombScreenCount() {
        return bombScreenCount;
    }

    public void setBombScreenCount(Integer bombScreenCount) {
        this.bombScreenCount = bombScreenCount;
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomBgPic() {
        return roomBgPic;
    }

    public void setRoomBgPic(String roomBgPic) {
        this.roomBgPic = roomBgPic;
    }

    public Integer getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(Integer onlineUser) {
        this.onlineUser = onlineUser;
    }

    public Integer getMachineUser() {
        return machineUser;
    }

    public void setMachineUser(Integer machineUser) {
        this.machineUser = machineUser;
    }

    public Integer getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }
}
