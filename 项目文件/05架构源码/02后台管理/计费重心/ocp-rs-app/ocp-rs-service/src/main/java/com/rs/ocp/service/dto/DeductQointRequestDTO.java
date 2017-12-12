/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.dto;

import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.utils.Commons;
import java.util.ArrayList;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author wangxinming
 */
public class DeductQointRequestDTO extends RequestDTO {

    /**
     * account id
     */
    private int accountId;
    /**
     * 登录成功后的session key
     */
    private String sessionKey;
    /**
     * gm等级
     */
    private int gmLevel;
    /**
     * 计费信息（空）
     */
    private String chargeInfo;

    public DeductQointRequestDTO(byte[] msg) {
        super(msg);
        byte[] bodys = ArrayUtils.subarray(msg,
                MessageConfConst.MSG_HEAD_LENGTH, msg.length);
        resolveMessageBody(bodys);
    }

    @Override
    public void resolveMessageBody(byte[] msg) {
        list = new ArrayList<byte[]>();
        getChildren(msg);
//		for (byte[] b : list) {
//			logger.debug("field is -------------->" + Arrays.toString(b));
//		}
        accountId = Commons.bytesToInt(list.get(0));
        sessionKey = new String(list.get(1));
        gmLevel = Commons.bytesToInt(list.get(2));
        chargeInfo = new String(list.get(3));
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
     * @return the sessionKey
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * @param sessionKey the sessionKey to set
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * @return the gmLevel
     */
    public int getGmLevel() {
        return gmLevel;
    }

    /**
     * @param gmLevel the gmLevel to set
     */
    public void setGmLevel(int gmLevel) {
        this.gmLevel = gmLevel;
    }

    /**
     * @return the chargeInfo
     */
    public String getChargeInfo() {
        return chargeInfo;
    }

    /**
     * @param chargeInfo the chargeInfo to set
     */
    public void setChargeInfo(String chargeInfo) {
        this.chargeInfo = chargeInfo;
    }

    @Override
    public String toString() {
        return "DeductQointRequestDTO{" + super.toString() + "accountId=" + accountId + ", sessionKey=" + sessionKey + ", gmLevel=" + gmLevel + ", chargeInfo=" + chargeInfo + '}';
    }
}
