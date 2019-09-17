package hk.health.framework.adapter.outbound.mongo.repository;

import hk.health.framework.adapter.outbound.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);
}
