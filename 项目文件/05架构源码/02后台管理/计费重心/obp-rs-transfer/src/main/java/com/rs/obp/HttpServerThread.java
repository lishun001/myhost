/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp;

import com.rs.obp.server.http.HttpServer;
import com.rs.obp.utils.ServerConfig;
import com.rs.obp.utils.SpringContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wangxinming
 */
public class HttpServerThread implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(HttpServerThread.class);

    @Override
    public void run() {
        try {
            HttpServer server = SpringContext.getBean("httpServer", HttpServer.class);
            server.start(ServerConfig.getHttpServerPort());
        } catch (Exception e) {
            logger.error("Launch Http Server Failure", e);
        }
    }
}
