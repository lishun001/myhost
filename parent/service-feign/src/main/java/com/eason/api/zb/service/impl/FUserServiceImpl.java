package com.eason.api.zb.service.impl;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.FUserService;
import com.eason.api.zb.service.FZhuboService;
import com.eason.api.zb.vo.user.TrySeeResponseVo;
import com.eason.api.zb.vo.user.UserLevelRankResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import com.eason.api.zb.vo.zhubo.ReadyPlayResponseVo;
import com.eason.api.zb.vo.zhubo.StartPlayRequestVo;
import com.eason.api.zb.vo.zhubo.StartPlayResponseVo;
import com.eason.api.zb.vo.zhubo.ZhuboResponseVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userServiceImpl")
public class FUserServiceImpl implements FUserService {
    @Override
    public TrySeeResponseVo isTrySee(Integer userId, Integer roomId, Boolean isTrySee) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public String isAttention(Integer userId, Integer channel, String userIds, Boolean isAttention) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public String isBook(Integer userId, Integer zbId, Boolean isBook) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public String isBlack(Integer userId, Integer channel, String userIds, Boolean isBlack) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public UserResponseVo getDetail(Integer tokenUserId, Integer userId) throws ServiceException {
       throw new ServiceException();
    }
}
