/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.PpUser;

/**
 *
 * @author zhaoweixing
 */
public interface PpUserDao {

    public PpUser getPpUserByPid(int pid) throws Exception;
}
