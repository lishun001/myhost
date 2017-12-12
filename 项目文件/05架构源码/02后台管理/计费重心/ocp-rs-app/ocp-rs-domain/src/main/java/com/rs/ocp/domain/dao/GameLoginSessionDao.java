/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.GameLoginsession;
import java.util.List;

/**
 *
 * @author zhaoweixing
 */
public interface GameLoginSessionDao {

    public void insert(GameLoginsession entity) throws Exception;

    public GameLoginsession validateLogin(int pId, int serverId) throws Exception;

    public GameLoginsession validateLogin(int pid, String sessionKey) throws Exception;

    public boolean removeSession(GameLoginsession gameLoginsession) throws Exception;
    
    public void delGameLoginsession(int serverId) throws Exception;
    
    public List<GameLoginsession> getGameLoginsessionByServerId(int serverId) throws Exception;
}
