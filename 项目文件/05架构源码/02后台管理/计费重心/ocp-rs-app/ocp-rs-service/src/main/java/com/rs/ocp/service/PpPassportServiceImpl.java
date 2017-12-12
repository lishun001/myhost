/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service;

import com.rs.ocp.domain.dao.AccAccPwdDao;
import com.rs.ocp.domain.dao.GameLoginSessionDao;
import com.rs.ocp.domain.dao.GameServerDao;
import com.rs.ocp.domain.dao.PpFcmTotaltimeDao;
import com.rs.ocp.domain.dao.PpMdcardDao;
import com.rs.ocp.domain.dao.PpPassportDao;
import com.rs.ocp.domain.dao.PpStatusDao;
import com.rs.ocp.domain.endity.AccAccount;
import com.rs.ocp.domain.endity.AccAccpwd;
import com.rs.ocp.domain.endity.GameLogin;
import com.rs.ocp.domain.endity.GameLoginsession;
import com.rs.ocp.domain.endity.GameServer;
import com.rs.ocp.domain.endity.PpFcmTotaltime;
import com.rs.ocp.domain.endity.PpMbcard;
import com.rs.ocp.domain.endity.PpPassport;
import com.rs.ocp.domain.endity.PpStatus;
import com.rs.ocp.domain.utils.DomainConfConst;
import com.rs.ocp.service.conf.CommonConstants;
import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.conf.ResponseCodeConst;
import com.rs.ocp.service.dto.LoginRequestDTO;
import com.rs.ocp.service.dto.LoginResponseDTO;
import com.rs.ocp.service.dto.LogoutRequestDTO;
import com.rs.ocp.service.dto.LogoutResponseDTO;
import com.rs.ocp.service.dto.MsgHeader;
import com.rs.ocp.service.dto.TwoLevelPwdRequestDTO;
import com.rs.ocp.service.dto.TwoLevelPwdResponseDTO;
import com.rs.ocp.service.dto.ValidatePpPassportRequestDto;
import com.rs.ocp.service.dto.ValidatePpPassportResponseDto;
import com.rs.ocp.service.utils.Commons;
import com.rs.ocp.service.utils.MdCardCache;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zhaoweixing
 */
@Service(value = "passportService")
public class PpPassportServiceImpl implements PpPassportService {

