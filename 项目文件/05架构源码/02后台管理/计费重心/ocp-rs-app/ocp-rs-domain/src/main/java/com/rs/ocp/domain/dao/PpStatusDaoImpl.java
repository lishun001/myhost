/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.PpStatus;
import com.rs.ocp.domain.endity.PpStatusExample;
import com.rs.ocp.domain.mappers.PpStatusMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wangxinming
 */
@Repository(value = "ppStatusDao")
public class PpStatusDaoImpl implements PpStatusDao {

    @Autowired
    private PpStatusMapper ppStatusMapper;

    @Override
    public List<PpStatus> getPpStatusByPid(int pid) throws Exception {
        PpStatusExample ppe = new PpStatusExample();
        ppe.createCriteria().andStatusPidEqualTo(pid);
        List<PpStatus> result = ppStatusMapper.selectByExample(ppe);
        return result;
        //return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public PpStatus getPpStatusByPidAndGameId(int pid, int gameId) throws Exception {
        PpStatusExample ppe = new PpStatusExample();
        ppe.createCriteria().andStatusPidEqualTo(pid).andStatusFrozenscopeEqualTo(gameId);
//        List<PpStatus> result = ppStatusMapper.selectByExample(ppe);
        List<PpStatus> result = ppStatusMapper.selectByExampleLimit1(ppe);
        return result.size() > 0 ? result.get(0) : null;
    }
}
