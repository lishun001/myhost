package com.eason.api.zb.service.impl;

import com.eason.api.zb.service.IGiftService;
import com.eason.api.zb.vo.gift.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GiftServiceImpl implements IGiftService {

    @Override
    public List<GiftResponseVo> getList() {
        System.out.println("-----GiftResponseVo-----");
        List<GiftResponseVo> list = new ArrayList<GiftResponseVo>();
        list.add(new GiftResponseVo(1, "戒指", "http://img001", "4", "旋转"));
        list.add(new GiftResponseVo(2, "飞机", "http://img002", "4", "旋转"));
        return list;
    }

    @Override
    public SendGiftResponseVo sendGift(Integer userId, Integer zbId, SendGiftRequestVo vo) {
        System.out.println("-----SendGiftResponseVo-----" + vo);
        SendGiftResponseVo responseVo = new SendGiftResponseVo();
        responseVo.setUserId(1);
        responseVo.setDiamondBalance(200.1);
        responseVo.setCost(5.0);
        return responseVo;
    }

    @Override
    public SendBombScreenResponseVo sendBombScreen(Integer userId, Integer zbId, SendBombScreenRequestVo vo) {
        System.out.println("-----SendBombScreenResponseVo-----" + vo);
        SendBombScreenResponseVo responseVo = new SendBombScreenResponseVo();
        responseVo.setUserId(1);
        responseVo.setDiamondBalance(201.1);
        responseVo.setCost(5.2);
        return responseVo;
    }
}
