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
public class LoginRequestDTO extends RequestDTO {

    private static Logger logger = LoggerFactory.getLogger(LoginRequestDTO.class);
    private int accountType;
    private String account;
    private String password;
    private String clientIp;
    private int port;

    /*
     byte[] b = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
     2, 1, 0, 0, 0,
     4, 116, 101, 115, 116, 48, 52, 49, 0,
     4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
     4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
     2, 22, 29, 0, 0};
     * */
    public LoginRequestDTO(byte[] msg) {
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
        accountType = Commons.bytesToInt(list.get(0));
        account = Commons.getGbkByBytes(list.get(1));

        password = new String(list.get(2));
        clientIp = new String(list.get(3));
        port = Commons.bytesToInt(list.get(4));
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "LoginRequestDTO{" + super.toString() + "accountType=" + accountType + ", account=" + account + ", password=" + password
                + ", clientIp=" + clientIp + ", port=" + port + '}';
    }
}
