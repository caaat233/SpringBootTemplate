package com.springboottemplate.thread;

import org.aspectj.util.FileUtil;
import org.junit.Test;

import java.io.File;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/7 15:07
 */
public class TestThread {



    @Test
    public void test1() throws InterruptedException {

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                FileUtil.writeAsString(new File("D:\\ceThread.text"),"子线程在执行");
                System.out.println(Thread.currentThread().getName()+"aaaaaaaaaaaa");
            }
        });
        thread.start();
        //必须要睡眠，要等子线程执行完，不然主线程退出了，子线程也会退出
        //但是线程之间不是相互独立的吗，为啥主线程退出会导致子线程也不执行了???
        thread.join();
      // Thread.sleep(5000);//这种方式等待子线程不优雅,可以用join

        System.out.println(Thread.currentThread().getName()+"bbbbbbbbbbbb");

    }
}
