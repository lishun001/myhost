package com.rs.obp;

import com.rs.obp.utils.SpringContext;

/**
 * Hello world!
 *
 */
public class App {

    private static final String START_CONFIG_FILE = "classpath*:META-INF/spring/applicationContext.xml";

    public static void main(String[] args) throws InterruptedException {
        //加载spring
        SpringContext.inizSpringCtx(START_CONFIG_FILE);

        //启动tcpServer
        Thread tcpServerThread = new Thread(new TcpServerThread());
        tcpServerThread.start();

        //启动httpServer
        Thread httpServerThread = new Thread(new HttpServerThread());
        httpServerThread.start();



    }
}
