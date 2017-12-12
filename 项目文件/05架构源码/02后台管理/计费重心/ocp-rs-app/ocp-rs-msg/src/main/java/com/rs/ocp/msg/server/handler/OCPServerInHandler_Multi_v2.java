/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.msg.server.handler;

import com.rs.ocp.domain.utils.DomainConfConst;
import com.rs.ocp.msg.server.cache.ServerIpCache;
import com.rs.ocp.msg.server.handler.message.MessageEntity;
import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.conf.ResponseCodeConst;
import com.rs.ocp.service.AccountService;
import com.rs.ocp.service.GameServerService;
import com.rs.ocp.service.PpPassportService;
import com.rs.ocp.service.conf.CommonConstants;
import com.rs.ocp.service.dto.DeductQointRequestDTO;
import com.rs.ocp.service.dto.DeductQointResponseDTO;
import com.rs.ocp.service.dto.LoginRequestDTO;
import com.rs.ocp.service.dto.LoginResponseDTO;
import com.rs.ocp.service.dto.LogoutRequestDTO;
import com.rs.ocp.service.dto.LogoutResponseDTO;
import com.rs.ocp.service.dto.MsgHeader;
import com.rs.ocp.service.dto.QueryPointRequestDTO;
import com.rs.ocp.service.dto.RegGameServerRequestDTO;
import com.rs.ocp.service.dto.RegGameServerResponseDTO;
import com.rs.ocp.service.dto.ResponseDTO;
import com.rs.ocp.service.dto.TwoLevelPwdRequestDTO;
import com.rs.ocp.service.dto.UnregGameServerRequestDTO;
import com.rs.ocp.service.dto.ValidatePpPassportRequestDto;
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
public class OCPServerInHandler_Multi_v2 extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(OCPServerInHandler_Multi_v2.class);
    private static Logger exception_logger = LoggerFactory.getLogger("exception_logger");
    //private static Logger db_logger = LoggerFactory.getLogger("db_logger");
    private BlockingQueue<MessageEntity> otherRequestDataQueue;
    private BlockingQueue<MessageEntity> deductQointDataQueue;
    @Autowired
    private PpPassportService passportService;
    @Autowired
    private GameServerService gameServerService;
    @Autowired
    private AccountService accountService;
