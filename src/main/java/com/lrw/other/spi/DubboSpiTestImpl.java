package com.lrw.other.spi;

public class DubboSpiTestImpl implements DubboSpiTest {
    @Override
    public void HelloWorld() {
        System.out.println("dubbo hello world");
    }
}
