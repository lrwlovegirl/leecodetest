package com.lrw.algorithm.other;

/**
 * 限流算法之令牌桶算法
 * 有一个固定容量的桶，桶里存着令牌，桶一开始为空
 * token以一个固定的速率向桶中填充，直到达到桶的容量
 * 多余的令牌将会被丢弃，每当一个请求过来时，就会尝试从桶中移除一个令牌
 * 如果桶中没有令牌的话，请求无法通过
 * ps: 这里要用单例模式
 */
public class TokenBucket {


    public long timeStamp = System.currentTimeMillis();
    /**
     * 桶容量
     */
    public int capacity = 5;
    /**
     * 填充速率
     */
    public int rate =1 ;
    /**
     * 当前令牌数量
     */
    public int tokens;

    /**
     * 授权方法，桶中是否有令牌
     * @return
     */
    public boolean grants(){
        long now = System.currentTimeMillis();
        /**
         * 向桶中添加令牌，如果桶已满，则丢弃
         */
        tokens = (int) Math.min(capacity,tokens+(now-timeStamp)*rate);
        timeStamp = now;
        if (tokens<1){
            return false;
        }else {
            tokens = tokens-1;
            return true;
        }
    }
}
