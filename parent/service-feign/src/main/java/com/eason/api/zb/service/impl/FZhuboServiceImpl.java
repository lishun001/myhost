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
       throw new ServiceException();
    }

    @Override
    public ZhuboResponseVo getZbDetail(Integer userId, Integer zbId) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public List<UserLevelRankResponseVo> getAttentionUserList(Integer zbId) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public List<UserResponseVo> getGiftUserList(Integer zbId, String category) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public ReadyPlayResponseVo getReadyPlayInfo(Integer userId, String token) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public StartPlayResponseVo startPlay(Integer userId, StartPlayRequestVo startPlayRequestVo) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public String overPlay(Integer userId, Integer planId) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public String saveVideo(Integer userId, Integer planId) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public RoomStatResponseVo getStat(Integer userId, Integer planId) throws ServiceException {
        throw new ServiceException();
    }

    @Override
    public String apply(Integer userId) throws ServiceException {
       throw new ServiceException();
    }
}
