package com.springboottemplate.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/26 10:11
 */
@Component
public class LockMockUtil {


//   public  synchronized  String  Sleep5s() throws InterruptedException {
//            long start = System.currentTimeMillis();
//            Thread.sleep(5000);
//            long end = System.currentTimeMillis();
//            double upTime = new BigDecimal(end - start).divide(new BigDecimal(1000)).doubleValue();//耗时(秒)
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String date = sdf.format(new Date());
//            return "当前时间为：" + date + "执行时间为：" + String.valueOf(upTime);
//    }

    /**
     * 这个锁是对象锁只能锁住单例，因为她锁的是LockMockUtil这个对象，LockMockUtil加了@Component注解，默认是单例的，所以多线程下，这个锁能生效
     * @throws InterruptedException
     */
    public synchronized void Sleep5s_single() throws InterruptedException {
        Thread.sleep(5000);
    }

    /**
     * 这个锁是类锁、就算LockMockUtil是多例，也能锁住
     * @throws InterruptedException
     */
    public  void Sleep5s_prototype() throws InterruptedException {
        synchronized (LockMockUtil.class){
            Thread.sleep(5000);
        }

    }

}
