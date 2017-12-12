/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.GameServer;
import com.rs.ocp.domain.endity.GameServerExample;
import com.rs.ocp.domain.mappers.GameServerMapper;
import com.rs.ocp.domain.utils.DomainConfConst;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhaoweixing
 */
@Repository(value = "gameServerDao")
public class GameServerDaoImpl implements GameServerDao {

    @Autowired
    private GameServerMapper gameServerMapper;

    /*
     根据serverIp获取serverId
     * 不区分服务器状态
     */
    @Override
    public GameServer getGameServerByIp(String serverIp) throws Exception {
        GameServerExample exp = new GameServerExample();
        exp.createCriteria().andServerIpEqualTo(serverIp);
        List<GameServer> result = gameServerMapper.selectByExample(exp);
        GameServer gameServer = result.size() > 0 ? result.get(0) : null;
        return gameServer == null ? null : gameServer;
    }

    @Override
    public GameServer getGameServerById(int serverId) throws Exception {
        //return gameServerMapper.selectByPrimaryKey(serverId);
        return gameServerMapper.selectByPrimaryKeyLimit1(serverId);
    }

    public GameServer getGameServerByIdAndIp(int serverId, String serverIp) throws Exception {
        GameServerExample exp = new GameServerExample();
        exp.createCriteria().andServerIdEqualTo(serverId).andServerIpEqualTo(serverIp);
        List<GameServer> result = gameServerMapper.selectByExample(exp);
        GameServer gameServer = result.size() > 0 ? result.get(0) : null;
        return gameServer == null ? null : gameServer;
        //return gameServerMapper.selectByPrimaryKey(serverId);
    }
    /*
     * 根据serverIp获取服务器状态为正常的服务器id
     */

    @Override
    public boolean validateGameServerIp(String serverIp) throws Exception {
        GameServerExample exp = new GameServerExample();
        exp.createCriteria().andServerIpEqualTo(serverIp).andServerStatusEqualTo(DomainConfConst.SERVER_STATUS_NORMAL);
        List<GameServer> result = gameServerMapper.selectByExample(exp);
        return result.size() > 0 ? true : false;
    }

    @Override
    public boolean updateGameServer(GameServer gs) throws Exception {
        int result = gameServerMapper.updateByPrimaryKey(gs);
        return result == 1;
    }
}
