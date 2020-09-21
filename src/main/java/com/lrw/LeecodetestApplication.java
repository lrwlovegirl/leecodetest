package com.lrw;

import org.apache.dubbo.common.threadpool.support.cached.CachedThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class LeecodetestApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeecodetestApplication.class, args);
        new CachedThreadPool();
    }
}
