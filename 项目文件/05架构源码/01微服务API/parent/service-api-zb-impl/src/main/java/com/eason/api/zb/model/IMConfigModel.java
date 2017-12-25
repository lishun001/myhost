package com.eason.api.zb.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "platfrom.im")
public class IMConfigModel {
    private Map<String,String > regAccountMap=new HashMap<>();
    private String imUrl;

    public Map<String, String> getRegAccountMap() {
        return regAccountMap;
    }

    public void setRegAccountMap(Map<String, String> regAccountMap) {
        this.regAccountMap = regAccountMap;
    }

    public String getImUrl() {
        return imUrl;
    }

    public void setImUrl(String imUrl) {
        this.imUrl = imUrl;
    }
}