package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTZhubo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ZhuboDao extends JpaRepository<ZbTZhubo, Integer>, PagingAndSortingRepository<ZbTZhubo, Integer> {
    @Query(value = "from #{#entityName} t where t.userId!=?1 ")
    Page<ZbTZhubo> findAllNotByUserId(Integer userId, Pageable pageable);

    ZbTZhubo findByUserId(Integer userId);

    @Query(value = "SELECT SUM(t.points) FROM qvod_zb_t_consume_logs t WHERE t.send_uid=?1 and t.type=1",nativeQuery = true)
    int getDiamondGiftZBTotal(Integer userId);

    @Query(value = "SELECT SUM(t.points) FROM qvod_zb_t_consume_logs t WHERE t.send_uid=?1 ",nativeQuery = true)
    int getCostTotal(Integer userId);
}
