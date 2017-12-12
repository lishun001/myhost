/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service;

import com.rs.ocp.domain.endity.AccAccount;
import com.rs.ocp.service.dto.DeductQointRequestDTO;
import com.rs.ocp.service.dto.DeductQointResponseDTO;
import com.rs.ocp.service.dto.QueryPointRequestDTO;
import com.rs.ocp.service.dto.QueryPointResponseDTO;

/**
 *
 * @author zhaoweixing
 */
public interface AccountService {

    public AccAccount getAccAccountByPidAndServerId(int pId, int serverId) throws Exception;

    public QueryPointResponseDTO QueryPoint(QueryPointRequestDTO dto) throws Exception;
    
    /**
     * 定时扣点
     * @param dto
     * @return
     * @throws Exception 
     */
     public DeductQointResponseDTO deductQoint(DeductQointRequestDTO dto) throws Exception;
     
     /**
      * 检测账户的状态，正常状态返回1，其他返回错误码
      * @param accAccount
      * @return
      * @throws Exception 
      */
    // public int checkAccAccountStatus(AccAccount accAccount) throws Exception;
     
   
}
