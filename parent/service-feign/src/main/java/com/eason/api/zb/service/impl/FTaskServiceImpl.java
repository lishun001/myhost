package com.eason.api.zb.service.impl;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.FTaskService;
import org.springframework.stereotype.Component;

@Component("taskServiceImpl")
public class FTaskServiceImpl implements FTaskService {
    @Override
    public String resetTrySee() throws ServiceException {
       throw new ServiceException();
    }
}
