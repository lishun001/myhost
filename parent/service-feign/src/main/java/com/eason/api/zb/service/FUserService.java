package com.eason.api.zb.service;

import com.eason.api.zb.IUserService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.impl.FUserServiceImpl;
import com.eason.api.zb.vo.user.TrySeeResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-api-zb-impl", fallback = FUserServiceImpl.class)
public interface FUserService extends IUserService {
    @RequestMapping(value = "/user/isTrySee/{roomId}/{isTrySee}", method = RequestMethod.GET)
    TrySeeResponseVo isTrySee(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "roomId") Integer roomId, @PathVariable(value = "isTrySee") Boolean isTrySee) throws ServiceException;

    @RequestMapping(value = "/user/{channel}/isAttention/{userIds}/{isAttention}", method = RequestMethod.GET)
    String isAttention(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "channel") Integer channel, @PathVariable(value = "userIds") String userIds, @PathVariable(value = "isAttention") Boolean isAttention) throws ServiceException;

    @RequestMapping(value = "/user/isBook/{zbId}/{isBook}", method = RequestMethod.GET)
    String isBook(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "zbId") Integer zbId, @PathVariable(value = "isBook") Boolean isBook) throws ServiceException;

    @RequestMapping(value = "/user/{channel}/isBlack/{userIds}/{isBlack}", method = RequestMethod.GET)
    String isBlack(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "channel") Integer channel, @PathVariable(value = "userIds") String userIds, @PathVariable(value = "isBlack") Boolean isBlack) throws ServiceException;

    @RequestMapping(value = "/user/getDetail/{userId}", method = RequestMethod.GET)
    UserResponseVo getDetail(@RequestParam(value = "tokenUserId") Integer tokenUserId,@PathVariable(value = "userId") Integer userId) throws ServiceException;
}
