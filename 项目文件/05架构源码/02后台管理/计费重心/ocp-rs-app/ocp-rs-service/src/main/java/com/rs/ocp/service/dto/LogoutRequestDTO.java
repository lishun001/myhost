/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.dto;

import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.utils.Commons;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author zhaoweixing
 */
public class LogoutRequestDTO extends RequestDTO {

    private static Logger logger = LoggerFactory.getLogger(LogoutRequestDTO.class);
    private int accountId;
    private String sessionKey;
    private int gmlevel;
    private String account;
    private String password;

    public LogoutRequestDTO(byte[] msg) {
        super(msg);
        byte[] bodys = ArrayUtils.subarray(msg, MessageConfConst.MSG_HEAD_LENGTH, msg.length);
        resolveMessageBody(bodys);
    }

    @Override
    public void resolveMessageBody(byte[] msg) {
        list = new ArrayList<byte[]>();
        getChildren(msg);
        for (byte[] b : list) {
            logger.debug("field is -------------->" + Arrays.toString(b));
        }
        accountId = Commons.bytesToInt(list.get(0));
        sessionKey = new String(list.get(1));
        gmlevel = Commons.bytesToInt(list.get(2));
        account = Commons.getGbkByBytes(list.get(3));
        password = new String(list.get(4));
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getGmlevel() {
        return gmlevel;
    }

    public void setGmlevel(int gmlevel) {
        this.gmlevel = gmlevel;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LogoutRequestDTO{" + super.toString() + "accountId=" + accountId + ", sessionKey=" + sessionKey + ", gmlevel=" + gmlevel
                + ", account=" + account + ", password=" + password + '}';
    }
}
