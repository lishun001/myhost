/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service;

import com.rs.ocp.domain.endity.GameServer;
import com.rs.ocp.service.dto.RegGameServerRequestDTO;
import com.rs.ocp.service.dto.RegGameServerResponseDTO;
import com.rs.ocp.service.dto.UnregGameServerRequestDTO;
import com.rs.ocp.service.dto.UnregGameServerResponseDTO;

/**
 *
 * @author zhaoweixing
 */
public interface GameServerService {

    public RegGameServerResponseDTO registerGameServer(RegGameServerRequestDTO requestDTO) throws Exception;

    public UnregGameServerResponseDTO unregisterGameServer(UnregGameServerRequestDTO requestDTO) throws Exception;

    public boolean validateGameServerByIp(String ip) throws Exception;

    public boolean validateGameServerByMd5(RegGameServerRequestDTO requestDTO) throws Exception;

    /**
     * 检测账户的状态，正常状态返回1，其他返回错误码
     *
     * @param gameServer
     * @return
     * @throws Exception
     */
    public int checkGameServerStatus(GameServer gameServer) throws Exception;
    /**
     * 更新服务注册、注销状态
     * @param gameServerId
     * @param state
     * @return 
     */
    public void updateGameServerRegisterState(int gameServerId,int state) ;
}
