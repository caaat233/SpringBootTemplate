package com.springboottemplate.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description:
 * @author: ttao
 * @create: 2020-09-30 17:01
 **/

/**
 * Executors.FixedThreadPool
 * Executors.SingleThreadExecutor
 * Executors.CachedThreadPool
 * Executors工具类的三个方法其实都是ThreadPoolExecutor。只是参数不同而已
 * <p>
 * ThreadPoolExecutor 3 个最重要的参数：
 * <p>
 * corePoolSize : 核心线程数线程数定义了最小可以同时运行的线程数量。
 * maximumPoolSize : 当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
 * workQueue: 当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中。
 * ThreadPoolExecutor其他常见参数:
 * <p>
 * keepAliveTime:当线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 keepAliveTime才会被回收销毁；
 * unit : keepAliveTime 参数的时间单位。
 * threadFactory :executor 创建新线程的时候会用到。
 * handler :饱和策略。关于饱和策略下面单独介绍一下。
 */

/**
 * CPU 密集型任务(N+1)： 这种任务消耗的主要是 CPU 资源，可以将线程数设置为 N（CPU 核心数）+1，比 CPU 核心数多出来的一个线程是为了防止线程偶发的缺页中断，或者其它原因导致的任务暂停而带来的影响。一旦任务暂停，CPU 就会处于空闲状态，而在这种情况下多出来的一个线程就可以充分利用 CPU 的空闲时间。
 * I/O 密集型任务(2N)： 这种任务应用起来，系统会用大部分的时间来处理 I/O 交互，而线程在处理 I/O 的时间段内不会占用 CPU 来处理，这时就可以将 CPU 交出给其它线程使用。因此在 I/O 密集型任务的应用中，我们可以多配置一些线程，具体的计算方法是 2N。
 * 如何判断是 CPU 密集任务还是 IO 密集任务？
 *
 * CPU 密集型简单理解就是利用 CPU 计算能力的任务比如你在内存中对大量数据进行排序。单凡涉及到网络读取，文件读取这类都是 IO 密集型，这类任务的特点是 CPU 计算耗费时间相比于等待 IO 操作完成的时间来说很少，大部分时间都花在了等待 IO 操作完成上。
 */
public class ThreadPool {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;


    /**
     * 使用阿里巴巴推荐的创建线程池的方式
     * 通过ThreadPoolExecutor构造函数自定义参数创建
     */
    @Test
    public void testThreadPoolExecutor() {
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

        //执行Runnable
        //这种不算是多线程，其实是一个线程，只是run方法里面再for循环执行业务。必须是多个executor.execute才算多线程，参考下面
//        executor.execute(() -> {
//            for (String username : userNameList) {
//                System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
//                System.out.println(Thread.currentThread().getName()+"   "+username);
//                System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
//            }
//        });

        for (String username : userNameList) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                //假如你业务逻辑比较复杂的话，可以以新建一个类继承Runnable，把username对象传递进去，比如 new MyRunnable（Streing username）
                System.out.println(Thread.currentThread().getName() + "   " + username);
                System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
            });
        }

        //终止线程池
        executor.shutdown();
        System.out.println("Finished all threads");

    }


    /**
     * 使用callable方式实现上面的代码，但是Callable是有返回值的
     */
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
        List<Future<String>> futureList = new ArrayList<>();
        for (String username : userNameList) {
            futureList.add(executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                //假如你业务逻辑比较复杂的话，可以以新建一个类继承Runnable，把username对象传递进去，比如 new MyRunnable（Streing username）
                System.out.println(Thread.currentThread().getName() + "   " + username);
                System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
                return username;
            }));
            Thread.sleep(1000);
        }
        for (Future<String> fut : futureList) {
            System.out.println(new Date() + "::" + fut.get());
        }
        //终止线程池
        executor.shutdown();
        System.out.println("Finished all threads");

    }

    /**
     * @param
     * @description: 下面写法是每循环一次，开一个线程，如果线程没归还，主流程继续跑，超出的线程在队列等待
     * @return: void
     */
    @Test
    public void test() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<String> userNameList = new ArrayList<>();
        userNameList.add("1");
        userNameList.add("1");
        userNameList.add("1");
        userNameList.add("1");
        userNameList.add("1");
        userNameList.add("1");
        //假设userNameList有一百条数据
        for (String username : userNameList) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是线程：" + Thread.currentThread().getName());
                    System.out.println(username + "写库成功");
                }
            });

        }
        Thread.sleep(2000);

    }

    /**
     * @param
     * @description: 两个线程去遍历集合里面的100条数据
     * @return: void
     */
    @Test
    public void test1() {
        ExecutorService executor1 = Executors.newFixedThreadPool(1);
        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        List<String> userNameList1 = new ArrayList<>();//50条
        List<String> userNameList2 = new ArrayList<>();//50条


        executor1.execute(new Runnable() {
            @Override
            public void run() {
                for (String s : userNameList1) {
                }
            }

        });
        executor2.execute(new Runnable() {
            @Override
            public void run() {
                //数据保存到数据库
                for (String s : userNameList2) {
                }
            }
        });


        System.out.println("我是主流程，我跑完了，可能这一百条数据还没执行完");


    }

    public void test3() {
        //原始的数据 100条
        List<String> userNameList = new ArrayList<>();
        //根据5050 拆分后的  两个 50大小 的
        List<String> user1List = new ArrayList<>();

        List<String> user2List = new ArrayList<>();

        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        executor1.execute(new Runnable() {
            @Override
            public void run() {
                doSoming(user1List);
            }
        });

        ExecutorService executor2 = Executors.newFixedThreadPool(2);
        executor2.execute(new Runnable() {
            @Override
            public void run() {
                doSoming(user2List);
            }

        });
    }

    private void doSoming(List<String> user2List) {
    }
}
