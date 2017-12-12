/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.cache;

import io.netty.channel.Channel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author wangxinming
 */
public class ChannelCache {

    private static ReentrantLock channelLock = new ReentrantLock();
    /**
     * 游戏服务器编号对应的Channel缓存
     */
    private static Map<Integer, Channel> serverId_Channel_Map = new HashMap<Integer, Channel>();
    /**
     * Channel对应的游戏服务器编号缓存
     */
    private static Map<Channel, Integer> channel_ServerId_Map = new HashMap<Channel, Integer>();

    public static void putChannel(int serverId, Channel channel) {
        ReentrantLock reentrantLock = channelLock;
        reentrantLock.lock();
        try {
            serverId_Channel_Map.put(serverId, channel);
            channel_ServerId_Map.put(channel, serverId);
        } finally {
            reentrantLock.unlock();
        }
    }

    public static Channel getChannel(int serverId) {
        return serverId_Channel_Map.get(serverId);
    }

    public static int getServerId(Channel channel) {
        return channel_ServerId_Map.get(channel);
    }

    public static void removeMap(Channel c) {
        ReentrantLock reentrantLock = channelLock;
        reentrantLock.lock();
        try {
            Integer serverId = channel_ServerId_Map.get(c);
            if (null != serverId) {
                channel_ServerId_Map.remove(c);
                serverId_Channel_Map.remove(serverId);
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
