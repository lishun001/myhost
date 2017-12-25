package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbUcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UcUserDao extends JpaRepository<ZbUcUser, Integer>, PagingAndSortingRepository<ZbUcUser, Integer> {
    @Query("select u FROM ZbUcUser u, ZbTZhubo b where u.id=b.userId and b.zbId=?1")
    ZbUcUser findByZbId(Integer zbId);
}
