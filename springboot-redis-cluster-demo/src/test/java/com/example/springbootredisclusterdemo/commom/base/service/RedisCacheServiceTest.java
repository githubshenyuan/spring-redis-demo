package com.example.springbootredisclusterdemo.commom.base.service;

import com.example.springbootredisclusterdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author sh on 2018/10/10
 * @version ideaIU-2017.2.5.win
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheServiceTest {
    @Autowired
    RedisCacheService redisCacheService;
    @Test
    public void setRedisTemplate() throws Exception {
    }

    @Test
    public void getExpire() throws Exception {
    }

    @Test
    public void hasKey() throws Exception {
    }

    @Test
    public void set() throws Exception {
        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setName("小明");
        user.setPassword("密码");
        System.out.println(user.getUuid());
        redisCacheService.set(user.getUuid(), user,150);
        redisCacheService.del(user.getUuid());
    }

    @Test
    public void getObject() throws Exception {
        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setName("小明");
        user.setPassword("密码");
        System.out.println(user.getUuid());
        redisCacheService.set(user.getUuid(), user, 150);
        user = (User) redisCacheService.getObject(user.getUuid());
        redisCacheService.del(user.getUuid());

    }

}