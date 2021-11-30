package com.springboottemplate.util;

/**
 * @author 唐涛
 * @description: 令牌算法
 * @date 2021/8/25 17:01
 */

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 令牌算法与漏桶算法的区别：
 * 1. 漏桶是出，令牌是进
 * 2. 令牌是允许伸缩
 * <p>
 * 桶算法与令牌桶算法的区别在于，漏桶算法能够强行限制数据的传输速率，
 * <p>
 * 令牌桶算法能够在限制数据的平均传输速率的同时还允许某种程度的突发传输。
 * <p>
 * 区别对应博客：https://www.jianshu.com/p/c02899c30bbd
 */
public class RateLimiterUti {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;


    @Test
    public void testCallable() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<String> userNameList = new ArrayList<>();
        userNameList.add("张三");
        userNameList.add("李四");
        userNameList.add("王五");
        userNameList.add("小明");
        userNameList.add("小红");
        userNameList.add("校长");
        //1代表一秒1个
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (String username : userNameList) {
            executor.execute(() -> {
                System.out.println("等待时间：" + rateLimiter.acquire());
                System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                //假如你业务逻辑比较复杂的话，可以以新建一个类继承Runnable，把username对象传递进去，比如 new MyRunnable（Streing username）
                System.out.println(Thread.currentThread().getName() + "   " + username);
                System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
            });

        }

        //睡眠10秒等子线程跑完
        Thread.sleep(10000);
        //终止线程池
        executor.shutdown();
        System.out.println("Finished all threads");
    }

}
