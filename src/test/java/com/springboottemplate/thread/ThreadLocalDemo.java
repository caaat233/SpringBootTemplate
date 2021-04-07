package com.springboottemplate.thread;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.springboottemplate.jihe.User;
import org.junit.Test;

/**
 * @author 唐涛
 * @description: TODO  可以看见，不同线程用的是一个ThreadLocal，但是不同线程之前赋值却相互不影响
 * @date 2021/3/18 17:34
 */
public class ThreadLocalDemo implements Runnable {
    static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo=new ThreadLocalDemo();
        Thread thread1=new Thread(threadLocalDemo);
        Thread thread2=new Thread(threadLocalDemo);
        Thread thread3=new Thread(threadLocalDemo);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");
        thread1.start();
        thread2.start();
        thread3.start();




    }

    @Override
    public void run() {
        int rom= (int)((Math.random()) * 10);
        System.out.println("rom:"+rom);
        local.set(rom);
        System.out.println(Thread.currentThread().getName()+":"+local.get());
        int time = (int)((Math.random()) * 100);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+local.get());

    }

}
