package com.eason.api.zb.service.impl;

import com.eason.api.zb.cache.ZbTRoomConf;
import com.eason.api.zb.dao.RoomConfDao;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.manager.PlatformManager;
import com.eason.api.zb.IPlatformService;
import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/platform")
public class PlatformServiceImpl implements IPlatformService {
    private static Logger logger = LoggerFactory.getLogger(PlatformServiceImpl.class);

    @Autowired
    private PlatformManager platformManager;
    @Autowired
    private RoomConfDao roomConfDao;

    @RequestMapping(value = "/media/get/{zbId}", method = RequestMethod.GET)
    @Override
    public MediaResponseVo getMedia(@PathVariable(value = "zbId")  Integer zbId, String token) throws ServiceException {
        try {
            ZbTRoomConf zbTRoomConf=this.roomConfDao.findByZbId(zbId);
            if (zbTRoomConf==null){
                throw new ServiceException("当前主播(zbId="+zbId+")可能还未开播");
            }

            String media_access_token=platformManager.getMediaAccessToken();
            Map<String,Object> rtmpMap=platformManager.getRtmpUrl(zbId,media_access_token,token);
            if (rtmpMap!=null){
                MediaResponseVo mediaResponseVo=new MediaResponseVo((String) rtmpMap.get("type"), (String) rtmpMap.get("url"), media_access_token);
                zbTRoomConf.setMediaInfo(mediaResponseVo);
                return mediaResponseVo;
            }else {
                throw new ServiceException("无法获取media流媒体地址");
            }
        } catch (Exception e) {
            logger.error("platform-media-exception",e.getMessage());
            throw new ServiceException(e);
        }

    }

    @RequestMapping(value = "/im/get/{zbId}", method = RequestMethod.GET)
    @Override
    public IMResponseVo getIM(@PathVariable(value = "zbId") Integer zbId, String token)  throws ServiceException{
        try {
            ZbTRoomConf zbTRoomConf=this.roomConfDao.findByZbId(zbId);
            if (zbTRoomConf==null){
                throw new ServiceException("当前主播(zbId="+zbId+")可能还未开播");
            }

            String im_access_token=platformManager.getImAccessToken();
            Map<String,Object> imMap=platformManager.getImUrl(zbId,im_access_token,token);
            if (imMap!=null){
                IMResponseVo imResponseVo=new IMResponseVo("1", (String) imMap.get("ip"),(Integer) imMap.get("port"), im_access_token);
                zbTRoomConf.setImInfo(imResponseVo);
                return imResponseVo;
            }else {
                throw new ServiceException("无法获取IM服务器地址");
            }
        } catch (Exception e) {
            logger.error("platform-im-exception",e.getMessage());
            throw new ServiceException(e);
        }
    }
}
