/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.dao;

import com.rs.ocp.domain.endity.PpMbcard;
import com.rs.ocp.domain.endity.PpMbcardExample;
import com.rs.ocp.domain.mappers.PpMbcardMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wangxinming
 */
@Repository(value = "ppMdcardDao")
public class PpMdcardDaoImpl implements PpMdcardDao {

    @Autowired
    private PpMbcardMapper ppMbcardMapper;

     public PpMbcard getPpMbcardByPidAndStatus(int pid,int status) throws Exception {
        PpMbcardExample exp = new PpMbcardExample();
        exp.createCriteria().andMbcardPidEqualTo(pid).andMbcardStatusEqualTo(status);
        List<PpMbcard> result = ppMbcardMapper.selectByExample(exp);
        return result.size() > 0 ? result.get(0) : null;
    }
}
