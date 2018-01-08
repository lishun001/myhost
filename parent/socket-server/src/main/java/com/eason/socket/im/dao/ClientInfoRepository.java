package com.eason.socket.im.dao;

import com.eason.socket.im.po.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientInfoRepository extends JpaRepository<ClientInfo, String> {
    ClientInfo findClientByclientid(String clientId);
}
