/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.AccAccount;

/**
 *
 * @author zhaoweixing
 */
public interface AccAountDao {

    
    
    public AccAccount getAccAccountByPidAndServerid(int pid, int serverid) throws Exception;
    
    /**
     * 更新账号
     */
    public boolean updateAccAccountPoint(AccAccount record) throws Exception;
}
