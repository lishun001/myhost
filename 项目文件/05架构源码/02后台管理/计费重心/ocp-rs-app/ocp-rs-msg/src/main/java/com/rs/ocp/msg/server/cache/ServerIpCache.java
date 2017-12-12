/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.msg.server.cache;

import io.netty.channel.Channel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhaoweixing
 */
public class ServerIpCache {

    public static List<String> tempServerIpList = new ArrayList<String>();
    public static Map<Channel, Integer> tempServerList = new HashMap<Channel, Integer>();

    public static int getGameServerIdByChannel(Channel c) {
        Integer result=tempServerList.get(c);
        return result;
    }
}
