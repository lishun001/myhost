package com.eason.api.zb;

import com.eason.api.zb.cache.ZbTRoomCron;
import com.eason.api.zb.cache.ZbTRoomPlan;
import com.eason.api.zb.dao.RoomCronDao;
import com.eason.api.zb.dao.RoomPlanDao;
import com.eason.api.zb.model.RedisFactory;
import com.eason.api.zb.model.ZbConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RoomPlanDao roomPlanDao;
    @Autowired
    private RoomCronDao roomCronDao;
    @Autowired
    private RedisTemplate stringRedisTemplate10;


    @Test
    public void testSet() {
        Map<String,String> map=new HashMap<String,String>();
        map.put("1","{\n" +
                "    \"userId\": 1,\n" +
                "    \"userLevel\": 7,\n" +
                "    \"isTrySee\": 1,\n" +
                "    \"allowTime\": 30\n" +
                "}");
        map.put("2","{\n" +
                "    \"userId\": 2,\n" +
                "    \"userLevel\": 7,\n" +
                "    \"isTrySee\": 1,\n" +
                "    \"allowTime\": 30\n" +
                "}");
        stringRedisTemplate.opsForHash().putAll("user_isTrySee",map);
//        Map<String,String> resultMap= stringRedisTemplate.opsForHash();
//        List<String> reslutMapList=stringRedisTemplate.opsForHash().values("map1");
//        Set<String> resultMapSet=stringRedisTemplate.opsForHash().keys("map1");
//        String value=(String)stringRedisTemplate.opsForHash().get("map1","key1");
//        System.out.println("value:"+value);
//        System.out.println("resultMapSet:"+resultMapSet);
//        System.out.println("resultMap:"+resultMap);
//        System.out.println("reslutMapList:"+reslutMapList);

//        stringRedisTemplate.boundHashOps("user_isTrySee").get(1)

    }
    @Test
    public void testMap() {
//        Map<String,String> map=new HashMap<String,String>();
//        map.put("4111169584094aa7c411201a910d80ac9","1");
//        stringRedisTemplate.opsForHash().putAll("user_api_token",map);
        Object s=stringRedisTemplate.boundHashOps("user_isTrySee").get(11+"");
        System.out.println(s);
    }
    @Test
    public void testGetMap() {
//        Map<String,String> map=new HashMap<String,String>();
//        map.put("4111169584094aa7c411201a910d80ac9","1");
//        String value=(String)stringRedisTemplate.opsForHash().get("user_detail_info",6451);
//        System.out.println("value:"+value);
//        r.getConnection().
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
//        redisConnectionFactory.setHostName("192.168.0.109");
//        redisConnectionFactory.setPort(6379);
        redisConnectionFactory.setDatabase(1);
//        redisConnectionFactory.setPassword("zbredis");
        redisConnectionFactory.afterPropertiesSet();

        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.opsForValue().set("eason","hahahahhahahahahahahh");

    }

    @Test
    public void testGetMap2() {
//        this.stringRedisTemplate.delete("test");
        stringRedisTemplate.convertAndSend(RedisFactory.redisChat, "333333");
    }


    @Test
    public void testRoomPlan() {
        ZbTRoomPlan roomPlan=new ZbTRoomPlan();
        roomPlan.setPlanId(10);
        roomPlan.setRoomTitle("卤蛋的直播间");
        roomPlan.setRoomType(ZbConstant.Room.Type.ticket.name());
        roomPlan.setOpenTime(new Timestamp(System.currentTimeMillis()));
        roomPlan.setCloseTime(new Timestamp(System.currentTimeMillis()+30000));
        Map<String,Object> map=new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        roomPlan.setRoomSet(map);
        roomPlanDao.save(roomPlan);
    }

    @Test
    public void testGetRoomPlan() throws  Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = formatter.parse("2017-12-12 11:40:26");
        Date overTime = formatter.parse("2017-12-2 12:39:26");
        Date now=new Date();
        int flag=0;
        if (now.compareTo(startTime)>=0 && now.compareTo(overTime)<=0){
            flag=1;  //1=收费
        }
        System.out.println(flag);
        System.out.println(now.compareTo(startTime));
        System.out.println(formatTime(23645789321L));
    }

    public static void main(String[] s) {
        System.out.println(formatTime(9439166604L));
    }
    /*
     * 毫秒转化时分秒毫秒
     */
    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if(day > 0) {
            sb.append(day+"天");
        }
        if(hour > 0) {
            sb.append(hour+"小时");
        }
        if(minute > 0) {
            sb.append(minute+"分");
        }
        if(second > 0) {
            sb.append(second+"秒");
        }
        if(milliSecond > 0) {
            sb.append(milliSecond+"毫秒");
        }
        return sb.toString();
    }



}
