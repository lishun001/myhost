/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.PpFcmTotaltime;
import com.rs.ocp.domain.endity.PpFcmTotaltimeExample;
import com.rs.ocp.domain.mappers.PpFcmTotaltimeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhaoweixing
 */
@Repository(value = "ppFcmTotaltimeDao")
public class PpFcmTotaltimeDaoImpl implements PpFcmTotaltimeDao {
    
    @Autowired
    private PpFcmTotaltimeMapper ppFcmTotaltimeMapper;
    
    @Override
    public PpFcmTotaltime getPpFcmTotaltimeByPid(int pid, int gameid) throws Exception {
        PpFcmTotaltimeExample exp = new PpFcmTotaltimeExample();
        exp.createCriteria().andFcmPidEqualTo(pid).andFcmGameidEqualTo(gameid);
        //List<PpFcmTotaltime> result = ppFcmTotaltimeMapper.selectByExample(exp);
        List<PpFcmTotaltime> result = ppFcmTotaltimeMapper.selectByExampleLimit1(exp);
        return result.size() > 0 ? result.get(0) : null;
    }
    
    @Override
    public boolean updatePpFcmTotaltime(PpFcmTotaltime pfi) {
        int result = ppFcmTotaltimeMapper.updateByPrimaryKey(pfi);
        return result == 1;
    }
    
    @Override
    public boolean insertPpFcmTotaltime(PpFcmTotaltime pfi) throws Exception {
        int result = ppFcmTotaltimeMapper.insert(pfi);
        return result == 1;
    }
}
