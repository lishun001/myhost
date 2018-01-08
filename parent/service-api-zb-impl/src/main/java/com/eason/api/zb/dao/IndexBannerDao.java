package com.eason.api.zb.dao;

import com.eason.api.zb.po.ZbTQvodBanners;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndexBannerDao extends JpaRepository<ZbTQvodBanners, Integer> {
    List<ZbTQvodBanners> getByType(int type);
}
