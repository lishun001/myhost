/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.entity.dto;

import com.rs.obp.common.Constants;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author zhaoweixing
 */
public abstract class RequestDTO {

    private MsgHeader header;
    List<byte[]> list;
    private int gameServerId;
    private byte[] msg;

    public RequestDTO(byte[] msg) {
        this.msg = msg;
    }

    public void getChildren(byte[] msg) {
        byte[] field = null;
        byte type = msg[0];
        switch (type) {
            case 2:
                field = ArrayUtils.subarray(msg, 1, 1 + Constants.TYPE_INT_LENGTH);
                msg = ArrayUtils.subarray(msg, 1 + Constants.TYPE_INT_LENGTH, msg.length);
                break;
            case 4:
                int index = ArrayUtils.indexOf(msg, (byte) 0);
                field = ArrayUtils.subarray(msg, 1, index);
                msg = ArrayUtils.subarray(msg, index + 1, msg.length);
                break;
            case 7:
                field = ArrayUtils.subarray(msg, 1, 1 + Constants.TYPE_DOUBLE_LENGTH);
                msg = ArrayUtils.subarray(msg, 1 + Constants.TYPE_DOUBLE_LENGTH, msg.length);
                break;
            default:
                return;

        }
        list.add(field);
        if (msg.length == 0) {
            return;
        }
        getChildren(msg);
    }

    public abstract void resolveMessageBody(byte[] msg);

    public MsgHeader getHeader() {
        return header;
    }

    public void setHeader(MsgHeader header) {
        this.header = header;
    }

    public byte[] getMsg() {
        return msg;
    }

    public void setMsg(byte[] msg) {
        this.msg = msg;
    }

    public int getGameServerId() {
        return gameServerId;
    }

    public void setGameServerId(int gameServerId) {
        this.gameServerId = gameServerId;
    }

    @Override
    public String toString() {
        return header.toString();
    }
}
