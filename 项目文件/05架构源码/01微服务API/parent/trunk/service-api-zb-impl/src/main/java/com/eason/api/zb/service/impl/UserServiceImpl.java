package com.eason.api.zb.service.impl;

import com.eason.api.zb.service.IUserService;
import com.eason.api.zb.vo.user.TrySeeResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public TrySeeResponseVo isTrySee(Integer userId, Integer roomId, Boolean isTrySee) {
        System.out.println("----isTrySee=" + isTrySee);
        TrySeeResponseVo responseVo = new TrySeeResponseVo();
        responseVo.setUserId(1);
        responseVo.setIsTrySee(1);
        responseVo.setAllowTime("30");
        responseVo.setUserLevel("7Level");
        responseVo.setOverTime(new Timestamp(System.currentTimeMillis()));
        return responseVo;
    }

    @Override
    public String isAttention(Integer userId, Integer zbId, Boolean isAttention) {

        return "关注成功";
    }

    @Override
    public String isBook(Integer userId, Integer zbId, Boolean isBook) {
        return "预约成功";
    }

    @Override
    public UserResponseVo getDetail(Integer userId) {
        UserResponseVo userResponseVo = new UserResponseVo();
        userResponseVo.setUserId(1);
        userResponseVo.setNickName("测试用户01");
        userResponseVo.setSex("男");
        userResponseVo.setUserHeadImg("http://userHeadImg");
        userResponseVo.setUserLevel("3Level");
        userResponseVo.setDiamondBalance(200.2);
        userResponseVo.setGiftRankNo1(2);
        userResponseVo.setDiamondGiftUserTotal(1333);
        return userResponseVo;
    }
}
