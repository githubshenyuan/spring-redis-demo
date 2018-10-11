package com.example.springbootredisclusterdemo.commom.base.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author sh on 2018/10/9
 * @version ideaIU-2017.2.5.win
 */
public class RedisCacheService {
    private RedisTemplate<String,Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取过期时间
     * @param key
     * @return
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断k是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * redis 数据入库 （默认存活时间 无限时）
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * redis 数据入库(时间默认单位为 秒)
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value,long time) {
        try {
            redisTemplate.opsForValue().set(key, value, time,TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void del(String ... key){
        if(key!=null&&key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }
    /**
     *
     * @param key
     * @return
     */
    public Object getObject(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    public void test(){
    }
}
