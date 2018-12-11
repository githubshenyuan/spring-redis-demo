package com.example.springbootredissingledemo.commom.service;

import com.example.springbootredissingledemo.entity.Gread;
import com.example.springbootredissingledemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author sh 2018/12/10 13:29
 * @version ideaIU-2018.2.5.win
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheServiceTest {
    @Resource
    RedisCacheService redisCacheService;

    @Test
    public void look() {
        redisCacheService.look("1234567890", "hello world ,你好世界");
        String uuid = UUID.randomUUID().toString();
        User user = new User();
        user.setUuid(uuid);
        Gread gread = new Gread();
        gread.setUuid(uuid);
        gread.setCreatDate(new Date());
        user.setGread(gread);
        user.setInputDate(new Date());
        redisCacheService.unLock("1234567890", "hello world ,你好世界");
    }

    @Test
    public void unLock() {
    }
}