    private static Logger exception_logger = LoggerFactory.getLogger("exception_logger");
    @Autowired
    private AccountService accountService;
    @Autowired
    private PpPassportDao passportDao;
    @Autowired
    private GameLoginSessionDao gameLoginSessionDao;
    @Autowired
    private PpFcmTotaltimeDao ppFcmTotaltimeDao;
    @Autowired
    private GameServerDao gameServerDao;
    @Autowired
    private PpStatusDao ppStatusDao;
    @Autowired
    private AccAccPwdDao accAccPwdDao;
    @Autowired
    private PpMdcardDao ppMdcardDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    /**
     * 进入游戏时发送（也需要验证账户和账号）
     */
    public LoginResponseDTO login(LoginRequestDTO requestDto) throws Exception {
        LoginResponseDTO responseDto = new LoginResponseDTO();
        int gameServerId = requestDto.getGameServerId();
        StringBuilder key = new StringBuilder();
        key.append(requestDto.getAccount()).append(gameServerId);
        try {
//        PpPassport passport = passportDao.login(requestDto.getAccount(), requestDto.getPassword());
            PpPassport passport = passportDao.login(requestDto.getAccount());
            MsgHeader requestHeader = requestDto.getHeader();

            MsgHeader responsetHeader = new MsgHeader();
            responsetHeader.setMessageVersion(requestHeader.getMessageVersion());
            responsetHeader.setMessageUserID(requestHeader.getMessageUserID());
            responsetHeader.setMessageReserved(requestHeader.getMessageReserved());
            responsetHeader.setMessageCode(MessageConfConst.MSG_CODE_BACK_LOGIN);
            responseDto.setHeader(responsetHeader);

            responseDto.setAccountType(requestDto.getAccountType());
            responseDto.setAccount(requestDto.getAccount());

            if (passport == null) {
                /*登陆失败:账号验证未通过*/
                responseDto.setResult(ResponseCodeConst.CAS_ERR_NO_PASSPORT);
                getMbKey(responseDto, key.toString());
                return responseDto;
            }


            boolean checkPwd = checkLoignPwd(passport.getPassportPwd(), requestDto.getPassword(), key.toString(), passport.getPassportPid());
            if (checkPwd) {
                /*登陆失败:密码错误*/
                responseDto.setResult(ResponseCodeConst.CAS_ERR_PASSPORT_PSWD);
                getMbKey(responseDto, key.toString());
                return responseDto;
            }

            responseDto.setAccount(passport.getPassportEmail());

            /*
             * 登陆成功在登陆Session表中插入一条记录
             */
            GameLoginsession gameLoginsession = gameLoginSessionDao.validateLogin(passport.getPassportPid(), gameServerId);
            /*如果未登陆过*/
            if (gameLoginsession == null) {
                /*随即产生32位SessionId*/
                String sessionKey = Commons.ganerator32Keys();
                responseDto.setSessionId(sessionKey);

                gameLoginsession = new GameLoginsession();
                gameLoginsession.setSessionKey(sessionKey);
                gameLoginsession.setSessionPid(passport.getPassportPid());
                gameLoginsession.setSessionServerid(gameServerId);
                gameLoginsession.setSessionAwake(0);
                gameLoginsession.setSessionTime(new Date());
                gameLoginSessionDao.insert(gameLoginsession);

                GameLoginsession gameLoginsession2 = gameLoginSessionDao.validateLogin(passport.getPassportPid(), gameServerId);
                gameLoginsession.setSessionId(gameLoginsession2.getSessionId());
            } else {
                responseDto.setSessionId(gameLoginsession.getSessionKey());
            }

            String gmLevel = passport.getPassportGmlevel();
            if (null != gmLevel && !CommonConstants.GM_MARK.equals(gmLevel)) {
                //gm账户
                responseDto.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);

                MdCardCache.delCards(key.toString());

                responseDto.setAccountId(passport.getPassportPid());
                responseDto.setUserType(StringUtils.isEmpty(passport.getPassportGmlevel()) ? 0 : Integer.parseInt(passport.getPassportGmlevel()));
                return responseDto;
            }
            /*----------------------------------------------*/
            /*
             * user_name,passport三个属性暂未处理
             */
            /*----------------------------------------------*/
            AccAccount accAcount = accountService.getAccAccountByPidAndServerId(passport.getPassportPid(), gameServerId);
            if (accAcount == null) {
                /*没有账户*/
                responseDto.setResult(ResponseCodeConst.CAS_ERR_UNACTIVE);
                getMbKey(responseDto, key.toString());
                return responseDto;
            }

            int pid = passport.getPassportPid();
            int passportStatus = checkPpPassportStatus(pid, accAcount.getAccountGameid());
            if (ResponseCodeConst.OUTER_RESULT_SUCCEED != passportStatus) {
                /*登陆失败:状态验证不通过*/
                responseDto.setResult(passportStatus);
                getMbKey(responseDto, key.toString());
                if (ResponseCodeConst.CAS_ERR_PASSPORT_BLOCK == passportStatus) {
                    //官方冻结，将point设置为剩余解冻秒数
                    PpStatus ps = ppStatusDao.getPpStatusByPidAndGameId(pid, accAcount.getAccountGameid());
                    if (null != ps) {
                        Date statusFrozentime = ps.getStatusFrozentime();
                        if (null != statusFrozentime) {
                            long nowTime = System.currentTimeMillis();
                            long diff = statusFrozentime.getTime() - nowTime;
                            int seconds = (int) (diff / 1000);
                            responseDto.setPoint(seconds);
                        }
                    }
                }
                return responseDto;
            }

            /*登陆成功*/
            responseDto.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);

            MdCardCache.delCards(key.toString());

            responseDto.setUserType(StringUtils.isEmpty(passport.getPassportGmlevel()) ? 0 : Integer.parseInt(passport.getPassportGmlevel()));
            responseDto.setAccountId(passport.getPassportPid());

