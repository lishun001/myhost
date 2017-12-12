package com.eason.api.zb.vo.zhubo;

import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;

import java.io.Serializable;

public class ReadyPlayResponseVo implements Serializable {

    private Integer roomId;     //房间id
    private String roomBackgroundImg;      //房间背景图

    private MediaResponseVo media;
    private IMResponseVo im;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
}
