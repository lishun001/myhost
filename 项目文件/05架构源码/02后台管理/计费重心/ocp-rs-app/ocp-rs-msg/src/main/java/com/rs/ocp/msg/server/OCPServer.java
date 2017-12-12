/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.msg.server;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import com.rs.ocp.service.conf.CommonConstants;
import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.utils.Commons;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author zhaoweixing
 */
public class OCPServer {

    private static Logger logger = LoggerFactory
            .getLogger(OCPServer.class);
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
                    ch.pipeline().addLast(new ReadTimeoutHandler(MessageConfConst.HEARTBEAT_VALUE, TimeUnit.SECONDS));
                    // 逻辑HANDLER
                    ch.pipeline().addLast(handler);
                }
            }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.SO_RCVBUF, 131072).childOption(ChannelOption.SO_SNDBUF, 262144)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT).childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);;



            ChannelFuture f = b.bind(port).sync();
            logger.info("------>>the charge server is started<<------");
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public OCPServer(EventLoopGroup bossGroup, EventLoopGroup workerGroup, ChannelInboundHandlerAdapter handler, ServerBootstrap b) {
        this.bossGroup = bossGroup;
        this.workerGroup = workerGroup;
        this.handler = handler;
        this.b = b;
    }

    public static void main(String[] args) throws Exception {
        //加载log配置文件
        initLogback();

        //加载防沉迷配置
        initConf();

        //加载spring配置
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext.xml");

        OCPServer server = ctx.getBean("ocpServer", OCPServer.class);
        server.start(CommonConstants.OCP_PORT);
    }

    public static void initLogback() throws Exception {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        lc.reset();
        configurator.setContext(lc);
        configurator.doConfigure(CommonConstants.CONFIG_LOGBACK);
    }

    public static void initConf() throws Exception {

        //通过配置设置防沉迷开关0为关1为开
        Commons.IS_OPEN_FCM = Commons.getPropertyByKey("ifOpenFCM").toString().equals("1");

        //防沉迷秒数
        Object famSeconds = Commons.getPropertyByKey("famSeconds");
        if (null != famSeconds) {
            CommonConstants.FCM_OFF_LINETIME_SET_UP_ZERO_NUM = Integer.parseInt(famSeconds.toString());
        }
        logger.info("------>>IS_OPEN_FCM<<------" + Commons.IS_OPEN_FCM);

        //端口
        Object port = Commons.getPropertyByKey("tcp_port");
        if (null != port) {
            CommonConstants.OCP_PORT = Integer.parseInt(port.toString());
        }
    }
}