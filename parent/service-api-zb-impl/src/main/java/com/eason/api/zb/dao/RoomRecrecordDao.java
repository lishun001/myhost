package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTRecrecordsLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoomRecrecordDao extends JpaRepository<ZbTRecrecordsLog, Integer>, PagingAndSortingRepository<ZbTRecrecordsLog, Integer> {
    @Query(value = "SELECT * FROM  qvod_zb_t_recrecords_logs t1 " +
            "INNER JOIN  (SELECT t2.id, MAX(t2.plan_id) AS plan_id FROM qvod_zb_t_recrecords_logs t2 GROUP BY t2.zb_id) t2b " +
            "ON t1.plan_id=t2b.plan_id WHERE t1.zb_id IN ?#{[0]} ORDER BY t1.created_at DESC ", nativeQuery = true)
    List<ZbTRecrecordsLog> findAllByZbIds(List<Integer> zbIds);
}
