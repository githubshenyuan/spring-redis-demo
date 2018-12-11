package com.example.springbootredissingledemo.controller;

import com.example.springbootredissingledemo.commom.service.RedisCacheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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
        // 创建一百个线程
        for (int i = 0; i < 100; i++) {
            creatThread(i);
        }

        return "redis";
    }

    /**
     * 线程内处理 多线程存储redis 的问题
     * @param num
     */
    private void creatThread(int num) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    int a = Integer.valueOf(getStringRandom(1));
                    String timestamp = String.valueOf(System.currentTimeMillis());
                    String uuid = "e6f50766-4665-4b10-b514-7b4ef010ea6a";
                    // 判断是否可以加锁
                    if (redisCacheService.look(uuid, timestamp)) {
                        System.out.println("线程id：" + Thread.currentThread().getName() +
                                "  key：" + uuid + "  value：" + timestamp);
                        // 设置 1-3 秒随机睡眠时间

                        try {
                            // 睡眠
                            Thread.sleep(a * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 解锁
                        if (redisCacheService.unLock(uuid, timestamp)) {
                            System.out.println("成功");
                        } else {
                            throw new RuntimeException();
                        }
                    } else {
                        try {
                            Thread.sleep(a * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程id：" + Thread.currentThread().getName() +
                                "  key：" + uuid + "  value：" + timestamp+" 失败");
                    }

                }

            }
        });
        thread.setName("id：" + num);
        thread.start();

    }
    public static String getStringRandom(int count){
        StringBuffer sb = new StringBuffer();
        String str = "123";
        Random r = new Random();
        for(int i=0;i<count;i++){
            int num = r.nextInt(str.length());
            sb.append(str.charAt(num));
            str = str.replace((str.charAt(num)+""), "");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String uuid = getStringRandom(1);
        System.out.println(uuid);

    }
}
