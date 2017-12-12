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
 * @author wangxinming
 */
public class ValidatePpPassportRequestDto extends RequestDTO {

//		accounttype		TYPE_INT		帐号类型，此处固定为1
//		account 		TYPE_STRING 	account
//		password 		TYPE_STRING 	密码，分加密和不加密两种
//		ip				TYPE_STRING 	客户端ip地址
//		port 			TYPE_STRING 	客户端端口
//		VendorId		TYPE_INT 		分运营商id
    private static Logger logger = LoggerFactory.getLogger(ValidatePpPassportRequestDto.class);
    private int accountType;
    private String account;
    private String password;
    private String clientIp;
    private int port;
    private int vendorId;

    public ValidatePpPassportRequestDto(byte[] msg) {
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
        vendorId = Commons.bytesToInt(list.get(5));
    }

    /**
     * @return the accountType
     */
    public int getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the clientIp
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * @param clientIp the clientIp to set
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the vendorId
     */
    public int getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId the vendorId to set
     */
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    @Override
    public String toString() {
        return "ValidatePpPassportRequestDto{" + super.toString() + "accountType=" + accountType + ", account=" + account + ", password=" + password
                + ", clientIp=" + clientIp + ", port=" + port + ", vendorId=" + vendorId + '}';
    }
}
