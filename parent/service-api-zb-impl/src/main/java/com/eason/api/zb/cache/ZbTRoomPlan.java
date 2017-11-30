package com.eason.api.zb.cache;

import com.eason.api.zb.model.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


@Document(collection = "zb_t_room_plan")
public class ZbTRoomPlan implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue
    @Id
    private int planId;

    private Integer activityTimeCount;

    private Integer bombScreen_count;

    private Date closeTime;

    private Integer giftCount;

    private Integer incomeAmount;

    private Integer machineUser;

    private Integer onlineUser;

    private Date openTime;

    @Indexed(unique = true)
    private Integer roomId;

    private Integer room_No1;

    private Integer orderField;

    private String roomTitle;

    private String roomType;

    private Integer roomStatus;      //房间状态

    private String roomBgPic;           //房间背景图

    private Integer viewCount;

    @Indexed(unique = true)
    private Integer zbId;                   //主播ID

    @Indexed(unique = true)
    private Integer userId;                //主播对应的用户ID

    private String zbNickname;  //主播昵称

    private Integer zbLevel;            //主播等级

    private String zbHeadImg;    //主播头像

    private String  zbSignature;       //主播的用户签名

    private Map<String, Object> roomSet;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomBgPic() {
        return roomBgPic;
    }

    public void setRoomBgPic(String roomBgPic) {
        this.roomBgPic = roomBgPic;
    }

    public String getZbSignature() {
        return zbSignature;
    }

    public void setZbSignature(String zbSignature) {
        this.zbSignature = zbSignature;
    }

    public Integer getActivityTimeCount() {
        return activityTimeCount;
    }

    public void setActivityTimeCount(Integer activityTimeCount) {
        this.activityTimeCount = activityTimeCount;
    }

    public Integer getBombScreen_count() {
        return bombScreen_count;
    }

    public void setBombScreen_count(Integer bombScreen_count) {
        this.bombScreen_count = bombScreen_count;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(Integer giftCount) {
        this.giftCount = giftCount;
    }

    public Integer getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Integer incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Integer getMachineUser() {
        return machineUser;
    }

    public void setMachineUser(Integer machineUser) {
        this.machineUser = machineUser;
    }

    public Integer getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(Integer onlineUser) {
        this.onlineUser = onlineUser;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoom_No1() {
        return room_No1;
    }

    public void setRoom_No1(Integer room_No1) {
        this.room_No1 = room_No1;
    }

    public Integer getOrderField() {
        return orderField;
    }

    public void setOrderField(Integer orderField) {
        this.orderField = orderField;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getZbId() {
        return zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    public String getZbNickname() {
        return zbNickname;
    }

    public void setZbNickname(String zbNickname) {
        this.zbNickname = zbNickname;
    }

    public Integer getZbLevel() {
        return zbLevel;
    }

    public void setZbLevel(Integer zbLevel) {
        this.zbLevel = zbLevel;
    }

    public String getZbHeadImg() {
        return zbHeadImg;
    }

    public void setZbHeadImg(String zbHeadImg) {
        this.zbHeadImg = zbHeadImg;
    }

    public Map<String, Object> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Map<String, Object> roomSet) {
        this.roomSet = roomSet;
    }
}