package com.eason.api.zb.manager;

import com.eason.api.common.util.HttpClientUtils;
import com.eason.api.zb.dao.RoomDeleteLogDao;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.IMConfigModel;
import com.eason.api.zb.model.MediaConfigModel;
import com.eason.api.zb.po.ZbTRoomMediaDeleteLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class PlatformManager {
    private static Logger logger = LoggerFactory.getLogger(PlatformManager.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private MediaConfigModel mediaConfigModel;
    @Autowired
    private IMConfigModel imConfigModel;
    @Autowired
    private RoomDeleteLogDao roomDeleteLogDao;


    public String getMediaAccessToken() throws ServiceException {
        try {
            String media_access_token = stringRedisTemplate.opsForValue().get("media_access_token");
            ObjectMapper objectMapper = new ObjectMapper();
            if (StringUtils.isNotEmpty(media_access_token)) {
                return media_access_token;
            }
            String url = mediaConfigModel.getRegAccountMap().get("url");
            String param = objectMapper.writeValueAsString(mediaConfigModel.getRegAccountMap());
            String result = HttpClientUtils.invokePostService(url, param, "utf-8", 3000);
            Map<String, String> resultMap = objectMapper.readValue(result, Map.class);
            if ("0".equals(resultMap.get("code"))) {
                stringRedisTemplate.opsForValue().set("media_access_token", resultMap.get("data"));
                return resultMap.get("data");
            }
            return null;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Map<String, Object> getRtmpUrl(Integer zbId, String media_access_token,String token) throws ServiceException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> reqMap = new HashMap<>();
            reqMap.put("UserId", zbId + "");
            reqMap.put("RoomType", "");
            reqMap.put("Location", "CN");
            reqMap.put("key", media_access_token);
            reqMap.put("token",token);
            String rtmpResult = HttpClientUtils.invokeFormPostService(mediaConfigModel.getRtmpUrl(), reqMap, "utf-8", 3000);
            Map<String, Object> rtmpMap = objectMapper.readValue(rtmpResult, Map.class);
            if ("0".equals(rtmpMap.get("code"))) {
                return (Map<String, Object>) rtmpMap.get("data");
            } else {
                stringRedisTemplate.delete("media_access_token");
                this.getRtmpUrl(zbId, this.getMediaAccessToken(),token);
            }
            return null;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Boolean deleteRecFile(Integer zbId, String rtmpurl) throws ServiceException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> reqMap = new HashMap<>();
            reqMap.put("UserId", zbId + "");
            reqMap.put("rtmpurl",rtmpurl);
            String rtmpResult = HttpClientUtils.invokeFormPostService(mediaConfigModel.getDeleteRecFile(), reqMap, "utf-8", 3000);
            Map<String, Object> rtmpMap = objectMapper.readValue(rtmpResult, Map.class);
            if ("0".equals(rtmpMap.get("code"))) {
                return true;
            } else {
                ZbTRoomMediaDeleteLog zbTRoomMediaDeleteLog=new ZbTRoomMediaDeleteLog();
                zbTRoomMediaDeleteLog.setZbId(zbId);
                zbTRoomMediaDeleteLog.setRmtpUrl(rtmpurl);
                zbTRoomMediaDeleteLog.setDeleteApi(mediaConfigModel.getDeleteRecFile());
                zbTRoomMediaDeleteLog.setCreateTime(new Timestamp(System.currentTimeMillis()));
                zbTRoomMediaDeleteLog.setResult(rtmpResult);
                roomDeleteLogDao.save(zbTRoomMediaDeleteLog);
                return false;
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }


    public String getImAccessToken() throws ServiceException {
        try {
            String im_access_token = stringRedisTemplate.opsForValue().get("im_access_token");
            ObjectMapper objectMapper = new ObjectMapper();
            if (StringUtils.isNotEmpty(im_access_token)) {
                return im_access_token;
            }
            String url = imConfigModel.getRegAccountMap().get("url") + "?username=" + imConfigModel.getRegAccountMap().get("username") + "&password=" + imConfigModel.getRegAccountMap().get("password");
            String result = HttpClientUtils.invokeGetService(url, "utf-8", 3000);
            Map<String, Object> resultMap = objectMapper.readValue(result, Map.class);
            if ("0".equals(resultMap.get("status"))) {
                Map<String, Object> dataMap = (Map<String, Object>) resultMap.get("data");
                stringRedisTemplate.opsForValue().set("im_access_token", (String) dataMap.get("imAccessToken"));

                return (String) dataMap.get("imAccessToken");
            }
            return null;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Map<String, Object> getImUrl(Integer zbId, String im_access_token,String token) throws ServiceException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> reqMap = new HashMap<>();
            reqMap.put("zbId", zbId + "");
            reqMap.put("imAccessToken", im_access_token);
            String imResult = HttpClientUtils.invokeFormPostService(imConfigModel.getImUrl(), reqMap, "utf-8", 3000);
            Map<String, Object> imMap = objectMapper.readValue(imResult, Map.class);
            if ("0".equals(imMap.get("status"))) {
                return (Map<String, Object>) imMap.get("data");
            } else {
                stringRedisTemplate.delete("im_access_token");
                this.getImUrl(zbId, this.getImAccessToken(),token);
            }
            return null;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

}
