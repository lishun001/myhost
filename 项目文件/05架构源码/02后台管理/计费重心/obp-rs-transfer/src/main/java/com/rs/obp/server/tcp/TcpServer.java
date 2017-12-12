/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.server.tcp;

import com.rs.obp.common.Constants;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.nio.ByteOrder;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wangxinming
 */
public class TcpServer {

    private static Logger logger = LoggerFactory
            .getLogger(TcpServer.class);
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ChannelInboundHandlerAdapter handler;
    private ServerBootstrap b;

    public void start(int port) throws Exception {
        try {
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch)
                        throws Exception {
                    /*按照小端解析length, 不跳过length四位字节*/
                    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN, Integer.MAX_VALUE, 0, 4, 0, 0, true));
                    /*心跳, 不区分心跳消息*/
                    ch.pipeline().addLast(new ReadTimeoutHandler(Constants.HEARTBEAT_VALUE, TimeUnit.SECONDS));
                    // 逻辑HANDLER
                    ch.pipeline().addLast(handler);
                }
            }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(port).sync();
            logger.info("------>>the tcp server is started<<------");
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public TcpServer(EventLoopGroup bossGroup, EventLoopGroup workerGroup, ChannelInboundHandlerAdapter handler, ServerBootstrap b) {
        this.bossGroup = bossGroup;
        this.workerGroup = workerGroup;
        this.handler = handler;
        this.b = b;
    }
}
