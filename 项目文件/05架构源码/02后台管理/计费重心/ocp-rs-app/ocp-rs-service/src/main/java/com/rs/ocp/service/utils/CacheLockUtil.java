package com.rs.ocp.service.utils;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 账号缓存锁
 *
 * @author wangxinming
 */
@SuppressWarnings("deprecation")
public class CacheLockUtil {
    private final static ConcurrentMap<Integer, ReentrantLock> cacheLockMap = new ConcurrentHashMap<Integer, ReentrantLock>();

    /**
     * 用于监控和调试,防止恶意注册内存溢出
     */
    public static int size() {
        return cacheLockMap.size();
    }

    /**
     * 用于监控和调试,防止恶意注册内存溢出
     */
    public static boolean isEmpty() {
        return cacheLockMap.isEmpty();
    }

    public static ReentrantLock getReentrantLock(int key) {
        ReentrantLock result = cacheLockMap.get(key);
        if (null == result) {
            result = new ReentrantLock();
            cacheLockMap.put(key, result);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(new Date());
    }
}
