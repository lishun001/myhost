/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.AccAccpwd;

/**
 *
 * @author wangxinming
 */
public interface AccAccPwdDao {

    public AccAccpwd getAccAccpwdByPid(int pid) throws Exception;

    public boolean insertAccAccpwd(AccAccpwd accAccpwd) throws Exception;

    public boolean updateAccAccpwd(AccAccpwd accAccpwd) throws Exception;
}
