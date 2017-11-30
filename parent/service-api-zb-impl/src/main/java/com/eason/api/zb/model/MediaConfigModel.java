package com.eason.api.zb.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "platfrom.media")
public class MediaConfigModel {
    private Map<String,String > regAccountMap=new HashMap<>();
    private String rtmpUrl;
    private String recRecords;
    private String deleteRecFile;

    public Map<String, String> getRegAccountMap() {
        return regAccountMap;
    }

    public void setRegAccountMap(Map<String, String> regAccountMap) {
        this.regAccountMap = regAccountMap;
    }

    public String getRtmpUrl() {
        return rtmpUrl;
    }

    public void setRtmpUrl(String rtmpUrl) {
        this.rtmpUrl = rtmpUrl;
    }

    public String getRecRecords() {
        return recRecords;
    }

    public void setRecRecords(String recRecords) {
        this.recRecords = recRecords;
    }

    public String getDeleteRecFile() {
        return deleteRecFile;
    }

    public void setDeleteRecFile(String deleteRecFile) {
        this.deleteRecFile = deleteRecFile;
    }
}