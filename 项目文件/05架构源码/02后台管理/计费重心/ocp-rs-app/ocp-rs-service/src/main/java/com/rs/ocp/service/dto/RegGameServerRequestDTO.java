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
public class RegGameServerRequestDTO extends RequestDTO {

    private static Logger logger = LoggerFactory.getLogger(RegGameServerRequestDTO.class);
    private int gameType;
    private int serverId;
    private String serverName;
    private String password;
    private int isnewreg;
    private String ip;

    /*
     byte[] b = new byte[]{89, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
     2, 1, 0, 0, 0,
     2, -119, 0, 0, 0,
     4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0,
     4, 53, 51, 48, 53, 102, 53, 54, 99, 98, 53, 49, 102, 101, 57, 102, 54, 56, 101, 50, 99, 54, 48, 49, 55, 99, 99, 100, 102, 56, 49, 101, 48, 0,
     2, 0, 0, 0, 0};
     */
    public RegGameServerRequestDTO(byte[] msg) {
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
        gameType = Commons.bytesToInt(list.get(0));
        serverId = Commons.bytesToInt(list.get(1));
        serverName = new String(list.get(2));
        password = new String(list.get(3));
        isnewreg = Commons.bytesToInt(list.get(4));
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsnewreg() {
        return isnewreg;
    }

    public void setIsnewreg(int isnewreg) {
        this.isnewreg = isnewreg;
    }

    @Override
    public String toString() {
        return "RegGameServerRequestDTO{" + super.toString() + "gameType=" + gameType + ", serverId=" + serverId + ", serverName=" + serverName + 
                ", password=" + password + ", isnewreg=" + isnewreg + '}';
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}
