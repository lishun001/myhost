package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTRoomTypeSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeSetDao extends JpaRepository<ZbTRoomTypeSet, Integer> {

    ZbTRoomTypeSet findByRoomType(String roomType);
}
