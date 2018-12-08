package com.example.springbootredissingledemo.controller;

import com.example.springbootredissingledemo.commom.service.RedisCacheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sh 2018/12/8 15:12
 * @version ideaIU-2018.2.5.win
 */
@RestController
public class RedisDemoController {

    @Resource
    RedisCacheService redisCacheService;

    @RequestMapping("/redis")
    public String redisDemo() {
        redisCacheService.look("123456789","123456789");
        return "redis";
    }

}
