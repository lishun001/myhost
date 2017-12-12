/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.GameLoginsession;
import com.rs.ocp.domain.endity.GameLoginsessionExample;
import com.rs.ocp.domain.mappers.GameLoginsessionMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhaoweixing
 */
@Repository(value = "gameLoginSessionDao")
public class GameLoginSessionDaoImpl implements GameLoginSessionDao {

    @Autowired
    private GameLoginsessionMapper gameLoginSessionDaoMapper;

    @Override
    public void insert(GameLoginsession entity) throws Exception {
        gameLoginSessionDaoMapper.insert(entity);
    }

    public void delGameLoginsession(int serverId) throws Exception {
        GameLoginsessionExample exp = new GameLoginsessionExample();
        exp.createCriteria().andSessionServeridEqualTo(serverId);
        gameLoginSessionDaoMapper.deleteByExample(exp);
    }

    @Override
    public GameLoginsession validateLogin(int pId, int serverId) throws Exception {
        GameLoginsessionExample exp = new GameLoginsessionExample();
        exp.createCriteria().andSessionPidEqualTo(pId).andSessionServeridEqualTo(serverId);
        //List<GameLoginsession> result = gameLoginSessionDaoMapper.selectByExample(exp);
        List<GameLoginsession> result = gameLoginSessionDaoMapper.selectByExampleLimit1(exp);
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public GameLoginsession validateLogin(int pid, String sessionKey) throws Exception {
        GameLoginsessionExample exp = new GameLoginsessionExample();
        exp.createCriteria().andSessionPidEqualTo(pid).andSessionKeyEqualTo(sessionKey);
        //List<GameLoginsession> result = gameLoginSessionDaoMapper.selectByExample(exp);
        List<GameLoginsession> result = gameLoginSessionDaoMapper.selectByExampleLimit1(exp);
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public boolean removeSession(GameLoginsession gameLoginsession) throws Exception {
        //具有validateLogin功能
        int result = gameLoginSessionDaoMapper.deleteByPrimaryKey(gameLoginsession.getSessionId());
        return result == 1;
    }

    public List<GameLoginsession> getGameLoginsessionByServerId(int serverId) throws Exception {
        GameLoginsessionExample exp = new GameLoginsessionExample();
        exp.createCriteria().andSessionServeridEqualTo(serverId);
        List<GameLoginsession> result = gameLoginSessionDaoMapper.selectByExample(exp);
        return result;
    }
}
