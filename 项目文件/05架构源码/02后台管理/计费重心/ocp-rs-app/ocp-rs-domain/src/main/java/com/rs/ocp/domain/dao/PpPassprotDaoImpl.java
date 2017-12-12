/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.GameLogin;
import com.rs.ocp.domain.endity.PpPassport;
import com.rs.ocp.domain.endity.PpPassportExample;
import com.rs.ocp.domain.mappers.GameLoginMapper;
import com.rs.ocp.domain.mappers.PpPassportMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhaoweixing
 */
@Repository(value = "passportDao")
public class PpPassprotDaoImpl implements PpPassportDao {

    @Autowired
    private PpPassportMapper passportMapper;
    @Autowired
    private GameLoginMapper gameLoginMapper;

    @Override
    public PpPassport login(String username, String password) throws Exception {
        PpPassportExample exp = new PpPassportExample();
        exp.createCriteria().andPassportNameEqualTo(username).andPassportPwdEqualTo(password);
        List<PpPassport> result = passportMapper.selectByExample(exp);
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public PpPassport login(String username) throws Exception {
        PpPassportExample exp = new PpPassportExample();
        exp.or(exp.createCriteria().andPassportNameEqualTo(username));
        exp.or(exp.createCriteria().andPassportEmailEqualTo(username));
        exp.or(exp.createCriteria().andPassportPhoneEqualTo(username));
        List<PpPassport> result = passportMapper.selectByExampleLimit1(exp);
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public PpPassport getPpPassportByPid(int pid) throws Exception {
        return passportMapper.selectByPrimaryKeyLimit1(pid);
        // return passportMapper.selectByPrimaryKey(pid);
    }

    @Override
    public boolean insertGamelogin(GameLogin gamelogin) throws Exception {
        int result = gameLoginMapper.insert(gamelogin);
        return result == 1;
    }

    @Override
    public boolean updatePpPassport(PpPassport pp) throws Exception {
        int result = passportMapper.updateByPrimaryKey(pp);
        return result == 1;
    }
}
