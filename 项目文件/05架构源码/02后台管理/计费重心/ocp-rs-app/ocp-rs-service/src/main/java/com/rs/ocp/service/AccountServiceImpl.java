/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service;

import com.rs.ocp.domain.dao.AccAountDao;
import com.rs.ocp.domain.dao.GameLoginSessionDao;
import com.rs.ocp.domain.dao.GameServerDao;
import com.rs.ocp.domain.dao.PpFcmTotaltimeDao;
import com.rs.ocp.domain.dao.PpPassportDao;
import com.rs.ocp.domain.endity.AccAccount;
import com.rs.ocp.domain.endity.GameLoginsession;
import com.rs.ocp.domain.endity.GameServer;
import com.rs.ocp.domain.endity.PpFcmTotaltime;
import com.rs.ocp.domain.endity.PpPassport;
import com.rs.ocp.domain.utils.DomainConfConst;
import com.rs.ocp.service.conf.CommonConstants;
import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.conf.ResponseCodeConst;
import com.rs.ocp.service.dto.DeductQointRequestDTO;
import com.rs.ocp.service.dto.DeductQointResponseDTO;
import com.rs.ocp.service.dto.MsgHeader;
import com.rs.ocp.service.dto.QueryPointRequestDTO;
import com.rs.ocp.service.dto.QueryPointResponseDTO;
import com.rs.ocp.service.utils.CacheLockUtil;
import com.rs.ocp.service.utils.Commons;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zhaoweixing
 */
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    private static Logger exception_logger = LoggerFactory.getLogger("exception_logger");
    @Autowired
    private AccAountDao accAountDao;
    @Autowired
    private PpPassportDao passportDao;
    @Autowired
    private PpFcmTotaltimeDao ppFcmTotaltimeDao;
    @Autowired
    private GameServerDao gameServerDao;
    @Autowired
    private GameLoginSessionDao gameLoginSessionDao;
    @Autowired
    private PpPassportService ppPassportService;
    @Autowired
    private GameServerService gameServerService;


    @Override
    public AccAccount getAccAccountByPidAndServerId(int pId, int serverId) throws Exception {
        return accAountDao.getAccAccountByPidAndServerid(pId, serverId);
    }

    @Override
    public QueryPointResponseDTO QueryPoint(QueryPointRequestDTO requestDto) throws Exception {
        QueryPointResponseDTO responseDTO = new QueryPointResponseDTO();
        try {
            MsgHeader requestHeader = requestDto.getHeader();

            MsgHeader responsetHeader = new MsgHeader();
            responsetHeader.setMessageVersion(requestHeader.getMessageVersion());
            responsetHeader.setMessageUserID(requestHeader.getMessageUserID());
            responsetHeader.setMessageReserved(requestHeader.getMessageReserved());
            responsetHeader.setMessageCode(MessageConfConst.MSG_CODE_BACK_RET_POINTS);
            responseDTO.setHeader(responsetHeader);

            int gameServerId = requestDto.getGameServerId();
            int aId = requestDto.getAccountId();
            responseDTO.setAccountId(aId);

            AccAccount accAcount = getAccAccountByPidAndServerId(requestDto.getAccountId(), gameServerId);
            if (accAcount != null) {
                int accountStatus = ppPassportService.checkPpPassportStatus(accAcount.getAccountPid(), accAcount.getAccountGameid());
                if (ResponseCodeConst.OUTER_RESULT_SUCCEED != accountStatus) {
                    /*登陆失败:账户状态验证不通过*/
                    responseDTO.setResult(accountStatus);
                    return responseDTO;
                }

                responseDTO.setPoint(accAcount.getAccountPoints());
                responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
            } else {
                responseDTO.setResult(ResponseCodeConst.CAS_ERR_UNACTIVE);
            }
            return responseDTO;
        } catch (Exception e) {
            responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);

            /*记录错误log*/
            Map<Object, Object> log_map = new HashMap<Object, Object>();
            log_map.put("Type", "AccountService");
            log_map.put("Method", "QueryPoint()");
            log_map.put("requestDTO", requestDto.toString());
            log_map.put("Exception_Message", Commons.getExceptionMessage(e));
            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            return responseDTO;
        }
    }

    @Override
    public DeductQointResponseDTO deductQoint(DeductQointRequestDTO dto) throws Exception {
//        awake =0，计费检测没通过       
//        awake =1，表明点数即将用完，points为剩余点数
//        awake =2，点数已经用完，直接断开客户端
//        awake =3，帐号为防沉迷帐号，points为防沉迷累积秒数
//        awake =3, points=-1 终止防沉迷
//        awake =4，帐号为试玩帐号，points为0
//        awake =4，points=-1 终止试玩
//        awake =5，扣款成功
        int aId = dto.getAccountId();
        DeductQointResponseDTO responseDTO = new DeductQointResponseDTO();

        MsgHeader requestHeader = dto.getHeader();
        MsgHeader newMsgHeader = Commons.getNewMsgHeader(requestHeader, MessageConfConst.MSG_CODE_BACK_RENEW);
        responseDTO.setHeader(newMsgHeader);
        int gameServerId = dto.getGameServerId();

        responseDTO.setLimit(23);
        responseDTO.setAccountId(aId);

        GameLoginsession gameLoginsession = gameLoginSessionDao.validateLogin(dto.getAccountId(), dto.getSessionKey());
        if (null == gameLoginsession) {
            responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_FAILED);
            responseDTO.setLimit(24);
            responseDTO.setAwake(CommonConstants.DEDUCT_QPINT_FAIL);
            return responseDTO;
        }



        int gmLevel = dto.getGmLevel();
        if (gmLevel > 0) {
            //是gm账号，返回正常扣点，固定点数
            responseDTO.setAwake(CommonConstants.NORMAL);
            responseDTO.setPoints(1000);
            responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
            return responseDTO;
        }

        AccAccount accAcount = getAccAccountByPidAndServerId(aId, gameServerId);
