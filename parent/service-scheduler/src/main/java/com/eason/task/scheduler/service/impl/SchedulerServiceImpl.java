package com.eason.task.scheduler.service.impl;

import com.eason.task.scheduler.job.BaseJob;
import com.eason.task.scheduler.service.ISchedulerService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class SchedulerServiceImpl implements ISchedulerService {

    @Autowired
    @Qualifier("schedulerFactoryBean")
    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public void addJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception {
        // 通过SchedulerFactory获取一个调度器实例
//        SchedulerFactory sf = new StdSchedulerFactory();
//        Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
        // 启动调度器
        Scheduler sched = schedulerFactoryBean.getScheduler();
        sched.start();

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass()).withIdentity(jobClassName, jobGroupName).build();

        //表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
                .withSchedule(scheduleBuilder).build();

        try {
            sched.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            System.out.println("创建定时任务失败" + e);
            throw new Exception("创建定时任务失败");
        }
    }

    @Override
    public void jobPause(String jobClassName, String jobGroupName) throws Exception {
        Scheduler sched = schedulerFactoryBean.getScheduler();
        sched.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    @Override
    public void jobresume(String jobClassName, String jobGroupName) throws Exception {
        Scheduler sched = schedulerFactoryBean.getScheduler();
        sched.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    @Override
    public void jobreschedule(String jobClassName, String jobGroupName, String cronExpression) throws Exception {
        try {
            Scheduler sched = schedulerFactoryBean.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();

            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);

            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            // 按新的trigger重新设置job执行
            sched.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            System.out.println("更新定时任务失败" + e);
            throw new Exception("更新定时任务失败");
        }
    }

    @Override
    public void jobdelete(String jobClassName, String jobGroupName) throws Exception {
        Scheduler sched = schedulerFactoryBean.getScheduler();
        sched.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
        sched.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
        sched.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    public static BaseJob getClass(String classname) throws Exception {
        Class<?> class1 = Class.forName(classname);
        return (BaseJob) class1.newInstance();
    }
}
