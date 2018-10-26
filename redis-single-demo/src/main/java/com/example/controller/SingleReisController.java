package com.example.controller;

import redis.clients.jedis.Jedis;

public class SingleReisController {


    public static void main(String[] args) {

        Jedis jedis = new Jedis("22.8.129.160",7000);
        //调用jedis对象的方法，方法名称和redis的命令一致。
       // jedis.set("key1", "jedis test");

        String info = jedis.info();

        System.out.println(info);
        //关闭jedis。
        jedis.close();




    }
}
