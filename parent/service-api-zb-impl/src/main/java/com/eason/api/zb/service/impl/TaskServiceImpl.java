package com.eason.api.zb.service.impl;

import com.eason.api.zb.ITaskService;
import com.eason.api.zb.exception.ServiceException;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/task")
public class TaskServiceImpl implements ITaskService {
    private static Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    @Autowired
    private RedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/resetTrySee", method = RequestMethod.GET)
    @Override
    public String resetTrySee() throws ServiceException {
        try {
            stringRedisTemplate.delete("user_isTrySee");
            String time=DateFormatUtils.format(new Date(),DateFormatUtils.ISO_DATETIME_FORMAT.getPattern());
            return  time+ "——用户试看时间全部恢复成功";
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
