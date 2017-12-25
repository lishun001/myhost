//package com.eason.api.zb.task;
//
//import com.eason.api.zb.cache.ZbTRoomCron;
//import com.eason.api.zb.dao.RoomCronDao;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Configuration
//@EnableScheduling
//public class CompleteScheduleConfig implements SchedulingConfigurer {
//    @Autowired
//    private RoomCronDao roomCronDao;
//    /**
//     * 执行定时任务.
//     */
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        List<ZbTRoomCron> cronList=roomCronDao.findAll();
//        cronList.forEach(cron->{
//            taskRegistrar.addTriggerTask(
//                    //1.添加任务内容(Runnable)
//                    () -> System.out.println(cron.getCron()+"执行定时任务: " + LocalDateTime.now().toLocalTime()),
//                    //2.设置执行周期(Trigger)
//                    (triggerContext) -> {
//                        //2.3 返回执行周期(Date)
//                        return new CronTrigger(cron.getCron()).nextExecutionTime(triggerContext);
//                    }
//            );
//        });
//    }
//
//}
