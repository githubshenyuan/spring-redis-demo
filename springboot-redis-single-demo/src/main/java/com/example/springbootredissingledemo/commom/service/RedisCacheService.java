package com.example.springbootredissingledemo.commom.service;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author sh on 2018/10/9
 * @version ideaIU-2017.2.5.win
 */
public class RedisCacheService {
    private RedisTemplate redisTemplate;
    private RedisTemplate<String,Object> redisTemplateObject;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setRedisTemplateObject(RedisTemplate<String, Object> redisTemplateObject) {
        this.redisTemplateObject = redisTemplateObject;
    }
}
