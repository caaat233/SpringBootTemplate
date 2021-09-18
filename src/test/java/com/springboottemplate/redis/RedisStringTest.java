package com.springboottemplate.redis;

import com.alibaba.fastjson.JSON;
import com.springboottemplate.pojo.User;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/7/9 16:24
 */
public class RedisStringTest {
    static Lock lock = new ReentrantLock();
    Jedis jedis;

     {
        //初始化操作
        //1、设置连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //设置池中最大连接数【可选】
        config.setMaxTotal(50);
        //设置空闲时池中保有的最大连接数【可选】
        config.setMaxIdle(10);
        //2、设置连接池对象
        JedisPool POOL = new JedisPool(config, "118.31.55.236", 6379);
         jedis = POOL.getResource();
    }


    @Test
    public void resolveCacheBreakdown2_Test() throws  Exception {
         //模拟两个线程
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                resolveCacheBreakdown2("541513140131");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                resolveCacheBreakdown2("541513140131");
            }
        });
        t1.setName("线程1");
        t1.start();
        t2.setName("线程2");
        t2.start();
        Thread.sleep(1000000000);

    }
    /**
     * 解决缓存击穿的问题（资源中心的方案比较粗暴，直接限流就完事了，流量大了直接降级,最好不要回答限流，解决问题太粗暴）
     * 分布式缓存的解救方案，运用set name zhangsan EX 10 NX   解决
     *这个锁比较细，只会锁住查询userId相同的线程，
     *
     *
     * 如果是缓存穿透的话，key的值可以设置个空，或者设置个固定值，如果值相等，直接返回空，防止缓存击穿
     *
     *
     *
     * @param userId  互
     * @return
     * @throws Exception
     */
    public String resolveCacheBreakdown2(String userId) throws Exception {
        String keyLock = "QUERY^9USERBYID^LOCK" + "^" + userId;//切记，只是锁查询不到这个user信息的userid,不要把整个方法都锁住了。斥锁，自旋，很大的缺点会降低系统吞吐量
        String fromCache = jedis.get(userId);
        if (fromCache == null) {
            String ok = jedis.set(keyLock, "1", "NX", "EX", 10);
            if (StringUtils.isNotBlank(ok) && "OK".equals(ok)) {
                //说明拿到锁了，查询数据库，这里不需要try,因为就算代码抛出异常也不存在死锁的可能
                System.out.println(Thread.currentThread().getName()+":我拿到锁了，我要查询数据库了");
                String dataFromDB = getDataFromDB(userId, true);
                //将数据写入缓存
                jedis.set("userId", dataFromDB);
                System.out.println(Thread.currentThread().getName()+"：userId的值是"+userId);
                return dataFromDB;
            } else {
                //说明没拿到锁，         这时候需要自旋
                System.out.println(Thread.currentThread().getName()+":我没拿到锁,缓存也没数据,先小憩一下");
                Thread.sleep(200);// 睡一会儿
                return resolveCacheBreakdown2(userId);// 重试
            }
        } else {
            return fromCache;
        }
    }

    /**
     * 解决缓存击穿的问题(单机锁+自旋)
     * 只适用于单机的项目，不适合分布式缓存(分布式环境，必须用分布式锁，因为lock锁或者synchronized 都是单机锁)
     * 这样存在问题，加锁后，其他线程的查询方法都需要排队
     */

    /**
     *https://juejin.cn/post/6844904150996615182     ReentrantLock 学习
     */

    public String resolveCacheBreakdown(String userId) throws Exception {
        if (jedis.get(userId) == null) {
            if (lock.tryLock()) {//可以理解为锁的是lock这个对象，是对象锁，由于这个对象也是单例的，所以功能上实现了类锁的功能
                try {//防止报错不放锁
                    System.out.println(Thread.currentThread().getName()+":我拿到锁了，我要查询数据库了");
                    String dataFromDB = getDataFromDB(userId, true);
                    //将数据写入缓存
                    jedis.set("userId", dataFromDB);
                } finally {
                    lock.unlock();
                }
            } else {
                //如果拿不到锁，先查询一下缓存，看一下，现在是不是存在数据了
                if (jedis.get(userId) == null) {
                    //说明还是查不到数据，这时候需要自旋
                    System.out.println(Thread.currentThread().getName()+":我没拿到锁,缓存也没数据,先小憩一下");
                    Thread.sleep(200);// 睡一会儿
                    return resolveCacheBreakdown(userId);// 重试
                } else {
                    return jedis.get(userId);
                }
            }
        }
        return jedis.get(userId);
    }


    @Test
    public void test() {
        Jedis jedis = JedisUtils.getJedis();
        //等效于 set name zhangsan EX 10 NX      10秒过期，10秒内不允许重复插入
        System.out.println(jedis.set("name", "zhangsan", "NX", "EX", 10L));
        System.out.println(jedis.setnx("password", "1234"));//没有过期时间，不允许重复插入
        System.out.println(jedis.ttl("name"));//查询key   过期时间
        //System.out.println(jedis.set("null", null));//这样写报错，value sent to redis cannot be null
        System.out.println(jedis.set("null", "null"));
        System.out.println(jedis.get("null"));
        System.out.println(jedis.get("null1111111") == null ? "1" : "0");//获取不存在的key,返回null
        User user=new User();
        user.setId("1");
        user.setName("张三");
        user.setEmail("923972487@qq.com");
        user.setGrade("大四");
        jedis.set("user1", JSON.toJSONString(user));
        User user1 = JSON.parseObject(jedis.get("user1"), User.class);
        System.out.println(user1);
    }













    /**
     * 模拟查询数据库
     *
     * @param key
     * @param flag true,数据库存在数据
     * @return
     */
    private String getDataFromDB(String key, boolean flag) {
        if (flag) {
            System.out.println("数据库存在数据");
            return key;
        } else {
            System.out.println("数据库不存在数据");
            return null;
        }
    }

}
