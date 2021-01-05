package com.ningdr.redis.redisdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工程测试
 * @author ning.dr@foxmail.com
 * @date 2021/1/5 9:24
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public String world() {
        return "hello world";
    }

}
