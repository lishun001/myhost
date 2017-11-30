package com.eason.api.zb.vo.index;

import java.io.Serializable;
import java.sql.Timestamp;

public class IndexResponseVo implements Serializable {

    private Integer roomId;     //房间ID
    private Integer roomPlanId;  //场次ID
    private Integer zbId;     //主播ID
    private String zbNickName;     //主播昵称
    private String zbHeadImg;       //主播头像
    private Integer zbLevel;            //主播等级
    private String roomTitle;     // 房间标题
    private String roomType;     // 房间类型：'normal=普通房间','ticket=门票房间','time=时常房间','personal=私密房间','game=游戏房间'
     private Integer onlineUser ;   //真实在线用户
    private Integer machineUser;     //机器用户
    private String roomBackgroundImg;     // 房间背景图片
    private Integer roomStatus;     // 直播状态： 1=直播中，2=未开播，3=回放中
    private Timestamp startTime;     //房间开播时间

    public IndexResponseVo() {
    }

    public IndexResponseVo(Integer roomId, Integer zbId, String zbNickName, String roomTitle, String roomType, Integer onlineUser, Integer machineUser, String roomBackgroundImg, Integer roomStatus, Timestamp startTime) {
        this.roomId = roomId;
        this.zbId = zbId;
        this.zbNickName = zbNickName;
        this.roomTitle = roomTitle;
        this.roomType = roomType;
        this.onlineUser=onlineUser;
        this.machineUser = machineUser;
        this.roomBackgroundImg = roomBackgroundImg;
        this.roomStatus = roomStatus;
        this.startTime = startTime;
    }

    public String getZbHeadImg() {
        return zbHeadImg;
    }

    public void setZbHeadImg(String zbHeadImg) {
        this.zbHeadImg = zbHeadImg;
    }

    public Integer getZbLevel() {
        return zbLevel;
    }

    public void setZbLevel(Integer zbLevel) {
        this.zbLevel = zbLevel;
    }

    public Integer getRoomPlanId() {
        return roomPlanId;
    }

    public void setRoomPlanId(Integer roomPlanId) {
        this.roomPlanId = roomPlanId;
    }

    public Integer getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(Integer onlineUser) {
        this.onlineUser = onlineUser;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getZbId() {
        return zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    public String getZbNickName() {
        return zbNickName;
    }

    public void setZbNickName(String zbNickName) {
        this.zbNickName = zbNickName;
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

    public Integer getMachineUser() {
        return machineUser;
    }

    public void setMachineUser(Integer machineUser) {
        this.machineUser = machineUser;
    }

    public String getRoomBackgroundImg() {
        return roomBackgroundImg;
    }

    public void setRoomBackgroundImg(String roomBackgroundImg) {
        this.roomBackgroundImg = roomBackgroundImg;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer zbStatus) {
        this.roomStatus = roomStatus;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

}
