package com.lrw.other.timingtask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Java自己实现定时任务demo
 */
public class TimeTaskDemo {
    public static void main(String[] args) throws InterruptedException {
        Timer timer  = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        },5000);
        Thread.sleep(10000);
        timer.cancel();
    }
}
