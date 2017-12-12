package com.eason.api.zb.vo.room;

import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import com.eason.api.zb.vo.user.UserLevelRankResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;

import java.io.Serializable;
import java.util.List;

public class RoomResponseVo implements Serializable {

    private Integer roomId;      //房间ID
    private String roomTitle;  //	房间标题
    private String roomType;  //房间类型：'normal=普通房间','ticket=门票房间','time=时常房间','private=私密房间','game=游戏房间'
    private Integer onlineUser;  //房间当前在线用户
    private Integer machineUser;  //房间用户
    private Integer diamondGiftNum;    //房间钻石礼物总数
    private Integer roomNo1;   //房间排名
    private String roomBackgroundImg; //房间背景图片
    private Integer zbId;    //主播ID
    private String zbNickname;    //主播昵称
    private String zbLevel;   //主播等级
    private String zbHeadImg;  //主播头像
    private String zbSignature;    //主播个性签名
    private Integer isAttention;    //用户是否关注
    private String userLevel;    // 用户等级息
    private Double diamondBalance;    //  用户钻石余额
    private List<UserResponseVo> diamondRankList;
    private List<UserLevelRankResponseVo> userLevelRankList;

    private MediaResponseVo media;
    private IMResponseVo im;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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

    public Integer getDiamondGiftNum() {
        return diamondGiftNum;
    }

    public void setDiamondGiftNum(Integer diamondGiftNum) {
        this.diamondGiftNum = diamondGiftNum;
    }

    public Integer getRoomNo1() {
        return roomNo1;
    }

    public void setRoomNo1(Integer roomNo1) {
        this.roomNo1 = roomNo1;
    }

    public String getRoomBackgroundImg() {
        return roomBackgroundImg;
    }

    public void setRoomBackgroundImg(String roomBackgroundImg) {
        this.roomBackgroundImg = roomBackgroundImg;
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

    public String getZbLevel() {
        return zbLevel;
    }

    public void setZbLevel(String zbLevel) {
        this.zbLevel = zbLevel;
    }

    public String getZbHeadImg() {
        return zbHeadImg;
    }

    public void setZbHeadImg(String zbHeadImg) {
        this.zbHeadImg = zbHeadImg;
    }

    public String getZbSignature() {
        return zbSignature;
    }

    public void setZbSignature(String zbSignature) {
        this.zbSignature = zbSignature;
    }

    public Integer getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(Integer isAttention) {
        this.isAttention = isAttention;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public Double getDiamondBalance() {
        return diamondBalance;
    }

    public void setDiamondBalance(Double diamondBalance) {
        this.diamondBalance = diamondBalance;
    }

    public List<UserResponseVo> getDiamondRankList() {
        return diamondRankList;
    }

    public void setDiamondRankList(List<UserResponseVo> diamondRankList) {
        this.diamondRankList = diamondRankList;
    }

    public List<UserLevelRankResponseVo> getUserLevelRankList() {
        return userLevelRankList;
    }

    public void setUserLevelRankList(List<UserLevelRankResponseVo> userLevelRankList) {
        this.userLevelRankList = userLevelRankList;
    }

    public MediaResponseVo getMedia() {
        return media;
    }

    public void setMedia(MediaResponseVo media) {
        this.media = media;
    }

    public IMResponseVo getIm() {
        return im;
    }

    public void setIm(IMResponseVo im) {
        this.im = im;
    }
}
