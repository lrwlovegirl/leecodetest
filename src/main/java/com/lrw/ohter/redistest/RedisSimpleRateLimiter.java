package com.lrw.ohter.redistest;
//redis 限流器

import lombok.AllArgsConstructor;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

/**
 * 计数器方法： 在10秒内，只有20个请求能访问我的代码
 * 实现方式： setnx key 10 value  每多一个请求,value就+1，，当value等于10时，不执行接下来的代码
 * 缺点： 能知道1-10s内有多少次请求，但是2-11s的请求数不知道
 * 时间滑动窗口
 *     下面介绍这种
 * Author liurenwang
 * time 2020-8-5
 */
@AllArgsConstructor
public class RedisSimpleRateLimiter {

    private Jedis jedis;
    //无论返回什么，都表示用户已经点击过，通过这个方法，接下来的代码时要去判断该用户点击行为是否有效
    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {
        String key = userId+":"+actionKey;
        long now = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        pipeline.multi();
        pipeline.zadd(key, now, "" + now);//key , score , value
        //删除now-period*1000秒之前的数据（也就是说保留periods秒之内的数据）
        pipeline.zremrangeByScore(key, 0, now - period * 1000);
        //查看在period秒内用户点击了多少次（无效点击+有效点击都算在period秒之内，所以如果用户一直连续不断点击，会一直提示无效点击）
        //用户必须停下来等待几秒才可以，不能一直连续点击，前端可以做个计数器，一直点，后面的就不发请求了，过几秒再发
        Response<Long> count = pipeline.zcard(key);
        //这里给key设置过期时间，是防止冷用户占用内存
        pipeline.expire(key, period + 1);
        pipeline.exec();
        pipeline.close();
        return count.get() <= maxCount;
    }

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new RedisUtil().getJedis();
        RedisSimpleRateLimiter redisSimpleRateLimiter = new RedisSimpleRateLimiter(jedis);
        for (int  x= 0;x<1000000;x++){
            System.out.println(redisSimpleRateLimiter.isActionAllowed("liurenwang","reply",10,5));
        }
    }

}
