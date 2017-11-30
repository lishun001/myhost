package com.eason.api.zb.service.impl;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.FZhuboService;
import com.eason.api.zb.vo.room.RoomStatResponseVo;
import com.eason.api.zb.vo.user.UserLevelRankResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import com.eason.api.zb.vo.zhubo.ReadyPlayResponseVo;
import com.eason.api.zb.vo.zhubo.StartPlayRequestVo;
import com.eason.api.zb.vo.zhubo.StartPlayResponseVo;
import com.eason.api.zb.vo.zhubo.ZhuboResponseVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("zhuboServiceImpl")
public class FZhuboServiceImpl implements FZhuboService {
    @Override
    public List<ZhuboResponseVo> getZhuboList(Integer userId, Integer num) throws ServiceException {
        return null;
    }

    @Override
    public ZhuboResponseVo getZbDetail(Integer userId, Integer zbId) throws ServiceException {
        return null;
    }

    @Override
    public List<UserLevelRankResponseVo> getAttentionUserList(Integer zbId) throws ServiceException {
        return null;
    }

    @Override
    public List<UserResponseVo> getGiftUserList(Integer zbId, String category) throws ServiceException {
        return null;
    }

    @Override
    public ReadyPlayResponseVo getReadyPlayInfo(Integer userId, String token) throws ServiceException {
        return null;
    }

    @Override
    public StartPlayResponseVo startPlay(Integer userId, StartPlayRequestVo startPlayRequestVo) throws ServiceException {
        return null;
    }

    @Override
    public String overPlay(Integer userId, Integer planId) throws ServiceException {
        return null;
    }

    @Override
    public String saveVideo(Integer userId, Integer planId) throws ServiceException {
        return null;
    }

    @Override
    public RoomStatResponseVo getStat(Integer userId, Integer planId) throws ServiceException {
        return null;
    }
}
