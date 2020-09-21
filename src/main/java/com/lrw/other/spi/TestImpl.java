package com.lrw.other.spi;

public class TestImpl implements TestSPI{

    @Override
    public String HelloWorld() {
        return "hello world";
    }
}
