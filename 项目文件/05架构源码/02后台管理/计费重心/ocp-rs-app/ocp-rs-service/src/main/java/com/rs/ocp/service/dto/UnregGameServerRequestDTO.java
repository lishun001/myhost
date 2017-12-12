/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.dto;

import com.rs.ocp.service.conf.MessageConfConst;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author zhaoweixing
 */
public class UnregGameServerRequestDTO extends RequestDTO {

    private static Logger logger = LoggerFactory.getLogger(UnregGameServerRequestDTO.class);

    public UnregGameServerRequestDTO(byte[] msg) {
        super(msg);
        byte[] bodys = ArrayUtils.subarray(msg, MessageConfConst.MSG_HEAD_LENGTH, msg.length);
        resolveMessageBody(bodys);
    }

    @Override
    public void resolveMessageBody(byte[] msg) {
    }

    @Override
    public String toString() {
        return "UnregGameServerRequestDTO{" + super.toString() + '}';
    }
}
