package com.lrw.other.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ServiceLoader<TestSPI> serviceLoader= ServiceLoader.load(TestSPI.class);
        for (TestSPI spi:serviceLoader){
            System.out.println(spi.HelloWorld());
        }





        DubboSpiTest dubboSpiTest = ExtensionLoader.getExtensionLoader(DubboSpiTest.class).getDefaultExtension();
        System.out.println(dubboSpiTest.toString());
        dubboSpiTest.HelloWorld();
        Thread.sleep(1000);
        DubboSpiTest dubboSpiTest2 = ExtensionLoader.getExtensionLoader(DubboSpiTest.class).getDefaultExtension();
        System.out.println(dubboSpiTest2.toString());
        dubboSpiTest2.HelloWorld();

    }
}
