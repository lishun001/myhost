package com.eason.api.zb.service.impl;

import com.eason.api.zb.dao.GiftListDao;
import com.eason.api.zb.po.ZbTGiftList;
import com.eason.api.zb.IGiftService;
import com.eason.api.zb.vo.gift.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gift")
public class GiftServiceImpl implements IGiftService {

    @Autowired
    private GiftListDao giftListDao;
    /**
     *礼物API - 礼物列表
     * （1）查询礼物列表
     * （2）根据order_field字段排序
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @Override
    public List<GiftResponseVo> getList(Integer userId) {
        Sort sort = new Sort(Sort.Direction.ASC, "orderField")
                            .and(new Sort(Sort.Direction.ASC, "createTime"));
        List<ZbTGiftList> list= giftListDao.findAll(sort);
        List<GiftResponseVo> responseVoList=new ArrayList<>();
        list.forEach(ZbTGiftList->{
            if (ZbTGiftList.getStatus()==8 && ZbTGiftList.getCategory()==1){
                responseVoList.add(new GiftResponseVo(ZbTGiftList.getGiftId(), ZbTGiftList.getGiftName(), ZbTGiftList.getGiftImg(), ZbTGiftList.getGiftPrice(), ZbTGiftList.getSpecialStyle()));
            }
        });
        return responseVoList;
    }

    @RequestMapping(value = "/sendGift/{zbId}", method = RequestMethod.POST)
    @Override
    public SendGiftResponseVo sendGift(Integer userId,@PathVariable(value = "zbId")  Integer zbId,@RequestBody SendGiftRequestVo vo) {
        System.out.println("-----SendGiftResponseVo-----" + vo);
        SendGiftResponseVo responseVo = new SendGiftResponseVo();
        responseVo.setUserId(1);
        responseVo.setDiamondBalance(200.1);
        responseVo.setCost(5.0);
        return responseVo;
    }

    @RequestMapping(value = "/sendBombScreen/{zbId}", method = RequestMethod.POST)
    @Override
    public SendBombScreenResponseVo sendBombScreen(Integer userId, @PathVariable(value = "zbId") Integer zbId, @RequestBody SendBombScreenRequestVo vo) {
        System.out.println("-----SendBombScreenResponseVo-----" + vo);
        SendBombScreenResponseVo responseVo = new SendBombScreenResponseVo();
        responseVo.setUserId(1);
        responseVo.setDiamondBalance(201.1);
        responseVo.setCost(5.2);
        return responseVo;
    }
}