            responseDto.setPoint(accAcount.getAccountPoints());
            responseDto.setLimit(accAcount.getAccountDeadline() == null ? 0 : accAcount.getAccountDeadline());
            int isRmb = accAcount.getAccountIsrmb();
            if (DomainConfConst.IS_ACCOUNT_RMB == isRmb) {
                //rmb玩家
                responseDto.setIsFree(0);
            } else {
                //试玩玩家
                responseDto.setIsFree(1);
            }

            /*暂时默认传0, 不查user表*/
            //int sex = 0;
            //PpUser ppUser = ppUserDao.getPpUserByPid(passport.getPassportPid());
            //if (ppUser != null) {
            //    sex = ppUser.getUserSex();
            //}
            //StringBuilder accoutnInfo = new StringBuilder();
                /*暂时默认传1900-01-01*/
            //String birthday = Commons.getBirthdayByIdentity(passport.getPassportIdentity());
            // String birthday = "1900-01-01";
            GameServer gameServer = gameServerDao.getGameServerById(gameServerId);

            String T = "-1";
            //防沉迷用户
            if (Commons.IS_OPEN_FCM) {
                if (passport.getPassportFlag().equals(DomainConfConst.IS_FCM_PASSPORT)) {
                    PpFcmTotaltime ppFcmTotaltime = ppFcmTotaltimeDao.getPpFcmTotaltimeByPid(passport.getPassportPid(), gameServer.getServerGameid());
                    if (ppFcmTotaltime != null) {
                        int nowTime = (int) (System.currentTimeMillis() / 1000);
                        Date nowTimeDate = new Date();
                        //累计下线时长
                        int fcmOfflinetime = ppFcmTotaltime.getFcmOfflinetime();
                        //下线时刻
                        // int fcmLogouttime = ppFcmTotaltime.getFcmLogouttime();
                        Date fcmLogouttimeDate = ppFcmTotaltime.getFcmLogouttime();
                        int fcmLogouttime = (int) (fcmLogouttimeDate.getTime() / 1000);

                        int intervalTime = nowTime - fcmLogouttime;
                        fcmOfflinetime = fcmOfflinetime + intervalTime;
                        if (fcmOfflinetime >= CommonConstants.FCM_OFF_LINETIME_SET_UP_ZERO_NUM) {
                            //累计下线时长清0
                            //累计上线时长清0
                            fcmOfflinetime = 0;
                            ppFcmTotaltime.setFcmOnlinetime(0);
                        }
                        ppFcmTotaltime.setFcmOfflinetime(fcmOfflinetime);
                        ppFcmTotaltime.setFcmLogintime(nowTimeDate);
                        ppFcmTotaltime.setFcmPid(passport.getPassportPid());
                        ppFcmTotaltime.setFcmGameid(gameServer.getServerGameid());

                        ppFcmTotaltimeDao.updatePpFcmTotaltime(ppFcmTotaltime);
                    } else {
                        ppFcmTotaltime = new PpFcmTotaltime();
                        Date nowTime = new Date();

                        ppFcmTotaltime.setFcmOnlinetime(0);
                        ppFcmTotaltime.setFcmOfflinetime(0);
                        ppFcmTotaltime.setFcmLogintime(nowTime);
                        ppFcmTotaltime.setFcmLogouttime(nowTime);
                        ppFcmTotaltime.setFcmPid(passport.getPassportPid());
                        ppFcmTotaltime.setFcmGameid(gameServer.getServerGameid());

                        ppFcmTotaltimeDao.insertPpFcmTotaltime(ppFcmTotaltime);
                    }
                    T = String.valueOf(ppFcmTotaltime.getFcmOnlinetime());
                }
            }
            //accoutnInfo.append(sex).append(birthday).append(",").append(T).append(",");
            //responseDto.setAccountInfo(accoutnInfo.toString());
            responseDto.setAccountInfo(T);



            /*记录登陆日志*/
            GameLogin gamelogin = new GameLogin();
            gamelogin.setLoginUserid(passport.getPassportPid());
            /*gameid 和分区id未保存*/
            gamelogin.setLoginServerid(gameServerId);
            gamelogin.setLoginTime(new Date());
            gamelogin.setLoginType(DomainConfConst.TYPE_OF_LOGIN);
            //gamelogin.setLoginSessionkey(gameLoginsession.getSessionKey());
            gamelogin.setLoginSessionid(gameLoginsession.getSessionId());

