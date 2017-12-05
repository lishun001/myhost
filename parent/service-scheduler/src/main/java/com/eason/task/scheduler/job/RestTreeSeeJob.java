package com.eason.task.scheduler.job;

import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
@Service
public class RestTreeSeeJob implements BaseJob{
    private static Logger _log = LoggerFactory.getLogger(RestTreeSeeJob.class);

    // 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
    @Autowired
    private  RestTemplate restTemplate;

    @Value("${zb.api.resetTrySee}")
    private String resetTrySee;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        String result=restTemplate.getForEntity(resetTrySee, String.class).getBody();
        _log.info( DateFormatUtils.format(new Date(),DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())+"—>RestTreeSeeJob执行时间: " +result);
    }

}