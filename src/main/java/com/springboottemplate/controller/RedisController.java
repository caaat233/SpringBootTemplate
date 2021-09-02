package com.springboottemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/9/1 10:38
 */
@RequestMapping("redis")
public class RedisController {

    @Autowired
    Jedis jedis;

    @RequestMapping("cleanAllKey")
    public void cleanAllKey(){
        jedis.flushDB();
    }
}
