package com.lrw.algorithm.other;

/**
 * i++在多线程情况下是不安全的，如果使用volatile关键字修饰呢？
 * 答案：不安全，因为volatile不能保证原子性
 */
public class VolaitileITest {
    public static volatile  int i=0;

    public static void main(String[] args) throws InterruptedException {
        //循环执行100次
//        for (int y=0;y<100;y++){
//            new Thread(() -> {for (int x=0;x<10000;x++){i++;}}).start();
//            new Thread(() -> {for (int x=0;x<10000;x++){i++;}}).start();
//            //休眠，让前面2个线程获得cpu，不加这句话main线程可能先于其他2个线程抢到cpu，直接输出0
//            Thread.sleep(2000);
//            System.out.println("第"+(y+1)+"次执行，"+"i="+i);
//            //重新置为0
//            i=0;
//        }

        int a =100;
        Integer b = new Integer(100);
        System.out.println(a==b);//true

        Integer c = new Integer(10000);
        Integer d = new Integer(10000);
        System.out.println(c==d);//false

        int e = 10000;
        System.out.println(c==e);//true

        Integer f = new Integer(104);
        Integer g = new Integer(104);
        System.out.println(f==g);//false

        System.out.println("###################");
        Integer i2 = 123;
        Integer i3 = new Integer(123);
        System.out.println(i2==i3);

    }
}


