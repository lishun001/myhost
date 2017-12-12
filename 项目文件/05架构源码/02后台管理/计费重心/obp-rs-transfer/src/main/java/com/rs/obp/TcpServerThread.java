/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp;

import com.rs.obp.server.tcp.TcpServer;
import com.rs.obp.utils.ServerConfig;
import com.rs.obp.utils.SpringContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wangxinming
 */
public class TcpServerThread implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(TcpServerThread.class);

    @Override
    public void run() {
        try {
            TcpServer server = SpringContext.getBean("tcpServer", TcpServer.class);
            server.start(ServerConfig.getTcpServerPort());
        } catch (Exception e) {
            logger.error("Launch Tcp Server Failure", e);
        }
    }
}
