package com.lrw.designpatterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式
 * 代理模式的思想便是各司其职
 * 核心对象只关注核心业务，不关注其他
 * 举个例子：你是古代的皇帝，宠幸妃子时，不可能自己去告诉某个妃子
 * 今晚要宠幸她，而是告诉太监（创建代理对象），一个命令（给代理对象注入核心业务对象），这个太监会帮助你
 * 去完成准备工作和善后工作，你只需要完成最主要的步骤
 *
 */
interface Fruit{
    void eat();
}
//真实对象只完成核心业务，不需要做准备及善后工作
class RealFruit implements Fruit{

    @Override
    public void eat() {
        System.out.println("吃水果");
    }
}



/**
 * 静态代理实现方式
 * 调用方式 ：
 * Fruit fruit = new RealFruit();
 * StaticProxy staticProxy = new StaticProxy(fruit);
 * staticProxy.eat();
 */
class StaticProxy implements Fruit{
    //真实对象
    private Fruit fruit;
    //构造方法直接注入
    public StaticProxy (Fruit fruit){
        this.fruit  = fruit;
    }
    private void prepare(){
        System.out.println("准备工作：洗水果");
    }

    @Override
    public void  eat() {
        prepare();
        fruit.eat();
        after();
    }

    private void after(){
        System.out.println("善后工作:扔垃圾");
    }
}
// ####################jdk动态代理####################################################
/**
 * jdk动态代理：当有成千上万个类需要去实现代理的时候，静态代理满足不了
 * 需求：有一个类，传入任何对象，可以调用其方法
 * 调用方式：
 *         Fruit fruit = new RealFruit();
 *         Fruit proxy = (Fruit) DynamicProxyFactory.getProxy(fruit);
 *         proxy.eat();
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;
    public void setTarget(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里可以调用其他类的方法，表示增强");
         method.invoke(target,args);
        System.out.println("这里同理+1");
        return null;
    }
}
//动态代理对象工厂
class DynamicProxyFactory{
   public static Object getProxy(Object object){
       DynamicProxy handle = new DynamicProxy();
       handle.setTarget(object);
       Object proxy = Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),handle);
       return proxy;
   }
}

//####################cgLib代理#################################
//todo:写一个cglib代理

/**
 * 动态代理和静态代理都需要子类实现接口
 * 那么如果有的类没有实现接口呢？
 * cglib代理会虚拟出一个继承了目标类的子类
 */
class CgLibProxy{

}
