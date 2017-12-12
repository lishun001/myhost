/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.PpStatus;
import java.util.List;

/**
 *
 * @author wangxinming
 */
public interface PpStatusDao {

    /**
     * 通过账号ID获取账号状态
     *
     * @param pid
     * @return
     * @throws Exception
     */
    public List<PpStatus> getPpStatusByPid(int pid) throws Exception;
    /**
     * 查询官方冻结的游戏账户状态
     * @param pid
     * @param gameId
     * @return
     * @throws Exception 
     */
    public PpStatus getPpStatusByPidAndGameId(int pid, int gameId) throws Exception;
}