//        ReentrantLock reentrantLock = CacheLockUtil.getReentrantLock(accAcount.getAccountId());
//        reentrantLock.lock();
        try {
            if (null == accAcount) {
                //找不到该账户
                responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_FAILED);
                responseDTO.setLimit(25);
                responseDTO.setAwake(CommonConstants.DEDUCT_QPINT_FAIL);
                return responseDTO;
            }


            //平台账户状态验证pp_status表  statusType封号标示= 1;官方冻结标示 = 2;玩家申请冻结标示 = 3;
            //状态验证通不过的话，游戏会踢下线（此处要和游戏服务器确认）
            //运营平台封号会发踢下线指令
//            int accountStatus = ppPassportService.checkPpPassportStatus(aId, accAcount.getAccountGameid());
//            if (ResponseCodeConst.OUTER_RESULT_SUCCEED != accountStatus) {
//                /*登陆失败:账户状态验证不通过*/
//                //返回点数为0，awake
//                responseDTO.setResult(accountStatus);
//                responseDTO.setLimit(26);
//                responseDTO.setAwake(ResponseCodeConst.OUTER_RESULT_FAILED);
//                return responseDTO;
//            }

            if (Commons.IS_OPEN_FCM) {
                PpPassport passport = passportDao.getPpPassportByPid(aId);
                if (null == passport) {
                    //找不到该账号
                    responseDTO.setResult(ResponseCodeConst.CAS_ERR_NO_PASSPORT);
                    responseDTO.setLimit(28);
                    responseDTO.setAwake(CommonConstants.DEDUCT_QPINT_FAIL);
                    return responseDTO;
                }

                String passportFlag = passport.getPassportFlag();
                //终止防沉迷
                if (DomainConfConst.END_FCM_PASSPORT.equals(passportFlag)) {
                    responseDTO.setLimit(32);
                    responseDTO.setAwake(3);
                    responseDTO.setPoints(DomainConfConst.END_STATE);

                    passport.setPassportFlag(DomainConfConst.IS_NOT_FCM_PASSPORT);
                    passportDao.updatePpPassport(passport);
                    return responseDTO;
                }

                if (DomainConfConst.IS_FCM_PASSPORT.equals(passportFlag)) {
                    //账号为防沉迷账号
                    GameServer gameServer = gameServerDao.getGameServerById(gameServerId);
                    if (null == gameServer) {
                        /*游戏服务器ID不可识别*/
                        responseDTO.setResult(ResponseCodeConst.CAS_ERR_SERVER_ID);
                        responseDTO.setAwake(CommonConstants.DEDUCT_QPINT_FAIL);
                        responseDTO.setLimit(30);
                        return responseDTO;
                    }
                    //检测服务器状态
//                    int gameServerStatus = gameServerService.checkGameServerStatus(gameServer);
//                    if (ResponseCodeConst.OUTER_RESULT_SUCCEED != gameServerStatus) {
//                        responseDTO.setResult(gameServerStatus);
//                        responseDTO.setLimit(30);
//                        return responseDTO;
//                    }

                    PpFcmTotaltime ppFcmTotaltime = ppFcmTotaltimeDao.getPpFcmTotaltimeByPid(passport.getPassportPid(), gameServer.getServerGameid());
                    if (null == ppFcmTotaltime) {
                        /*获取防沉迷数据失败*/
                        responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_FAILED);
                        responseDTO.setAwake(CommonConstants.DEDUCT_QPINT_FAIL);
                        responseDTO.setLimit(31);
                        return responseDTO;
                    }

                    long nowTime = System.currentTimeMillis() / 1000;
                    //累计在线时长
                    int fcmOnlinetime = ppFcmTotaltime.getFcmOnlinetime();
                    //上线时刻
                    // int fcmLogintime = ppFcmTotaltime.getFcmLogintime();
                    Date fcmLogintimeDate = ppFcmTotaltime.getFcmLogintime();
                    int fcmLogintime = (int) (fcmLogintimeDate.getTime() / 1000);

                    //计算防沉迷累计秒数
                    //当前时间-登录时间+登出时间
                    int ppFcmTotaltimeSeconds = (int) (nowTime - fcmLogintime) + fcmOnlinetime;

                    responseDTO.setPoints(ppFcmTotaltimeSeconds);

                    getAwakeByPoint(accAcount, responseDTO, CommonConstants.IS_FCM);

                    return responseDTO;
                }
            }

            int isRmb = accAcount.getAccountIsrmb();
            //发送试玩终止
            if (isRmb == DomainConfConst.END_NOT_ACCOUNT_RMB) {
                responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
                responseDTO.setLimit(27);
                responseDTO.setAwake(4);
                responseDTO.setPoints(DomainConfConst.END_STATE);

                accAcount.setAccountIsrmb(1);

                accAountDao.updateAccAccountPoint(accAcount);
                return responseDTO;
            }
            if (DomainConfConst.IS_NOT_ACCOUNT_RMB == isRmb) {
                //试玩
                getAwakeByPoint(accAcount, responseDTO, CommonConstants.IS_TRY_PLAY);
                return responseDTO;
            }
            //付费玩家
            getAwakeByPoint(accAcount, responseDTO, CommonConstants.NORMAL);
            return responseDTO;
        } catch (Exception e) {
            //非预期异常
            responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);

            /*记录错误log*/
            Map<Object, Object> log_map = new HashMap<Object, Object>();
            log_map.put("Type", "AccountService");
            log_map.put("Method", "deductQoint()");
            log_map.put("requestDTO", dto.toString());
            log_map.put("Exception_Message", Commons.getExceptionMessage(e));
            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            return responseDTO;
        }
