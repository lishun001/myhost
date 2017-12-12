/*
 * To change this template, choose Tools | Templates
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
 * @author zhaoweixing
 */
public class QueryPointResponseDTO extends ResponseDTO {

    private int accountId;
    private int result;
    private int point;

    @Override
    public byte[] getBytes() throws Exception {
        byte[] msg = getMsg();
        list = new ArrayList<byte[]>();
        byte[] byte_accountId = Commons.intToByteWithType(accountId);
        byte[] byte_result = Commons.intToByteWithType(result);
        byte[] byte_point = Commons.intToByteWithType(point);
        Collections.addAll(list, byte_accountId, byte_result, byte_point);
        for (byte[] b : list) {
            msg = ArrayUtils.addAll(msg, b);
        }
        int dataLength = msg.length + MessageConfConst.MSG_HEAD_LENGTH - MessageConfConst.TYPE_INT_LENGTH;
        getHeader().setMessageLength(dataLength);
        msg = ArrayUtils.addAll(getHeader().getBytes(), msg);
        return msg;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        try {
            getBytes();
        } catch (Exception e) {
        }
        return "QueryPointResponseDTO{" + super.toString() + "accountId=" + accountId + ", result=" + result + ", point=" + point + '}';
    }
}
