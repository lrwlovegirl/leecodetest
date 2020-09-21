package com.lrw.other.redistest;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

//实现redis可重入锁,用ThreadLocal实现数据隔离

/**
 * Author liurenwang
 * time 2020-8-5
 */
public class ReentryRedisLock {
    private ThreadLocal<Map<String,Integer>> lockers = new ThreadLocal<>();
    @Autowired
    private Jedis jedis;
    //真正的锁操作
    private boolean privateLock(String key){
        //value设置成线程Id，删除的时候判断一下是不是当前线程
        return jedis.setex(key, 5, String.valueOf(Thread.currentThread().getId()))!=null;
    }

    //释放锁，判断加锁和释放锁是否是同一个线程
    private boolean  privateUnLock(String key) throws Exception {
        String threadId = jedis.get(key);
        if (threadId==null){
            throw new Exception("报警：xxx操作没有获取到分布式锁，锁可能已经过期，或请检查传入的key值,key:"+key);
        }
        //不为空，且释放锁的是同一个线程
        if (threadId.equals(Thread.currentThread().getId())){
            return jedis.del(key)>0;
        }else {
            throw  new Exception("报警： xxx操作加锁和释放锁不是同一个线程");
        }
    }

    //工具，获得存取加锁次数的容器，因为每个使用的是ThreadLocal，所以可以实现数据隔离
    private Map<String ,Integer> currentLockers(){
        Map<String,Integer> refs = lockers.get();
        if (refs!=null){
            return refs;
        }
        lockers.set(new HashMap<>());
        return lockers.get();
    }

    //加锁对外接口
    public boolean lock(String key){
        Map<String,Integer> refs = currentLockers();
        Integer refCnt = refs.get(key);
        if (refCnt!=null){
            refs.put(key,refCnt+1);
            return true;
        }
        boolean ok = privateLock(key);
        if (!ok){
            return false;
        }
        refs.put(key,1);
        return true;
    }


    //释放锁对外接口
    public boolean unLock(String key) throws Exception {
       Map<String,Integer> refs = currentLockers();
       Integer refCnt = refs.get(key);
       if (refCnt==null){
           return false;
       }
       refCnt-=1;
       if (refCnt>0){
           refs.put(key,refCnt);
       }else {
           refs.remove(key);
           privateUnLock(key);
       }
        return  true;
    }

    public static void main(String[] args) throws Exception {
        ReentryRedisLock reentryRedisLock = new ReentryRedisLock();
        System.out.println(reentryRedisLock.lock("test1"));
        System.out.println(reentryRedisLock.lock("test1"));
        System.out.println(reentryRedisLock.unLock("test1"));
        System.out.println(reentryRedisLock.unLock("test1"));
    }


}
