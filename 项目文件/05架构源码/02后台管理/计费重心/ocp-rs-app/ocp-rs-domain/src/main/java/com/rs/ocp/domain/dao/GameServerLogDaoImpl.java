/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.GameServerLog;
import com.rs.ocp.domain.mappers.GameServerLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhaoweixing
 */
@Repository(value = "GameServerLogDao")
public class GameServerLogDaoImpl implements GameServerLogDao {

    @Autowired
    private GameServerLogMapper gameServerLogMapper;

    @Override
    public boolean insertGameServerLog(GameServerLog log) {
        int result = gameServerLogMapper.insert(log);
        return result == 1;
    }
}
