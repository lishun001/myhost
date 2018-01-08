package com.eason.api.zb.model;

import com.eason.api.zb.manager.Receiver;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.CountDownLatch;

@Configuration
public class RedisFactory {
    public static final String redisChat="java_event_api";

    @Bean(name = "stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(
            @Value("${spring.redis.host}") String hostName,
            @Value("${spring.redis.port}") int port,
            @Value("${spring.redis.password}") String password,
            @Value("${spring.redis.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.pool.max-active}") int maxTotal,
            @Value("${spring.redis.database}") int index,
            @Value("${spring.redis.pool.max-wait}") long maxWaitMillis,
            @Value("${spring.redis.testOnBorrow}") boolean testOnBorrow) {
        StringRedisTemplate temple = new StringRedisTemplate();
        temple.setConnectionFactory(connectionFactory(hostName, port, password,
                maxIdle, maxTotal, index, maxWaitMillis, testOnBorrow));
        return temple;
    }

    @Bean(name = "stringRedisTemplate10")
    public StringRedisTemplate stringRedisTemplate10(
            @Value("${spring.redis.host}") String hostName,
            @Value("${spring.redis.port}") int port,
            @Value("${spring.redis.password}") String password,
            @Value("${spring.redis.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.pool.max-active}") int maxTotal,
            @Value("${spring.redis.database10}") int index,
            @Value("${spring.redis.pool.max-wait}") long maxWaitMillis,
            @Value("${spring.redis.testOnBorrow}") boolean testOnBorrow) {
        StringRedisTemplate temple = new StringRedisTemplate();
        temple.setConnectionFactory(connectionFactory(hostName, port, password,
                maxIdle, maxTotal, index, maxWaitMillis, testOnBorrow));
        return temple;
    }

    @Bean(name = "redisTemplate10")
    public RedisTemplate redisTemplate(
            @Value("${spring.redis.host}") String hostName,
            @Value("${spring.redis.port}") int port,
            @Value("${spring.redis.password}") String password,
            @Value("${spring.redis.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.pool.max-active}") int maxTotal,
            @Value("${spring.redis.database10}") int index,
            @Value("${spring.redis.pool.max-wait}") long maxWaitMillis,
            @Value("${spring.redis.testOnBorrow}") boolean testOnBorrow) {
        RedisTemplate temple = new RedisTemplate();
        temple.setConnectionFactory(connectionFactory(hostName, port, password,
                maxIdle, maxTotal, index, maxWaitMillis, testOnBorrow));
        return temple;
    }

    /*
     * Redis消息监听器容器
     * 这个容器加载了RedisConnectionFactory和消息监听器
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(redisChat));
        return container;
    }

    /*
     * 将Receiver注册为一个消息监听器，并指定消息接收的方法（receiveMessage）
     * 如果不指定消息接收的方法，消息监听器会默认的寻找Receiver中的handleMessage这个方法作为消息接收的方法
     */
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver){
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    /*
     * Receiver实例
     */
    @Bean
    Receiver receiver(CountDownLatch latch){
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch(){
        return new CountDownLatch(1);
    }


    public RedisConnectionFactory connectionFactory(String hostName, int port,
                                                    String password, int maxIdle, int maxTotal, int index,
                                                    long maxWaitMillis, boolean testOnBorrow) {
        JedisConnectionFactory jedis = new JedisConnectionFactory();
        jedis.setHostName(hostName);
        jedis.setPort(port);
        if (!StringUtils.isEmpty(password)) {
            jedis.setPassword(password);
        }
        if (index != 0) {
            jedis.setDatabase(index);
        }
        jedis.setPoolConfig(poolCofig(maxIdle, maxTotal, maxWaitMillis,
                testOnBorrow));
        // 初始化连接pool
        jedis.afterPropertiesSet();
        RedisConnectionFactory factory = jedis;

        return factory;
    }

    public JedisPoolConfig poolCofig(int maxIdle, int maxTotal, long maxWaitMillis, boolean testOnBorrow) {
        JedisPoolConfig poolCofig = new JedisPoolConfig();
        poolCofig.setMaxIdle(maxIdle);
        poolCofig.setMaxTotal(maxTotal);
        poolCofig.setMaxWaitMillis(maxWaitMillis);
        poolCofig.setTestOnBorrow(testOnBorrow);
        return poolCofig;
    }
}