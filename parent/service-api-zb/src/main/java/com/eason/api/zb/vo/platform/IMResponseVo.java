package com.eason.api.zb.vo.platform;

import java.io.Serializable;

public class IMResponseVo implements Serializable {

    private String type;   // 即时通讯类型
    private String url;        // 即时通讯地址
    private Integer port;     //即时通讯端口
    private String access_token;      //访问token

    public IMResponseVo() {
    }

    public IMResponseVo(String type, String url, Integer port, String access_token) {
        this.type = type;
        this.url = url;
        this.port = port;
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

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