            gamelogin.setLoginClientip(requestDto.getClientIp());
            gamelogin.setLoginClientport(requestDto.getPort());
            passportDao.insertGamelogin(gamelogin);

            return responseDto;
        } catch (Exception e) {
//            responseDto.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
            /*记录错误log*/
            getMbKey(responseDto, key.toString());

            Map<Object, Object> log_map = new HashMap<Object, Object>();
            log_map.put("Type", "PpPassportService");
            log_map.put("Method", "login()");
            log_map.put("requestDTO", requestDto.toString());
            log_map.put("Exception_Message", Commons.getExceptionMessage(e));
            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
//            return responseDto;
            throw e;
        }
    }

    private void getMbKey(LoginResponseDTO responseDto, String cardKey) {
        String oldCardKey = MdCardCache.getUseingCard(cardKey);
        if (null != oldCardKey) {
            //绑定密保卡
            String cardStr = Commons.getRandomMiBao();
            responseDto.setAccountInfo(cardStr);
            //缓存本次登录产生的密保序列（account+serverid）
            MdCardCache.putCards(cardKey, cardStr);
        }
    }

    private boolean checkLoignPwd(String passportPwd, String pwd, String cardKey, int pid) throws Exception {
        PpMbcard ppMbcard = ppMdcardDao.getPpMbcardByPidAndStatus(pid, CommonConstants.MBCARD_USE_SRARUS);
        if (null == ppMbcard) {
            //没有绑定密保卡
            if (!passportPwd.equals(pwd)) {
                return true;
            }

            return false;
        }

        String[] pwds = pwd.split(CommonConstants.VERTICAL);
        if (!pwds[0].equals(passportPwd)) {
            return true;
        }

        String card = MdCardCache.getUseingCard(cardKey);
        String[] sss = card.split(CommonConstants.COMMA_DECOLLATOR);
        String[][] cardValues = Commons.getMiBaoByJson(ppMbcard.getMbcardArray());

        StringBuilder values = new StringBuilder();
        for (String str : sss) {
            int[] index = DomainConfConst.getIndex(str);
            String targetValue = cardValues[index[0]][index[1]];
            values.append(targetValue).append(CommonConstants.COMMA_DECOLLATOR);
        }
        values.delete(values.length() - 1, values.length());
        if (!values.toString().equals(pwds[1])) {
            return true;
        }

        return false;
//        if (!passport.getPassportPwd().equals(requestDto.getPassword())) {
//            /*登陆失败:密码错误*/
//            responseDto.setResult(ResponseCodeConst.CAS_ERR_PASSPORT_PSWD);
//            return responseDto;
//        }
    }

    private int checkPpStatus(PpStatus ps, int gameId) {
        int statusType = ps.getStatusType();
        if (CommonConstants.CLOSED_STATE == statusType) {
            //处于封号状态
            return ResponseCodeConst.CAS_ERR_PASSPORT_FORBID;
        }
        if (CommonConstants.APPLY_FROZEN == statusType) {
            //玩家申请冻结账号（所有游戏）
            return ResponseCodeConst.CAS_ERR_PASSPORT_LOCKED;
        }
        //官方冻结指定游戏
        int statusFrozenscope = ps.getStatusFrozenscope();
        if (statusFrozenscope == gameId) {
            //官方冻结指定游戏
            Date statusFrozentime = ps.getStatusFrozentime();
            if (null != statusFrozentime) {
                Date nowTime = new Date();
                if (!Commons.isExceed(statusFrozentime, nowTime)) {
                    return ResponseCodeConst.CAS_ERR_PASSPORT_BLOCK;
                }
            }
        }
        return ResponseCodeConst.OUTER_RESULT_SUCCEED;
    }

    @Override
    public int checkPpPassportStatus(int pid, int gameId) throws Exception {
        List<PpStatus> pss = ppStatusDao.getPpStatusByPid(pid);
        if (null == pss) {
            //无该账号异常状态记录
            return ResponseCodeConst.OUTER_RESULT_SUCCEED;
        }

        for (PpStatus ps : pss) {
            int result = checkPpStatus(ps, gameId);
            if (result != ResponseCodeConst.OUTER_RESULT_SUCCEED) {
                return result;
            }
        }
        //PpStatus ps = ppStatusDao.getPpStatusByPid(pid);
        return ResponseCodeConst.OUTER_RESULT_SUCCEED;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public LogoutResponseDTO logout(LogoutRequestDTO requestDto) throws Exception {
        LogoutResponseDTO responseDto = new LogoutResponseDTO();
        try {


            MsgHeader requestHesder = requestDto.getHeader();
            int pid = requestDto.getAccountId();

            MsgHeader responsetHeader = new MsgHeader();
            responsetHeader.setMessageVersion(requestHesder.getMessageVersion());
            responsetHeader.setMessageUserID(requestHesder.getMessageUserID());
            responsetHeader.setMessageReserved(requestHesder.getMessageReserved());
            responsetHeader.setMessageCode(MessageConfConst.MSG_CODE_BACK_LOGOUT);
            responseDto.setHeader(responsetHeader);
            responseDto.setAccountId(pid);

            int gameServerId = requestDto.getGameServerId();


//            PpPassport passport = passportDao.login(requestDto.getAccount(), requestDto.getPassword());
            PpPassport passport = passportDao.getPpPassportByPid(pid);
            if (null == passport) {
                /*登出失败:账号验证未通过*/
                responseDto.setResult(ResponseCodeConst.CAS_ERR_NO_PASSPORT);
                return responseDto;
            }

            GameLoginsession gameLoginsession = gameLoginSessionDao.validateLogin(pid, requestDto.getSessionKey());
            if (gameLoginsession == null) {
                responseDto.setResult(ResponseCodeConst.OUTER_RESULT_FAILED);
                return responseDto;
            }

            gameLoginSessionDao.removeSession(gameLoginsession);
            responseDto.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);

            if (Commons.IS_OPEN_FCM) {
                if (passport.getPassportFlag().equals(DomainConfConst.IS_FCM_PASSPORT)) {
                    GameServer gameServer = gameServerDao.getGameServerById(gameServerId);
                    PpFcmTotaltime ppFcmTotaltime = ppFcmTotaltimeDao.getPpFcmTotaltimeByPid(passport.getPassportPid(), gameServer.getServerGameid());
                    if (ppFcmTotaltime != null) {
                        int nowTime = (int) (System.currentTimeMillis() / 1000);

                        Date nowTimeDate = new Date();
                        //累计在线时长
                        int fcmOnlinetime = ppFcmTotaltime.getFcmOnlinetime();
                        //上线时刻
                        //int fcmLogintime = ppFcmTotaltime.getFcmLogintime();
                        Date fcmLogintimeDate = ppFcmTotaltime.getFcmLogintime();
                        int fcmLogintime = (int) (fcmLogintimeDate.getTime() / 1000);

                        //DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss")

                        int intervalTime = nowTime - fcmLogintime;
                        fcmOnlinetime = fcmOnlinetime + intervalTime;

                        ppFcmTotaltime.setFcmOnlinetime(fcmOnlinetime);
                        ppFcmTotaltime.setFcmLogouttime(nowTimeDate);

                        ppFcmTotaltimeDao.updatePpFcmTotaltime(ppFcmTotaltime);
                    }
                }
            }

            /*记录登出日志*/
            GameLogin gamelogin = new GameLogin();
            gamelogin.setLoginUserid(pid);
            /*gameid 和分区id未保存*/
            gamelogin.setLoginServerid(gameServerId);
            gamelogin.setLoginTime(new Date());
            gamelogin.setLoginType(DomainConfConst.TYPE_OF_LOGOUT);
            //gamelogin.setLoginSessionkey(gameLoginsession.getSessionKey());
            gamelogin.setLoginSessionid(gameLoginsession.getSessionId());

            passportDao.insertGamelogin(gamelogin);

            return responseDto;

        } catch (Exception e) {
//            responseDto.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
            /*记录错误log*/
            Map<Object, Object> log_map = new HashMap<Object, Object>();
            log_map.put("Type", "PpPassportService");
            log_map.put("Method", "logout()");
            log_map.put("requestDTO", requestDto.toString());
            log_map.put("Exception_Message", Commons.getExceptionMessage(e));
            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            throw e;
//            return responseDto;
        }
    }

    @Override
    /**
     * 登录游戏时发送（需要验证账号和账户）
     */
    public ValidatePpPassportResponseDto validatePpPassport(ValidatePpPassportRequestDto requestDto) throws Exception {
        ValidatePpPassportResponseDto responseDto = new ValidatePpPassportResponseDto();
        try {
//        PpPassport passport = passportDao.login(requestDto.getAccount(), requestDto.getPassword());
            PpPassport passport = passportDao.login(requestDto.getAccount());
            MsgHeader requestHeader = requestDto.getHeader();

            MsgHeader responsetHeader = new MsgHeader();
            responsetHeader.setMessageVersion(requestHeader.getMessageVersion());
            responsetHeader.setMessageUserID(requestHeader.getMessageUserID());
            responsetHeader.setMessageReserved(requestHeader.getMessageReserved());
            responsetHeader.setMessageCode(MessageConfConst.MSG_CODE_BACK_VALIDATE_PPPASSPORT);
            responseDto.setHeader(responsetHeader);

            responseDto.setAccountType(requestDto.getAccountType());
            responseDto.setAccount(requestDto.getAccount());
            if (passport != null) {
                if (!passport.getPassportPwd().equals(requestDto.getPassword())) {
                    /*验证帐号失败:密码错误*/
                    responseDto.setResult(ResponseCodeConst.CAS_ERR_PASSPORT_PSWD);
                    return responseDto;
                }

                int passportStatus = checkPpPassportStatus(passport.getPassportPid(), CommonConstants.FOREVER_NOT_GAMEID);
                if (ResponseCodeConst.OUTER_RESULT_SUCCEED != passportStatus) {
                    /*验证帐号失败:状态验证不通过*/
                    responseDto.setResult(passportStatus);
                    return responseDto;
                }


                /*验证帐号成功*/
                responseDto.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
                responseDto.setAccountId(passport.getPassportPid());
                responseDto.setUserType(StringUtils.isEmpty(passport.getPassportGmlevel()) ? 0 : Integer.parseInt(passport.getPassportGmlevel()));


                //如验证通过且绑定密保卡,则返回密保卡列(K1,K2,K3)
                PpMbcard ppMbcard = ppMdcardDao.getPpMbcardByPidAndStatus(passport.getPassportPid(), CommonConstants.MBCARD_USE_SRARUS);
                if (null != ppMbcard) {
                    //已经绑定密保卡
                    String cardStr = Commons.getRandomMiBao();
                    responseDto.setAccountInfo(cardStr);

                    StringBuilder key = new StringBuilder();
                    int gameServerId = requestDto.getVendorId();
                    key.append(requestDto.getAccount()).append(gameServerId);
                    //缓存本次登录产生的密保序列（account+serverid）
                    MdCardCache.putCards(key.toString(), cardStr);
                }
            } else {
                /*验证帐号失败:账号验证未通过*/
                responseDto.setResult(ResponseCodeConst.CAS_ERR_NO_PASSPORT);
            }
            return responseDto;
        } catch (Exception e) {
            responseDto.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
            /*记录错误log*/
            Map<Object, Object> log_map = new HashMap<Object, Object>();
            log_map.put("Type", "PpPassportService");
            log_map.put("Method", "validatePpPassport()");
            log_map.put("requestDTO", requestDto.toString());
            log_map.put("Exception_Message", Commons.getExceptionMessage(e));
            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            return responseDto;
        }
    }

    @Override
    public void delGameLoginsession(int serverId, boolean addLogout) throws Exception {
        if (addLogout) {
            List<GameLoginsession> gls = gameLoginSessionDao.getGameLoginsessionByServerId(serverId);
            if (null != gls) {
                for (GameLoginsession gl : gls) {
                    /*记录登出日志*/
                    GameLogin gamelogin = new GameLogin();
                    gamelogin.setLoginUserid(gl.getSessionPid());
                    /*gameid 和分区id未保存*/
                    gamelogin.setLoginServerid(serverId);
                    gamelogin.setLoginTime(new Date());
                    gamelogin.setLoginType(DomainConfConst.TYPE_OF_LOGOUT);
                    //gamelogin.setLoginSessionkey(gameLoginsession.getSessionKey());
                    gamelogin.setLoginSessionid(gl.getSessionId());

                    passportDao.insertGamelogin(gamelogin);
                }
            }
        }


        gameLoginSessionDao.delGameLoginsession(serverId);
    }

    public TwoLevelPwdResponseDTO twoLevelPwd(TwoLevelPwdRequestDTO twoLevelPwdRequestDTO) throws Exception {
        TwoLevelPwdResponseDTO responseDTO = new TwoLevelPwdResponseDTO();
        try {
            MsgHeader requestHeader = twoLevelPwdRequestDTO.getHeader();

            MsgHeader responsetHeader = new MsgHeader();
            responsetHeader.setMessageVersion(requestHeader.getMessageVersion());
            responsetHeader.setMessageUserID(requestHeader.getMessageUserID());
            responsetHeader.setMessageReserved(requestHeader.getMessageReserved());
            responsetHeader.setMessageCode(MessageConfConst.MSG_CODE_BACK_TWO_LEVEL_PWD);
            responseDTO.setHeader(responsetHeader);

            int type = twoLevelPwdRequestDTO.getType();
            String account = twoLevelPwdRequestDTO.getAccount();
            String pwd = twoLevelPwdRequestDTO.getPwd();
            int gameServerId = twoLevelPwdRequestDTO.getGameServerId();

            responseDTO.setAccount(account);
            responseDTO.setType(type);

            PpPassport passport = passportDao.login(account);
            if (null == passport) {
                responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
                return responseDTO;
            }

            AccAccount accAcount = accountService.getAccAccountByPidAndServerId(passport.getPassportPid(), gameServerId);
            if (null == accAcount) {
                responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_FAILED);
                return responseDTO;
            }
            int accountStatus = checkPpPassportStatus(passport.getPassportPid(), accAcount.getAccountGameid());
            if (ResponseCodeConst.OUTER_RESULT_SUCCEED != accountStatus) {
                /*登陆失败:账户状态验证不通过*/
                responseDTO.setResult(accountStatus);
                return responseDTO;
            }
            //type:1初始密码;2验证密码;3修改密码
            //pwd:当初始和验证只传password,当为修改时,传入MD5(oldpassword)|MD5(newpassword)
            AccAccpwd accAccpwd = accAccPwdDao.getAccAccpwdByPid(accAcount.getAccountId());
            if (type == 1) {
                //初始密码(插入初始数据)
                if (null == accAccpwd) {
                    AccAccpwd aa = new AccAccpwd();
                    aa.setAccpwdAccid(accAcount.getAccountId());
                    aa.setAccpwdPwd(pwd);
                    accAccPwdDao.insertAccAccpwd(aa);

                    responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
                    return responseDTO;
                }

                responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
                return responseDTO;
            }
            if (type == 2) {
                //验证密码（验证密码）
                if (null == accAccpwd) {
                    responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
                    return responseDTO;
                }

                if (!pwd.equals(accAccpwd.getAccpwdPwd())) {
                    responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
                    return responseDTO;
                }

                responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
                return responseDTO;
            }
            if (type == 3) {
                //修改密码（修改密码）
                if (null == accAccpwd) {
                    responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
                    return responseDTO;
                }

                String[] pwdArray = pwd.split(CommonConstants.VERTICAL);
                if (!pwd.equals(pwdArray[0])) {
                    responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);
                    return responseDTO;
                }
                accAccpwd.setAccpwdPwd(pwdArray[1]);
                accAccPwdDao.updateAccAccpwd(accAccpwd);
                responseDTO.setResult(ResponseCodeConst.OUTER_RESULT_SUCCEED);
                return responseDTO;
            }

            return responseDTO;
        } catch (Exception e) {
            responseDTO.setResult(ResponseCodeConst.OUTER_ERR_UNEXPECT);

            /*记录错误log*/
            Map<Object, Object> log_map = new HashMap<Object, Object>();
            log_map.put("Type", "AccountService");
            log_map.put("Method", "twoLevelPwd()");
            log_map.put("requestDTO", twoLevelPwdRequestDTO.toString());
            log_map.put("Exception_Message", Commons.getExceptionMessage(e));
            exception_logger.error(Commons.GaneratorJsonByMap(log_map));
            return responseDTO;
        }

    }
}
