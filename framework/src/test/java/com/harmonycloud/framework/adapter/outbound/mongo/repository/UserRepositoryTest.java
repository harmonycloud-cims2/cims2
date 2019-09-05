package com.harmonycloud.framework.adapter.outbound.mongo.repository;

import com.harmonycloud.common.BaseMongoTest;
import com.harmonycloud.framework.adapter.outbound.mongo.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRepositoryTest extends BaseMongoTest {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {

        // 创建三个User，并验证User总数
        userRepository.save(new User(1L, "didi", 30));
        userRepository.save(new User(2L, "mama", 40));
        userRepository.save(new User(3L, "kaka", 50));
        System.out.println(userRepository.findAll().size());
        Assert.assertEquals(3, userRepository.findAll().size());

        // 删除一个User，再验证User总数
//        User u = userRepository.findOne(1L);
//        userRepository.delete(u);
//        Assert.assertEquals(2, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        User u = userRepository.findByUsername("mama");
        userRepository.delete(u);
        System.out.println(userRepository.findAll().size());
        Assert.assertEquals(2, userRepository.findAll().size());

    }

}
