package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTRoomPlanStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomPlanStatDao extends JpaRepository<ZbTRoomPlanStat, Integer> {
    ZbTRoomPlanStat findByPlanId(Integer planId);
}
