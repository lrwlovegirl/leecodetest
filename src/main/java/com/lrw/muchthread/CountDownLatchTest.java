package com.lrw.muchthread;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 */
public class CountDownLatchTest {
    //时间戳
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //常用方法
        /**
         * await 方法，会阻塞当前线程
         * countDown 方法，计数减1，当count的值等于0的时候，被阻塞的线程才会继续运行
         */
        countDownLatch.await();
        countDownLatch.countDown();
    }
}

class Worker extends Thread {
    private String name;
    private int workTime;
    private CountDownLatch countDownLatch;

    public Worker(String name, int workTime, CountDownLatch latch) {
        this.name = name;
        this.workTime = workTime;
        this.countDownLatch = latch;
    }
    @Override
    public void run() {
        super.run();
    }
}
