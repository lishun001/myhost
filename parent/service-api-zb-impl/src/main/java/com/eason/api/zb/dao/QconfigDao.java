package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTQvodConfigs;
import com.eason.api.zb.po.ZbUcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QconfigDao extends JpaRepository<ZbTQvodConfigs, Integer> {
    @Query("select config FROM ZbTQvodConfigs config where config.aliasName=?1")
    ZbTQvodConfigs findByConfig(String aliasName);
}
