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
public class RegGameServerResponseDTO extends ResponseDTO {

    private int result;

    @Override
    public byte[] getBytes() throws Exception {
        byte[] msg = getMsg();
        list = new ArrayList<byte[]>();
        byte[] byte_result = Commons.intToByteWithType(result);
        Collections.addAll(list, byte_result);
        for (byte[] b : list) {
            msg = ArrayUtils.addAll(msg, b);
        }
        int dataLength = msg.length + MessageConfConst.MSG_HEAD_LENGTH - MessageConfConst.TYPE_INT_LENGTH;
        getHeader().setMessageLength(dataLength);
        msg = ArrayUtils.addAll(getHeader().getBytes(), msg);
        return msg;
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
        return "RegGameServerRequestDTO{" + super.toString() + "result=" + result + '}';
    }
}
