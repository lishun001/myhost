package com.eason.api.zb.vo.platform;

import java.io.Serializable;

public class IMResponseVo implements Serializable {

    private Integer type;   // 即时通讯类型
	private String  url;        // 即时通讯地址
	private String  port;     //即时通讯端口
	private String  access_token;      //访问token

    public IMResponseVo() {
    }

    public IMResponseVo(Integer type, String url, String port, String access_token) {
        this.type = type;
        this.url = url;
        this.port = port;
        this.access_token = access_token;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
