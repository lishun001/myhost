package com.eason.api.zb.vo.platform;

import java.io.Serializable;

public class MediaResponseVo implements Serializable {

     private String type;  //视频流类型
	 private String url;    //视频推流地址
     private String play_url;   //视频拉流地址
	 private String  access_token ; //访问token

    public MediaResponseVo() {
    }

    public MediaResponseVo(String type, String url, String play_url,String access_token) {
        this.type = type;
        this.url = url;
        this.play_url=play_url;
        this.access_token = access_token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getPlay_url() {
        return play_url;
    }

    public void setPlay_url(String play_url) {
        this.play_url = play_url;
    }
}
