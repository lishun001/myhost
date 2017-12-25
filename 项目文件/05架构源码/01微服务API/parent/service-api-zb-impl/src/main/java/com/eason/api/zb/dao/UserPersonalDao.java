package com.eason.api.zb.dao;

import com.eason.api.zb.cache.ZbTUserPersonal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface UserPersonalDao extends MongoRepository<ZbTUserPersonal, BigInteger> {
    @Query("{'userId':?#{[0]},'zbId':?#{[1]}}")
    ZbTUserPersonal findByUserIdAndZbId(Integer userId, Integer zbId);

    List<ZbTUserPersonal> findByZbId(Integer zbId);
}