//    @Autowired
//    private MailSenderService mailSenderService;
    /**
     * 处理除扣点以外业务的线程数
     */
    int OTHER_CONSUMERS = Runtime.getRuntime().availableProcessors();
    /**
     * 处理扣点业务的线程数
     */
    int DEDUCT_QOINT_CONSUMERS = Runtime.getRuntime().availableProcessors() * 3;

    public OCPServerInHandler_Multi_v2() {
        init();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中  
        result.readBytes(result1);
        Channel channel = ctx.channel();

        MsgHeader header = buildHeader(result1);
        MessageEntity entity = new MessageEntity(channel, result1);

        switch (header.getMessageCode()) {
            case MessageConfConst.MSG_CODE_FORW_RENEW:
                //logger.info("msg receive......................." + d.getAccountId());
                deductQointDataQueue.put(entity);
                entity.setInQueueTime(System.currentTimeMillis());
                break;
            default:
                otherRequestDataQueue.put(entity);
        }
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

    public final void init() {
        otherRequestDataQueue = new LinkedBlockingQueue<MessageEntity>(MessageConfConst.MSG_QUEUE_LENGTH);
        deductQointDataQueue = new LinkedBlockingQueue<MessageEntity>(MessageConfConst.MSG_QUEUE_LENGTH);

        final List<Future<?>> futureList = new ArrayList<Future<?>>();
        ScheduledExecutorService deductQointService = Executors.newScheduledThreadPool(DEDUCT_QOINT_CONSUMERS);
        ScheduledExecutorService otherService = Executors.newScheduledThreadPool(OTHER_CONSUMERS);
        for (int i = 0; i < OTHER_CONSUMERS; i++) {
            final Future<?> future_otherRequest = otherService.scheduleAtFixedRate(new OCPServerInHandler_Multi_v2.Consumer_otherRequest(), 0, 10, TimeUnit.MILLISECONDS);
            futureList.add(future_otherRequest);
        }
        for (int i = 0; i < DEDUCT_QOINT_CONSUMERS; i++) {
            final Future<?> future_deductPonint = deductQointService.scheduleAtFixedRate(new OCPServerInHandler_Multi_v2.Consumer_deductPoint(), 0, 10, TimeUnit.MILLISECONDS);
            futureList.add(future_deductPonint);
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
        logger.info("{\"System\":\"Client Connect\",\"ClientIP\":\"" + getGameServerIpByChannel(ctx.channel()) + "\"}");
        System.out.println("{\"System\":\"Client Connect\",\"ClientIP\":\"" + getGameServerIpByChannel(ctx.channel()) + "\"}");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //客户端断开连接时, 从channel缓存中移除该channel
        logger.info("{\"System\":\"Client Disonnect\",\"ClientIP\":\"" + getGameServerIpByChannel(ctx.channel()) + "\"}");
        Channel channel = ctx.channel();
        if (ServerIpCache.tempServerList.keySet().contains(channel)) {
            int gameServerId = ServerIpCache.getGameServerIdByChannel(channel);
            //设置服务器为异常注销状态
            gameServerService.updateGameServerRegisterState(gameServerId, DomainConfConst.GAME_SERVER_ERROR_UN_REGISTER);
            //清除该服务器玩家登陆session
            passportService.delGameLoginsession(gameServerId, true);
            ServerIpCache.tempServerList.remove(channel);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //心跳超时
        if (cause instanceof ReadTimeoutException) {
            String serverIp = getGameServerIpByChannel(ctx.channel());
            // The connection was OK but there was no traffic for last period.
            //mailSenderService.autoSendMail("计费中心预警", "客户端" + serverIp + "心跳超时, 请检查!");
            exception_logger.error("{\"Exception\":\"" + "serverIp:" + serverIp + "心跳超时, 请检查!" + Commons.getExceptionMessage(cause) + "\"}");
        }
        exception_logger.error("{\"Exception\":\"" + Commons.getExceptionMessage(cause) + "\"}");
    }

    public void checkChannel(Channel channel) throws Exception {
        if (!ServerIpCache.tempServerList.keySet().contains(channel)) {
            throw new Exception("Invalid Server, Please Regite First :" + getGameServerIpByChannel(channel));
        }
    }

    class Consumer_deductPoint implements Runnable {

        @Override
        public void run() {
            try {

                if (deductQointDataQueue.size() <= 0) {
                    return;
                }
                //取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到Blocking有新的对象被加入为止
                MessageEntity entity = deductQointDataQueue.take();
                byte[] result1 = entity.getMsg();
                Channel channel = entity.getChannel();
                String gameServerIp = getGameServerIpByChannel(channel);
                MsgHeader header = buildHeader(result1);

                /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                checkChannel(channel);

                DeductQointRequestDTO deductQointRequestDTO = new DeductQointRequestDTO(result1);
                deductQointRequestDTO.setHeader(header);
                deductQointRequestDTO.setGameServerId(ServerIpCache.tempServerList.get(channel));


                int gameServerId = ServerIpCache.getGameServerIdByChannel(channel);
                logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Game_Server_Id\":\"" + gameServerId + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                        + " \"Request_Msg\":\"" + deductQointRequestDTO.toString() + "\"}");

                //db_logger.info(deductQointRequestDTO.toString() + "--|--deductQ id:{}--time:{}--type:{}--serverId:{}", deductQointRequestDTO.getAccountId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), "begin", gameServerId);
                //long t1 = System.currentTimeMillis();
                ResponseDTO responseDTO = accountService.deductQoint(deductQointRequestDTO);
                //long t2 = System.currentTimeMillis();
                //exception_logger.error("deductPoint:" + (t2 - t1));

                ByteBuf encoded = channel.alloc().buffer();
                if (responseDTO != null) {
                    encoded.writeBytes(responseDTO.getBytes());

                    //消息处理时间超过45秒
                    msgHanlderTimeout(entity, header, result1);

                    logger.info("{\"Type\":\"Response\", \"Game_Server\":\"" + gameServerIp + "\", \"Game_Server_Id\":\"" + gameServerId + "\", \"Msg_Code\":\"0x" + Integer.toHexString(responseDTO.getHeader().getMessageCode()) + "\","
                            + " \"Response_Msg\":\"" + responseDTO.toString() + "\"}");

                    DeductQointResponseDTO dq = (DeductQointResponseDTO) responseDTO;

                    //db_logger.info(responseDTO.toString() + "--|--deductQ id:{}--time:{}--type:{}--serverId:{}", dq.getAccountId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), "end", gameServerId);

                }
                channel.write(encoded);
                //encoded.release();
                channel.flush();


            } catch (Exception e) {
                /*记录错误log*/
                Map<Object, Object> log_map = new HashMap<Object, Object>();
                log_map.put("Type", "Consumer");
                log_map.put("Method", "run()");
                log_map.put("Exception_Message", Commons.getExceptionMessage(e));
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            }
        }
    }

    class Consumer_otherRequest implements Runnable {

        @Override
        public void run() {
            try {

                if (otherRequestDataQueue.size() <= 0) {
                    return;
                }
                //取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到Blocking有新的对象被加入为止
                MessageEntity entity = otherRequestDataQueue.take();
                byte[] result1 = entity.getMsg();
                Channel channel = entity.getChannel();
                String gameServerIp = getGameServerIpByChannel(channel);
                MsgHeader header = buildHeader(result1);
                ResponseDTO responseDTO = null;
                int gameServerId = 0;
                switch (header.getMessageCode()) {
                    /*
                     * 1. 注册服务器
                     */
                    case MessageConfConst.MSG_CODE_FORW_REG:
                        RegGameServerRequestDTO regRequestDto = new RegGameServerRequestDTO(result1);
                        regRequestDto.setHeader(header);
                        regRequestDto.setIp(gameServerIp);
                        gameServerId = regRequestDto.getServerId();
                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Game_Server_Id\":\"" + gameServerId + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + regRequestDto.toString() + "\"}");

                        //db_logger.info("gameServerIp:{}--time:{}--type:{}--serverId:{}", gameServerIp, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), MessageConfConst.MSG_CODE_FORW_REG, gameServerId);
                        responseDTO = gameServerService.registerGameServer(regRequestDto);
                        //db_logger.info(responseDTO.toString() + "--|--gameServerIp:{}--time:{}--type:{}--serverId:{}", gameServerIp, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), responseDTO.getHeader().getMessageCode(), gameServerId);
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
                        checkChannel(channel);
                        gameServerId = ServerIpCache.getGameServerIdByChannel(channel);

                        UnregGameServerRequestDTO unregGameServerRequestDTO = new UnregGameServerRequestDTO(result1);
                        unregGameServerRequestDTO.setHeader(header);
                        unregGameServerRequestDTO.setGameServerId(gameServerId);


                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Game_Server_Id\":\"" + gameServerId + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + unregGameServerRequestDTO.toString() + "\"}");
                        //db_logger.info("gameServerIp:{}--time:{}--type:{}--serverId:{}", gameServerIp, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), MessageConfConst.MSG_CODE_FORW_UNREG, gameServerId);
                        responseDTO = gameServerService.unregisterGameServer(unregGameServerRequestDTO);
                        //db_logger.info(responseDTO.toString() + "--|--gameServerIp:{}--time:{}--type:{}--serverId:{}", gameServerIp, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), responseDTO.getHeader().getMessageCode(), gameServerId);

//                        gameServerService.updateGameServerRegisterState(gameServerId, DomainConfConst.GAME_SERVER_UN_REGISTER);
                        //清除该服务器玩家登陆session
                        passportService.delGameLoginsession(gameServerId, false);
                        ServerIpCache.tempServerList.remove(channel);
                        break;
                    /*
                     * 3. 登陆
                     */
                    case MessageConfConst.MSG_CODE_FORW_LOGIN:
                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                        checkChannel(channel);
                        LoginRequestDTO loginRequestDto = new LoginRequestDTO(result1);
                        loginRequestDto.setHeader(header);
                        loginRequestDto.setGameServerId(ServerIpCache.tempServerList.get(channel));
                        gameServerId = ServerIpCache.getGameServerIdByChannel(channel);

                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Game_Server_Id\":\"" + gameServerId + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + loginRequestDto.toString() + "\"}");
                        //db_logger.info(loginRequestDto.toString() + "--|--account:{}--time{}--type:{}--serverId:{}", loginRequestDto.getAccount(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), MessageConfConst.MSG_CODE_FORW_LOGIN, gameServerId);

                        try {
                            //long t1=System.currentTimeMillis();
                            responseDTO = passportService.login(loginRequestDto);
                            //long t2=System.currentTimeMillis();
                            //exception_logger.error("login:" + (t2 - t1));

                            //db_logger.info(responseDTO.toString() + "--|--account:{}--time:{}--type:{}--serverId:{}", loginRequestDto.getAccount(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), responseDTO.getHeader().getMessageCode(), gameServerId);
                        } catch (Exception e) {
                            LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

                            MsgHeader requestHeader = loginRequestDto.getHeader();

                            MsgHeader responsetHeader = new MsgHeader();
                            responsetHeader.setMessageVersion(requestHeader.getMessageVersion());
                            responsetHeader.setMessageUserID(requestHeader.getMessageUserID());
                            responsetHeader.setMessageReserved(requestHeader.getMessageReserved());
                            responsetHeader.setMessageCode(MessageConfConst.MSG_CODE_BACK_LOGIN);
                            loginResponseDTO.setHeader(responsetHeader);

                            loginResponseDTO.setAccountType(loginRequestDto.getAccountType());
                            loginResponseDTO.setAccount(loginRequestDto.getAccount());
                            loginResponseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
                            responseDTO = loginResponseDTO;

                            //db_logger.info(responseDTO.toString() + "--|--account:{}--time:{}--type:{}--serverId:{}", loginRequestDto.getAccount(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), responseDTO.getHeader().getMessageCode(), gameServerId);
                        }

                        break;
                    /*
                     * 4. 登出
                     */
                    case MessageConfConst.MSG_CODE_FORW_LOGOUT:
                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                        checkChannel(channel);
                        LogoutRequestDTO logoutRequestDto = new LogoutRequestDTO(result1);
                        logoutRequestDto.setHeader(header);
                        logoutRequestDto.setGameServerId(ServerIpCache.tempServerList.get(channel));
                        gameServerId = ServerIpCache.getGameServerIdByChannel(channel);

                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Game_Server_Id\":\"" + gameServerId + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + logoutRequestDto.toString() + "\"}");
                        //db_logger.info(logoutRequestDto.toString() + "--|--accountid:{}--time:{}--type:{}--serverId:{}", logoutRequestDto.getAccountId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), MessageConfConst.MSG_CODE_FORW_LOGOUT, gameServerId);
                        try {
                            // long t1=System.currentTimeMillis();
                            responseDTO = passportService.logout(logoutRequestDto);
                            //long t2=System.currentTimeMillis();
                            //exception_logger.error("logout:" + (t2 - t1));
                            //db_logger.info(responseDTO.toString() + "--|--accountid:{}--time:{}--type:{}--serverId:{}", logoutRequestDto.getAccountId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), responseDTO.getHeader().getMessageCode(), gameServerId);
                        } catch (Exception e) {
                            LogoutResponseDTO logoutResponseDto = new LogoutResponseDTO();

                            MsgHeader requestHesder = logoutRequestDto.getHeader();
                            MsgHeader responsetHeader = new MsgHeader();
                            responsetHeader.setMessageVersion(requestHesder.getMessageVersion());
                            responsetHeader.setMessageUserID(requestHesder.getMessageUserID());
                            responsetHeader.setMessageReserved(requestHesder.getMessageReserved());
                            responsetHeader.setMessageCode(MessageConfConst.MSG_CODE_BACK_LOGOUT);
                            logoutResponseDto.setHeader(responsetHeader);
                            logoutResponseDto.setAccountId(logoutRequestDto.getAccountId());
                            logoutResponseDto.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
                            responseDTO = logoutResponseDto;
                            //db_logger.info(responseDTO.toString() + "--|--accountid:{}--time:{}--type:{}--serverId:{}", logoutRequestDto.getAccountId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), responseDTO.getHeader().getMessageCode(), gameServerId);
                        }

                        break;
                    /*
                     * 5. 返回中心点数
                     */
                    case MessageConfConst.MSG_CODE_FORW_RET_POINTS:
                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                        checkChannel(channel);
                        QueryPointRequestDTO queryPointRequestDTO = new QueryPointRequestDTO(result1);
                        queryPointRequestDTO.setHeader(header);
                        queryPointRequestDTO.setGameServerId(ServerIpCache.tempServerList.get(channel));
                        gameServerId = ServerIpCache.getGameServerIdByChannel(channel);

                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Game_Server_Id\":\"" + gameServerId + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + queryPointRequestDTO.toString() + "\"}");
                        //db_logger.info(queryPointRequestDTO.toString() + "--|--accountid:{}--time:{}--type:{}--serverId:{}", queryPointRequestDTO.getAccountId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), MessageConfConst.MSG_CODE_FORW_RET_POINTS, gameServerId);
                        responseDTO = accountService.QueryPoint(queryPointRequestDTO);
                        //db_logger.info(responseDTO.toString() + "--|--accountid:{}--time:{}--type:{}--serverId:{}", queryPointRequestDTO.getAccountId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), responseDTO.getHeader().getMessageCode(), gameServerId);
                        break;
                    /*
                     * 6. 验证账号
                     */
                    case MessageConfConst.MSG_CODE_FORW_VALIDATE_PPPASSPORT:
                        ValidatePpPassportRequestDto validatePpPassportRequestDto = new ValidatePpPassportRequestDto(result1);
                        validatePpPassportRequestDto.setHeader(header);
                        //gameServerId = ServerIpCache.getGameServerIdByChannel(channel);
                        //validatePpPassportRequestDto.setGameServerId(gameServerId);

                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + validatePpPassportRequestDto.toString() + "\"}");
                        //validatePpPassportRequestDto.setGameServerId(ServerIpCache.tempServerList.get(channel));


                        //db_logger.info(validatePpPassportRequestDto.toString() + "account{}--time{}--type{}--params", validatePpPassportRequestDto.getAccount(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), MessageConfConst.MSG_CODE_FORW_VALIDATE_PPPASSPORT);
                        responseDTO = passportService.validatePpPassport(validatePpPassportRequestDto);
                        //db_logger.info(responseDTO.toString() + "--|--account{}--time{}--type{}", validatePpPassportRequestDto.getAccount(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), responseDTO.getHeader().getMessageCode());
                        break;

                    /*
                     * 7. 验证游戏二级密码
                     */
                    case MessageConfConst.MSG_CODE_FORW_TWO_LEVEL_PWD:
                        TwoLevelPwdRequestDTO twoLevelPwdRequestDTO = new TwoLevelPwdRequestDTO(result1);
                        twoLevelPwdRequestDTO.setHeader(header);
                        gameServerId = ServerIpCache.getGameServerIdByChannel(channel);
                        twoLevelPwdRequestDTO.setGameServerId(gameServerId);

                        logger.info("{\"Type\":\"Request\", \"Game_Server\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\","
                                + " \"Request_Msg\":\"" + twoLevelPwdRequestDTO.toString() + "\"}");
                        //validatePpPassportRequestDto.setGameServerId(ServerIpCache.tempServerList.get(channel));

                        //db_logger.info(validatePpPassportRequestDto.toString() + "account{}--time{}--type{}--params", validatePpPassportRequestDto.getAccount(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), MessageConfConst.MSG_CODE_FORW_VALIDATE_PPPASSPORT);
                        responseDTO = passportService.twoLevelPwd(twoLevelPwdRequestDTO);
                        //db_logger.info(responseDTO.toString() + "--|--account{}--time{}--type{}", validatePpPassportRequestDto.getAccount(), DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), responseDTO.getHeader().getMessageCode());
                        break;

                    /*
                     * 8. 心跳
                     */
                    case MessageConfConst.MSG_CODE_FORW_KEEP:
                        logger.info("{\"Type\":\"Request\", \"Heartbeat\":\"" + gameServerIp + "\", \"Msg_Code\":\"0x" + Integer.toHexString(header.getMessageCode()) + "\"}");
                        //db_logger.info("gameServerIp{}--time{}--type{}", gameServerIp, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), MessageConfConst.MSG_CODE_FORW_KEEP);
                        return;
                    default:
                        logger.info("Invalid Message Code: [0x" + Integer.toHexString(header.getMessageCode()) + "]");

                        /*验证应该在注册服务器后, 在tempServerIpList里验证*/
                        checkChannel(channel);
                        return;
                }

                ByteBuf encoded = channel.alloc().buffer();
                if (responseDTO != null) {
                    encoded.writeBytes(responseDTO.getBytes());

                    logger.info("{\"Type\":\"Response\", \"Game_Server\":\"" + gameServerIp + "\", \"Game_Server_Id\":\"" + gameServerId + "\", \"Msg_Code\":\"0x" + Integer.toHexString(responseDTO.getHeader().getMessageCode()) + "\","
                            + " \"Response_Msg\":\"" + responseDTO.toString() + "\"}");

                }
                channel.write(encoded);
                //encoded.release();
                channel.flush();

            } catch (Exception e) {
                /*记录错误log*/
                Map<Object, Object> log_map = new HashMap<Object, Object>();
                log_map.put("Type", "Consumer");
                log_map.put("Method", "run()");
                log_map.put("Exception_Message", Commons.getExceptionMessage(e));
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            }
        }
    }

    /**
     * 消息处理时间超过45秒
     *
     * @param putTime
     * @param msgCode
     * @param serverId
     */
    private void msgHanlderTimeout(MessageEntity entity, MsgHeader header, byte[] result1) throws Exception {
        long putTime = entity.getPutTime();
        Channel channel = entity.getChannel();
        int serverId = ServerIpCache.tempServerList.get(channel);
        long nowTime = System.currentTimeMillis();
        long diffValue = nowTime - putTime;
        long diffInQueValue = nowTime - entity.getInQueueTime();

        //exception_logger.error("diffValue:" + String.valueOf(diffValue) + ",QueueNUm:" + deductQointDataQueue.size() + ",inQueTime:" + diffInQueValue);

        if (diffValue > CommonConstants.MSG_HANDLER_TIME_OUT_MILLISECOND) {
            //发送预警邮件
            long earlyWarningTime = CommonConstants.getEARLY_WARNING_TIME();
            long diffEarlyWarningTime = nowTime - earlyWarningTime;


            if (diffEarlyWarningTime > CommonConstants.EARLY_WARNING_TIME_MILLISECOND) {
                CommonConstants.setEARLY_WARNING_TIME(nowTime);
                //发送预警邮件
                // mailSenderService.autoSendMail("计费中心预警", "客户端请求处理时间超过预警阀值, 请检查!");
                Map<Object, Object> log_map = new HashMap<Object, Object>();
                log_map.put("serverId", serverId);
                log_map.put("milliSecond", diffValue);
                log_map.put("MsgHeader", header);
                log_map.put("Msg", result1);
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            }
        }
    }
}
