package com.lrw.designpatterns;

/**
 * 单例设计模式
 * 懒汉式
 * 饿汉式-->线程安全
 * Author liurenwang
 * time 2020-4-1
 */
public class SingleObject {
    //饿汉式，线程安全
    private static SingleObject object = new SingleObject();
    private SingleObject(){}
    public static SingleObject getInstance(){
        return object;
    }
}
class LazyUnsafeSingleObject{
    //懒汉式 线程不安全
    private static LazyUnsafeSingleObject object ;
    private LazyUnsafeSingleObject(){}
    public  static LazyUnsafeSingleObject getInstance(){
        if (null==object){
            object = new LazyUnsafeSingleObject();
        }
        return object;
    }
}

class LazySafeSingleObject{
    //懒汉式 线程安全
    private static LazySafeSingleObject object;
    private LazySafeSingleObject(){}
    public static synchronized LazySafeSingleObject getInstance(){
        if (null==object){
            object = new LazySafeSingleObject();
        }
        return object;
    }
}

class DoubleLockSingleObject{
    //懒汉式 双检锁 线程安全
    private static volatile DoubleLockSingleObject object;
    private DoubleLockSingleObject(){}
    public static synchronized DoubleLockSingleObject getInstance(){
        if (null==object){
            object = new DoubleLockSingleObject();
        }
        return object;
    }
}