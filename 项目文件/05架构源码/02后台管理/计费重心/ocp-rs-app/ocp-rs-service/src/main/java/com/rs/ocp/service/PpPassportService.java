/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service;

import com.rs.ocp.service.dto.LoginRequestDTO;
import com.rs.ocp.service.dto.LoginResponseDTO;
import com.rs.ocp.service.dto.LogoutRequestDTO;
import com.rs.ocp.service.dto.LogoutResponseDTO;
import com.rs.ocp.service.dto.TwoLevelPwdRequestDTO;
import com.rs.ocp.service.dto.TwoLevelPwdResponseDTO;
import com.rs.ocp.service.dto.ValidatePpPassportRequestDto;
import com.rs.ocp.service.dto.ValidatePpPassportResponseDto;

/**
 *
 * @author zhaoweixing
 */
public interface PpPassportService {

    public LoginResponseDTO login(LoginRequestDTO dto) throws Exception;

    public LogoutResponseDTO logout(LogoutRequestDTO dto) throws Exception;

    /**
     * 检测账号的状态(精确到指定游戏)，正常状态返回1，其他返回错误码
     *
     * @param pid
     * @param gameId
     * @return
     * @throws Exception
     */
    public int checkPpPassportStatus(int pid, int gameId) throws Exception;

    /**
     * 验证帐号（不登陆）
     *
     * @param validatePpPassportRequestDto
     * @return
     * @throws Exception
     */
    public ValidatePpPassportResponseDto validatePpPassport(ValidatePpPassportRequestDto validatePpPassportRequestDto) throws Exception;

    public void delGameLoginsession(int serverId,boolean addLogout) throws Exception;
    
      /**
      * 验证游戏二级密码
      * @param twoLevelPwdRequestDTO
      * @return
      * @throws Exception 
      */
     public TwoLevelPwdResponseDTO twoLevelPwd(TwoLevelPwdRequestDTO twoLevelPwdRequestDTO)throws Exception;
}
