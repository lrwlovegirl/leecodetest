package com.lrw.other.netty.netty.client;


public class TestNettyClient {

    public static void main(String[] args) {

        new Thread(new NettyClient("hello world")).start();
    }
}

