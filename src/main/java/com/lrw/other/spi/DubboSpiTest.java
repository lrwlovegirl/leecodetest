package com.lrw.other.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI("impl")
public interface DubboSpiTest {
    void HelloWorld();
}
