package com.eason.api.zb.service;

import com.eason.api.zb.IGiftService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.impl.FGiftServiceImpl;
import com.eason.api.zb.vo.gift.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "service-api-zb-impl",fallback = FGiftServiceImpl.class )
public interface FGiftService extends IGiftService {
    @RequestMapping(value = "/gift/getList", method = RequestMethod.GET)
    List<GiftResponseVo> getList(@RequestParam(value = "userId") Integer userId) throws ServiceException;

    @RequestMapping(value = "/gift/sendGift/{zbId}", method = RequestMethod.POST)
    SendGiftResponseVo sendGift(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "zbId") Integer zbId, @RequestBody SendGiftRequestVo vo) throws ServiceException;

    @RequestMapping(value = "/gift/sendBombScreen/{zbId}", method = RequestMethod.POST)
    SendBombScreenResponseVo sendBombScreen(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "zbId") Integer zbId,@RequestBody SendBombScreenRequestVo vo) throws ServiceException;
}
