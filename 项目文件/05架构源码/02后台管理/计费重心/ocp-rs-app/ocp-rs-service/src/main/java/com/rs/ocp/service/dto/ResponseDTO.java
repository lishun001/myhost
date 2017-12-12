/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.dto;

import java.util.List;

/**
 *
 * @author zhaoweixing
 */
public class ResponseDTO {

    private MsgHeader header;
    private byte[] msg;
    List<byte[]> list;
    

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

    public List<byte[]> getList() {
        return list;
    }

    public void setList(List<byte[]> list) {
        this.list = list;
    }
    
    public byte[] getBytes() throws Exception{
        return msg;
    }

    @Override
    public String toString() {
        return header.toString();
    }
}