//        finally {
//            reentrantLock.unlock();
//        }
    }

    private void getAwakeByPoint(AccAccount accAcount, DeductQointResponseDTO responseDTO, int type) throws Exception {
        int point = accAcount.getAccountPoints();
        if (point < CommonConstants.MINUTE_DEDUCT_QOINT) {
            //点数已经用完
            responseDTO.setAwake(CommonConstants.POINT_NOT_ENOUGH);
            responseDTO.setPoints(point);
            responseDTO.setResult(ResponseCodeConst.CAS_ERR_EXPIRED);
            return;
        }

        //合法扣款
        int newPoint = point - CommonConstants.MINUTE_DEDUCT_QOINT;
        accAcount.setAccountPoints(newPoint);

        boolean updateResult = accAountDao.updateAccAccountPoint(accAcount);
        if (!updateResult) {
            //数据库更新失败
            responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
            double tempLimit = 23.08;
            responseDTO.setLimit(tempLimit);
            return;
        }

        if (newPoint == CommonConstants.REMIND_RUN_OUT_QOINT_NUM_300 || newPoint == CommonConstants.REMIND_RUN_OUT_QOINT_NUM_180 || newPoint == CommonConstants.REMIND_RUN_OUT_QOINT_NUM_60
                || newPoint == CommonConstants.REMIND_RUN_OUT_QOINT_NUM_5 || newPoint == CommonConstants.REMIND_RUN_OUT_QOINT_NUM_3 || newPoint == CommonConstants.REMIND_RUN_OUT_QOINT_NUM_2
                || newPoint == CommonConstants.REMIND_RUN_OUT_QOINT_NUM_1) {
            //300点180点60点各预警一次
            //点数即将用完
            responseDTO.setAwake(CommonConstants.POINT_WILL_RUN_OUT);
            responseDTO.setPoints(newPoint);
            responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
            return;
        }
        if (newPoint == 0) {
            //点数已经用完
            responseDTO.setAwake(CommonConstants.POINT_NOT_ENOUGH);
            responseDTO.setPoints(newPoint);
            responseDTO.setResult(ResponseCodeConst.CAS_ERR_EXPIRED);
            return;
        }


        if (type == CommonConstants.IS_FCM) {
            //如果是防沉迷用户
            responseDTO.setAwake(CommonConstants.IS_FCM);
            responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
            return;
        }
        if (type == CommonConstants.IS_TRY_PLAY) {
            //如果是试玩用户
            responseDTO.setAwake(CommonConstants.IS_TRY_PLAY);
            responseDTO.setPoints(newPoint);
            responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
            return;
        }

        //非防沉迷用户
        responseDTO.setAwake(CommonConstants.NORMAL);
        responseDTO.setPoints(newPoint);
        responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
    }

   
