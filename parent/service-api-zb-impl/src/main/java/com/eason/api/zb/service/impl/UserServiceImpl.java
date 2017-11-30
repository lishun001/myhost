package com.eason.api.zb.service.impl;

import com.eason.api.zb.IUserService;
import com.eason.api.zb.cache.ZbTRoomPlan;
import com.eason.api.zb.cache.ZbTUserPersonal;
import com.eason.api.zb.dao.RoomPlanDao;
import com.eason.api.zb.dao.UserAttentionDao;
import com.eason.api.zb.dao.UserPersonalDao;
import com.eason.api.zb.dao.ZhuboDao;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.po.ZbTUserAttention;
import com.eason.api.zb.po.ZbTZhubo;
import com.eason.api.zb.vo.user.TrySeeResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserAttentionDao userAttentionDao;
    @Autowired
    private ZhuboDao zhuboDao;
    @Autowired
    private RoomPlanDao roomPlanDao;
    @Autowired
    private UserPersonalDao userPersonalDao;
    @Autowired
    private RedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate stringRedisTemplate10;

    /**
     * 用户API - 开始/结束试看
     * （1）以user_isTrySee为key=map，查询是否试看记录
     * （2）开始试看：
     * A. 没有试看，组织试看信息返回，不存储到缓存
     * B.  有试看，从缓存查询到试看记录，返回给客户端
     * （3）结束试看：
     * A. 查询缓存，没有试看记录，组织试看信息存储缓存，标记已试看
     * B. 查询缓存，有试看记录，组织试看信息，标记已试看
     *
     * @param userId
     * @param roomId
     * @param isTrySee
     * @return
     */
    @RequestMapping(value = "/isTrySee/{roomId}/{isTrySee}", method = RequestMethod.GET)
    @Override
    public TrySeeResponseVo isTrySee(Integer userId, @PathVariable(value = "roomId") Integer roomId, @PathVariable(value = "isTrySee") Boolean isTrySee) throws ServiceException {
        try {
            ZbTRoomPlan zbTRoomPlan = this.roomPlanDao.findByRoomId(roomId);
            if (zbTRoomPlan == null) {
                throw new ServiceException("当前房间(roomId=" + roomId + ")还未开播");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String trySeeUser = (String) stringRedisTemplate.boundHashOps("user_isTrySee").get(String.valueOf(userId));
            if (isTrySee) {
                if (trySeeUser == null) {
                    //2A. 没有试看，组织试看信息返回，不存储到缓存
                    TrySeeResponseVo responseVo = new TrySeeResponseVo();
                    responseVo.setUserId(userId);
                    responseVo.setIsTrySee(0);  //0=未试看，1=已试看
                    responseVo.setAllowTime(30);      //TODO 试看等级需要Qvod等级规则获取
                    responseVo.setRoomId(roomId);
                    responseVo.setTrySeeTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                    String userDetail = (String) stringRedisTemplate.opsForHash().get("user_detail_info", userId + "");
                    Map<String, Object> resultMap = null;
                    try {
                        resultMap = objectMapper.readValue(userDetail, Map.class);
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    Integer level = (Integer) resultMap.get("level");
                    responseVo.setUserLevel(level);
                    return responseVo;
                } else {
                    //2B.  有试看，从缓存查询到试看记录，返回给客户端
                    Map<String, Object> resultMap = null;
                    try {
                        resultMap = objectMapper.readValue(trySeeUser, Map.class);
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    TrySeeResponseVo responseVo = new TrySeeResponseVo();
                    responseVo.setUserId(userId);
                    responseVo.setIsTrySee(1);
                    responseVo.setRoomId((Integer) resultMap.get("roomId"));
                    responseVo.setAllowTime((Integer) resultMap.get("allowTime"));
                    responseVo.setUserLevel((Integer) resultMap.get("userLevel"));
                    responseVo.setTrySeeTime((String) resultMap.get("trySeeTime"));
                    return responseVo;
                }
            } else {
                //3.A. 查询缓存，没有试看记录，组织试看信息存储缓存，标记已试看
                if (trySeeUser == null) {
                    TrySeeResponseVo responseVo = new TrySeeResponseVo();
                    responseVo.setUserId(userId);
                    responseVo.setIsTrySee(1);  //0=未试看，1=已试看
                    responseVo.setAllowTime(30);      //TODO 试看等级需要Qvod等级规则获取
                    responseVo.setRoomId(roomId);
                    responseVo.setTrySeeTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                    String userDetail = (String) stringRedisTemplate.opsForHash().get("user_detail_info", userId + "");
                    Map<String, Object> resultMap = null;
                    try {
                        resultMap = objectMapper.readValue(userDetail, Map.class);
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    Integer level = (Integer) resultMap.get("level");
                    responseVo.setUserLevel(level);

                    stringRedisTemplate.opsForHash().put("user_isTrySee", String.valueOf(userId), objectMapper.writeValueAsString(responseVo));
                    return responseVo;
                } else {
                    //3.B. 查询缓存，有试看记录，组织试看信息，标记已试看
                    Map<String, Object> resultMap = null;
                    try {
                        resultMap = objectMapper.readValue(trySeeUser, Map.class);
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    TrySeeResponseVo responseVo = new TrySeeResponseVo();
                    responseVo.setUserId(userId);
                    responseVo.setIsTrySee(1);
                    responseVo.setRoomId((Integer) resultMap.get("roomId"));
                    responseVo.setAllowTime((Integer) resultMap.get("allowTime"));
                    responseVo.setUserLevel((Integer) resultMap.get("userLevel"));
                    responseVo.setTrySeeTime((String) resultMap.get("trySeeTime"));
                    return responseVo;
                }
            }
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    /**
     * 用户API - 关注/取消关注
     * （1）用户关注主播，关注与未关注来回切换
     * （2）isAttention=true,false
     * （3）channel= (1=房间、2=个人中心、3=私信、4=收藏推荐)
     * （4）支持一键关注格式：zbIds=1,2,3 用英文逗号,隔开
     * （5）以user_attention_{userId} 为key=list，存储到redis缓存
     *
     * @param userId
     * @param channel
     * @param userIds
     * @param isAttention
     * @return
     * @throws ServiceException
     */
    @RequestMapping(value = "/{channel}/isAttention/{userIds}/{isAttention}", method = RequestMethod.GET)
    @Override
    public String isAttention(Integer userId, @PathVariable(value = "channel") Integer channel, @PathVariable(value = "userIds") String userIds, @PathVariable(value = "isAttention") Boolean isAttention) throws ServiceException {
        try {
            if (channel != 1 && channel != 2 && channel != 3 && channel != 4) {
                throw new ServiceException("channel渠道号错误（1=房间、2=个人中心、3=私信、4=收藏推荐）");
            }
            String[] idArrays = userIds.split(",");
            List<Integer> userIdList = new ArrayList<>();
            for (String id : idArrays) {
                Integer ud = null;
                try {
                    ud = Integer.parseInt(id);
                    int count = this.userAttentionDao.findUserById(ud);
                    if (count == 0) {
                        throw new ServiceException("用户id(userId=" + ud + ")不存在");
                    } else {
                        userIdList.add(ud);
                    }
                } catch (Exception e) {
                    throw new ServiceException("用户id(userId=" + id + ")不存在");
                }
            }

            if (isAttention) {
                userIdList.forEach(ud -> {
                    ZbTUserAttention zbTUserAttention = userAttentionDao.findByAIdAndFId(userId, ud);
                    if (zbTUserAttention == null) {
                        ZbTUserAttention zbTUserAttention2 = new ZbTUserAttention();
                        zbTUserAttention2.setaId(userId);
                        zbTUserAttention2.setfId(ud);
                        zbTUserAttention2.setAttentionTime(new Timestamp(System.currentTimeMillis()));
                        zbTUserAttention2.setChannel(channel);
                        userAttentionDao.saveAndFlush(zbTUserAttention2);

                        //（5）以user_attention_{userId} 为key=list，存储到redis缓存
                        String key = "user_attention_" + userId;
                        stringRedisTemplate10.opsForSet().add(key, String.valueOf(ud));
                    }
                });
                return "用户userIds=" + userIds + "关注成功";
            } else {
                userIdList.forEach(ud -> {
                    userAttentionDao.deleteByAIdAndFId(userId, ud);
                    String key = "user_attention_" + userId;
                    stringRedisTemplate10.opsForSet().remove(key, String.valueOf(ud));
                });
                return "用户userIds=" + userIds + "取消成功";
            }

        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 用户API - 预约/取消预约
     * （1）主播参数验证
     * （2）isBook=true，预约，插入缓存记录
     * （3）isBook=false，取消预约，删除缓存记录
     *
     * @param userId
     * @param zbId
     * @param isBook
     * @return
     */
    @RequestMapping(value = "/isBook/{zbId}/{isBook}", method = RequestMethod.GET)
    @Override
    public String isBook(Integer userId,  @PathVariable(value = "zbId") Integer zbId, @PathVariable(value = "isBook") Boolean isBook) throws ServiceException {
        //（1）主播参数验证
        ZbTZhubo zbTZhubo = this.zhuboDao.getOne(zbId);
        if (zbTZhubo == null) {
            throw new ServiceException("主播id(zbId=" + zbId + ")不存在");
        }
        if (zbTZhubo.getUserId().equals(userId)) {
            throw new ServiceException("主播id(zbId=" + zbId + ")不能自己预约自己");
        }
        //（2）isBook=true，预约，插入缓存记录
        if (isBook) {
            ZbTUserPersonal zbTUserPersonal = this.userPersonalDao.findByUserIdAndZbId(userId, zbId);
            if (zbTUserPersonal == null) {
                zbTUserPersonal = new ZbTUserPersonal();
                zbTUserPersonal.setUserId(userId);
                zbTUserPersonal.setZbId(zbId);
                zbTUserPersonal.setBookTime(new Date());
                this.userPersonalDao.save(zbTUserPersonal);
                return "userId=" + userId + "预约zbId=" + zbId + "成功";
            } else {
                return "userId=" + userId + "预约zbId=" + zbId + "已经预约过了";
            }


        } else {
            ZbTUserPersonal zbTUserPersonal = this.userPersonalDao.findByUserIdAndZbId(userId, zbId);
            if (zbTUserPersonal != null) {
                this.userPersonalDao.delete(zbTUserPersonal);
                return "userId=" + userId + "取消预约zbId=" + zbId + "成功";
            } else {
                return "userId=" + userId + "预约zbId=" + zbId + "并未预约";
            }
        }

    }

    @RequestMapping(value = "/user/getDetail", method = RequestMethod.GET)
    @Override
    public UserResponseVo getDetail(Integer userId) {
        UserResponseVo userResponseVo = new UserResponseVo();
        userResponseVo.setUserId(1);
        userResponseVo.setNickName("测试用户01");
        userResponseVo.setSex(1);
        userResponseVo.setUserHeadImg("http://userHeadImg");
        userResponseVo.setUserLevel(3);
        userResponseVo.setDiamondBalance(200.2);
        userResponseVo.setGiftRankNo1(2);
        userResponseVo.setDiamondGiftUserTotal(1333);
        return userResponseVo;
    }
}
