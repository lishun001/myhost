/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.PpMbcard;

/**
 *
 * @author wangxinming
 */
public interface PpMdcardDao {
     public PpMbcard getPpMbcardByPidAndStatus(int pid,int status) throws Exception;
}
