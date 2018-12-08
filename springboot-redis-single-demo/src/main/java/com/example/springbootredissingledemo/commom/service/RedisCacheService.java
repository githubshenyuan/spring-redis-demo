package com.example.springbootredissingledemo.commom.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author sh on 2018/10/9
 * @version ideaIU-2017.2.5.win
 */
@Service
public class RedisCacheService {
    @Resource(name = "redisTemplateObject")
    private RedisTemplate<String,Object> redisTemplateObject;

    public boolean look(String key ,String value) {
        try {
            boolean b = redisTemplateObject.opsForValue().setIfAbsent(key, value);
            if (b) {
                redisTemplateObject.expire(key,30, TimeUnit.SECONDS);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
