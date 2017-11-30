package com.eason.api.zb.dao;

import com.eason.api.zb.cache.ZbTRoomCron;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface RoomCronDao extends MongoRepository<ZbTRoomCron, BigInteger> {

}
