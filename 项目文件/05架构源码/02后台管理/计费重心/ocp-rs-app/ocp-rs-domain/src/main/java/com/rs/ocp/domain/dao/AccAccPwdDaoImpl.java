/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.AccAccpwd;
import com.rs.ocp.domain.endity.AccAccpwdExample;
import com.rs.ocp.domain.mappers.AccAccpwdMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wangxinming
 */
@Repository(value = "accAccPwdDao")
public class AccAccPwdDaoImpl implements AccAccPwdDao {

    @Autowired
    private AccAccpwdMapper accAccpwdMapper;

    public AccAccpwd getAccAccpwdByPid(int pid) throws Exception {
        AccAccpwdExample exp = new AccAccpwdExample();
        exp.createCriteria().andAccpwdAccidEqualTo(pid);
        List<AccAccpwd> result = accAccpwdMapper.selectByExample(exp);
        return result.size() > 0 ? result.get(0) : null;
    }

    public boolean insertAccAccpwd(AccAccpwd accAccpwd) throws Exception {
        int result = accAccpwdMapper.insert(accAccpwd);
        return result == 1;
    }

    public boolean updateAccAccpwd(AccAccpwd accAccpwd) throws Exception {
        int result = accAccpwdMapper.updateByPrimaryKey(accAccpwd);
        return result == 1;
    }
}
