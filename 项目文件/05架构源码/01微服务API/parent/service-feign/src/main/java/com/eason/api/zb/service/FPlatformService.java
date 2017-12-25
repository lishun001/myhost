package com.eason.api.zb.service;

import com.eason.api.zb.IPlatformService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.impl.FPlatformServiceImpl;
import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-api-zb-impl", fallback = FPlatformServiceImpl.class)
public interface FPlatformService extends IPlatformService {
    @RequestMapping(value = "/platform/media/get/{zbId}", method = RequestMethod.GET)
    MediaResponseVo getMedia(@PathVariable(value = "zbId") Integer zbId, @RequestParam(value = "token") String token) throws ServiceException;

    @RequestMapping(value = "/platform/im/get/{zbId}", method = RequestMethod.GET)
    IMResponseVo getIM(@PathVariable(value = "zbId") Integer zbId, @RequestParam(value = "token") String token) throws ServiceException;
}
