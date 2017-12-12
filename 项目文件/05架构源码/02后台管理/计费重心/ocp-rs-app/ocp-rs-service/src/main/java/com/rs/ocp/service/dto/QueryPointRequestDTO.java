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
public class QueryPointRequestDTO extends RequestDTO {

    private static Logger logger = LoggerFactory.getLogger(QueryPointRequestDTO.class);
    private int accountId;

    public QueryPointRequestDTO(byte[] msg) {
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
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "QueryPointRequestDTO{" + super.toString() + "accountId=" + accountId + '}';
    }
}
