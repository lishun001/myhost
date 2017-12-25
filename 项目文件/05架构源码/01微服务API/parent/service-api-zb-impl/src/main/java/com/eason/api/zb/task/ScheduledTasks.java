//package com.eason.api.zb.task;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Component
//@Configurable
//@EnableScheduling
//public class ScheduledTasks {
//    private static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
//    @Autowired
//    private RedisTemplate stringRedisTemplate;
//
////    @Scheduled(fixedRate = 1000 * 30)
////    public void reportCurrentTime(){
////        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat().format(new Date()));
////    }
//
//    //每天凌晨4点执行一次
//    @Scheduled(cron = "0 0 4 * * ? ")
//    public void reportCurrentByCron() {
//        stringRedisTemplate.delete("user_isTrySee");
//        logger.info(dateFormat().format(new Date()) + "——用户试看时间全部恢成功");
//    }
//
//    private SimpleDateFormat dateFormat() {
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    }
//
//}