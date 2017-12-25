package com.eason.api.zb.service;

import com.eason.api.zb.ITaskService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.impl.FPlatformServiceImpl;
import com.eason.api.zb.service.impl.FTaskServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-api-zb-impl", fallback = FTaskServiceImpl.class)
public interface FTaskService extends ITaskService {

    @RequestMapping(value = "/task/resetTrySee", method = RequestMethod.GET)
    String resetTrySee() throws ServiceException;

}
