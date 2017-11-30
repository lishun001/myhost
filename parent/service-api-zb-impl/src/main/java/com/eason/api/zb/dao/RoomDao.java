package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RoomDao extends JpaRepository<ZbTRoom, Integer> {

        ZbTRoom findByZbId(Integer zbId);

        @Query(value = "SELECT * FROM qvod_zb_t_room r LEFT JOIN qvod_zb_t_zhubo z ON r.zb_id=z.zb_id WHERE z.user_id=?1",nativeQuery = true)
        ZbTRoom findByZbUserId(Integer userId);

        @Modifying
        @Transactional
        @Query("UPDATE #{#entityName}  u SET u.roomStatus=?2 , u.roomTitle=?3 WHERE u.roomId=?1")
        void updateRoomStatusAndAndRoomTitle(Integer roomId, Integer status,String roomTitle);

        @Modifying
        @Transactional
        @Query("UPDATE #{#entityName}  u SET u.roomBgPic=?2  WHERE u.roomId=?1")
        void updateRoomBgPic(Integer roomId, String roomBgPic);
}
