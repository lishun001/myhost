package com.eason.api.zb.service.impl;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.FGiftService;
import com.eason.api.zb.vo.gift.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("giftServiceImpl")
public class FGiftServiceImpl implements FGiftService {

    @Override
    public List<GiftResponseVo> getList(Integer userId) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public SendGiftResponseVo sendGift(Integer userId, Integer zbId, SendGiftRequestVo vo) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public SendBombScreenResponseVo sendBombScreen(Integer userId, Integer zbId, SendBombScreenRequestVo vo) throws ServiceException {
       throw new ServiceException();
    }
}
