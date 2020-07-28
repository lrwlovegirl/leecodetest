package com.lrw.ohter;

import sun.nio.ch.DirectBuffer;

/**
 * 什么是ThreadLocal
 *     线程本地存储，spring中Transaction中用到。是一个数据结构，有点像HashMap,可以保存key-value键值对
 * 但是threadLocal只能保存一个变量
 * 每个线程都有一个ThreadLocalMap数据结构，ThreadLocalMap是ThreadLocal中的一个静态内部类
 * ThreadLocalMap中初始化了一个大小为16的Entry对象数组，Entry对象用来保存每一个key-value值，而每一个key都是
 * ThreadLocal对象，Entry对象没有next对象
 * 每个对象ThreadLocal对象都有一个hash值，threadLocalHashCode，每初始化一个ThreadLocal对象，hash值就增加固定的大小
 * set过程:
 * 在插入过程中，根据threadLocalHashCode 定位到要将此对象（ThreadLocal+value）插入到位置i上,
 * 如果当前位置上为空，就初始化一个entry对象放在位置i上
 * 如果当前位置有对象，则判断当前位置是否是当前对象，如果是，则重新设置值
 * 如果不是当前对象，则找下一个空位置
 * get过程:
 * 根据根据threadLocalHashCode定位。--》可能会很慢
 *
 * ThreadLocal可能会导致内存泄露
 *  什么是内存泄漏: 一个不再使用的对象还在内存中占用空间
 *   为什么：因为Entry类继承了weakReference,key被保存到了weakReference中，如果创建ThreadLocal的线程一直运行，那么
 *这个Entry中的值，可能就会得不到释放
 */

/**
 * **************多线程 ThreadLocal 父子线程怎么共享数据****************
 * 上面简述了什么是ThreadLocal，以及ThreadLocal的get set 过程
 * 那么如果子线程想使用父线程的值呢？怎么办呢
 * InheritableThreadLocal 这个类就是为了解决这个问题的
 *   使用方法:
 *   ThreadLocal<String> threadLocal=new InheritableThreadLocal<String>();
 * 解析:
 *   InheritableThreadLocal 继承了ThreadLocal类，并重写了三个方法，childValue(),getMap() createMap()
 *   getMap 返回的是一个inheritableThreadLocals属性变量 (ThreadLocalMap) ==》Thread类的static 变量
 *  在 Thread 类的构造方法中，调用了init（）方法，这个方法调用createInheritedMap方法：作用，如果父线程的inheritableThreadLocals 不为空，则
 *  将当前线程的inheritableThreadLocals设置父线程的inheritableThreadLocals赋值给子线程，如何赋值呢，就是简单的拷贝一下
 *
 *
 */

public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {
//        ThreadLocal<String> localName = new ThreadLocal<>();
//        localName.set("xxx");
//        localName.set("yyy");
//        System.out.println(localName.get());
        //todo: 子线程想使用父线程的值演示
        //ThreadLocal<String> threadLocal=new ThreadLocal<String>();
        InheritableThreadLocal<String> local=new InheritableThreadLocal<String>();
        local.set("xxxxx父线程");
        System.out.println("父线程的值："+local.get());
        new Thread(new Runnable(){
              @Override
              public void run(){
                  System.out.println("子线程的值："+local.get());
              }
           }).start();
        Thread.sleep(2000);
    }
}
