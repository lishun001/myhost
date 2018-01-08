package com.eason.api.zb.service.impl;

import com.eason.api.zb.cache.ZbTRoomConf;
import com.eason.api.zb.cache.ZbTRoomPlan;
import com.eason.api.zb.dao.RoomConfDao;
import com.eason.api.zb.dao.RoomPlanDao;
import com.eason.api.zb.dao.ZhuboDao;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.manager.PlatformManager;
import com.eason.api.zb.IPlatformService;
import com.eason.api.zb.po.ZbTZhubo;
import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ZhuboDao zhuboDao;
    @Autowired
    private RoomPlanDao roomPlanDao;


    @RequestMapping(value = "/media/get/{zbId}", method = RequestMethod.GET)
    @Override
    public MediaResponseVo getMedia(@PathVariable(value = "zbId")  Integer zbId, String token) throws ServiceException {
        try {
            ZbTZhubo zbTZhubo=zhuboDao.findOne(zbId);
            if (zbTZhubo==null){
                throw new ServiceException("主播不存在");
            }
            ZbTRoomPlan zbTRoomPlan=roomPlanDao.findByZbId(zbId);
            if (zbTRoomPlan==null){
                throw new ServiceException("主播还未开播");
            }
            ZbTRoomConf zbTRoomConf=roomConfDao.findByZbId(zbId);
            if (zbTRoomConf==null){
                zbTRoomConf=new ZbTRoomConf();
                zbTRoomConf.setZbId(zbId);
                zbTRoomConf.setUserId(zbTRoomPlan.getUserId());
                zbTRoomConf.setRoomId(zbTRoomPlan.getRoomId());
            }

            String media_access_token=platformManager.getMediaAccessToken();
            Map<String,Object> rtmpMap=platformManager.getRtmpUrl(zbId,media_access_token,token);
            if (rtmpMap!=null){
                MediaResponseVo mediaResponseVo=new MediaResponseVo((String) rtmpMap.get("type"), (String) rtmpMap.get("url"), (String) rtmpMap.get("play_url"),media_access_token);
                zbTRoomConf.setMediaInfo(mediaResponseVo);
                this.roomConfDao.save(zbTRoomConf);
                return mediaResponseVo;
            }else {
                throw new ServiceException("无法获取media流媒体地址");
            }
        } catch (Exception e) {
            logger.error("getMedia--Media="+e.getMessage());
            throw new ServiceException(e.getMessage());
        }

    }

    @RequestMapping(value = "/im/get/{zbId}", method = RequestMethod.GET)
    @Override
    public IMResponseVo getIM(@PathVariable(value = "zbId") Integer zbId, String token)  throws ServiceException{
        try {
            ZbTZhubo zbTZhubo=zhuboDao.findOne(zbId);
            if (zbTZhubo==null){
                throw new ServiceException("主播不存在");
            }
            ZbTRoomPlan zbTRoomPlan=roomPlanDao.findByZbId(zbId);
            if (zbTRoomPlan==null){
                throw new ServiceException("主播还未开播");
            }
            ZbTRoomConf zbTRoomConf=roomConfDao.findByZbId(zbId);
            if (zbTRoomConf==null){
                zbTRoomConf=new ZbTRoomConf();
                zbTRoomConf.setZbId(zbId);
                zbTRoomConf.setUserId(zbTRoomPlan.getUserId());
                zbTRoomConf.setRoomId(zbTRoomPlan.getRoomId());
            }

            String im_access_token=platformManager.getImAccessToken();
            Map<String,Object> imMap=platformManager.getImUrl(zbId,im_access_token,token);
            if (imMap!=null){
                IMResponseVo imResponseVo=new IMResponseVo("1", (String) imMap.get("ip"),(Integer) imMap.get("port"), im_access_token);
                zbTRoomConf.setImInfo(imResponseVo);
                this.roomConfDao.save(zbTRoomConf);
                return imResponseVo;
            }else {
                throw new ServiceException("无法获取IM服务器地址");
            }
        } catch (Exception e) {
            logger.error("getIM--IM="+e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
