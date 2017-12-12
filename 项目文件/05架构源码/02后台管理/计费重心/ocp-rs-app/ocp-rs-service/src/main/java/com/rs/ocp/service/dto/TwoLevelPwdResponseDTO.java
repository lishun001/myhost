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
public class TwoLevelPwdResponseDTO extends ResponseDTO {

    private String account;
    private int type;
    private int result;

    @Override
    public byte[] getBytes() throws Exception {
        byte[] msg = getMsg();
        list = new ArrayList<byte[]>();
        byte[] byte_account = Commons.stringToByteWithType(account);
        byte[] byte_type = Commons.intToByteWithType(getType());
        byte[] byte_result = Commons.intToByteWithType(result);

        Collections.addAll(list, byte_account, byte_type, byte_result);

        for (byte[] b : list) {
            msg = ArrayUtils.addAll(msg, b);
        }
        int dataLength = msg.length + MessageConfConst.MSG_HEAD_LENGTH - MessageConfConst.TYPE_INT_LENGTH;
        getHeader().setMessageLength(dataLength);
        msg = ArrayUtils.addAll(getHeader().getBytes(), msg);
        return msg;
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

    @Override
    public String toString() {
        try {
            getBytes();
        } catch (Exception e) {
        }
        return "LoginResponseDTO{" + super.toString() + "account=" + account + ", type=" + type + ", result=" + result + "}";
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
}
