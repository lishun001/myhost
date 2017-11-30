package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTMsgNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgNotificationDao extends JpaRepository<ZbTMsgNotification, Integer> {

}
