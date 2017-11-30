package com.eason.api.zb.cache;

import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;

@Document(collection = "zb_t_room_conf")
public class ZbTRoomConf implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private BigInteger id;
    @Indexed(unique = true)
    private Integer zbId;                   //主播ID
    @Indexed(unique = true)
    private Integer roomId;             //房间ID
    @Indexed(unique = true)
    private Integer userId;                //主播对应的用户ID

    private MediaResponseVo mediaInfo;
    private IMResponseVo imInfo;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getZbId() {
        return zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public MediaResponseVo getMediaInfo() {
        return mediaInfo;
    }

    public void setMediaInfo(MediaResponseVo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public IMResponseVo getImInfo() {
        return imInfo;
    }

    public void setImInfo(IMResponseVo imInfo) {
        this.imInfo = imInfo;
    }
}