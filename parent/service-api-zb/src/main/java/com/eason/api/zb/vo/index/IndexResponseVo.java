package com.eason.api.zb.vo.index;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

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
    private Integer viewCount;          //浏览次数
    private Integer watchCount;          //观看次数
    private String roomBackgroundImg;     // 房间背景图片
    private Integer roomStatus;     // 直播状态： 1=直播中，2=未开播，3=回放中
    private Timestamp startTime;     //房间开播时间
    private String playUrl;                 //回放地址
    private Integer isCharge;           //是否收费

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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomPlanId() {
        return roomPlanId;
    }

    public void setRoomPlanId(Integer roomPlanId) {
        this.roomPlanId = roomPlanId;
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

    public String getRoomBackgroundImg() {
        return roomBackgroundImg;
    }

    public void setRoomBackgroundImg(String roomBackgroundImg) {
        this.roomBackgroundImg = roomBackgroundImg;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public Integer getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(Integer isCharge) {
        this.isCharge = isCharge;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexResponseVo that = (IndexResponseVo) o;
        return Objects.equals(roomId, that.roomId) &&
                Objects.equals(roomPlanId, that.roomPlanId) &&
                Objects.equals(zbId, that.zbId) &&
                Objects.equals(zbNickName, that.zbNickName) &&
                Objects.equals(zbHeadImg, that.zbHeadImg) &&
                Objects.equals(zbLevel, that.zbLevel) &&
                Objects.equals(roomTitle, that.roomTitle) &&
                Objects.equals(roomType, that.roomType) &&
                Objects.equals(onlineUser, that.onlineUser) &&
                Objects.equals(machineUser, that.machineUser) &&
                Objects.equals(viewCount, that.viewCount) &&
                Objects.equals(watchCount, that.watchCount) &&
                Objects.equals(roomBackgroundImg, that.roomBackgroundImg) &&
                Objects.equals(roomStatus, that.roomStatus) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(playUrl, that.playUrl) &&
                Objects.equals(isCharge, that.isCharge);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roomId, roomPlanId, zbId, zbNickName, zbHeadImg, zbLevel, roomTitle, roomType, onlineUser, machineUser, viewCount, watchCount, roomBackgroundImg, roomStatus, startTime, playUrl, isCharge);
    }
}
