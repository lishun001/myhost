/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.server.tcp;

import com.rs.obp.cache.ChannelCache;
import com.rs.obp.common.Commons;
import com.rs.obp.entity.dto.MsgHeader;
import com.rs.obp.entity.dto.ResponseDTO;
import com.rs.obp.service.HttpService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.ReadTimeoutException;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author wangxinming
 */
public class TcpServerHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    private HttpService httpService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中  
        result.readBytes(result1);

        Channel channel = ctx.channel();
        String gameServerIp = getGameServerIpByChannel(channel);
        MsgHeader header = buildHeader(result1);
        ResponseDTO responseDTO = null;



        ByteBuf encoded = ctx.alloc().buffer();
        if (responseDTO != null) {
            encoded.writeBytes(responseDTO.getBytes());
        }
        ctx.write(encoded);
        ctx.flush();

    }

    public MsgHeader buildHeader(byte[] msg) {
        MsgHeader requestHeader = new MsgHeader();
        if (msg.length >= 32) {
            requestHeader.setMessageLength(Commons.bytesToInt(ArrayUtils.subarray(msg, 0, 4)));
            requestHeader.setMessageVersion(Commons.bytesToInt(ArrayUtils.subarray(msg, 4, 8)));
            requestHeader.setMessageUserID(ArrayUtils.subarray(msg, 8, 24));
            requestHeader.setMessageReserved(Commons.bytesToInt(ArrayUtils.subarray(msg, 24, 28)));
            requestHeader.setMessageCode(Commons.bytesToInt(ArrayUtils.subarray(msg, 28, 32)));
        }
        return requestHeader;
    }

    public String getGameServerIpByChannel(Channel ch) {
        return ch.remoteAddress().toString();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //客户端断开连接时, 从channel缓存中移除该channel
        Channel channel = ctx.channel();
        ChannelCache.removeMap(channel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //心跳超时
        if (cause instanceof ReadTimeoutException) {
            // The connection was OK but there was no traffic for last period.
            return;
        }
        ctx.channel().close();
    }
}
