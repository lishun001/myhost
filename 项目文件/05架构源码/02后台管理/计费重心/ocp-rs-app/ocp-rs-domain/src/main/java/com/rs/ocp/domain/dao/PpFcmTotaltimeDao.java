/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.PpFcmTotaltime;

/**
 *
 * @author zhaoweixing
 */
public interface PpFcmTotaltimeDao {

    public PpFcmTotaltime getPpFcmTotaltimeByPid(int pid, int gamaid) throws Exception;

    public boolean updatePpFcmTotaltime(PpFcmTotaltime pfi) throws Exception;

    public boolean insertPpFcmTotaltime(PpFcmTotaltime pfi) throws Exception;
    
}
