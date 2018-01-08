package com.eason.api.zb.vo.zhubo;

import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ReadyPlayResponseVo implements Serializable {

    private Integer roomId;     //房间id
    private String roomTitle;   //房间标题
    private Integer roomStatus;        //房间状态(0=创建，1=直播中，2=未开播，3=回放中)
    private String roomType;            //房间类型
    private String roomBackgroundImg;      //房间背景图
    private Timestamp openTime;         //开播时间（如果有）
    private String download_url;    //下载地址
    private String result;
    private MediaResponseVo media=new MediaResponseVo();
    private IMResponseVo im=new IMResponseVo();

    private Map<String,Object> ticketConf=new HashMap<>();
    private Map<String,Object> timeConf=new HashMap<>();
    private Map<String,Object> personalConf=new HashMap<>();
    private Map<String,Object> gameConf=new HashMap<>();


    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomBackgroundImg() {
        return roomBackgroundImg;
    }

    public void setRoomBackgroundImg(String roomBackgroundImg) {
        this.roomBackgroundImg = roomBackgroundImg;
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

    public Timestamp getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Timestamp openTime) {
        this.openTime = openTime;
    }

    public Map<String, Object> getTicketConf() {
        return ticketConf;
    }

    public void setTicketConf(Map<String, Object> ticketConf) {
        this.ticketConf = ticketConf;
    }

    public Map<String, Object> getTimeConf() {
        return timeConf;
    }

    public void setTimeConf(Map<String, Object> timeConf) {
        this.timeConf = timeConf;
    }

    public Map<String, Object> getPersonalConf() {
        return personalConf;
    }

    public void setPersonalConf(Map<String, Object> personalConf) {
        this.personalConf = personalConf;
    }

    public Map<String, Object> getGameConf() {
        return gameConf;
    }

    public void setGameConf(Map<String, Object> gameConf) {
        this.gameConf = gameConf;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }
}
