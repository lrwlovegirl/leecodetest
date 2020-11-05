package com.lrw;

import com.lrw.other.netty.netty.server.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class LeecodetestApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(LeecodetestApplication.class, args);
    }

    @Autowired
    private NettyServer nettyServer;


    @Override
    public void run(String... args) throws Exception {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",9999);
        System.out.println("准备开启netty server");
        nettyServer.start(address);
    }
}
