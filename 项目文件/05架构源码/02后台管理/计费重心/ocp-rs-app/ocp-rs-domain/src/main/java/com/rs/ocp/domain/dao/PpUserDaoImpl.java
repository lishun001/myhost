/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.PpUser;
import com.rs.ocp.domain.endity.PpUserExample;
import com.rs.ocp.domain.mappers.PpUserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhaoweixing
 */
@Repository(value = "ppUserDao")
public class PpUserDaoImpl implements PpUserDao {

    @Autowired
    private PpUserMapper ppUserMapper;

    @Override
    public PpUser getPpUserByPid(int pid) throws Exception{
        PpUserExample exp = new PpUserExample();
        exp.createCriteria().andUserPidEqualTo(pid);
        List<PpUser> result = ppUserMapper.selectByExample(exp);
        return result.size() > 0 ? result.get(0) : null;
    }
}
