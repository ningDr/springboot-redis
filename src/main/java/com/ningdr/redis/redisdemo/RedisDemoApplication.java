package com.ningdr.redis.redisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * redis入门工程
 * @author ning.dr@foxmail.com
 * @date 2021/1/5 9:16
 */
@SpringBootApplication(scanBasePackages = {"com.ningdr.redis.redisdemo"})
public class RedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

}
