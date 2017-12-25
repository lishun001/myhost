package com.eason.api.zb.service;

import com.eason.api.zb.IZhuboService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.impl.FZhuboServiceImpl;
import com.eason.api.zb.vo.room.RoomStatResponseVo;
import com.eason.api.zb.vo.user.UserLevelRankResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import com.eason.api.zb.vo.zhubo.ReadyPlayResponseVo;
import com.eason.api.zb.vo.zhubo.StartPlayRequestVo;
import com.eason.api.zb.vo.zhubo.StartPlayResponseVo;
import com.eason.api.zb.vo.zhubo.ZhuboResponseVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "service-api-zb-impl", fallback = FZhuboServiceImpl.class)
public interface FZhuboService extends IZhuboService {

    @RequestMapping(value = "/zhubo/getZhuboList/{num}", method = RequestMethod.GET)
    List<ZhuboResponseVo> getZhuboList(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "num") Integer num) throws ServiceException;

    @RequestMapping(value = "/zhubo/getZbDetail/{zbId}", method = RequestMethod.GET)
    ZhuboResponseVo getZbDetail(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "zbId") Integer zbId) throws ServiceException;

    @RequestMapping(value = "/zhubo/{zbId}/getAttentionUserList", method = RequestMethod.GET)
    List<UserLevelRankResponseVo> getAttentionUserList(@PathVariable(value = "zbId") Integer zbId) throws ServiceException;

    @RequestMapping(value = "/zhubo/{zbId}/getGiftUserList/{category}", method = RequestMethod.GET)
    List<UserResponseVo> getGiftUserList(@PathVariable(value = "zbId") Integer zbId, @PathVariable(value = "category") String category) throws ServiceException;

    @RequestMapping(value = "/zhubo/getReadyPlayInfo", method = RequestMethod.GET)
    ReadyPlayResponseVo getReadyPlayInfo(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "token") String token) throws ServiceException;

    @RequestMapping(value = "/zhubo/startPlay", method = RequestMethod.POST)
    StartPlayResponseVo startPlay(@RequestParam(value = "userId") Integer userId, @RequestBody StartPlayRequestVo startPlayRequestVo) throws ServiceException;

    @RequestMapping(value = "/zhubo/overPlay/{planId}", method = RequestMethod.GET)
    String overPlay(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "planId") Integer planId) throws ServiceException;

    @RequestMapping(value = "/zhubo/saveVideo/{planId}", method = RequestMethod.GET)
    String saveVideo(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "planId") Integer planId) throws ServiceException;

    @RequestMapping(value = "/zhubo/getStat/{planId}", method = RequestMethod.GET)
    RoomStatResponseVo getStat(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "planId") Integer planId) throws ServiceException;

    @RequestMapping(value = "/zhubo/apply", method = RequestMethod.GET)
    String apply(@RequestParam(value = "userId") Integer userId) throws ServiceException;
}
