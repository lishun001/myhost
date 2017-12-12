/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.dto;

import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.conf.ResponseCodeConst;
import com.rs.ocp.service.utils.Commons;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author zhaoweixing
 */
public class LoginResponseDTO extends ResponseDTO {

    private int accountType;
    private String account;
    private int result;
    private int accountId;
    private String sessionId;
    private String userName;
    private int userType;
    private String passport;
    private int point;
    private double limit;
    private int isFree;
    private String accountInfo;

    @Override
    public byte[] getBytes() throws Exception {
        byte[] msg = getMsg();
        list = new ArrayList<byte[]>();
        byte[] byte_accounttype = Commons.intToByteWithType(accountType);
        byte[] byte_account = Commons.stringToByteWithType(account);
        byte[] byte_result = Commons.intToByteWithType(result);
        byte[] byte_accountId = Commons.intToByteWithType(accountId);
        byte[] byte_sessionId = Commons.stringToByteWithType(sessionId);
        byte[] byte_userName = Commons.stringToByteWithType(userName);
        byte[] byte_userType = Commons.intToByteWithType(userType);
        byte[] byte_passport = Commons.stringToByteWithType(passport);
        byte[] byte_point = Commons.intToByteWithType(point);
        byte[] byte_limit = Commons.doubleToByteWithType(limit);
        byte[] byte_isFree = Commons.intToByteWithType(isFree);
        byte[] byte_accountInfo = Commons.stringToByteWithType(accountInfo);
        if (result == ResponseCodeConst.OUTER_RESULT_SUCCEED) {
            Collections.addAll(list, byte_accounttype, byte_account, byte_result, byte_accountId,
                    byte_sessionId, byte_userName, byte_userType, byte_passport, byte_point, byte_limit,
                    byte_isFree, byte_accountInfo);
        } else {
            Collections.addAll(list, byte_accounttype, byte_account, byte_result);
        }

        for (byte[] b : list) {
            msg = ArrayUtils.addAll(msg, b);
        }
        int dataLength = msg.length + MessageConfConst.MSG_HEAD_LENGTH - MessageConfConst.TYPE_INT_LENGTH;
        getHeader().setMessageLength(dataLength);
        msg = ArrayUtils.addAll(getHeader().getBytes(), msg);
        return msg;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public int getIsFree() {
        return isFree;
    }

    public void setIsFree(int isFree) {
        this.isFree = isFree;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    @Override
    public String toString() {
        try {
            getBytes();
        } catch (Exception e) {
        }
        if (result == ResponseCodeConst.OUTER_RESULT_SUCCEED) {
            return "LoginResponseDTO{" + super.toString() + "accountType=" + accountType + ", account=" + account + ", result=" + result + ", accountId="
                    + accountId + ", sessionId=" + sessionId + ", userName=" + userName + ", userType=" + userType + ", passport=" + passport + ", point="
                    + point + ", limit=" + limit + ", isFree=" + isFree + ", accountInfo=" + accountInfo + "}";
        } else {
            return "LoginResponseDTO{" + super.toString() + "accountType=" + accountType + ", account=" + account + ", result=" + result + ", point=" + point + "}";
        }
    }
}
