package com.lrw.designpatterns;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.HashMap;

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
    private SingleObject(){
    }
    public static SingleObject getInstance(){
        return object;
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleObject.getInstance());
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

class DoubleLockSingleObject implements BeanFactoryPostProcessor {
    //懒汉式 双检锁 线程安全
    private static volatile DoubleLockSingleObject object;
    private DoubleLockSingleObject(){}
    public static  DoubleLockSingleObject getInstance(){
        if (null==object){
            synchronized(DoubleLockSingleObject.class){
                if (null==object){
                    object = new DoubleLockSingleObject();
                }
            }
        }
        return object;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}

//枚举类单例
class  EnumSingleObject{
    private EnumSingleObject(){}
    private  enum  SingleObject{
        INSTANCE;
        private  final EnumSingleObject instance;
         SingleObject(){
             System.out.println("枚举单例。。。");
             instance = new  EnumSingleObject();
        }
        private EnumSingleObject getInstance(){
             return  instance;
        }
    }

    public static EnumSingleObject getInstance(){
        return  SingleObject.INSTANCE.getInstance();
    }
}


