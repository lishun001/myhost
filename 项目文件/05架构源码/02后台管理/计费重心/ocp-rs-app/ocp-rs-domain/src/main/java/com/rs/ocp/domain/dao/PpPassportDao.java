/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.GameLogin;
import com.rs.ocp.domain.endity.PpPassport;

/**
 *
 * @author zhaoweixing
 */
public interface PpPassportDao {

    public PpPassport login(String username, String password) throws Exception;

    public PpPassport login(String username) throws Exception;

    /**
     * 通过通行证id获取通行证账号
     *
     * @param pid
     * @return
     * @throws Exception
     */
    public PpPassport getPpPassportByPid(int pid) throws Exception;

    public boolean insertGamelogin(GameLogin gamelogin) throws Exception;

    /**
     * 更新账户
     */
    public boolean updatePpPassport(PpPassport pp) throws Exception;
}