//    @Override
//    public int checkAccAccountStatus(AccAccount accAccount) throws Exception {
//        Map<Object, Object> log_map = null;
//        if (accAccount.getAccountStatus() == DomainConfConst.ACCOUNT_STATUS_LOCKED) {
//            /*登陆失败:账户锁定(玩家自己锁定)*/
//
//            return ResponseCodeConst.OUTER_ERR_UNEXPECT;
//        }
//        if (accAccount.getAccountStatus() == DomainConfConst.ACCOUNT_STATUS_FROZEN) {
//            /*登陆失败:账户冻结(官方暂时冻结)*/
//            log_map = new HashMap<Object, Object>();
//            log_map.put("Type", "AccountService");
//            log_map.put("Method", "checkAccAccountStatus()");
//            log_map.put("Respose_Code", ResponseCodeConst.CAS_ERR_PASSPORT_BLOCK);
//            log_map.put("AccAccount_Pid", accAccount.getAccountPid());
//            log_map.put("AccAccount_Aid", accAccount.getAccountId());
//            log_map.put("AccAccount_Sid", accAccount.getAccountServerid());
//            log_map.put("AccAccount_Pot", accAccount.getAccountPoints());
//            log_map.put("AccAccount_Status", accAccount.getAccountStatus());
//            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
//            return ResponseCodeConst.OUTER_ERR_UNEXPECT;
//        }
//        if (accAccount.getAccountStatus() == DomainConfConst.ACCOUNT_STATUS_FROZEN_FOREVER) {
//            /*登陆失败:账户停封(官方永久停封)---自定义code,统一记录到日志中, 并统一返回非预期错误*/
//            log_map = new HashMap<Object, Object>();
//            log_map.put("Type", "AccountService");
//            log_map.put("Method", "checkAccAccountStatus()");
//            log_map.put("Respose_Code", Customer_ResponseCodeConst.CAS_ERR_PASSPORT_BLOCK_FOREVER);
//            log_map.put("AccAccount_Pid", accAccount.getAccountPid());
//            log_map.put("AccAccount_Aid", accAccount.getAccountId());
//            log_map.put("AccAccount_Sid", accAccount.getAccountServerid());
//            log_map.put("AccAccount_Pot", accAccount.getAccountPoints());
//            log_map.put("AccAccount_Status", accAccount.getAccountStatus());
//            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
//            return ResponseCodeConst.OUTER_ERR_UNEXPECT;
//            //return Customer_ResponseCodeConst.CAS_ERR_PASSPORT_BLOCK_FOREVER;
//        }
//        if (accAccount.getAccountStatus() == DomainConfConst.ACCOUNT_STATUS_DELETE) {
//            /*登陆失败:账户删除---自定义code,统一记录到日志中, 并统一返回非预期错误*/
//            log_map = new HashMap<Object, Object>();
//            log_map.put("Type", "AccountService");
//            log_map.put("Method", "checkAccAccountStatus()");
//            log_map.put("Respose_Code", Customer_ResponseCodeConst.CAS_ERR_PASSPORT_DELETE);
//            log_map.put("AccAccount_Pid", accAccount.getAccountPid());
//            log_map.put("AccAccount_Aid", accAccount.getAccountId());
//            log_map.put("AccAccount_Sid", accAccount.getAccountServerid());
//            log_map.put("AccAccount_Pot", accAccount.getAccountPoints());
//            log_map.put("AccAccount_Status", accAccount.getAccountStatus());
//            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
//            return ResponseCodeConst.OUTER_ERR_UNEXPECT;
//        }
//        return ResponseCodeConst.OUTER_RESULT_SUCCEED;
//    }
}
