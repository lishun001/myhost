package com.eason.api.zb;

import com.eason.api.zb.model.MediaConfigModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTests {
    @Autowired
    private MediaConfigModel mediaConfigModel;

    @Test
    public void testConfig() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(mediaConfigModel.getRecRecords());
        System.out.println(mediaConfigModel.getRtmpUrl());
        mediaConfigModel.getRegAccountMap().remove("url");
        System.out.println("mapProps: " + objectMapper.writeValueAsString(mediaConfigModel.getRegAccountMap()));
    }

}
