package com.eason.api.zb;

import com.eason.api.zb.dao.UcUserDao;
import com.eason.api.zb.model.MediaConfigModel;
import com.eason.api.zb.po.ZbUcUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTests {
    @Autowired
    private MediaConfigModel mediaConfigModel;

    @Autowired
    private UcUserDao ucUserDao;


    @Test
    public void testConfig() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(mediaConfigModel.getRecRecords());
        System.out.println(mediaConfigModel.getRtmpUrl());
        mediaConfigModel.getRegAccountMap().remove("url");
        System.out.println("mapProps: " + objectMapper.writeValueAsString(mediaConfigModel.getRegAccountMap()));
    }

    @Test
    public void testZhubo() {
        ZbUcUser user=ucUserDao.findByZbId(19);
        System.out.println(user);
    }

}
