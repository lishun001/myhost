package com.eason.task.scheduler.dao;


import com.eason.task.scheduler.entity.JobAndTrigger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface JobAndTriggerMapper {
    @Select("SELECT\n" +
            "\t\t\t\tqrtz_job_details.JOB_NAME,\n" +
            "\t\t\t\tqrtz_job_details.JOB_GROUP,\n" +
            "\t\t\t\tqrtz_job_details.JOB_CLASS_NAME,\n" +
            "\t\t\t\tqrtz_triggers.TRIGGER_NAME,\n" +
            "\t\t\t\tqrtz_triggers.TRIGGER_GROUP,\n" +
            "\t\t\t\tqrtz_cron_triggers.CRON_EXPRESSION,\n" +
            "\t\t\t\tqrtz_cron_triggers.TIME_ZONE_ID\n" +
            "\t\t\tFROM\n" +
            "\t\t\t\tQRTZ_JOB_DETAILS qrtz_job_details\n" +
            "\t\t\tJOIN QRTZ_TRIGGERS qrtz_triggers\n" +
            "\t\t\tJOIN QRTZ_CRON_TRIGGERS qrtz_cron_triggers ON qrtz_job_details.JOB_NAME = qrtz_triggers.JOB_NAME\n" +
            "\t\t\tAND qrtz_triggers.TRIGGER_NAME = qrtz_cron_triggers.TRIGGER_NAME\n" +
            "\t\t\tAND qrtz_triggers.TRIGGER_GROUP = qrtz_cron_triggers.TRIGGER_GROUP")
    public List<JobAndTrigger> getJobAndTriggerDetails();
}
