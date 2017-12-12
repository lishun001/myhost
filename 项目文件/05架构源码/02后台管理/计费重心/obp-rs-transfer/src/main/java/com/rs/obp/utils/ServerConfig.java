/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.utils;

/**
 *
 * @author wangxinming
 */
public class ServerConfig {

    // tcp服务端口
    private static int tcpServerPort;
    // HTTP服务端口
    private static int httpServerPort;

    public static int getTcpServerPort() {
        return tcpServerPort;
    }

    public static int getHttpServerPort() {
        return httpServerPort;
    }

    /**
     * @param aTcpServerPort the tcpServerPort to set
     */
    public static void setTcpServerPort(int aTcpServerPort) {
        tcpServerPort = aTcpServerPort;
    }

    /**
     * @param aHttpServerPort the httpServerPort to set
     */
    public static void setHttpServerPort(int aHttpServerPort) {
        httpServerPort = aHttpServerPort;
    }
}
