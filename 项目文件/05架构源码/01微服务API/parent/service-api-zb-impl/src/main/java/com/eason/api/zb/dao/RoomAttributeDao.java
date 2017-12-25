package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTRoomAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAttributeDao extends JpaRepository<ZbTRoomAttribute, Integer> {
    ZbTRoomAttribute findByAttributeKey(String attributeKey);
}
