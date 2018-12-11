package com.example.springbootredissingledemo.commom.service;

import org.apache.el.lang.ELArithmetic;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    // 注入 处理对象类型的数据
    @Resource()
    private RedisTemplate<String,Object> redisTemplateObject;
    // 注入 处理字符串类型的数据 （注意 两种不相通）
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    //redis 到期时间
    private final static int EXPIRE_TIME = 900;
    public boolean look(String key ,String value) {
        try {
            if (stringRedisTemplate.opsForValue().setIfAbsent(key, value)) {
                stringRedisTemplate.expire(key,EXPIRE_TIME, TimeUnit.SECONDS);
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public boolean unLock(String key, String value) {
        try {
            if (stringRedisTemplate.hasKey(key)) {
                if (stringRedisTemplate.opsForValue().get(key).equals(value)) {
                    stringRedisTemplate.delete(key);
                } else {
                    return false;
                }

            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
