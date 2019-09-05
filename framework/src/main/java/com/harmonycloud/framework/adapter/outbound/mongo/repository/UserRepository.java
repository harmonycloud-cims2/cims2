package com.harmonycloud.framework.adapter.outbound.mongo.repository;

import com.harmonycloud.framework.adapter.outbound.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);
}
