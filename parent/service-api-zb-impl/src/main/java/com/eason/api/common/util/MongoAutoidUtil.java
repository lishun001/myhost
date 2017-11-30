//package com.eason.api.common.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Component;
//
//import static org.springframework.data.mongodb.core.query.Query.query;
//
//@Component
//public class MongoAutoidUtil {
//    @Autowired
//    MongoTemplate mongo;
//
//    public int getNextSequence(String collectionName) {
//        MongoSequence seq = mongo.findAndModify(
//                query(where("_id").is(collectionName)),
//                new Update().inc("seq", 1),
//                options().upsert(true).returnNew(true),
//                MongoSequence.class);
//
//        return seq.getSeq();
//    }
//}
