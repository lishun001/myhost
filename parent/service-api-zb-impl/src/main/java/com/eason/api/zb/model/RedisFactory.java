package com.eason.api.zb.model;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisFactory {
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