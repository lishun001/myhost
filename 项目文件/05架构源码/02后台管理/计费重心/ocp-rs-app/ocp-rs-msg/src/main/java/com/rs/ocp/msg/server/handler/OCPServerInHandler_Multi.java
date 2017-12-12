/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.msg.server.handler;

import com.rs.ocp.msg.server.cache.ServerIpCache;
import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.conf.ResponseCodeConst;
import com.rs.ocp.service.AccountService;
import com.rs.ocp.service.GameServerService;
import com.rs.ocp.service.PpPassportService;
import com.rs.ocp.service.dto.DeductQointRequestDTO;
import com.rs.ocp.service.dto.LoginRequestDTO;
import com.rs.ocp.service.dto.LogoutRequestDTO;
import com.rs.ocp.service.dto.MsgHeader;
import com.rs.ocp.service.dto.QueryPointRequestDTO;
import com.rs.ocp.service.dto.RegGameServerRequestDTO;
import com.rs.ocp.service.dto.RegGameServerResponseDTO;
import com.rs.ocp.service.dto.ResponseDTO;
import com.rs.ocp.service.dto.UnregGameServerRequestDTO;
import com.rs.ocp.service.utils.Commons;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.ReadTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author zhaoweixing
 */
// 该handler是InboundHandler类型  
@Sharable
public class OCPServerInHandler_Multi extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(OCPServerInHandler_Multi.class);
    private static Logger exception_logger = LoggerFactory.getLogger("exception_logger");
    private BlockingQueue<byte[]> requestDataQueue;
    @Autowired
    private PpPassportService passportService;
    @Autowired
    private GameServerService gameServerService;
    @Autowired
    private AccountService accountService;
    int CONSUMERS = Runtime.getRuntime().availableProcessors() + 1;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中  
        result.readBytes(result1);
        requestDataQueue.put(result1);

        // 释放资源
        result.release();
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

    public void init(ChannelHandlerContext ctx) {
        requestDataQueue = new LinkedBlockingQueue<byte[]>(MessageConfConst.MSG_QUEUE_LENGTH);
        //requestDataQueue = new LinkedBlockingQueue<byte[]>();
        final List<Future<?>> futureList = new ArrayList<Future<?>>();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(CONSUMERS);
        for (int i = 0; i < CONSUMERS; i++) {
            final Future<?> future = service.scheduleAtFixedRate(new Consumer(ctx), 0, 10, TimeUnit.MILLISECONDS);
            futureList.add(future);
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (futureList.size() > 0) {
                    for (Future<?> future : futureList) {
                        if (future != null) {
                            future.cancel(false);
                        }
                    }
                }
            }
        });
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        logger.info("{\"System\":\"Client Connect\",\"ClientIP\":\"" + getGameServerIpByChannel(ctx.channel()) + "\"}");
        logger.info("{\"System\":\"Client Connect\",\"ClientIP11111111\":\"" + ctx.channel().toString() + "\"}");
        init(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //客户端断开连接时, 从channel缓存中移除该channel
        logger.info("{\"System\":\"Client Disonnect\",\"ClientIP\":\"" + getGameServerIpByChannel(ctx.channel()) + "\"}");
        Channel channel = ctx.channel();
        if (ServerIpCache.tempServerList.keySet().contains(channel)) {
            ServerIpCache.tempServerList.remove(channel);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        //心跳超时
        if (cause instanceof ReadTimeoutException) {
            // The connection was OK but there was no traffic for last period.
            logger.info("{\"Exception\":\"短信预警\"}");
        }
        exception_logger.error("{\"Exception\":\"" + cause.getMessage() + "\"}");
    }

    class Consumer implements Runnable {

        ChannelHandlerContext ctx;

        public Consumer(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            try {

                if (requestDataQueue.size() <= 0) {
                    return;
                }
                //取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到Blocking有新的对象被加入为止
                byte[] result1 = requestDataQueue.take();
                Channel channel = ctx.channel();
                String gameServerIp = getGameServerIpByChannel(channel);
                MsgHeader header = buildHeader(result1);
                ResponseDTO responseDTO = null;

                switch (header.getMessageCode()) {
                    /*
                     * 1. 注册服务器
                     */
                    case MessageConfConst.MSG_CODE_FORW_REG:
                        RegGameServerRequestDTO regRequestDto = new RegGameServerRequestDTO(result1);
                        regRequestDto.setHeader(header);
                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + regRequestDto.toString() + "\"}");
                        responseDTO = gameServerService.registerGameServer(regRequestDto);
                        RegGameServerResponseDTO tempDTO = (RegGameServerResponseDTO) responseDTO;
                        if (tempDTO.getResult() == ResponseCodeConst.OUTER_RESULT_SUCCEED) {
                            ServerIpCache.tempServerList.put(channel, regRequestDto.getServerId());
                        }
                        break;
                    /*
                     * 2. 注销服务器
                     */
                    case MessageConfConst.MSG_CODE_FORW_UNREG:
                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                        if (!ServerIpCache.tempServerList.keySet().contains(channel)) {
                            ctx.channel().close();
                            throw new Exception("Invalid Server, Please Regite First");
                        }
                        ServerIpCache.tempServerList.remove(channel);
                        UnregGameServerRequestDTO unregGameServerRequestDTO = new UnregGameServerRequestDTO(result1);
                        unregGameServerRequestDTO.setHeader(header);
                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + unregGameServerRequestDTO.toString() + "\"}");
                        responseDTO = gameServerService.unregisterGameServer(unregGameServerRequestDTO);
                        break;
                    /*
                     * 3. 登陆
                     */
                    case MessageConfConst.MSG_CODE_FORW_LOGIN:
                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/

                        //注释, 方便测试
                        if (!ServerIpCache.tempServerList.keySet().contains(channel)) {
                            ctx.channel().close();
                            throw new Exception("Invalid Server, Please Regite First");
                        }
                        LoginRequestDTO loginRequestDto = new LoginRequestDTO(result1);
                        loginRequestDto.setHeader(header);
                        //注释, 方便测试
//                        loginRequestDto.setGameServerId(ServerIpCache.tempServerList.get(channel));
                        loginRequestDto.setGameServerId(137);
                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + loginRequestDto.toString() + "\"}");
                        responseDTO = passportService.login(loginRequestDto);
                        break;
                    /*
                     * 4. 登出
                     */
                    case MessageConfConst.MSG_CODE_FORW_LOGOUT:
                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                        //注释, 方便测试
//                        if (!ServerIpCache.tempServerList.keySet().contains(channel)) {
//                            ctx.channel().close();
//                            throw new Exception("Invalid Server, Please Regite First");
//                        }
                        LogoutRequestDTO logoutRequestDto = new LogoutRequestDTO(result1);
                        logoutRequestDto.setHeader(header);
                        //注释, 方便测试
//                        logoutRequestDto.setGameServerId(ServerIpCache.tempServerList.get(channel));
                        logoutRequestDto.setGameServerId(137);

                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + logoutRequestDto.toString() + "\"}");
                        responseDTO = passportService.logout(logoutRequestDto);
                        break;
                    /*
                     * 5. 返回中心点数
                     */
                    case MessageConfConst.MSG_CODE_FORW_RET_POINTS:
                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                        //注释, 方便测试
//                        if (!ServerIpCache.tempServerList.keySet().contains(channel)) {
//                            ctx.channel().close();
//                            throw new Exception("Invalid Server, Please Regite First");
//                        }
                        QueryPointRequestDTO queryPointRequestDTO = new QueryPointRequestDTO(result1);
                        queryPointRequestDTO.setHeader(header);
                        //注释, 方便测试
//                        queryPointRequestDTO.setGameServerId(ServerIpCache.tempServerList.get(channel));
                        queryPointRequestDTO.setGameServerId(137);
                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + queryPointRequestDTO.toString() + "\"}");
                        responseDTO = accountService.QueryPoint(queryPointRequestDTO);
                        break;

                    /*
                     * 6. 更新帐户(游戏服务器发)（扣点,每隔60秒发一次）
                     */
                    case MessageConfConst.MSG_CODE_FORW_RENEW:
                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                        //注释, 方便测试
