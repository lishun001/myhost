package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTUserAttention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserAttentionDao extends JpaRepository<ZbTUserAttention, Integer> {

    List<ZbTUserAttention> findAllByAId(Integer aId);

    ZbTUserAttention findByAIdAndFId(Integer aId, Integer fId);

    @Query(value = "SELECT COUNT(*) FROM qvod_zb_t_user_attention t WHERE t.f_id =?1",nativeQuery = true)
    int findATotalByFId(Integer fId);

    @Transactional
    @Modifying
    void deleteByAIdAndFId(Integer aId, Integer fId);

    @Query(value = "SELECT COUNT(*) FROM qvod_uc_users t WHERE t.id =?1",nativeQuery = true)
    int findUserById(Integer userId);
}
