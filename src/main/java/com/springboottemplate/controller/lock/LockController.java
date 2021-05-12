package com.springboottemplate.controller.lock;

import com.springboottemplate.util.LockMockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/26 10:06
 */
@Controller
public class LockController {

    @Autowired
    private LockMockUtil lockMockUtil;

    /**
     * 可以看见，多个线程访问这个方法，锁是能生效的。可以看见不同线程执行时间间隔是五秒
     * 但是不知道为什么，他们的方法执行耗时都是5s，不计算锁的等待时间
     *
     * @return
     * @throws InterruptedException
     */
    @ResponseBody
    @RequestMapping("lock/getMethodRunTime")
    public String getName() throws InterruptedException {
        long start = System.currentTimeMillis();
        lockMockUtil.Sleep5s_single();
        long end = System.currentTimeMillis();
        double upTime = new BigDecimal(end - start).divide(new BigDecimal(1000)).doubleValue();//耗时(秒)
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String date = sdf.format(new Date());
        return "执行时间为：" + date + "  执行耗时：" + String.valueOf(upTime);
    }

    @ResponseBody
    @RequestMapping("lock/dealLock")
    public String dealLock(int id) throws InterruptedException {

        if (id == 1) {
            synchronized (LockController.class) {
                Thread.sleep(2000);
                synchronized (Object.class) {
                    System.out.println("执行完毕：" + id);
                }
            }

        }
        if (id == 2) {
            synchronized (Object.class) {
                Thread.sleep(2000);
                synchronized (LockController.class) {
                    System.out.println("执行完毕：" + id);
                }
            }
        }
        return String.valueOf(id);
    }

    /**
     * 解决上面方法因为锁竞争导致死锁的问题
     * @param id
     * @return
     * @throws InterruptedException
     */
    @ResponseBody
    @RequestMapping("lock/reloveDealLock")
    public String reloveDealLock(int id) throws InterruptedException {

        if (id == 1) {
            synchronized (LockController.class) {
                Thread.sleep(2000);
                int i;
                for (i = 0; i <= 10; i++) {
                    synchronized (Object.class) {
                        System.out.println("执行完毕：" + id);
                        break;
                    }
                }
                if (i == 10) {
                    //因为我锁的是类对象，必须指定哪个对象要wait的是哪个，this.wait这样写会报错
                    LockController.class.wait();//因为我锁的是类对象，必须指定哪个对象要wait的是哪个，this.wait这样写会报错
                }
                LockController.class.notifyAll();
            }

        }
        if (id == 2) {
            synchronized (Object.class) {
                Thread.sleep(2000);
                int i;
                for (i = 0; i <= 10; i++) {
                    synchronized (LockController.class) {
                        System.out.println("执行完毕：" + id);
                        break;
                    }
                }
                if (i == 10) {
                    //因为我锁的是类对象，必须指定哪个对象要wait的是哪个，this.wait这样写会报错
                    Object.class.wait();//因为我锁的是类对象，必须指定哪个对象要wait的是哪个，this.wait这样写会报错
                }
                Object.class.notifyAll();
            }

        }
        return String.valueOf(id);
    }

//    @ResponseBody
//    @RequestMapping("lock/getMethodRunTime")
//    public String getName() throws InterruptedException {
//        lockMockUtil.Sleep5s();
////        long end = System.currentTimeMillis();
////        double upTime = new BigDecimal(end - start).divide(new BigDecimal(1000)).doubleValue();//耗时(秒)
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = sdf.format(new Date());
//        return "执行的开始时间为：" + date ;
//    }

}
