/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service;

import com.rs.ocp.domain.dao.GameServerDao;
import com.rs.ocp.domain.dao.GameServerLogDao;
import com.rs.ocp.domain.endity.GameServer;
import com.rs.ocp.domain.endity.GameServerLog;
import com.rs.ocp.domain.utils.DomainConfConst;
import com.rs.ocp.domain.utils.MD5Util;
import com.rs.ocp.service.conf.Customer_ResponseCodeConst;
import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.conf.ResponseCodeConst;
import com.rs.ocp.service.dto.RegGameServerRequestDTO;
import com.rs.ocp.service.dto.RegGameServerResponseDTO;
import com.rs.ocp.service.dto.MsgHeader;
import com.rs.ocp.service.dto.UnregGameServerRequestDTO;
import com.rs.ocp.service.dto.UnregGameServerResponseDTO;
import com.rs.ocp.service.utils.Commons;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zhaoweixing
 */
@Service(value = "gameServerService")
public class GameServerServiceImpl implements GameServerService {

    private static Logger exception_logger = LoggerFactory.getLogger("exception_logger");
    @Autowired
    private GameServerDao gameServerDao;
    @Autowired
    private GameServerLogDao gameServerLogDao;

    /*注册服务器*/
    @Override
    public RegGameServerResponseDTO registerGameServer(RegGameServerRequestDTO requestDTO) throws Exception {

        RegGameServerResponseDTO gameServerResponseDTO = new RegGameServerResponseDTO();
        try {
            MsgHeader requestHesder = requestDTO.getHeader();
            MsgHeader responsetHeader = new MsgHeader();
            responsetHeader.setMessageVersion(requestHesder.getMessageVersion());
            responsetHeader.setMessageUserID(requestHesder.getMessageUserID());
            responsetHeader.setMessageReserved(requestHesder.getMessageReserved());
            responsetHeader.setMessageCode(MessageConfConst.MSG_CODE_BACK_REG);
            //"/192.168.2.175:52492"

            gameServerResponseDTO.setHeader(responsetHeader);
            /*验证发送消息格式是否正确:MD5密码(::sprintf(buf, "%d1%d%d%d%d", ServerId, 10, 1, 0, 0);)*/
            if (!validateGameServerByMd5(requestDTO)) {
                /*CAS_ERR_SERVER_ID = 50001; 游戏服务器ID不可识别*/
                gameServerResponseDTO.setResult(ResponseCodeConst.CAS_ERR_SERVER_ID);
            } else {
                String[] ipStr=requestDTO.getIp().split(":");
                String ip=ipStr[0].substring(1, ipStr[0].length());
                GameServer gameServer = gameServerDao.getGameServerByIdAndIp(requestDTO.getServerId(),ip);
                if (gameServer != null) {
                    int gameServerStatus = checkGameServerStatus(gameServer);

                    gameServerResponseDTO.setResult(gameServerStatus);
                    //设置gameserver表server_isregist为注册状态标示
                    //                    gameServer.setServerIsregist(DomainConfConst.GAME_SERVER_REGISTER);
                    //                    boolean updateResult = gameServerDao.updateGameServer(gameServer);
                    if (gameServerStatus == ResponseCodeConst.OUTER_RESULT_SUCCEED) {
                        updateGameServerRegisterState(gameServer.getServerId(), DomainConfConst.GAME_SERVER_REGISTER);
                    }
                } else {
                    /*OUTER_RESULT_FAILED = 0*/
                    gameServerResponseDTO.setResult(ResponseCodeConst.OUTER_RESULT_FAILED);
                }

            }
            return gameServerResponseDTO;
        } catch (Exception e) {
            gameServerResponseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);

            /*记录错误log*/
            Map<Object, Object> log_map = new HashMap<Object, Object>();
            log_map.put("Type", "GameServerService");
            log_map.put("Method", "registerGameServer()");
            log_map.put("requestDTO", requestDTO.toString());
            log_map.put("Exception_Message", Commons.getExceptionMessage(e));
            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            return gameServerResponseDTO;
        }
    }

    /*注销服务器*/
    @Override
    public UnregGameServerResponseDTO unregisterGameServer(UnregGameServerRequestDTO requestDTO) throws Exception {
        UnregGameServerResponseDTO unregGameServerResponseDTO = new UnregGameServerResponseDTO();
        //game_server_log
        try {
            int gameServerId = requestDTO.getGameServerId();

            MsgHeader requestHesder = requestDTO.getHeader();
            MsgHeader responsetHeader = new MsgHeader();
            responsetHeader.setMessageVersion(requestHesder.getMessageVersion());
            responsetHeader.setMessageUserID(requestHesder.getMessageUserID());
            responsetHeader.setMessageReserved(requestHesder.getMessageReserved());
            responsetHeader.setMessageCode(MessageConfConst.MSG_CODE_BACK_UNREG);

            unregGameServerResponseDTO.setHeader(responsetHeader);

            //修改注册状态
            updateGameServerRegisterState(gameServerId, DomainConfConst.GAME_SERVER_UN_REGISTER);
            return unregGameServerResponseDTO;
        } catch (Exception e) {
            /*记录错误log*/
            Map<Object, Object> log_map = new HashMap<Object, Object>();
            log_map.put("Type", "GameServerService");
            log_map.put("Method", "unregisterGameServer()");
            log_map.put("requestDTO", requestDTO.toString());
            log_map.put("Exception_Message", Commons.getExceptionMessage(e));
            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            return unregGameServerResponseDTO;
        }
    }

    @Override
    public void updateGameServerRegisterState(int gameServerId, int state) {
        try {
            GameServer gameServer = gameServerDao.getGameServerById(gameServerId);
            if (null != gameServer) {
                gameServer.setServerIsregist(state);
                boolean updateResult = gameServerDao.updateGameServer(gameServer);
                if (!updateResult) {
                    //更新失败
                    Map<Object, Object> log_map = new HashMap<Object, Object>();
                    log_map.put("Type", "GameServerService");
                    log_map.put("Method", "updateGameServerRegisterState()");
                    log_map.put("updateResult", updateResult);
                    exception_logger.error(Commons.GaneratorJsonByMap(log_map));
                }
            } else {
                //记录日志
                Map<Object, Object> log_map = new HashMap<Object, Object>();
                log_map.put("Type", "GameServerService");
                log_map.put("Method", "updateGameServerRegisterState()");
                log_map.put("gameServerNull", null);
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            }
            //server log
            GameServerLog gameServerLog = new GameServerLog();
            gameServerLog.setLogServerid(gameServerId);
            gameServerLog.setLogTime(new Date());
            gameServerLog.setLogType(state);
            gameServerLogDao.insertGameServerLog(gameServerLog);
        } catch (Exception ex) {
            /*记录错误log*/
            Map<Object, Object> log_map = new HashMap<Object, Object>();
            log_map.put("Type", "GameServerService");
            log_map.put("Method", "updateGameServerRegisterState()");
            log_map.put("Exception_Message", Commons.getExceptionMessage(ex));
            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
        }
    }

    @Override
    public boolean validateGameServerByIp(String ip) throws Exception {
        return gameServerDao.validateGameServerIp(ip);
    }

    /*验证发送消息格式是否正确:MD5密码(::sprintf(buf, "%d1%d%d%d%d", ServerId, 10, 1, 0, 0);)*/
    @Override
    public boolean validateGameServerByMd5(RegGameServerRequestDTO requestDTO) throws Exception {
        int serverId = requestDTO.getServerId();
        String md5Response = serverId + "110100";
        String md5FromRequest = requestDTO.getPassword();
        return MD5Util.getMD5String(md5Response).equals(md5FromRequest);
    }

    @Override
    public int checkGameServerStatus(GameServer gameServer) throws Exception {
        int result;
        Map<Object, Object> log_map = null;
        switch (gameServer.getServerStatus()) {
            case DomainConfConst.SERVER_STATUS_NORMAL:
                /*OUTER_RESULT_SUCCEED = 1*/
                result = ResponseCodeConst.OUTER_RESULT_SUCCEED;
                break;
            case DomainConfConst.SERVER_STATUS_FORBID:
                /*CAS_ERR_SERVER_FORBID = 50002; 游戏服务器状态为已禁用*/
                log_map = new HashMap<Object, Object>();
                log_map.put("Type", "GameServerService");
                log_map.put("Method", "checkGameServerStatus()");
                log_map.put("Respose_Code", ResponseCodeConst.CAS_ERR_SERVER_FORBID);
                log_map.put("Game_Server_Name", gameServer.getServerName());
                log_map.put("Game_Server_Ip", gameServer.getServerIp());
                log_map.put("Game_Server_Status", gameServer.getServerStatus());
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));

                result = ResponseCodeConst.CAS_ERR_SERVER_FORBID;
                break;
            case DomainConfConst.SERVER_STATUS_BLOCKED:
                /*CAS_ERR_SERVER_MAINTENANCE = 50007; 冻结（官方暂时冻结）---自定义code,统一记录到日志中, 并统一返回非预期错误*/
                log_map = new HashMap<Object, Object>();
                log_map.put("Type", "GameServerService");
                log_map.put("Method", "checkGameServerStatus()");
                log_map.put("Respose_Code", Customer_ResponseCodeConst.CAS_ERR_SERVER_BLOCK);
                log_map.put("Game_Server_Name", gameServer.getServerName());
                log_map.put("Game_Server_Ip", gameServer.getServerIp());
                log_map.put("Game_Server_Status", gameServer.getServerStatus());
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));

                result = ResponseCodeConst.OUTER_ERR_UNEXPECT;
                break;
            case DomainConfConst.SERVER_STATUS_MAINTENANCE:
                /*CAS_ERR_SERVER_MAINTENANCE = 50005; 游戏服务器状态为维护中---自定义code,统一记录到日志中, 并统一返回非预期错误*/
                log_map = new HashMap<Object, Object>();
                log_map.put("Type", "GameServerService");
                log_map.put("Method", "checkGameServerStatus()");
                log_map.put("Respose_Code", Customer_ResponseCodeConst.CAS_ERR_SERVER_MAINTENANCE);
                log_map.put("Game_Server_Name", gameServer.getServerName());
                log_map.put("Game_Server_Ip", gameServer.getServerIp());
                log_map.put("Game_Server_Status", gameServer.getServerStatus());
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));

                result = ResponseCodeConst.OUTER_ERR_UNEXPECT;
                break;
            case DomainConfConst.SERVER_STATUS_MERGE:
                /*CAS_ERR_SERVER_MERGE = 50006; 游戏服务器状态为合服---自定义code,统一记录到日志中, 并统一返回非预期错误*/
                log_map = new HashMap<Object, Object>();
                log_map.put("Type", "GameServerService");
                log_map.put("Method", "checkGameServerStatus()");
                log_map.put("Respose_Code", Customer_ResponseCodeConst.CAS_ERR_SERVER_MERGE);
                log_map.put("Game_Server_Name", gameServer.getServerName());
                log_map.put("Game_Server_Ip", gameServer.getServerIp());
                log_map.put("Game_Server_Status", gameServer.getServerStatus());
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));

                result = ResponseCodeConst.OUTER_ERR_UNEXPECT;
                break;
            case DomainConfConst.SERVER_STATUS_DELETE:
                /*CAS_ERR_SERVER_MAINTENANCE = 50008; 删除 ---自定义code,统一记录到日志中, 并统一返回非预期错误*/
                log_map = new HashMap<Object, Object>();
                log_map.put("Type", "GameServerService");
                log_map.put("Method", "checkGameServerStatus()");
                log_map.put("Respose_Code", Customer_ResponseCodeConst.CAS_ERR_SERVER_DELETE);
                log_map.put("Game_Server_Name", gameServer.getServerName());
                log_map.put("Game_Server_Ip", gameServer.getServerIp());
                log_map.put("Game_Server_Status", gameServer.getServerStatus());
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));

                result = ResponseCodeConst.OUTER_ERR_UNEXPECT;
                break;
            default:
                /*OUTER_ERR_UNEXPECT = 1000;  非预期错误*/
                log_map = new HashMap<Object, Object>();
                log_map.put("Type", "GameServerService");
                log_map.put("Method", "checkGameServerStatus()");
                log_map.put("Respose_Code", ResponseCodeConst.OUTER_ERR_UNEXPECT);
                log_map.put("Game_Server_Name", gameServer.getServerName());
                log_map.put("Game_Server_Ip", gameServer.getServerIp());
                log_map.put("Game_Server_Status", gameServer.getServerStatus());
                exception_logger.error(Commons.GaneratorJsonByMap(log_map));

                result = ResponseCodeConst.OUTER_ERR_UNEXPECT;
                break;
        }
        return result;
    }
}
