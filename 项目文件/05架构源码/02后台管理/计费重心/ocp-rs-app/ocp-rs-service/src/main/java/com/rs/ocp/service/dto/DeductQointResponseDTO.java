/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.dto;

import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.utils.Commons;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author wangxinming
 */
public class DeductQointResponseDTO extends ResponseDTO {

    private int result;

    private int accountId;

    private int awake;

    private int points;

    private double limit;

    @Override
    public byte[] getBytes() throws Exception {
        byte[] msg = getMsg();
        list = new ArrayList<byte[]>();
       // byte[] byte_result = Commons.intToByteWithType(result);
        byte[] byte_accountId = Commons.intToByteWithType(accountId);
        byte[] byte_awake = Commons.intToByteWithType(awake);
        byte[] byte_point = Commons.intToByteWithType(points);
        byte[] byte_limit = Commons.doubleToByteWithType(limit);
        Collections.addAll(list, byte_accountId, byte_awake, byte_point,
                byte_limit);
        for (byte[] b : list) {
            msg = ArrayUtils.addAll(msg, b);
        }
        int dataLength = msg.length + MessageConfConst.MSG_HEAD_LENGTH - MessageConfConst.TYPE_INT_LENGTH;
        getHeader().setMessageLength(dataLength);
        msg = ArrayUtils.addAll(getHeader().getBytes(), msg);
        return msg;
    }

    /**
     * @return the accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the awake
     */
    public int getAwake() {
        return awake;
    }

    /**
     * @param awake the awake to set
     */
    public void setAwake(int awake) {
        this.awake = awake;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the limit
     */
    public double getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(double limit) {
        this.limit = limit;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }

    //    @Override
    //    public String toString() {
    //        return "LoginResponseDTO{" + super.toString() + "accountType=" + accountType + ", account=" + account + ", result=" + result + ", accountId="
    //                + accountId + ", sessionId=" + sessionId + ", userName=" + userName + ", userType=" + userType + ", passport=" + passport + ", point="
    //                + point + ", limit=" + limit + ", isFree=" + isFree + ", accountInfo=" + accountInfo + '}';
    //    }
    @Override
    public String toString() {
        try {
            getBytes();
        } catch (Exception e) {
        }
        return "DeductQointResponseDTO{"+ super.toString() + "result=" + result + ", accountId=" + accountId + ", awake=" + awake + ", points=" + points + ", limit=" + limit + '}';
    }
    
    
}
