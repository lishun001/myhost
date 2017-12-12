/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.entity.dto;

import com.rs.obp.common.Commons;
import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author wangxinming
 */
public class MsgHeader {

    private int messageLength;
    private int messageVersion;
    private byte[] messageUserID;
    private int messageReserved;
    private int messageCode;

    public byte[] getBytes() {
        byte[] result = ArrayUtils.addAll(Commons.intToByte(messageLength), Commons.intToByte(messageVersion));
        result = ArrayUtils.addAll(result, messageUserID);
        result = ArrayUtils.addAll(result, Commons.intToByte(messageReserved));
        result = ArrayUtils.addAll(result, Commons.intToByte(messageCode));
        return result;
    }

    public int getMessageLength() {
        return messageLength;
    }

    public void setMessageLength(int messageLength) {
        this.messageLength = messageLength;
    }

    public int getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(int messageVersion) {
        this.messageVersion = messageVersion;
    }

    public byte[] getMessageUserID() {
        return messageUserID;
    }

    public void setMessageUserID(byte[] messageUserID) {
        this.messageUserID = messageUserID;
    }

    public int getMessageReserved() {
        return messageReserved;
    }

    public void setMessageReserved(int messageReserved) {
        this.messageReserved = messageReserved;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }

    @Override
    public String toString() {
        return "MsgHeader{" + "messageLength=" + messageLength + ", messageVersion=" + messageVersion + ", messageUserID=" + Arrays.toString(messageUserID)
                + ", messageReserved=" + messageReserved + ", messageCode=0x" + Integer.toHexString(messageCode) + '}';
    }
}

