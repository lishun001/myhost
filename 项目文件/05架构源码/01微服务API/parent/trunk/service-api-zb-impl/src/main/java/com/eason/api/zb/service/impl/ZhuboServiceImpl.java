package com.eason.api.zb.service.impl;

import com.eason.api.zb.service.IZhuboService;
import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import com.eason.api.zb.vo.user.UserLevelRankResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import com.eason.api.zb.vo.zhubo.ReadyPlayResponseVo;
import com.eason.api.zb.vo.zhubo.StartPlayRequestVo;
import com.eason.api.zb.vo.zhubo.ZhuboResponseVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZhuboServiceImpl implements IZhuboService {

    @Override
    public List<ZhuboResponseVo> getZhuboList(Integer userId) {
        List<ZhuboResponseVo> list=new ArrayList<>();
        ZhuboResponseVo responseVo = new ZhuboResponseVo();
        responseVo.setZbId(1);
        responseVo.setZbNickname("卤蛋01");
        responseVo.setZbLevel("5Level");
        responseVo.setZbHeadImg("http://zbHeadImg.png");
        responseVo.setZbSignature("卤蛋01直播间");
        responseVo.setZbBackgroundImg("http://ZbBackgroundImg.png");
        responseVo.setIsAttention(0);
        responseVo.setAttentionUserTotal(100);
        responseVo.setDiamondGiftZBTotal(200);
        responseVo.setCostTotal(300);
        list.add(responseVo);

        ZhuboResponseVo responseVo2 = new ZhuboResponseVo();
        responseVo2.setZbId(2);
        responseVo2.setZbNickname("卤蛋02");
        responseVo2.setZbLevel("6Level");
        responseVo2.setZbHeadImg("http://zbHeadImg.png");
        responseVo2.setZbSignature("卤蛋02直播间");
        responseVo2.setZbBackgroundImg("http://ZbBackgroundImg.png");
        responseVo2.setIsAttention(0);
        responseVo2.setAttentionUserTotal(1002);
        responseVo2.setDiamondGiftZBTotal(2002);
        responseVo2.setCostTotal(3002);
        list.add(responseVo2);

        return list;
    }

    @Override
    public ZhuboResponseVo getZbDetail(Integer userId,Integer zbId) {
        ZhuboResponseVo responseVo = new ZhuboResponseVo();
        responseVo.setZbId(1);
        responseVo.setZbNickname("卤蛋");
        responseVo.setZbLevel("5Level");
        responseVo.setZbHeadImg("http://zbHeadImg.png");
        responseVo.setZbSignature("卤蛋的直播间");
        responseVo.setZbBackgroundImg("http://ZbBackgroundImg.png");
        responseVo.setIsAttention(1);
        responseVo.setAttentionUserTotal(100);
        responseVo.setDiamondGiftZBTotal(200);
        responseVo.setCostTotal(300);
        return responseVo;
    }

    @Override
    public List<UserLevelRankResponseVo> getAttentionUserList(Integer zbId) {
        List<UserLevelRankResponseVo> userLevelRankList = new ArrayList<>();
        UserLevelRankResponseVo userLevelRankResponseVo = new UserLevelRankResponseVo();
        userLevelRankResponseVo.setUserId(1);
        userLevelRankResponseVo.setNickName("测试用户01");
        userLevelRankResponseVo.setSex("男");
        userLevelRankResponseVo.setUserHeadImg("http://userHeadImg");
        userLevelRankResponseVo.setUserLevel("3Level");
        userLevelRankList.add(userLevelRankResponseVo);
        return userLevelRankList;
    }

    @Override
    public List<UserResponseVo> getGiftUserList(Integer zbId, String category) {
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
        return diamondRankList;
    }

    @Override
    public ReadyPlayResponseVo getReadyPlayInfo(Integer zbId) {
        ReadyPlayResponseVo responseVo = new ReadyPlayResponseVo();
        responseVo.setRoomId(1);
        responseVo.setRoomBackgroundImg("http://RoomBackgroundImg.png");
        responseVo.setMedia(new MediaResponseVo(1, "http://media", "access_token"));
        responseVo.setIm(new IMResponseVo(1, "http://im", "8080", "access_token"));
        return responseVo;
    }

    @Override
    public String startPlay(Integer zbId, StartPlayRequestVo startPlayRequestVo) {
        return "直播成功";
    }

    @Override
    public String overPlay(Integer zbId) {
        return "直播结束";
    }
}
