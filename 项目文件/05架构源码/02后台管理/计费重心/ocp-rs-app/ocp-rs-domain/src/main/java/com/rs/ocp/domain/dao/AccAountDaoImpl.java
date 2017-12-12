/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.AccAccount;
import com.rs.ocp.domain.endity.AccAccountExample;
import com.rs.ocp.domain.mappers.AccAccountMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhaoweixing
 */
@Repository(value = "accAountDao")
public class AccAountDaoImpl implements AccAountDao {

    @Autowired
    private AccAccountMapper accAccountMapper;

    @Override
    public AccAccount getAccAccountByPidAndServerid(int pid, int serverid) throws Exception {
        AccAccountExample exp = new AccAccountExample();
        exp.createCriteria().andAccountPidEqualTo(pid).andAccountServeridEqualTo(serverid);
        //不做全表查询, 只查询出account_gameid, account_points, account_deadline, account_isrmb
        //List<AccAccount> result = accAccountMapper.selectByExample(exp);
        List<AccAccount> result = accAccountMapper.selectByExample_Customer(exp);
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public boolean updateAccAccountPoint(AccAccount record)
            throws Exception {
        //int result = accAccountMapper.updateByPrimaryKey(record);
        int result = accAccountMapper.updatePointsAndIsrmb(record);
        return result == 1;
    }
}
