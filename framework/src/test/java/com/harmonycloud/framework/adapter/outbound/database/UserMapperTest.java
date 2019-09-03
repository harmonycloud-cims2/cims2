package com.harmonycloud.framework.adapter.outbound.database;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Usage:
 * @Author: gjq
 * @Date: 2019-09-03 20:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void findById() {
        String name = userMapper.findById(1);
        System.out.println(name);
    }
}