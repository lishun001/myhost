/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.server.http;

import com.rs.obp.utils.ServerConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author wangxinming
 */
public class HttpServer {

    private static Logger logger = LoggerFactory.getLogger(HttpServer.class);
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ChannelInboundHandlerAdapter handler;
    private ServerBootstrap b;

    public void start(int port) throws Exception {
        try {
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
                    ch.pipeline().addLast(new HttpResponseEncoder());
                    // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
                    ch.pipeline().addLast(new HttpRequestDecoder());
                    ch.pipeline().addLast(handler);
                }
            }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(port).sync();
            logger.info("------>>the http server is started<<------");
            f.channel().closeFuture().sync();

        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public HttpServer(EventLoopGroup bossGroup, EventLoopGroup workerGroup, ChannelInboundHandlerAdapter handler, ServerBootstrap b) {
        this.bossGroup = bossGroup;
        this.workerGroup = workerGroup;
        this.handler = handler;
        this.b = b;
    }
}
