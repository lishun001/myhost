package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTUserBlacklist;
import com.eason.api.zb.po.ZbTZhubo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserBlackDao extends JpaRepository<ZbTUserBlacklist, Integer> {
    ZbTUserBlacklist findByUserIdAndBlacklistUserId(Integer userId,Integer blacklistUserId);

    @Transactional
    @Modifying
    void deleteByUserIdAndBlacklistUserId(Integer userId,Integer blacklistUserId);
}