//                        if (!ServerIpCache.tempServerList.keySet().contains(channel)) {
//                            ctx.channel().close();
//                            throw new Exception("Invalid Server, Please Regite First");
//                        }
                        DeductQointRequestDTO deductQointRequestDTO = new DeductQointRequestDTO(result1);
                        deductQointRequestDTO.setHeader(header);
                        //注释, 方便测试
//                        deductQointRequestDTO.setGameServerId(ServerIpCache.tempServerList.get(channel));
                        deductQointRequestDTO.setGameServerId(137);
                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + deductQointRequestDTO.toString() + "\"}");
                        responseDTO = accountService.deductQoint(deductQointRequestDTO);
                        break;
                    default:
                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                        if (!ServerIpCache.tempServerList.keySet().contains(channel)) {
                            ctx.channel().close();
                            throw new Exception("Invalid Server, Please Regite First");
                        }
                        throw new Exception("Invalid Message Code: [0x" + Integer.toHexString(header.getMessageCode()) + "]");
                }

                ByteBuf encoded = ctx.alloc().buffer();
                if (responseDTO != null) {
                    encoded.writeBytes(responseDTO.getBytes());
                    logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(responseDTO.getHeader().getMessageCode()) + "\","
                            + " \"Response_Msg\":\"" + responseDTO.toString() + "\"}");
                }
                ctx.write(encoded);
                ctx.flush();
            } catch (Exception e) {
                /*记录错误log*/
                Map<Object, Object> log_map = new HashMap<Object, Object>();
                log_map.put("Type", "Consumer");
                log_map.put("Method", "run()");
                log_map.put("Exception_Message", e.getMessage());
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            }
        }
    }
}
