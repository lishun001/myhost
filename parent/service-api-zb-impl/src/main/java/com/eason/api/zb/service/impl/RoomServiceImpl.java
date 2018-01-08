package com.eason.api.zb.service.impl;

import com.eason.api.zb.IRoomService;
import com.eason.api.zb.cache.ZbTRoomConf;
import com.eason.api.zb.cache.ZbTRoomPlan;
import com.eason.api.zb.cache.ZbTUserPersonal;
import com.eason.api.zb.cache.ZbTUserTicket;
import com.eason.api.zb.dao.*;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.FileItemModel;
import com.eason.api.zb.model.TreeSeeConfig;
import com.eason.api.zb.model.ZbConstant;
import com.eason.api.zb.po.*;
import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import com.eason.api.zb.vo.room.IsChargedResponseVo;
import com.eason.api.zb.vo.room.RoomResponseVo;
import com.eason.api.zb.vo.room.RoomSetResponseVo;
import com.eason.api.zb.vo.room.RoomStatResponseVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomServiceImpl implements IRoomService {
    private static Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
    @Autowired
    private ZhuboDao zhuboDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private RoomPlanDao roomPlanDao;
    @Autowired
    private RoomConfDao roomConfDao;
    @Autowired
    private RoomPlanStatDao roomPlanStatDao;
    @Autowired
    private UserTicketDao userTicketDao;
    @Autowired
    private UserPersonalDao userPersonalDao;
    @Autowired
    private UcUserDao ucUserDao;
    @Autowired
    private QconfigDao qconfigDao;
    @Autowired
    private UserAttentionDao userAttentionDao;
    @Autowired
    private RoomAttributeDao roomAttributeDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Value("${zb.file.img.local}")
    private String fileImgLocal;
    @Value("${zb.file.img.remote}")
    private String fileImgRemote;

    /**
     * 房间API - 进入房间（主播进入与用户进入一样）
     * 选择房间类型，点击开始直播：
     * （1）验证参数：是否合法（房间ID，验证场次）
     * （2）验证房间状态：
     * A.未开播（=2）直接查询是否在缓存中，如果不存在，跳过（3-10）
     * B.直播中（=1）直接进入直播间
     * （3）获取直播统计数据缓存: 热门排行，砖石数，礼物数，观看人数等
     * （4）获取当前用户关注信息：排除主播不能关注自己
     * （5）获取进入房间用户：拿用户昵称,用户等级与用户钻石余额（钻石余额从缓存拿，还是从数据库拿）
     * （6）获取该房间用户的钻石排行：只拿在线用户
     * （7）获取该房间用户的等级排行：只拿在线用户
     * （8）TODO 用户进入房间，消息推送：调用IM消息推送接口
     * （9）从缓存里面，获取IM与Media地址：
     * A.如果拿不到地址，IM=null或者Media=null接口正常返回，不中断
     * B.如果拿到地址，不存入缓存，下一次直接重新拿
     * （10）组件返回值：
     *
     * @param userId
     * @param roomId
     * @return
     * @throws ServiceException
     */
    @RequestMapping(value = "/{roomId}/enterRoom", method = RequestMethod.GET)
    @Override
    public RoomResponseVo enterRoom(Integer userId, @PathVariable(value = "roomId") Integer roomId) throws ServiceException {
        try {
            RoomResponseVo responseVo = new RoomResponseVo();
            //（1）验证参数：是否合法（房间ID，验证场次）
//            String userDetail = (String) stringRedisTemplate.opsForHash().get("user_detail_info", userId + "");
//            if (userDetail == null) {
//                throw new ServiceException("房间ID(userId=" + userId + ")缓存中没有该用户信息");
//            }
            ZbUcUser ucUser=this.ucUserDao.findOne(userId);
            //（2）验证房间状态：
            ZbTRoomPlan zbTRoomPlan = roomPlanDao.findByRoomId(roomId);
            if (zbTRoomPlan == null) {
                throw new ServiceException("房间还未开播");
            }
            //（3）获取直播统计数据缓存: 热门排行，砖石数，礼物数，观看人数等
            responseVo.setPlanId(zbTRoomPlan.getPlanId());
            responseVo.setRoomId(zbTRoomPlan.getRoomId());
            responseVo.setRoomTitle(zbTRoomPlan.getRoomTitle());
            responseVo.setRoomType(zbTRoomPlan.getRoomType());
            responseVo.setOnlineUser(zbTRoomPlan.getOnlineUser());
            responseVo.setMachineUser(zbTRoomPlan.getMachineUser());
            responseVo.setDiamondGiftNum(zbTRoomPlan.getGiftCount());
            responseVo.setRoomNo1(zbTRoomPlan.getRoom_No1());
            responseVo.setRoomBackgroundImg(zbTRoomPlan.getRoomBgPic());
            responseVo.setZbId(zbTRoomPlan.getZbId());
            responseVo.setUserId(zbTRoomPlan.getUserId());
            responseVo.setZbNickname(zbTRoomPlan.getZbNickname());
            responseVo.setZbLevel(zbTRoomPlan.getZbLevel());
            responseVo.setZbHeadImg(zbTRoomPlan.getZbHeadImg());
            responseVo.setZbSignature(zbTRoomPlan.getZbSignature());
            ZbTQvodConfigs config=this.qconfigDao.findByConfig("download_url");
            if (config==null){
                responseVo.setDownload_url("无法获取download_url地址");
            }else{
                responseVo.setDownload_url(config.getDescription());
            }

            //（4）获取当前用户关注信息：排除主播不能关注自己
            ZbTUserAttention zbTUserAttention = userAttentionDao.findByAIdAndFId(userId, zbTRoomPlan.getUserId());
            if (zbTUserAttention == null) {
                responseVo.setIsAttention(0);
            } else {
                responseVo.setIsAttention(1);
            }
            //（5）获取进入房间用户：拿用户昵称,用户等级与用户钻石余额（TODO 钻石余额从缓存拿，还是从数据库拿）
//            ObjectMapper objectMapper = new ObjectMapper();
//            Map<String, Object> resultMap = null;
//            try {
//                resultMap = objectMapper.readValue(userDetail, Map.class);
//            } catch (IOException e) {
//                e.getMessage();
//            }
//            Integer level = (Integer) resultMap.get("level");    //用户等级
//            String price = resultMap.get("deposit").toString();
//            Double deposit = Double.valueOf(price);
            responseVo.setUserLevel(ucUser.getLevel()*1);
            responseVo.setDiamondBalance(ucUser.getDeposit());
            //（6）获取该房间用户的钻石排行：只拿在线用户 TODO 钻石排行待接入
//            List<UserResponseVo> diamondRankList = new ArrayList<>();
//            UserResponseVo userResponseVo = new UserResponseVo();
//            userResponseVo.setUserId(1);
//            userResponseVo.setNickName("测试用户01");
//            userResponseVo.setSex(1);
//            userResponseVo.setUserHeadImg("http://userHeadImg");
//            userResponseVo.setUserLevel(3);
//            userResponseVo.setDiamondBalance(200.2);
//            userResponseVo.setGiftRankNo1(2);
//            userResponseVo.setDiamondGiftUserTotal(1333);
//            diamondRankList.add(userResponseVo);
//            responseVo.setDiamondRankList(diamondRankList);

            //（7）获取该房间用户的等级排行：只拿在线用户 TODO 等级排行待接入
//            List<UserLevelRankResponseVo> userLevelRankList = new ArrayList<>();
//            UserLevelRankResponseVo userLevelRankResponseVo = new UserLevelRankResponseVo();
//            userLevelRankResponseVo.setUserId(1);
//            userLevelRankResponseVo.setNickName("测试用户01");
//            userLevelRankResponseVo.setSex(1);
//            userLevelRankResponseVo.setUserHeadImg("http://userHeadImg");
//            userLevelRankResponseVo.setUserLevel(3);
//            userLevelRankList.add(userLevelRankResponseVo);
//            responseVo.setUserLevelRankList(userLevelRankList);

            //（8）TODO 用户进入房间，消息推送：调用IM消息推送接口

            //（9）从缓存里面，获取IM与Media地址：
            ZbTRoomConf zbTRoomConf = this.roomConfDao.findByRoomId(roomId);
            if (zbTRoomConf == null) {
                throw new ServiceException("缓存无法获取当前房间的IM与Media地址");
            }
            MediaResponseVo mediaResponseVo = zbTRoomConf.getMediaInfo();
            IMResponseVo imResponseVo = zbTRoomConf.getImInfo();
            responseVo.setMedia(mediaResponseVo);
            responseVo.setIm(imResponseVo);

            responseVo.setIsCharge(0);  //0=不收费
            //新增收费房间是否收费字段
            Map<String,Object> map=zbTRoomPlan.getRoomSet();
            if (map!=null && !map.isEmpty()){
                Date startTime=(Date) map.get("startTime");
                Date overTime=(Date) map.get("overTime");
                Date now=new Date();
                if (now.compareTo(startTime)>=0 && now.compareTo(overTime)<=0){
                    responseVo.setIsCharge(1);  //1=收费
                }
            }

            return responseVo;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 房间API - 退出房间
     * 主播主动结束退出直播
     * （1）房间id验证，当前房间是否在直播中
     * （2）获取缓存该房间场次的信息，收益做账统计，存储到DB
     * （3）清除该房间场次信息缓存，清楚该场次的门票、预约，清除media+im缓存信息
     * （4）更改房间状态status=1（直播中）—>2（未开播）
     * （5）返回统计信息
     * @param userId
     * @param roomId
     * @return
     */
    @RequestMapping(value = "/{roomId}/backRoom/{userId}", method = RequestMethod.GET)
    @Override
    public RoomStatResponseVo backRoom(@PathVariable(value = "userId")  Integer userId, @PathVariable(value = "roomId") Integer roomId) throws ServiceException {
        try {
            RoomStatResponseVo roomStatResponseVo=new RoomStatResponseVo();
            //（1）房间id验证，当前房间是否在直播中
            ZbTRoomPlan zbTRoomPlan = this.roomPlanDao.findByRoomId(roomId);
            if (zbTRoomPlan == null) {
                throw new ServiceException("当前房间还未开播");
            }
            if (!userId.equals(zbTRoomPlan.getUserId())) {
                throw new ServiceException("您不是当前房间的主播");
            }
            //（2）获取缓存该房间场次的信息，收益做账统计，存储到DB
            ZbTRoomPlanStat zbTRoomPlanStat = new ZbTRoomPlanStat();
            zbTRoomPlanStat.setPlanId(zbTRoomPlan.getPlanId());
            zbTRoomPlanStat.setRoomId(zbTRoomPlan.getRoomId());
            zbTRoomPlanStat.setZbId(zbTRoomPlan.getZbId());
            zbTRoomPlanStat.setRoomTitle(zbTRoomPlan.getRoomTitle());
            zbTRoomPlanStat.setRoomType(zbTRoomPlan.getRoomType());
            Map<String, Object> map=null;
            if (zbTRoomPlan.getRoomSet() != null) {
                map=zbTRoomPlan.getRoomSet();
            }else{
                map=new HashMap<>();
            }
            map.put("onlineUser",zbTRoomPlan.getOnlineUser());
            map.put("machineUser",zbTRoomPlan.getMachineUser());
            map.put("watchCount",zbTRoomPlan.getWatchCount());
            ObjectMapper objectMapper = new ObjectMapper();
            String conf=objectMapper.writeValueAsString(map);
            zbTRoomPlanStat.setZbRoomConf(conf);
            zbTRoomPlanStat.setOpenTime(new Timestamp(zbTRoomPlan.getOpenTime().getTime()));
            zbTRoomPlanStat.setCloseTime(new Timestamp(System.currentTimeMillis()));
            //TODO 与LEO讨论没有异常状态2017-11-23
            zbTRoomPlanStat.setIsVideo(ZbConstant.Room.video.disable);
            zbTRoomPlanStat.setRecordStatus(ZbConstant.Room.close.normal);
            long time=new Date().getTime()-zbTRoomPlan.getOpenTime().getTime();
            zbTRoomPlanStat.setActivityTime(time);
            zbTRoomPlanStat.setIncomeAmount(zbTRoomPlan.getIncomeAmount());
            zbTRoomPlanStat.setViewCount(zbTRoomPlan.getViewCount());
            zbTRoomPlanStat.setGiftCount(zbTRoomPlan.getGiftCount());
            zbTRoomPlanStat.setBombScreen_count(zbTRoomPlan.getBombScreen_count());
            zbTRoomPlanStat.setCreate_Time(new Timestamp(System.currentTimeMillis()));
            this.roomPlanStatDao.save(zbTRoomPlanStat);
            //（3.1）清除该房间场次信息缓存，清楚该场次的门票、预约
            if (ZbConstant.Room.Type.personal.name().equals(zbTRoomPlan.getRoomType())) {
                List<ZbTUserPersonal> zbTUserPersonal = userPersonalDao.findByZbId(zbTRoomPlan.getZbId());
                zbTUserPersonal.forEach(zbTUserPersonal1 -> {
                    this.userPersonalDao.delete(zbTUserPersonal1);
                });
            }
            this.roomPlanDao.delete(zbTRoomPlan);
            //（3.2）清除media+im缓存信息
            ZbTRoomConf zbTRoomConf=this.roomConfDao.findByRoomId(roomId);
            if (zbTRoomConf!=null){
                this.roomConfDao.delete(zbTRoomConf);
            }

            //（4）更改房间状态status=1（直播中）—>2（未开播）
            this.roomDao.updateRoomStatusAndAndRoomTitle(zbTRoomPlan.getRoomId(), ZbConstant.Room.status.room_closed, zbTRoomPlan.getRoomTitle());
            //（5）返回统计信息
            roomStatResponseVo.setPlanId(zbTRoomPlanStat.getPlanId());
            roomStatResponseVo.setStatId(zbTRoomPlanStat.getRecordId());
            roomStatResponseVo.setActivityTime(zbTRoomPlanStat.getActivityTime());
            roomStatResponseVo.setBombScreenCount(zbTRoomPlan.getBombScreen_count());
            roomStatResponseVo.setGiftCount(zbTRoomPlan.getGiftCount());
            roomStatResponseVo.setOnlineUser(zbTRoomPlan.getOnlineUser());
            roomStatResponseVo.setMachineUser(zbTRoomPlan.getMachineUser());
            roomStatResponseVo.setWatchCount(zbTRoomPlan.getWatchCount());
            roomStatResponseVo.setIncomeAmount(zbTRoomPlan.getIncomeAmount());
            roomStatResponseVo.setViewCount(zbTRoomPlan.getViewCount());
            Integer attentionUser=this.userAttentionDao.findATotalByFId(zbTRoomPlan.getUserId());
            roomStatResponseVo.setAttentionCount(attentionUser);
            return roomStatResponseVo;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 2017/12/2 讨论，新增收费房间是否收费字段
     * 2017/1/6讨论，付费房间：提示修改（增加已播时长&剩余时长）
     * @param userId
     * @param roomId
     * @return
     * @throws ServiceException
     */
    @RequestMapping(value = "/{roomId}/isCharged", method = RequestMethod.GET)
    @Override
    public IsChargedResponseVo isCharged(Integer userId, @PathVariable(value = "roomId") Integer roomId) throws ServiceException {
        try {
            ZbTRoomPlan zbTRoomPlan = roomPlanDao.findByRoomId(roomId);
            if (zbTRoomPlan == null) {
                throw new ServiceException("抱歉，房间还未开播");
            }
            IsChargedResponseVo responseVo = new IsChargedResponseVo();
            responseVo.setRoomId(zbTRoomPlan.getRoomId());
            responseVo.setRoomType(zbTRoomPlan.getRoomType());
            responseVo.setZbId(zbTRoomPlan.getZbId());

            BoundHashOperations<String, String, String> ops = stringRedisTemplate.boundHashOps("user_isTrySee");
            String userTrySee = ops.get(userId + "");
            responseVo.setUserId(userId);
            if (StringUtils.isEmpty(userTrySee)) {
                ZbUcUser zbUcUser=ucUserDao.findOne(userId);
                responseVo.setIsTrySee(0);
                if (zbUcUser.getVip()==0){
//                    throw new ServiceException("您不是VIP用户");
                    responseVo.setIsTrySee(1);
                }
                if (new Date().compareTo(zbUcUser.getExVipTime())>=0){
//                    throw new ServiceException("您的试看时间过期");
                    responseVo.setIsTrySee(1);
                }
                //TODO 会员试看时间，随等级的变化而变化
                responseVo.setAllowTime(TreeSeeConfig.getTreeTime(zbUcUser.getVip()));
            } else {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> trySeeMap = objectMapper.readValue(userTrySee, Map.class);
                responseVo.setIsTrySee(1);
                responseVo.setAllowTime((Integer) trySeeMap.get("allowTime"));
            }

            if (ZbConstant.Room.Type.ticket.name().equals(zbTRoomPlan.getRoomType())) {
                ZbTUserTicket zbTUserTicket = userTicketDao.findByPlanIdAndUserId(zbTRoomPlan.getPlanId(), userId);
                if (zbTUserTicket == null) {
                    responseVo.setTicketStatus(0);
                } else {
                    responseVo.setTicketStatus(1);
                }
                responseVo.setSelectPrice((Integer) zbTRoomPlan.getRoomSet().get("selectPrice"));

            }

            if (ZbConstant.Room.Type.time.name().equals(zbTRoomPlan.getRoomType())) {
                responseVo.setSelectPrice((Integer) zbTRoomPlan.getRoomSet().get("selectPrice"));
                responseVo.setTimeInterval((Integer) zbTRoomPlan.getRoomSet().get("timeInterval"));
            }

            if (ZbConstant.Room.Type.personal.name().equals(zbTRoomPlan.getRoomType())) {
                ZbTUserPersonal zbTUserPersonal = userPersonalDao.findByUserIdAndZbId(userId, zbTRoomPlan.getZbId());
                if (zbTUserPersonal == null) {
                    responseVo.setPersonalStatus(0);
                } else {
                    responseVo.setPersonalStatus(1);
                }
                responseVo.setIsTrySee(null);
                responseVo.setAllowTime(null);
            }
            responseVo.setIsCharge(0);  //0=不收费
            //新增收费房间是否收费字段
            Map<String,Object> map=zbTRoomPlan.getRoomSet();
            if (map!=null && !map.isEmpty()){
                Date startTime=(Date) map.get("startTime");
                Date overTime=(Date) map.get("overTime");
                Date now=new Date();
                Integer selectActivityTime = (Integer) map.get("selectActivityTime");
                if (now.compareTo(startTime)>=0 && now.compareTo(overTime)<=0){
                    responseVo.setIsCharge(1);  //1=收费
                    long t = overTime.getTime() - now.getTime();
                    long remainTime = 0;
                    long activityTime = selectActivityTime* 60000;
                    if (t > 0) {
                        remainTime = t;  //1分钟=60000
                        if (t > activityTime) {
                            remainTime = activityTime;
                        }
                    }
                    responseVo.setUsedTime(activityTime-remainTime);
                    responseVo.setRemainTime(remainTime);
                }
            }
            return responseVo;
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @RequestMapping(value = "/{roomType}/getRoomSet", method = RequestMethod.GET)
    @Override
    public RoomSetResponseVo getRoomSet(@PathVariable(value = "roomType") String roomType) {
        RoomSetResponseVo responseVo = new RoomSetResponseVo();
        responseVo.setRoomType(roomType);
//        if ("ticket".equals(roomType)) {
//            Map<String, Object> target = new HashMap<>();
//            target.put("startTime", new Timestamp(System.currentTimeMillis()));
//            target.put("activityTime", "30,60,90,120");
//            target.put("price", "1,2,5,10");
//            return (RoomSetResponseVo) DynaBeanUtil.getTarget(responseVo, target);
//        }
//        if ("time".equals(roomType)) {
//            Map<String, Object> target = new HashMap<>();
//            target.put("startTime", new Timestamp(System.currentTimeMillis()));
//            target.put("activityTime", "20,40,50,100");
//            target.put("price", "2,3,5,7");
//            return (RoomSetResponseVo) DynaBeanUtil.getTarget(responseVo, target);
//        }
//        if ("personal".equals(roomType)) {
//            Map<String, Object> target = new HashMap<>();
//            target.put("startTime", new Timestamp(System.currentTimeMillis()));
//            target.put("activityTime", "30,60,90,120");
//            target.put("userId", 1);
//            return (RoomSetResponseVo) DynaBeanUtil.getTarget(responseVo, target);
//        }
        return responseVo;
    }

    /**
     * 图片文件上传：
     * （1）验证房间是否属于当前用户
     * （2）房间背景图更新
     * （3）场次背景图，如果有更新
     *
     * @param roomId
     * @param fileImg
     * @return
     * @throws ServiceException
     */
    @RequestMapping(value = "/{roomId}/setRoomBackgroundImg", method = RequestMethod.POST)
    @Override
    public String setRoomBackgroundImg(Integer userId, @PathVariable(value = "roomId") Integer roomId, @RequestBody FileItemModel fileImg) throws ServiceException {
        try {
            ZbTZhubo zbTZhubo = this.zhuboDao.findByUserId(userId);
            if (zbTZhubo == null) {
                throw new ServiceException("您不是主播");
            }
            ZbTRoom zbTRoom = this.roomDao.findByZbId(zbTZhubo.getZbId());
            if (zbTRoom == null) {
                throw new ServiceException("您没有创建直播房间");
            }
            if (zbTRoom.getRoomId() != roomId) {
                throw new ServiceException("您的直播间不是这个房间");
            }
            FileCopyUtils.copy(fileImg.getContent(), new File(fileImgLocal + fileImg.getFileName()));
            String pic = fileImgRemote + fileImg.getFileName();
            this.roomDao.updateRoomBgPic(roomId, pic);
            ZbTRoomPlan zbTRoomPlan = this.roomPlanDao.findByRoomId(roomId);
            if (zbTRoomPlan != null) {
                zbTRoomPlan.setRoomBgPic(pic);
                this.roomPlanDao.save(zbTRoomPlan);
            }
            return fileImgRemote + fileImg.getFileName();
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * （1）优先先从ROOM表里面拿
     * （2）没有从房间属性表里面拿
     * @param userId
     * @return
     * @throws ServiceException
     */
    @RequestMapping(value = "/getRoomWaterMarkImg", method = RequestMethod.GET)
    @Override
    public String getRoomWaterMarkImg(Integer userId) throws ServiceException {
        try {
            ZbTRoom zbTRoom=this.roomDao.findByZbUserId(userId);
            if(StringUtils.isNotEmpty(zbTRoom.getRoomWatermark()) && !"".equals(zbTRoom.getRoomWatermark())){
                return zbTRoom.getRoomWatermark();
            }
            ZbTRoomAttribute zbTRoomAttribute=this.roomAttributeDao.findByAttributeKey("room_watermark");
            return zbTRoomAttribute.getAttributeValue();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
