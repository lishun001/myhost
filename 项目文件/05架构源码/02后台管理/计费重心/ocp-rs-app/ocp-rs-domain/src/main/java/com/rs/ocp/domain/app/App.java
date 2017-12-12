package com.rs.ocp.domain.app;

import com.rs.ocp.domain.endity.AccAccount;
import com.rs.ocp.domain.endity.AccAccountExample;
import com.rs.ocp.domain.mappers.AccAccountMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 *
 */
public class App {

    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext.xml");

        AccAccountMapper mapper = ctx.getBean("accAccountMapper", AccAccountMapper.class);
        AccAccountExample exp = new AccAccountExample();
        exp.createCriteria().andAccountPidEqualTo(4).andAccountServeridEqualTo(1001);
        List<AccAccount> list = mapper.selectByExample_Customer(exp);
        for (AccAccount acc : list) {
            System.out.println("1.........." + acc.getAccountPoints());
            System.out.println("1.........." + acc.getAccountGameid());
            System.out.println("1.........." + acc.getAccountIsrmb());
            System.out.println("1.........." + acc.getAccountAreaid());
            System.out.println("1.........." + acc.getAccountDeadline());
        }

//        final RedisTemplate rt = (RedisTemplate) ctx.getBean("redisTemplate");
//        rt.execute(new RedisCallback<Boolean>() {  
//            public Boolean doInRedis(RedisConnection connection)  
//                    throws DataAccessException {  
//                RedisSerializer<String> serializer =rt.getStringSerializer();  
//                byte[] key  = serializer.serialize("1");  
//                byte[] name = serializer.serialize("zhangsan");  
//                return connection.setNX(key, name);  
//            }  
//        }); 
//        rt.execute(new RedisCallback() {
//            public Boolean doInRedis(RedisConnection connection) {
//                RedisSerializer<String> serializer = rt.getStringSerializer();
//                byte[] key = serializer.serialize("test");
//                byte[] name = serializer.serialize("zhangsan");
//                System.out.println(new String(connection.get(key)));
//                return null;
//            }
//        });

//        Jedis jedis = new Jedis("192.168.2.241", 6379);//连接redis 

//        jedis.set("1", "hello redis");
//        System.out.println(jedis.get("1"));
    }
}
