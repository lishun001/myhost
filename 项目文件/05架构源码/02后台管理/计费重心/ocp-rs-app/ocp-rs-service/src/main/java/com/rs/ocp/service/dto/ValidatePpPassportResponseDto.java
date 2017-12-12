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
 * @author wangxinming
 */
public class ValidatePpPassportResponseDto extends ResponseDTO {
//		accounttype		TYPE_INT		帐号类型
//		account 		TYPE_STRING 	account
//		result			TYPE_INT		结果,返回OUTER_RESULT_SUCCEED表示成功
//		如果成功则需要提供以下数据:
//		accid			TYPE_INT		account id
//		user_name		TYPE_STRING		用户名
//		user_type		TYPE_INT 		用户类型
//		passport		TYPE_STRING 	通行证
//		points 			TYPE_INT 		游戏点数
//		limit 			TYPE_DOUBLE 	到期日期
//		acc_info		TYPE_STRING 	帐号信息

    private int accountType;
    private String account;
    private int result;
    private int accountId;
    private String userName;
    private int userType;
    private String passport;
    private int point;
    private double limit;
    private String accountInfo;

    @Override
    public byte[] getBytes() throws Exception {
        byte[] msg = getMsg();
        list = new ArrayList<byte[]>();
        byte[] byte_accounttype = Commons.intToByteWithType(accountType);
        byte[] byte_account = Commons.stringToByteWithType(account);
        byte[] byte_result = Commons.intToByteWithType(result);
        byte[] byte_accountId = Commons.intToByteWithType(accountId);
        byte[] byte_userName = Commons.stringToByteWithType(userName);
        byte[] byte_userType = Commons.intToByteWithType(userType);
        byte[] byte_passport = Commons.stringToByteWithType(passport);
        byte[] byte_point = Commons.intToByteWithType(point);
        byte[] byte_limit = Commons.doubleToByteWithType(limit);
        byte[] byte_accountInfo = Commons.stringToByteWithType(accountInfo);
        if (result == ResponseCodeConst.OUTER_RESULT_SUCCEED) {
            Collections.addAll(list, byte_accounttype, byte_account, byte_result, byte_accountId,
                    byte_userName, byte_userType, byte_passport, byte_point, byte_limit,
                    byte_accountInfo);
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
            return "ValidatePpPassportResponseDto{" + super.toString() + "accountType=" + accountType + ", account=" + account + ", result=" + result + ", accountId="
                    + accountId + ", userName=" + userName + ", userType=" + userType + ", passport=" + passport + ", point="
                    + point + ", limit=" + limit + ", accountInfo=" + accountInfo + "}";
        } else {
            return "ValidatePpPassportResponseDto{" + super.toString() + "accountType=" + accountType + ", account=" + account + ", result=" + result + "}";
        }
    }
}
