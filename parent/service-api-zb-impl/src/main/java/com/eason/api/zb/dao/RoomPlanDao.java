package com.eason.api.zb.dao;

import com.eason.api.zb.cache.ZbTRoomPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

public interface RoomPlanDao extends MongoRepository<ZbTRoomPlan, BigInteger>, PagingAndSortingRepository<ZbTRoomPlan, BigInteger> {

    @Query("{'zbId':{$in:?#{[0]}}}")
    Page<ZbTRoomPlan> findByZbIds(List<Integer> zbIds, Pageable pageable);
    @Query("{'roomType': {$in:?#{[0]}}}")
    Page<ZbTRoomPlan> findByChargedRoom(List<String> roomTypes, Pageable pageable);
    @Query("{'roomType': ?#{[0]}}")
    Page<ZbTRoomPlan> findByRoomType(String roomType, Pageable pageable);
    @Query("{'roomId': ?#{[0]}}")
    ZbTRoomPlan findByRoomId(Integer roomId);
    @Query("{'zbId': ?#{[0]}}")
    ZbTRoomPlan findByZbId(Integer zbId);
}
