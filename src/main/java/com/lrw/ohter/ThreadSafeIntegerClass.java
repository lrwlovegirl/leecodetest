package com.lrw.ohter;

import sun.misc.Unsafe;

/**
 * 不使用锁，以及synchronized关键字实现一个线程安全的整数类
 * 参考文档：https://www.jianshu.com/p/4a99f2e65dcc
 */
public class ThreadSafeIntegerClass {
    /**
     * 工具类，获取对象内存地址的访问的类
     */
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (ThreadSafeIntegerClass.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private volatile int value;
    public final int getAndSet(int newValue) {
        return unsafe.getAndSetInt(this, valueOffset, newValue);
    }
}
