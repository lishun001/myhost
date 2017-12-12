/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.GameServer;

/**
 *
 * @author zhaoweixing
 */
public interface GameServerDao {

    public GameServer getGameServerByIp(String serverIp) throws Exception;

    public GameServer getGameServerById(int serverId) throws Exception;

    public GameServer getGameServerByIdAndIp(int serverId, String serverIp) throws Exception;

    public boolean validateGameServerIp(String serverIp) throws Exception;

    /**
     * 更新GameServer
     */
    public boolean updateGameServer(GameServer gs) throws Exception;
}
