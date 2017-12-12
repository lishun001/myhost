/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.msg.server.handler.message;

import io.netty.channel.Channel;

/**
 *
 * @author zhaoweixing
 */
public class MessageEntity {

    private Channel channel;
    private byte[] msg;
    private long putTime;
    private long inQueueTime;

    public MessageEntity(Channel channel, byte[] msg) {
        this.channel = channel;
        this.msg = msg;
        this.putTime = System.currentTimeMillis();
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public byte[] getMsg() {
        return msg;
    }

    public void setMsg(byte[] msg) {
        this.msg = msg;
    }

    /**
     * @return the putTime
     */
    public long getPutTime() {
        return putTime;
    }

    /**
     * @param putTime the putTime to set
     */
    public void setPutTime(long putTime) {
        this.putTime = putTime;
    }

    /**
     * @return the inQueueTime
     */
    public long getInQueueTime() {
        return inQueueTime;
    }

    /**
     * @param inQueueTime the inQueueTime to set
     */
    public void setInQueueTime(long inQueueTime) {
        this.inQueueTime = inQueueTime;
    }
}
