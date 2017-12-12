package com.eason.api.zb.service.impl;

import com.eason.api.common.util.DynaBeanUtil;
import com.eason.api.zb.model.FileItem;
import com.eason.api.zb.service.IRoomService;
import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import com.eason.api.zb.vo.room.IsChargedResponseVo;
import com.eason.api.zb.vo.room.RoomResponseVo;
import com.eason.api.zb.vo.room.RoomSetResponseVo;
import com.eason.api.zb.vo.user.UserLevelRankResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements IRoomService {
    @Override
    public RoomResponseVo enterRoom(Integer userId, Integer roomId) {
        RoomResponseVo responseVo = new RoomResponseVo();
        responseVo.setRoomId(1);
        responseVo.setRoomTitle("卤蛋的直播间");
        responseVo.setRoomType("ticket");
        responseVo.setOnlineUser(2980);
        responseVo.setMachineUser(200);
        responseVo.setDiamondGiftNum(1999);
        responseVo.setRoomNo1(1);
        responseVo.setRoomBackgroundImg("http://roomBackgroudImg.png");
        responseVo.setZbId(1);
        responseVo.setZbNickname("一颗卤蛋");
        responseVo.setZbLevel("10VIP");
        responseVo.setZbHeadImg("http://zbHeadImg.png");
        responseVo.setZbSignature("主播个性签名");
        responseVo.setIsAttention(1);
        responseVo.setUserLevel("5level");
        responseVo.setDiamondBalance(3000.0);

        List<UserResponseVo> diamondRankList = new ArrayList<>();
        UserResponseVo userResponseVo = new UserResponseVo();
        userResponseVo.setUserId(1);
        userResponseVo.setNickName("测试用户01");
        userResponseVo.setSex("男");
        userResponseVo.setUserHeadImg("http://userHeadImg");
        userResponseVo.setUserLevel("3Level");
        userResponseVo.setDiamondBalance(200.2);
        userResponseVo.setGiftRankNo1(2);
        userResponseVo.setDiamondGiftUserTotal(1333);
        diamondRankList.add(userResponseVo);
        responseVo.setDiamondRankList(diamondRankList);

        List<UserLevelRankResponseVo> userLevelRankList = new ArrayList<>();
        UserLevelRankResponseVo userLevelRankResponseVo = new UserLevelRankResponseVo();
        userLevelRankResponseVo.setUserId(1);
        userLevelRankResponseVo.setNickName("测试用户01");
        userLevelRankResponseVo.setSex("男");
        userLevelRankResponseVo.setUserHeadImg("http://userHeadImg");
        userLevelRankResponseVo.setUserLevel("3Level");
        userLevelRankList.add(userLevelRankResponseVo);
        responseVo.setUserLevelRankList(userLevelRankList);

        responseVo.setMedia(new MediaResponseVo(1, "http://media", "access_token"));
        responseVo.setIm(new IMResponseVo(1, "http://im", "8080", "access_token"));
        return responseVo;
    }

    @Override
    public String backRoom(Integer userId, Integer roomId) {
        return "退房成功";
    }

    @Override
    public IsChargedResponseVo isCharged(Integer userId, Integer roomId) {
        IsChargedResponseVo responseVo = new IsChargedResponseVo();
        responseVo.setRoomId(1);
        responseVo.setRoomType("ticket");
        responseVo.setZbId(2);

        Map<String, Object> ticket = new HashMap<>();
        ticket.put("ticketStatus", 1);
        ticket.put("price", 124);
        return (IsChargedResponseVo) DynaBeanUtil.getTarget(responseVo, ticket);
    }

    @Override
    public RoomSetResponseVo getRoomSet(String roomType) {
        RoomSetResponseVo responseVo = new RoomSetResponseVo();
        responseVo.setRoomType(roomType);
        if ("ticket".equals(roomType)) {
            Map<String, Object> target = new HashMap<>();
            target.put("startTime", new Timestamp(System.currentTimeMillis()));
            target.put("activityTime", "[30,60,90,120]");
            target.put("price", "[1,2,5,10]");
            return (RoomSetResponseVo) DynaBeanUtil.getTarget(responseVo, target);
        }
        if ("time".equals(roomType)) {
            Map<String, Object> target = new HashMap<>();
            target.put("startTime", new Timestamp(System.currentTimeMillis()));
            target.put("activityTime", "[20,40,50,100]");
            target.put("price", "[2,3,5,7]");
            return (RoomSetResponseVo) DynaBeanUtil.getTarget(responseVo, target);
        }
        if ("personal".equals(roomType)) {
            Map<String, Object> target = new HashMap<>();
            target.put("startTime", new Timestamp(System.currentTimeMillis()));
            target.put("activityTime", "[30,60,90,120]");
            target.put("userIds", "[user001,user002,user003]");
            return (RoomSetResponseVo) DynaBeanUtil.getTarget(responseVo, target);
        }
        return responseVo;
    }

    @Override
    public String setRoomBackgroundImg(Integer roomId, FileItem fileImg) {
        return "http://success-address";
    }
}
