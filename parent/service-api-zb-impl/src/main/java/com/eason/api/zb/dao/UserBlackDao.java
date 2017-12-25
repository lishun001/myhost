package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTUserBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface UserBlackDao extends JpaRepository<ZbTUserBlacklist, Integer> {
    ZbTUserBlacklist findByUserIdAndBlacklistUserId(Integer userId,Integer blacklistUserId);

    @Transactional
    @Modifying
    void deleteByUserIdAndBlacklistUserId(Integer userId,Integer blacklistUserId);
}
