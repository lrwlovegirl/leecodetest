package com.lrw.other.redistest;
import org.springframework.beans.factory.FactoryBean;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class RedisTest {
    public static void main(String[] args) {
        RedisUtil redisUtil = new RedisUtil();
        Jedis jedis = redisUtil.getJedis();
        for (int x = 0; x < 100; x++) {
            jedis.set("test" + x, String.valueOf(x));
        }
        new HashMap<>();
    }
}
