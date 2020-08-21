package com.lrw.ohter.redistest;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.UUID;

/**
 * redis 延时队列
 * Author liurenwang
 * time 2020-8-5
 * redis 如果加锁失败，建议采用延时队列处理请求
 */
@AllArgsConstructor
public class RedisDelayQueue<T> {

    static class TaskItem<T> {
        public String id;
        public T msg;
    }


    private Jedis jedis;
    private String queueKey; //延迟队列的名称

    //元素入队
    public void entreQueue(T msg) {
        TaskItem<T> task = new TaskItem<>();
        //保证唯一ID
        task.id = UUID.randomUUID().toString();
        task.msg = msg;
        String taskStr = JSON.toJSONString(task);
        //塞进延时队列，时间戳+5000 作为score  -->5s后再试
        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, taskStr);
    }

    //取最近的一条
    public void loop() {
        while (!Thread.interrupted()) {
            Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            //队列中没有在这个区间的值
            if (values == null || values.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getId() + ",休息一下");
                    Thread.sleep(500);//休息一下，再重试
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            String result = values.iterator().next();
            //抢到了cpu
            if (jedis.zrem(queueKey, result) > 0) {
                TaskItem<T> taskObject = JSON.parseObject(result, TaskItem.class);
                //这里应该是函数，表示去处理请求,简单输出一下
                System.out.println(taskObject.msg);
            } else {
                System.out.println(Thread.currentThread().getId() + ",没有抢到cpu");
            }
        }
    }

    public static void main(String[] args) {

        Jedis jedis = new RedisUtil().getJedis();
        RedisDelayQueue redisDelayQueue = new RedisDelayQueue(jedis, "delayQueue");
        Thread producer = new Thread(() -> {
            for (int x = 0; x < 100000; x++) {
                redisDelayQueue.entreQueue("test" + x);
            }
        });
        Thread consumer = new Thread(() -> {
            redisDelayQueue.loop();
        });
        producer.start();
        consumer.start();
        try {
            producer.join();
            Thread.sleep(6000);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
